import Configs.EnvironmentType;
import Helpers.Enums.Icon;
import Helpers.Enums.StaticText;
import Models.Client;
import Pages.*;
import SeleniumBase.Base;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FlowTest {

    private Client receiverPm, receiverAddress, sender;

    @BeforeEach
    public void setup(){
        receiverPm = new Client("Anna Krasowska", "123123123", "anna@anna.pl", "KRA01M");
        receiverAddress = new Client("Anna Krasowska", "123123123", "anna@anna.pl", "01-123", "Warszawa", "Elekcyjna", "1", "1");
        sender = new Client("Magda Asowska", "321321321", "magda@magda.pl");
    }


    @Nested
    @Order(1)
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    @DisplayName("Parcelmachine delivery method")
    public class ParcelmachineDeliveryTest extends Base {
        private BoxmachineFormPage boxmachineFormPage = new BoxmachineFormPage();
        private SummaryPage summaryPage = new SummaryPage("modal", "parcelmachine");
        private FormPage formPage = new FormPage();
        private PaymentFormPage paymentFormPage = new PaymentFormPage();
        private PaymentRedirectPage paymentRedirectPage = new PaymentRedirectPage();
        private SummaryPage finalSummaryPage = new SummaryPage("final", "parcelmachine");

        @Test
        @Order(1)
        @DisplayName("Page loaded")
        public void Should_LoadPage() {
            if (!(Base.environment.getEnv() == EnvironmentType.PRODUCTION)) {
                formPage.clickPolicyButton();
            }
            formPage.clickCookieButton();

            Assertions.assertDoesNotThrow(() ->
                    formPage.<FormPage>init()
            );
        }

        @Test
        @Order(2)
        public void Should_SelectDeliveryMethodBoxmachine_When_Clicked() {
            formPage.clickBoxmachineDeliveryMethod();
            assertEquals(formPage.srcSummaryReceiverMethodIcon(), Icon.BOXMACHINE.url);
        }

        @Test
        @Order(3)
        public void Should_SelectParcelSizeB_When_Clicked() {
            formPage.clickParcelSizeB();
            String text = formPage.textSummarySizeText();
            boolean result = text.contains(StaticText.SIZE_PARCEL_B.pl) || text.contains(StaticText.SIZE_PARCEL_B.en);
            assertTrue(result);
        }

        @Test
        @Order(4)
        public void Should_ReceiverNameBeCorrect_When_FilledWithCorrectData() {
            formPage.fillReceiverName(receiverPm.getName());
            assertTrue(formPage.valueReceiverName().contains(receiverPm.getName()));
        }

        @Test
        @Order(5)
        public void Should_ReceiverPhoneBeCorrect_When_FilledWithCorrectData() {
            formPage.fillReceiverPhone(receiverPm.getPhone());
            assertTrue(formPage.valueReceiverPhone().contains("+48" + receiverPm.getPhone()));
        }

        @Test
        @Order(6)
        public void Should_ReceiverEmailBeCorrect_When_FilledWithCorrectData() {
            formPage.fillReceiverEmail(receiverPm.getEmail());
            assertTrue(formPage.valueReceiverEmail().contains(receiverPm.getEmail()));
        }

        @Test
        @Order(7)
        public void Should_ReceiverParcelmachineBeCorrect_When_FilledWithCorrectData() {
            boxmachineFormPage.setParcelmachine(receiverPm.getParcelmachine());
            assertTrue(boxmachineFormPage.textParcelmachineFieldValue().contains(receiverPm.getParcelmachine()));
        }

        @Test
        @Order(8)
        public void Should_SenderNameBeCorrect_When_FilledWithCorrectData() {
            formPage.fillSenderName(sender.getName());
            assertTrue(formPage.valueSenderName().contains(sender.getName()));
        }

        @Test
        @Order(9)
        public void Should_SenderPhoneBeCorrect_When_FilledWithCorrectData() {
            formPage.fillSenderPhone(sender.getPhone());
            assertTrue(formPage.valueSenderPhone().contains("+48" + sender.getPhone()));
        }

        @Test
        @Order(10)
        public void Should_SenderEmailBeCorrect_When_FilledWithCorrectData() {
            formPage.fillSenderEmail(sender.getEmail());
            assertTrue(formPage.valueSenderEmail().contains(sender.getEmail()));
        }

        @Test
        @Order(11)
        public void Should_ExceptionNotThrow_When_TermsCheckboxIsClicked() {
            assertDoesNotThrow(() ->
                    formPage.clickTermsCheckbox()
            );
        }

        @Test
        @Order(12)
        public void Should_DisplaySummaryModal_When_FormIsSubmitted() {
            assertTrue(formPage.submit());
        }

        @Test
        @Order(13)
        public void Should_ReceiverDataBeTheSame_When_FormIsSubmitted() {
            assertAll(() -> assertEquals(receiverPm.getName(), summaryPage.textReceiverName()),
                    () -> assertEquals(receiverPm.getPhone(), summaryPage.textReceiverPhone()),
                    () -> assertEquals(receiverPm.getEmail(), summaryPage.textReceiverEmail())
            );
        }

        @Test
        @Order(14)
        public void Should_ParcelmachineDataBeTheSame_When_FormIsSubmitted() {
            summaryPage.setReceiverParcelmachineFields();
            assertEquals(receiverPm.getParcelmachine(), summaryPage.textReceiverParcelmachineName());
        }

        @Test
        @Order(15)
        public void Should_SenderDataBeTheSame_When_FormIsSubmitted() {
            assertAll(() -> assertEquals(sender.getName(), summaryPage.textSenderName()),
                    () -> assertEquals(sender.getPhone(), summaryPage.textSenderPhone()),
                    () -> assertEquals(sender.getEmail(), summaryPage.textSenderEmail())
            );
        }

        @Test
        @Order(16)
        public void Should_LoadPaymentPage_When_PayIsClicked() {
            summaryPage.clickPayButton();
            assertDoesNotThrow(() ->
                    paymentFormPage.<PaymentFormPage>init()
            );
        }

        @Test
        @Order(17)
        public void Should_RedirectToSummary_When_PaymentIsDone() {
            paymentFormPage.fillEmailField(sender.getEmail());
            paymentFormPage.clickMtransferPaymentButton();
            paymentFormPage.clickDataProcessingAgreementCheckbox();
            paymentFormPage.clickFinishButton();
            paymentRedirectPage.<PaymentRedirectPage>init().clickConfirmedPaymentButton();
            assertDoesNotThrow(() ->
                    finalSummaryPage.<SummaryPage>init()
            );
        }

        @Test
        @Order(18)
        public void Should_ReceiverDataBeTheSame_When_InFinalSummary() {
            assertAll(() -> assertEquals(receiverPm.getName(), finalSummaryPage.textReceiverName()),
                    () -> assertEquals(receiverPm.getPhone(), finalSummaryPage.textReceiverPhone()),
                    () -> assertEquals(receiverPm.getEmail(), finalSummaryPage.textReceiverEmail())
            );
        }

        @Test
        @Order(19)
        public void Should_SenderDataBeTheSame_When_InFinalSummary() {
            assertAll(() -> assertEquals(sender.getName(), finalSummaryPage.textSenderName()),
                    () -> assertEquals(sender.getPhone(), finalSummaryPage.textSenderPhone()),
                    () -> assertEquals(sender.getEmail(), finalSummaryPage.textSenderEmail())
            );
        }
        @Test
        @Order(20)
        public void Should_ParcelmachineDataBeTheSame_When_InFinalSummary() {
            finalSummaryPage.setReceiverParcelmachineFields();
            assertEquals(receiverPm.getParcelmachine(), finalSummaryPage.textReceiverParcelmachineName());
        }

        @Test
        @Order(21)
        public void Should_DownloadLabel_When_ButtonClicked() {
            finalSummaryPage.clickDownloadLabelButton();
        }

    }

    @Nested
    @Order(2)
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    @DisplayName("Address delivery method")
    public class AddressDeliveryTest extends Base{
        private SummaryPage summaryPage = new SummaryPage("modal","address");
        private AddressFormPage addressFormPage = new AddressFormPage();
        private FormPage formPage = new FormPage();


        @Test
        @Order(1)
        @DisplayName("Page loaded")
        public void Should_LoadPage(){
            if (!(Base.environment.getEnv() == EnvironmentType.PRODUCTION)){
                formPage.clickPolicyButton();
            }
            formPage.clickCookieButton();

            Assertions.assertDoesNotThrow(()->
                    formPage.<FormPage>init()
            );
        }

        @Test
        @Order(2)
        public void Should_SelectDeliveryMethodAddress_When_Clicked(){
            formPage.clickAddressDeliveryMethod();
            assertEquals(formPage.srcSummaryReceiverMethodIcon(), Icon.ADDRESS.url);
        }
        @Test
        @Order(3)
        public void Should_SelectParcelSizeB_When_Clicked(){
            formPage.clickParcelSizeB();
            String text = formPage.textSummarySizeText();
            boolean result = text.contains(StaticText.SIZE_PARCEL_B.pl) || text.contains(StaticText.SIZE_PARCEL_B.en);
            assertTrue(result);
        }
        @Test
        @Order(4)
        public void Should_ReceiverNameBeCorrect_When_FilledWithCorrectData(){
            formPage.fillReceiverName(receiverAddress.getName());
            assertTrue(formPage.valueReceiverName().contains(receiverAddress.getName()));
        }
        @Test
        @Order(5)
        public void Should_ReceiverPhoneBeCorrect_When_FilledWithCorrectData(){
            formPage.fillReceiverPhone(receiverAddress.getPhone());
            assertTrue(formPage.valueReceiverPhone().contains("+48"+receiverAddress.getPhone()));
        }
        @Test
        @Order(6)
        public void Should_ReceiverEmailBeCorrect_When_FilledWithCorrectData(){
            formPage.fillReceiverEmail(receiverAddress.getEmail());
            assertTrue(formPage.valueReceiverEmail().contains(receiverAddress.getEmail()));
        }

        @Test
        @Order(7)
        public void Should_ReceiverZipCodeBeCorrect_When_FilledWithCorrectData(){
            addressFormPage.fillReceiverZipCode(receiverAddress.getZipCode());
            assertTrue(addressFormPage.valueReceiverZipCode().contains(receiverAddress.getZipCode()));
        }

        @Test
        @Order(8)
        public void Should_ReceiverTownBeCorrect_When_FilledWithCorrectData(){
            addressFormPage.fillReceiverTown(receiverAddress.getCity());
            assertEquals(receiverAddress.getCity(), addressFormPage.textReceiverTownValue());
        }

        @Test
        @Order(9)
        public void Should_ReceiverStreetBeCorrect_When_FilledWithCorrectData(){
            addressFormPage.fillReceiverStreet(receiverAddress.getStreet());
            assertEquals(receiverAddress.getStreet(), addressFormPage.textReceiverStreetValue());
        }

        @Test
        @Order(10)
        public void Should_ReceiverBuildingNoBeCorrect_When_FilledWithCorrectData(){
            addressFormPage.fillReceiverBuildingNo(receiverAddress.getBuildingNo());
            assertTrue(addressFormPage.valueReceiverBuildingNo().contains(receiverAddress.getBuildingNo()));
        }

        @Test
        @Order(11)
        public void Should_ReceiverFlatNoBeCorrect_When_FilledWithCorrectData(){
            addressFormPage.fillReceiverFlatNo(receiverAddress.getFlatNo());
            assertTrue(addressFormPage.valueReceiverFlatNo().contains(receiverAddress.getFlatNo()));
        }

        @Test
        @Order(12)
        public void Should_SenderNameBeCorrect_When_FilledWithCorrectData(){
            formPage.fillSenderName(sender.getName());
            assertTrue(formPage.valueSenderName().contains(sender.getName()));
        }
        @Test
        @Order(13)
        public void Should_SenderPhoneBeCorrect_When_FilledWithCorrectData(){
            formPage.fillSenderPhone(sender.getPhone());
            assertTrue(formPage.valueSenderPhone().contains("+48"+sender.getPhone()));
        }
        @Test
        @Order(14)
        public void Should_SenderEmailBeCorrect_When_FilledWithCorrectData(){
            formPage.fillSenderEmail(sender.getEmail());
            assertTrue(formPage.valueSenderEmail().contains(sender.getEmail()));
        }
        @Test
        @Order(15)
        public void Should_ExceptionNotThrow_When_TermsCheckboxIsClicked(){
            assertDoesNotThrow(()->
                    formPage.clickTermsCheckbox()
            );
        }
        @Test
        @Order(16)
        public void Should_DisplaySummaryModal_When_FormIsSubmitted(){
            assertTrue(formPage.submit());
        }
        @Test
        @Order(17)
        public void Should_ReceiverDataBeTheSame_When_FormIsSubmitted() {
            assertAll(()->assertEquals(receiverAddress.getName(), summaryPage.textReceiverName()),
                    ()->assertEquals(receiverAddress.getPhone(), summaryPage.textReceiverPhone()),
                    ()->assertEquals(receiverAddress.getEmail(), summaryPage.textReceiverEmail()),
                    ()->assertEquals(receiverAddress.getZipCode()+" "+receiverAddress.getCity(), summaryPage.textReceiverZipCodeCity()),
                    ()->assertEquals(receiverAddress.getStreet()+" "+receiverAddress.getBuildingNo()+"/"+receiverAddress.getFlatNo(), summaryPage.textReceiverStreetBuildingNo())
            );
        }
        @Test
        @Order(18)
        public void Should_SenderDataBeTheSame_When_FormIsSubmitted() {
            assertAll(()->assertEquals(sender.getName(), summaryPage.textSenderName()),
                    ()->assertEquals(sender.getPhone(), summaryPage.textSenderPhone()),
                    ()->assertEquals(sender.getEmail(), summaryPage.textSenderEmail())
            );
        }
    }

}

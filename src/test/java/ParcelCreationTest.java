import Configs.EnvironmentType;
import Helpers.Enums.Icon;
import Helpers.Enums.StaticText;
import Helpers.FileHelper;
import Models.Client;
import Pages.*;
import SeleniumBase.Base;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ParcelCreationTest {

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
            Assertions.assertDoesNotThrow(() ->
                    formPage.<FormPage>init()
            );
        }

        @Test
        @Order(2)
        public void Should_SelectDeliveryMethodBoxmachine_When_Clicked() {
            formPage.deliveryTypeBoxmachine().click();
            assertEquals(formPage.summaryReceiverMethodIcon().src(), Icon.BOXMACHINE.url);
        }

        @Test
        @Order(3)
        public void Should_SelectParcelSizeB_When_Clicked() {
            formPage.parcelSizeB().click();
            String text = formPage.summarySizeText().text();
            boolean result = text.contains(StaticText.SIZE_PARCEL_B.pl) || text.contains(StaticText.SIZE_PARCEL_B.en);
            assertTrue(result);
        }

        @Test
        @Order(4)
        public void Should_ReceiverNameBeCorrect_When_FilledWithCorrectData() {
            formPage.receiverName().fill(receiverPm.getName());
            assertTrue(formPage.receiverName().value().contains(receiverPm.getName()));
        }

        @Test
        @Order(5)
        public void Should_ReceiverPhoneBeCorrect_When_FilledWithCorrectData() {
            formPage.receiverPhone().fill(receiverPm.getPhone());
            String phone = formPage.receiverPhone().value().replace(" ", "");
            assertEquals("+48" + receiverPm.getPhone(), phone);
        }

        @Test
        @Order(6)
        public void Should_ReceiverEmailBeCorrect_When_FilledWithCorrectData() {
            formPage.receiverEmail().fill(receiverPm.getEmail());
            assertTrue(formPage.receiverEmail().value().contains(receiverPm.getEmail()));
        }

        @Test
        @Order(7)
        public void Should_ReceiverParcelmachineBeCorrect_When_FilledWithCorrectData() {
            boxmachineFormPage.parcelmachine().fill(receiverPm.getParcelmachine()).confirmDropdown();
            assertTrue(boxmachineFormPage.parcelmachineFieldValue().value().contains(receiverPm.getParcelmachine()));
        }

        @Test
        @Order(8)
        public void Should_SenderNameBeCorrect_When_FilledWithCorrectData() {
            formPage.senderName().fill(sender.getName());
            assertTrue(formPage.senderName().value().contains(sender.getName()));
        }

        @Test
        @Order(9)
        public void Should_SenderPhoneBeCorrect_When_FilledWithCorrectData() {
            formPage.senderPhone().fill(sender.getPhone());
            String phone = formPage.senderPhone().value().replace(" ","");
            assertEquals("+48" + sender.getPhone(), phone);
        }

        @Test
        @Order(10)
        public void Should_SenderEmailBeCorrect_When_FilledWithCorrectData() {
            formPage.senderEmail().fill(sender.getEmail());
            assertTrue(formPage.senderEmail().value().contains(sender.getEmail()));
        }

        @Test
        @Order(11)
        public void Should_ExceptionNotThrow_When_TermsCheckboxIsClicked() {
            assertDoesNotThrow(() ->
                    formPage.terms().click()
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
            assertAll(() -> assertEquals(receiverPm.getName(), summaryPage.receiverName().text()),
                    () -> assertEquals(receiverPm.getPhone(), summaryPage.receiverPhone().text().replace(" ", "")),
                    () -> assertEquals(receiverPm.getEmail(), summaryPage.receiverEmail().text())
            );
        }

        @Test
        @Order(14)
        public void Should_ParcelmachineDataBeTheSame_When_FormIsSubmitted() {
            summaryPage.setReceiverParcelmachineFields();
            assertEquals(receiverPm.getParcelmachine(), summaryPage.receiverParcelmachineName().text());
        }

        @Test
        @Order(15)
        public void Should_SenderDataBeTheSame_When_FormIsSubmitted() {
            assertAll(() -> assertEquals(sender.getName(), summaryPage.senderName().text()),
                    () -> assertEquals(sender.getPhone(), summaryPage.senderPhone().text().replace(" ", "")),
                    () -> assertEquals(sender.getEmail(), summaryPage.senderEmail().text())
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
            paymentFormPage.emailField().fill(sender.getEmail());
            paymentFormPage.mtransferPaymentButton().click();
            paymentFormPage.clickDataProcessingAgreementCheckbox();
            paymentFormPage.finishButton().click();
            paymentRedirectPage.<PaymentRedirectPage>init().confirmedPaymentButton().click();
            assertDoesNotThrow(() ->
                    finalSummaryPage.<SummaryPage>init()
            );
        }

        @Test
        @Order(18)
        public void Should_ReceiverDataBeTheSame_When_InFinalSummary() {
            assertAll(() -> assertEquals(receiverPm.getName(), finalSummaryPage.receiverName().text()),
                    () -> assertEquals(receiverPm.getPhone(), finalSummaryPage.receiverPhone().text()),
                    () -> assertEquals(receiverPm.getEmail(), finalSummaryPage.receiverEmail().text())
            );
        }

        @Test
        @Order(19)
        public void Should_SenderDataBeTheSame_When_InFinalSummary() {
            assertAll(() -> assertEquals(sender.getName(), finalSummaryPage.senderName().text()),
                    () -> assertEquals(sender.getPhone(), finalSummaryPage.senderPhone().text()),
                    () -> assertEquals(sender.getEmail(), finalSummaryPage.senderEmail().text())
            );
        }
        @Test
        @Order(20)
        public void Should_ParcelmachineDataBeTheSame_When_InFinalSummary() {
            finalSummaryPage.setReceiverParcelmachineFields();
            assertEquals(receiverPm.getParcelmachine(), finalSummaryPage.receiverParcelmachineName().text());
        }

        @Test
        @Order(21)
        public void Should_DownloadLabel_When_ButtonClicked() throws IOException {
            finalSummaryPage.downloadLabelButton().click();
            FileHelper fileHelper = new FileHelper();
            assertTrue(fileHelper.isLatestFileNew());
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
        private SummaryPage finalSummaryPage = new SummaryPage("final", "address");
        private PaymentFormPage paymentFormPage = new PaymentFormPage();
        private PaymentRedirectPage paymentRedirectPage = new PaymentRedirectPage();


        @Test
        @Order(1)
        @DisplayName("Page loaded")
        public void Should_LoadPage(){
            Assertions.assertDoesNotThrow(()->
                    formPage.<FormPage>init()
            );
        }

        @Test
        @Order(2)
        public void Should_SelectDeliveryMethodAddress_When_Clicked(){
            formPage.deliveryTypeAddress().click();
            assertEquals(formPage.summaryReceiverMethodIcon().src(), Icon.ADDRESS.url);
        }
        @Test
        @Order(3)
        public void Should_SelectParcelSizeB_When_Clicked(){
            formPage.parcelSizeB().click();
            String text = formPage.summarySizeText().text();
            boolean result = text.contains(StaticText.SIZE_PARCEL_B.pl) || text.contains(StaticText.SIZE_PARCEL_B.en);
            assertTrue(result);
        }
        @Test
        @Order(4)
        public void Should_ReceiverNameBeCorrect_When_FilledWithCorrectData(){
            formPage.receiverName().fill(receiverAddress.getName());
            assertTrue(formPage.receiverName().value().contains(receiverAddress.getName()));
        }
        @Test
        @Order(5)
        public void Should_ReceiverPhoneBeCorrect_When_FilledWithCorrectData(){
            formPage.receiverPhone().fill(receiverAddress.getPhone());
            String phone = formPage.receiverPhone().value().replace(" ", "");
            assertEquals("+48"+receiverAddress.getPhone(), phone);
        }
        @Test
        @Order(6)
        public void Should_ReceiverEmailBeCorrect_When_FilledWithCorrectData(){
            formPage.receiverEmail().fill(receiverAddress.getEmail());
            assertTrue(formPage.receiverEmail().value().contains(receiverAddress.getEmail()));
        }

        @Test
        @Order(7)
        public void Should_ReceiverZipCodeBeCorrect_When_FilledWithCorrectData(){
            addressFormPage.receiverZipCode().fill(receiverAddress.getZipCode());
            assertTrue(addressFormPage.receiverZipCode().value().contains(receiverAddress.getZipCode()));
        }

        @Test
        @Order(8)
        public void Should_ReceiverTownBeCorrect_When_FilledWithCorrectData(){
            addressFormPage.receiverTown().fill(receiverAddress.getCity()).confirmDropdown();
            assertEquals(receiverAddress.getCity(), addressFormPage.receiverTownValue().text());
        }

        @Test
        @Order(9)
        public void Should_ReceiverStreetBeCorrect_When_FilledWithCorrectData(){
            addressFormPage.receiverStreet().confirmDropdown();
            assertEquals(receiverAddress.getStreet(), addressFormPage.receiverStreetValue().text());
        }

        @Test
        @Order(10)
        public void Should_ReceiverBuildingNoBeCorrect_When_FilledWithCorrectData(){
            addressFormPage.receiverBuildingNo().fill(receiverAddress.getBuildingNo());
            assertTrue(addressFormPage.receiverBuildingNo().value().contains(receiverAddress.getBuildingNo()));
        }

        @Test
        @Order(11)
        public void Should_ReceiverFlatNoBeCorrect_When_FilledWithCorrectData(){
            addressFormPage.receiverFlatNo().fill(receiverAddress.getFlatNo());
            assertTrue(addressFormPage.receiverFlatNo().value().contains(receiverAddress.getFlatNo()));
        }

        @Test
        @Order(12)
        public void Should_SenderNameBeCorrect_When_FilledWithCorrectData(){
            formPage.senderName().fill(sender.getName());
            assertTrue(formPage.senderName().value().contains(sender.getName()));
        }
        @Test
        @Order(13)
        public void Should_SenderPhoneBeCorrect_When_FilledWithCorrectData(){
            formPage.senderPhone().fill(sender.getPhone());
            String phone = formPage.senderPhone().value().replace(" ", "");
            assertEquals("+48"+sender.getPhone(), phone);
        }
        @Test
        @Order(14)
        public void Should_SenderEmailBeCorrect_When_FilledWithCorrectData(){
            formPage.senderEmail().fill(sender.getEmail());
            assertTrue(formPage.senderEmail().value().contains(sender.getEmail()));
        }
        @Test
        @Order(15)
        public void Should_ExceptionNotThrow_When_TermsCheckboxIsClicked(){
            assertDoesNotThrow(()->
                    formPage.terms().click()
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
            assertAll(()->assertEquals(receiverAddress.getName(), summaryPage.receiverName().text()),
                    ()->assertEquals(receiverAddress.getPhone(), summaryPage.receiverPhone().text().replace(" ", "")),
                    ()->assertEquals(receiverAddress.getEmail(), summaryPage.receiverEmail().text()),
                    ()->assertEquals(receiverAddress.getZipCode()+" "+receiverAddress.getCity(), summaryPage.receiverZipCodeCity().text()),
                    ()->assertEquals(receiverAddress.getStreet()+" "+receiverAddress.getBuildingNo()+"/"+receiverAddress.getFlatNo(), summaryPage.receiverStreetBuildingNo().text())
            );
        }

        @Test
        @Order(18)
        public void Should_SenderDataBeTheSame_When_FormIsSubmitted() {
            assertAll(()->assertEquals(sender.getName(), summaryPage.senderName().text()),
                    ()->assertEquals(sender.getPhone(), summaryPage.senderPhone().text().replace(" ", "")),
                    ()->assertEquals(sender.getEmail(), summaryPage.senderEmail().text())
            );
        }

        @Test
        @Order(19)
        public void Should_LoadPaymentPage_When_PayIsClicked() {
            summaryPage.clickPayButton();
            assertDoesNotThrow(() ->
                    paymentFormPage.<PaymentFormPage>init()
            );
        }

        @Test
        @Order(20)
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
        @Order(21)
        public void Should_ReceiverDataBeTheSame_When_InFinalSummary() {
            assertAll(()->assertEquals(receiverAddress.getName(), finalSummaryPage.receiverName().text()),
                    ()->assertEquals(receiverAddress.getPhone(), finalSummaryPage.receiverPhone().text()),
                    ()->assertEquals(receiverAddress.getEmail(), finalSummaryPage.receiverEmail().text()),
                    ()->assertEquals(receiverAddress.getZipCode()+" "+receiverAddress.getCity(), finalSummaryPage.receiverZipCodeCity().text()),
                    ()->assertEquals(receiverAddress.getStreet()+" "+receiverAddress.getBuildingNo()+"/"+receiverAddress.getFlatNo(), finalSummaryPage.receiverStreetBuildingNo().text())
            );
        }

        @Test
        @Order(22)
        public void Should_SenderDataBeTheSame_When_InFinalSummary() {
            assertAll(() -> assertEquals(sender.getName(), finalSummaryPage.senderName().text()),
                    () -> assertEquals(sender.getPhone(), finalSummaryPage.senderPhone().text()),
                    () -> assertEquals(sender.getEmail(), finalSummaryPage.senderEmail().text())
            );
        }

        @Test
        @Order(23)
        public void Should_DownloadLabel_When_ButtonClicked() throws IOException {
            finalSummaryPage.downloadLabelButton().click();
            FileHelper fileHelper = new FileHelper();
            assertTrue(fileHelper.isLatestFileNew());
        }
    }

}

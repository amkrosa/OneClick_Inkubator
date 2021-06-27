import Configs.EnvironmentType;
import Helpers.Enums.Icon;
import Helpers.Enums.StaticText;
import Helpers.FileHelper;
import Helpers.WaitHelper;
import Models.Client;
import Pages.*;
import SeleniumBase.Base;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class FormTest extends Base {

    private Client receiverPm = new Client("Anna Krasowska", "123123123", "anna@anna.pl", "KRA01M");
    private Client receiverAddress = new Client("Anna Krasowska", "123123123", "anna@anna.pl", "01-123", "Warszawa", "Elekcyjna", "1", "1");
    private Client sender = new Client("Magda Asowska", "321321321", "magda@magda.pl");
    private FormPage formPage = new FormPage();


    @Test
    @DisplayName("Page loaded")
    public void Should_LoadPage() {
        Assertions.assertDoesNotThrow(() ->
                formPage.<FormPage>init()
        );
    }

    @Nested
    @DisplayName("Parcelmachine delivery method")
    public class ReceiverParcelmachineFormTest{
        private BoxmachineFormPage boxmachineFormPage = new BoxmachineFormPage();
        private FormPage formPage = new FormPage();

        @BeforeEach
        public void setup(){
            if (!formPage.srcSummaryReceiverMethodIcon().equals(Icon.BOXMACHINE.url))
                formPage.clickBoxmachineDeliveryMethod().clickParcelSizeA();
        }

        @Test
        @DisplayName("Page loaded")
        public void Should_LoadPage() {
            Assertions.assertDoesNotThrow(() ->
                    formPage.<FormPage>init()
            );
        }

        @Test
        public void Should_SelectDeliveryMethodBoxmachine_When_Clicked() {
            formPage.clickBoxmachineDeliveryMethod();
            assertEquals(formPage.srcSummaryReceiverMethodIcon(), Icon.BOXMACHINE.url);
        }

        @Test
        public void Should_SelectParcelSizeB_When_Clicked() {
            formPage.clickParcelSizeB();
            String text = formPage.textSummarySizeText();
            boolean result = text.contains(StaticText.SIZE_PARCEL_B.pl) || text.contains(StaticText.SIZE_PARCEL_B.en);
            assertTrue(result);
        }

        @Test
        public void Should_ReceiverNameBeCorrect_When_FilledWithCorrectData() {
            formPage.fillReceiverName(receiverPm.getName());
            assertTrue(formPage.valueReceiverName().contains(receiverPm.getName()));
        }

        @Test
        public void Should_ReceiverPhoneBeCorrect_When_FilledWithCorrectData() {
            formPage.fillReceiverPhone("").fillReceiverPhone(receiverPm.getPhone());
            assertTrue(formPage.valueReceiverPhone().contains("+48" + receiverPm.getPhone()));
        }

        @ParameterizedTest
        @ValueSource(strings = {"000000000", "aaa", "  "})
        public void Should_ReceiverPhoneBeInvalid_When_FilledWithInvalidData(String str) {
            formPage.clearReceiverPhone().fillReceiverPhone(str);
            assertTrue(formPage.getErrorReceiverPhone().isDisplayed());
        }

        @ParameterizedTest
        @ValueSource(strings = {"a@a.pl", "anna@anna.pl"})
        public void Should_ReceiverEmailBeCorrect_When_FilledWithCorrectData(String str) {
            //clear etc
            formPage.fillReceiverEmail(receiverPm.getEmail());
            assertTrue(formPage.valueReceiverEmail().contains(receiverPm.getEmail()));
        }

        @ParameterizedTest
        @ValueSource(strings = {"a@a.p", "anna", "aaa@aaa", "###@###.pl"})
        public void Should_ReceiverEmailBeInvalid_When_FilledWithInvalidData(String str) {
            //clear etc
            formPage.fillReceiverEmail(receiverPm.getEmail());
            assertTrue(formPage.valueReceiverEmail().contains(receiverPm.getEmail()));
        }

        @Test
        public void Should_ReceiverParcelmachineBeCorrect_When_FilledWithCorrectData() {
            boxmachineFormPage.setParcelmachine(receiverPm.getParcelmachine());
            assertTrue(boxmachineFormPage.textParcelmachineFieldValue().contains(receiverPm.getParcelmachine()));
        }

        @Test
        public void Should_SenderNameBeCorrect_When_FilledWithCorrectData() {
            formPage.fillSenderName(sender.getName());
            assertTrue(formPage.valueSenderName().contains(sender.getName()));
        }

        @Test
        public void Should_SenderPhoneBeCorrect_When_FilledWithCorrectData() {
            formPage.fillSenderPhone(sender.getPhone());
            assertTrue(formPage.valueSenderPhone().contains("+48" + sender.getPhone()));
        }

        @Test
        public void Should_SenderEmailBeCorrect_When_FilledWithCorrectData() {
            formPage.fillSenderEmail(sender.getEmail());
            assertTrue(formPage.valueSenderEmail().contains(sender.getEmail()));
        }

    }

}

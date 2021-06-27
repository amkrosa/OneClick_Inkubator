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
            if (!formPage.summaryReceiverMethodIcon().src().equals(Icon.BOXMACHINE.url))
                formPage.parcelSizeA().click();
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
            formPage.deliveryTypeBoxmachine().click();
            assertEquals(formPage.summaryReceiverMethodIcon().src(), Icon.BOXMACHINE.url);
        }

        @Test
        public void Should_SelectParcelSizeB_When_Clicked() {
            formPage.parcelSizeB().click();
            String text = formPage.summarySizeText().text();
            boolean result = text.contains(StaticText.SIZE_PARCEL_B.pl) || text.contains(StaticText.SIZE_PARCEL_B.en);
            assertTrue(result);
        }

        @Test
        public void Should_ReceiverNameBeCorrect_When_FilledWithCorrectData() {
            formPage.receiverName().clear().fill(receiverPm.getName());
            assertEquals(receiverPm.getName(), formPage.receiverName().value());
        }

        @Test
        public void Should_ReceiverPhoneBeCorrect_When_FilledWithCorrectData() {
            formPage.receiverPhone().clear().fill(receiverPm.getPhone());
            String phone = formPage.receiverPhone().value().replace(" ","");
            assertEquals("+48"+receiverPm.getPhone(), phone);
        }

        @ParameterizedTest
        @ValueSource(strings = {"000000000", "aaa", "  "})
        public void Should_ReceiverPhoneBeInvalid_When_FilledWithInvalidData(String str) {
            formPage.receiverPhone().clear().fill(str);
            String phone = formPage.receiverPhone().value().replace(" ", "");
            assertTrue(formPage.errorReceiverPhone().isDisplayed());
        }

        @ParameterizedTest
        @ValueSource(strings = {"a@a.pl", "anna@anna.pl"})
        public void Should_ReceiverEmailBeCorrect_When_FilledWithCorrectData(String str) {
            //clear etc
            formPage.receiverEmail().clear().fill(receiverPm.getEmail());

        }

        @ParameterizedTest
        @ValueSource(strings = {"a@a.p", "anna", "aaa@aaa", "###@###.pl"})
        public void Should_ReceiverEmailBeInvalid_When_FilledWithInvalidData(String str) {
            //clear etc
            formPage.receiverEmail().clear().fill(receiverPm.getEmail());

        }

        @Test
        public void Should_ReceiverParcelmachineBeCorrect_When_FilledWithCorrectData() {
            boxmachineFormPage.setParcelmachine(receiverPm.getParcelmachine());
            assertTrue(boxmachineFormPage.parcelmachineFieldValue().text().contains(receiverPm.getParcelmachine()));
        }

        @Test
        public void Should_SenderNameBeCorrect_When_FilledWithCorrectData() {
            formPage.senderName().clear().fill(sender.getName());

        }

        @Test
        public void Should_SenderPhoneBeCorrect_When_FilledWithCorrectData() {
            formPage.senderPhone().clear().fill(sender.getPhone());

        }

        @Test
        public void Should_SenderEmailBeCorrect_When_FilledWithCorrectData() {
            formPage.senderEmail().clear().fill(sender.getEmail());

        }

    }

}

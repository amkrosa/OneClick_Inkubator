package Forms;

import Helpers.Enums.Statics.Icon;
import Helpers.Enums.Statics.StaticText;
import Models.Client;
import Pages.Home.AddressFormPage;
import Pages.Home.BoxmachineFormPage;
import Pages.Home.FormPage;
import Selenium.Base;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;


public class FormTest extends Base {

    private Client receiverPm = new Client("Anna Krasowska", "123123123", "anna@anna.pl", "KRA01M");
    private Client receiverAddress = new Client("Anna Krasowska", "123123123", "anna@anna.pl", "01-123", "Warszawa", "Elekcyjna", "1", "1");
    private Client sender = new Client("Magda Asowska", "321321321", "magda@magda.pl");
    private final String string251= "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    private final String string10= "aaaaaaaaaa";
    private final String string51= "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    private final String string11= "aaaaaaaaaaa";

    @Test
    public void Should_SelectDeliveryMethodBoxmachine_When_Clicked() {
        page.Form.deliveryTypeBoxmachine().click();
        assertEquals(page.Form.summaryReceiverMethodIcon().src(), Icon.BOXMACHINE.url);
    }

    @Test
    public void Should_SelectDeliveryMethodAddress_When_Clicked() {
        page.Form.deliveryTypeAddress().click();
        assertEquals(page.Form.summaryReceiverMethodIcon().src(), Icon.ADDRESS.url);
    }


    @Test
    public void Should_SelectParcelSizeA_When_Clicked() {
        page.Form.parcelSizeA().click();
        String text = page.Form.summarySizeText().text();
        boolean result = text.contains(StaticText.SIZE_PARCEL_A.current());
        assertTrue(result, "Text "+text+" does not contain "+StaticText.SIZE_PARCEL_A.current());
    }

    @Test
    public void Should_SelectParcelSizeB_When_Clicked() {
        page.Form.parcelSizeB().click();
        String text = page.Form.summarySizeText().text();
        boolean result = text.contains(StaticText.SIZE_PARCEL_B.current());
        assertTrue(result, "Text "+text+" does not contain "+StaticText.SIZE_PARCEL_B.current());
    }

    @Test
    public void Should_SelectParcelSizeC_When_Clicked() {
        page.Form.parcelSizeC().click();
        String text = page.Form.summarySizeText().text();
        boolean result = text.contains(StaticText.SIZE_PARCEL_C.current());
        assertTrue(result, "Text "+text+" does not contain "+StaticText.SIZE_PARCEL_C.current());
    }

    @Test
    public void Should_ReceiverNameBeCorrect_When_FilledWithCorrectData() {
        page.Form.receiverName().clear().fill(receiverPm.getName());
        assertEquals(receiverPm.getName(), page.Form.receiverName().value());
    }

    @ParameterizedTest
    @ValueSource(strings = {string251, "", " ", "$", "%", "^", "(", ")"})
    public void Should_ReceiverNameBeInvalid_When_FilledWithInvalidData(String str) {
        page.Form.receiverName().clear().fill(str);
        assertTrue(page.Form.errorReceiverName().isDisplayed());
    }

    @Test
    public void Should_ReceiverPhoneBeCorrect_When_FilledWithCorrectData() {
        page.Form.receiverPhone().clear().fill(receiverPm.getPhone());
        String phone = page.Form.receiverPhone().value().replace(" ","");
        assertEquals("+48"+receiverPm.getPhone(), phone);
    }

    @ParameterizedTest
    @ValueSource(strings = {"000000000", "aaa", "  "})
    public void Should_ReceiverPhoneBeInvalid_When_FilledWithInvalidData(String str) {
        page.Form.receiverPhone().clear().fill(str);
        String phone = page.Form.receiverPhone().value().replace(" ", "");
        assertTrue(page.Form.errorReceiverPhone().isDisplayed());
    }

    @ParameterizedTest
    @ValueSource(strings = {"a@a.pl", "anna@anna.pl"})
    public void Should_ReceiverEmailBeCorrect_When_FilledWithCorrectData(String str) {
        page.Form.receiverEmail().clear().fill(str);
        assertEquals(str, page.Form.receiverEmail().value());
    }

    @ParameterizedTest
    @ValueSource(strings = {"a@a.p", "anna", "aaa@aaa", "###@###.pl"})
    public void Should_ReceiverEmailBeInvalid_When_FilledWithInvalidData(String str) {
        page.Form.receiverEmail().clear().fill(str);
        assertTrue(page.Form.errorReceiverEmail().isDisplayed());
    }

    @Test
    public void Should_SenderNameBeCorrect_When_FilledWithCorrectData() {
        page.Form.senderName().clear().fill(sender.getName());
        assertEquals(sender.getName(), page.Form.senderName().value());
    }

    @Test
    public void Should_SenderPhoneBeCorrect_When_FilledWithCorrectData() {
        page.Form.senderPhone().clear().fill(sender.getPhone());
        String phone = page.Form.senderPhone().value().replace(" ", "");
        assertEquals("+48"+sender.getPhone(), phone);
    }

    @ParameterizedTest
    @ValueSource(strings = {"000000000", "aaa", "  "})
    public void Should_SenderPhoneBeInvalid_When_FilledWithInvalidData(String str) {
        page.Form.senderPhone().clear().fill(str);
        assertTrue(page.Form.errorSenderPhone().isDisplayed());
    }

    @ParameterizedTest
    @ValueSource(strings = {"a@a.pl", "anna@anna.pl"})
    public void Should_SenderEmailBeCorrect_When_FilledWithCorrectData(String str) {
        page.Form.senderEmail().clear().fill(str);
        assertEquals(str, page.Form.senderEmail().value());
    }

    @ParameterizedTest
    @ValueSource(strings = {"a@a.p", "anna", "aaa@aaa", "###@###.pl"})
    public void Should_SenderEmailBeInvalid_When_FilledWithInvalidData(String str) {
        page.Form.senderEmail().clear().fill(str);
        assertTrue(page.Form.errorSenderEmail().isDisplayed());
    }

    @ParameterizedTest
    @ValueSource(strings = {string251, "", " ", "$", "%", "^", "(", ")"})
    public void Should_SenderNameBeInvalid_When_FilledWithInvalidData(String str) {
        page.Form.senderName().clear().fill(str).page().senderPhone().click();
        assertTrue(page.Form.errorSenderName().isDisplayed());
    }

    @Test
    public void Should_CheckNewsletterCheckbox_When_Clicked(){
        assertDoesNotThrow(()->page.Form.newsletter().click());
    }

    @Nested
    @DisplayName("Parcelmachine delivery method")
    public class ReceiverParcelmachineFormTest{

        @BeforeEach
        public void setup(){
            if (!page.Form.summaryReceiverMethodIcon().src().equals(Icon.BOXMACHINE.url))
                page.Form.deliveryTypeBoxmachine().click();
        }

        @Test
        public void Should_ReceiverParcelmachineBeCorrect_When_FilledWithCorrectData() {
            page.BoxmachineForm.parcelmachine().clear().fill(receiverPm.getParcelmachine()).confirmDropdown();
            assertTrue(page.BoxmachineForm.parcelmachineFieldValue().text().contains(receiverPm.getParcelmachine()));
        }

        @ParameterizedTest
        @ValueSource(strings = {"nieistnieje", "random"})
        public void Should_ReceiverParcelmachineBeInvalid_When_FilledWithInvalidData(String str) {
            String pmBefore = page.BoxmachineForm.parcelmachineFieldValue().text();
            page.BoxmachineForm.parcelmachine().clear().fill(str).confirmDropdown();
            assertEquals(pmBefore, page.BoxmachineForm.parcelmachineFieldValue().text());
        }

    }

    @Nested
    @DisplayName("Address delivery method")
    public class ReceiverAddresseFormTest{

        @BeforeEach
        public void setup(){
            if (!page.Form.summaryReceiverMethodIcon().src().equals(Icon.ADDRESS.url))
                page.Form.deliveryTypeAddress().click();
        }

        @ParameterizedTest
        @ValueSource(strings = {"11-111", "random", "00-000"})
        public void Should_ReceiverZipCodeBeInvalid_When_FilledWithInvalidData(String str) {
            page.AddressForm.receiverZipCode().click().clear().fill(str).clickAbove();
            assertTrue(page.AddressForm.errorReceiverZipCode().waitVisible().isDisplayed());
        }

        @ParameterizedTest
        @ValueSource(strings = {string10, "123", "aaa"})
        public void Should_ReceiverBuildingNoBeCorrect_When_FilledWithCorrectData(String str) {
            page.AddressForm.receiverBuildingNo().clear().fill(str);
            assertThrows(NoSuchElementException.class, () -> page.AddressForm.errorBuildingNo().isDisplayed());
        }

        @ParameterizedTest
        @ValueSource(strings = {string11})
        public void Should_ReceiverBuildingNoBeInvalid_When_FilledWithInvalidData(String str) {
            page.AddressForm.receiverBuildingNo().clear().fill(str);
            assertTrue(page.AddressForm.errorBuildingNo().isDisplayed());
        }

        @ParameterizedTest
        @ValueSource(strings = {string10, "123", "aaa"})
        public void Should_ReceiverFlatNoBeCorrect_When_FilledWithCorrectData(String str) {
            page.AddressForm.receiverFlatNo().clear().fill(str);
            assertThrows(NoSuchElementException.class, () -> page.AddressForm.errorFlatNo().isDisplayed());
        }

        @ParameterizedTest
        @ValueSource(strings = {string11})
        public void Should_ReceiverFlatNoBeInvalid_When_FilledWithInvalidData(String str) {
            page.AddressForm.receiverFlatNo().clear().fill(str);
            assertTrue(page.AddressForm.errorFlatNo().isDisplayed());
        }

        @ParameterizedTest
        @ValueSource(strings = {string51})
        public void Should_ReceiverTownBeInvalid_When_FilledWithInvalidData(String str) {
            page.AddressForm.receiverTown().clear().fill(str).confirmDropdown();
            assertTrue(page.AddressForm.errorReceiverTown().isDisplayed());
        }

        @ParameterizedTest
        @ValueSource(strings = {"Warszawa", "cokolwiek"})
        public void Should_ReceiverTownBeCorrect_When_FilledWithCorrectData(String str) {
            page.AddressForm
                    .receiverZipCode().clear().fill("01-123")
                    .page()
                    .receiverTown().waitClickable().fill(str).confirmDropdown().clickAbove();
            assertThrows(NoSuchElementException.class, () -> page.AddressForm.errorReceiverTown().isDisplayed());
        }

        @ParameterizedTest
        @ValueSource(strings = {string51})
        public void Should_ReceiverStreetBeInvalid_When_FilledWithInvalidData(String str) {
            page.AddressForm.receiverTown().clear().fill(str).confirmDropdown();
            assertTrue(page.AddressForm.errorReceiverTown().isDisplayed());
        }

        @ParameterizedTest
        @ValueSource(strings = {"Elekcyjna", "cokolwiek"})
        public void Should_ReceiverStreetBeCorrect_When_FilledWithCorrectData(String str) {
            page.AddressForm
                    .receiverZipCode().click().clear().fill("01-123")
                    .page()
                    .receiverTown().waitClickable().click().confirmDropdown()
                    .page()
                    .receiverStreet().waitClickable().fill(str).confirmDropdown().clickAbove();

            assertThrows(NoSuchElementException.class, () -> page.AddressForm.errorReceiverStreet().isDisplayed());
        }


    }

}

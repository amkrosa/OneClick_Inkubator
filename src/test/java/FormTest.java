import Helpers.Enums.Icon;
import Helpers.Enums.StaticText;
import Models.Client;
import Pages.*;
import SeleniumBase.Base;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class FormTest extends Base {

    private Client receiverPm = new Client("Anna Krasowska", "123123123", "anna@anna.pl", "KRA01M");
    private Client receiverAddress = new Client("Anna Krasowska", "123123123", "anna@anna.pl", "01-123", "Warszawa", "Elekcyjna", "1", "1");
    private Client sender = new Client("Magda Asowska", "321321321", "magda@magda.pl");
    private FormPage formPage = new FormPage();
    private final String string251= "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    private final String string10= "aaaaaaaaaa";
    private final String string51= "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    private final String string11= "aaaaaaaaaaa";

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
    public void Should_SelectDeliveryMethodAddress_When_Clicked() {
        formPage.deliveryTypeAddress().click();
        assertEquals(formPage.summaryReceiverMethodIcon().src(), Icon.ADDRESS.url);
    }


    @Test
    public void Should_SelectParcelSizeA_When_Clicked() {
        formPage.parcelSizeA().click();
        String text = formPage.summarySizeText().text();
        boolean result = text.contains(StaticText.SIZE_PARCEL_A.pl) || text.contains(StaticText.SIZE_PARCEL_A.en);
        assertTrue(result);
    }

    @Test
    public void Should_SelectParcelSizeB_When_Clicked() {
        formPage.parcelSizeB().click();
        String text = formPage.summarySizeText().text();
        boolean result = text.contains(StaticText.SIZE_PARCEL_B.pl) || text.contains(StaticText.SIZE_PARCEL_B.en);
        assertTrue(result);
    }

    @Test
    public void Should_SelectParcelSizeC_When_Clicked() {
        formPage.parcelSizeC().click();
        String text = formPage.summarySizeText().text();
        boolean result = text.contains(StaticText.SIZE_PARCEL_C.pl) || text.contains(StaticText.SIZE_PARCEL_C.en);
        assertTrue(result);
    }

    @Test
    public void Should_ReceiverNameBeCorrect_When_FilledWithCorrectData() {
        formPage.receiverName().clear().fill(receiverPm.getName());
        assertEquals(receiverPm.getName(), formPage.receiverName().value());
    }

    @ParameterizedTest
    @ValueSource(strings = {string251, "", " ", "$", "%", "^", "(", ")"})
    public void Should_ReceiverNameBeInvalid_When_FilledWithInvalidData(String str) {
        formPage.receiverName().clear().fill(str);
        assertTrue(formPage.errorReceiverName().isDisplayed());
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
        formPage.receiverEmail().clear().fill(str);
        assertEquals(str, formPage.receiverEmail().value());
    }

    @ParameterizedTest
    @ValueSource(strings = {"a@a.p", "anna", "aaa@aaa", "###@###.pl"})
    public void Should_ReceiverEmailBeInvalid_When_FilledWithInvalidData(String str) {
        formPage.receiverEmail().clear().fill(str);
        assertTrue(formPage.errorReceiverEmail().isDisplayed());
    }

    @Test
    public void Should_SenderNameBeCorrect_When_FilledWithCorrectData() {
        formPage.senderName().clear().fill(sender.getName());
        assertEquals(sender.getName(), formPage.senderName().value());
    }

    @Test
    public void Should_SenderPhoneBeCorrect_When_FilledWithCorrectData() {
        formPage.senderPhone().clear().fill(sender.getPhone());
        String phone = formPage.senderPhone().value().replace(" ", "");
        assertEquals("+48"+sender.getPhone(), phone);
    }

    @ParameterizedTest
    @ValueSource(strings = {"000000000", "aaa", "  "})
    public void Should_SenderPhoneBeInvalid_When_FilledWithInvalidData(String str) {
        formPage.senderPhone().clear().fill(str);
        assertTrue(formPage.errorSenderPhone().isDisplayed());
    }

    @ParameterizedTest
    @ValueSource(strings = {"a@a.pl", "anna@anna.pl"})
    public void Should_SenderEmailBeCorrect_When_FilledWithCorrectData(String str) {
        formPage.senderEmail().clear().fill(str);
        assertEquals(str, formPage.senderEmail().value());
    }

    @ParameterizedTest
    @ValueSource(strings = {"a@a.p", "anna", "aaa@aaa", "###@###.pl"})
    public void Should_SenderEmailBeInvalid_When_FilledWithInvalidData(String str) {
        formPage.senderEmail().clear().fill(str);
        assertTrue(formPage.errorSenderEmail().isDisplayed());
    }

    @ParameterizedTest
    @ValueSource(strings = {string251, "", " ", "$", "%", "^", "(", ")"})
    public void Should_SenderNameBeInvalid_When_FilledWithInvalidData(String str) {
        formPage.senderName().clear().fill(str).page().senderPhone().click();
        assertTrue(formPage.errorSenderName().isDisplayed());
    }

    @Nested
    @DisplayName("Parcelmachine delivery method")
    public class ReceiverParcelmachineFormTest{
        private BoxmachineFormPage boxmachineFormPage = new BoxmachineFormPage();
        private FormPage formPage = new FormPage();

        @BeforeEach
        public void setup(){
            if (!formPage.summaryReceiverMethodIcon().src().equals(Icon.BOXMACHINE.url))
                formPage.deliveryTypeBoxmachine().click();
        }

        @Test
        @DisplayName("Page loaded")
        public void Should_LoadPage() {
            Assertions.assertDoesNotThrow(() ->
                    formPage.<FormPage>init()
            );
        }

        @Test
        public void Should_ReceiverParcelmachineBeCorrect_When_FilledWithCorrectData() {
            boxmachineFormPage.parcelmachine().clear().fill(receiverPm.getParcelmachine()).confirmDropdown();
            assertTrue(boxmachineFormPage.parcelmachineFieldValue().text().contains(receiverPm.getParcelmachine()));
        }

        @ParameterizedTest
        @ValueSource(strings = {"nieistnieje", "random"})
        public void Should_ReceiverParcelmachineBeInvalid_When_FilledWithInvalidData(String str) {
            String pmBefore = boxmachineFormPage.parcelmachineFieldValue().text();
            boxmachineFormPage.parcelmachine().clear().fill(str).confirmDropdown();
            assertTrue(pmBefore.equals(boxmachineFormPage.parcelmachineFieldValue().text()));
        }

    }

    @Nested
    @DisplayName("Address delivery method")
    public class ReceiverAddresseFormTest{
        private AddressFormPage addressFormPage = new AddressFormPage();
        private FormPage formPage = new FormPage();

        @BeforeEach
        public void setup(){
            if (!formPage.summaryReceiverMethodIcon().src().equals(Icon.ADDRESS.url))
                formPage.deliveryTypeAddress().click();
        }

        @Test
        @DisplayName("Page loaded")
        public void Should_LoadPage() {
            Assertions.assertDoesNotThrow(() ->
                    formPage.<FormPage>init()
            );
        }

        @ParameterizedTest
        @ValueSource(strings = {"11-111", "random", "00-000"})
        public void Should_ReceiverZipCodeBeInvalid_When_FilledWithInvalidData(String str) {
            addressFormPage.receiverZipCode().click().clear().fill(str).clickAbove();
            assertTrue(addressFormPage.errorReceiverZipCode().isDisplayed());
        }

        @ParameterizedTest
        @ValueSource(strings = {string10, "123", "aaa"})
        public void Should_ReceiverBuildingNoBeCorrect_When_FilledWithCorrectData(String str) {
            addressFormPage.receiverBuildingNo().clear().fill(str);
            assertThrows(NoSuchElementException.class, () -> addressFormPage.errorBuildingNo().isDisplayed());
        }

        @ParameterizedTest
        @ValueSource(strings = {string11})
        public void Should_ReceiverBuildingNoBeInvalid_When_FilledWithInvalidData(String str) {
            addressFormPage.receiverBuildingNo().clear().fill(str);
            assertTrue(addressFormPage.errorBuildingNo().isDisplayed());
        }

        @ParameterizedTest
        @ValueSource(strings = {string10, "123", "aaa"})
        public void Should_ReceiverFlatNoBeCorrect_When_FilledWithCorrectData(String str) {
            addressFormPage.receiverFlatNo().clear().fill(str);
            assertThrows(NoSuchElementException.class, () -> addressFormPage.errorFlatNo().isDisplayed());
        }

        @ParameterizedTest
        @ValueSource(strings = {string11})
        public void Should_ReceiverFlatNoBeInvalid_When_FilledWithInvalidData(String str) {
            addressFormPage.receiverFlatNo().clear().fill(str);
            assertTrue(addressFormPage.errorFlatNo().isDisplayed());
        }

        @ParameterizedTest
        @ValueSource(strings = {string51})
        public void Should_ReceiverTownBeInvalid_When_FilledWithInvalidData(String str) {
            addressFormPage.receiverTown().clear().fill(str).confirmDropdown();
            assertTrue(addressFormPage.errorReceiverTown().isDisplayed());
        }

        @ParameterizedTest
        @ValueSource(strings = {"Warszawa", "cokolwiek"})
        public void Should_ReceiverTownBeCorrect_When_FilledWithCorrectData(String str) {
            addressFormPage
                    .receiverZipCode().clear().fill("01-123")
                    .page()
                    .receiverTown().waitClickable().fill(str).confirmDropdown().clickAbove();
            assertThrows(NoSuchElementException.class, () -> addressFormPage.errorReceiverTown().isDisplayed());
        }

        @ParameterizedTest
        @ValueSource(strings = {string51})
        public void Should_ReceiverStreetBeInvalid_When_FilledWithInvalidData(String str) {
            addressFormPage.receiverTown().clear().fill(str).confirmDropdown();
            assertTrue(addressFormPage.errorReceiverTown().isDisplayed());
        }

        @ParameterizedTest
        @ValueSource(strings = {"Elekcyjna", "cokolwiek"})
        public void Should_ReceiverStreetBeCorrect_When_FilledWithCorrectData(String str) {
            addressFormPage
                    .receiverZipCode().click().clear().fill("01-123")
                    .page()
                    .receiverTown().waitClickable().confirmDropdown()
                    .page()
                    .receiverStreet().waitClickable().fill(str).confirmDropdown().clickAbove();

            assertThrows(NoSuchElementException.class, () -> addressFormPage.errorReceiverStreet().isDisplayed());
        }


    }

}

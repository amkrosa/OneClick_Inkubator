package Forms;

import Helpers.Enums.Dictionaries.InvoiceDictionary;
import Helpers.Enums.Statics.Message;
import Models.Invoice;
import Selenium.Base;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class InvoiceFormTest {

    private final String string251= "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    private final String string10= "aaaaaaaaaa";
    private final String string51= "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    private final String string11= "aaaaaaaaaaa";

    @Nested
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    public class IndividualInvoiceTest extends Base{

        private final Invoice individual = InvoiceDictionary.INDIVIDUAL.invoice;

        @Test
        @Order(1)
        public void Should_DisplayIndividualInvoiceForm_When_CheckboxClicked(){
            page.Form.invoiceCheckbox().click();
            page.Invoice.clickInvoiceIndividualCheckbox();
        }

        @Test
        @Order(2)
        public void Should_CopySenderData_When_LinkActionClicked(){
            page.Form.senderEmail().fill(individual.getEmail())
                    .page().senderName().fill(individual.getName());
            page.Invoice.copySenderData().click();
            assertAll(
                    ()->assertEquals(individual.getEmail(), page.Invoice.individualEmail().value()),
                    ()->assertEquals(individual.getName(), page.Invoice.individualName().value())
                    );
        }

        @ParameterizedTest
        @ValueSource(strings = {"11-111", "random", "00-000"})
        public void Should_InvoiceIndividualZipCodeBeInvalid_When_FilledWithInvalidData(String str) {
            page.Invoice.individualZipCode().click().clear().fill(str).clickAbove();
            assertTrue(page.Invoice.errorIndividualZipCode().waitVisible().isDisplayed());
        }

        @ParameterizedTest
        @ValueSource(strings = {string10, "123", "aaa"})
        public void Should_InvoiceIndividualBuildingNoBeCorrect_When_FilledWithCorrectData(String str) {
            page.Invoice.individualBuildingNo().clear().fill(str);
            assertThrows(NoSuchElementException.class, () -> page.Invoice.errorIndividualBuildingNo().isDisplayed());
        }

        @ParameterizedTest
        @ValueSource(strings = {string11})
        public void Should_InvoiceIndividualBuildingNoBeInvalid_When_FilledWithInvalidData(String str) {
            page.Invoice.individualBuildingNo().clear().fill(str);
            assertTrue(page.Invoice.errorIndividualBuildingNo().isDisplayed());
        }

        @ParameterizedTest
        @ValueSource(strings = {string10, "123", "aaa"})
        public void Should_InvoiceIndividualFlatNoBeCorrect_When_FilledWithCorrectData(String str) {
            page.Invoice.individualFlatNo().clear().fill(str);
            assertThrows(NoSuchElementException.class, () -> page.Invoice.errorIndividualFlatNo().isDisplayed());
        }

        @ParameterizedTest
        @ValueSource(strings = {string11})
        public void Should_InvoiceIndividualFlatNoBeInvalid_When_FilledWithInvalidData(String str) {
            page.Invoice.individualFlatNo().clear().fill(str);
            assertTrue(page.Invoice.errorIndividualFlatNo().isDisplayed());
        }

        @ParameterizedTest
        @ValueSource(strings = {string51})
        public void Should_InvoiceIndividualTownBeInvalid_When_FilledWithInvalidData(String str) {
            page.Invoice.individualTown().clear().fill(str).confirmDropdown();
            assertTrue(page.Invoice.errorIndividualTown().isDisplayed());
        }

        @ParameterizedTest
        @ValueSource(strings = {"Warszawa", "cokolwiek"})
        public void Should_InvoiceIndividualTownBeCorrect_When_FilledWithCorrectData(String str) {
            page.Invoice
                    .individualZipCode().clear().fill("01-123")
                    .page()
                    .individualTown().waitClickable().fill(str).confirmDropdown().clickAbove();
            assertThrows(NoSuchElementException.class, () -> page.Invoice.errorIndividualTown().isDisplayed());
        }

        @ParameterizedTest
        @ValueSource(strings = {string51})
        public void Should_InvoiceIndividualStreetBeInvalid_When_FilledWithInvalidData(String str) {
            page.Invoice.individualTown().clear().fill(str).confirmDropdown();
            assertTrue(page.Invoice.errorIndividualTown().isDisplayed());
        }

        @ParameterizedTest
        @ValueSource(strings = {"Elekcyjna", "cokolwiek"})
        public void Should_InvoiceIndividualStreetBeCorrect_When_FilledWithCorrectData(String str) {
            page.Invoice
                    .individualZipCode().click().clear().fill("01-123")
                    .page()
                    .individualTown().waitClickable().confirmDropdown()
                    .page()
                    .individualStreet().waitClickable().fill(str).confirmDropdown().clickAbove();

            assertThrows(NoSuchElementException.class, () -> page.Invoice.errorIndividualStreet().isDisplayed());
        }


    }

    @Nested
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    public class CompanyInvoiceTest extends Base{

        private final Invoice company = InvoiceDictionary.COMPANY.invoice;

        @Test
        @Order(1)
        public void Should_DisplayCompanyInvoiceForm_When_CheckboxClicked(){
            page.Form.invoiceCheckbox().click();
            page.Invoice.clickInvoiceCompanyCheckbox();
        }

        @Test
        @Order(2)
        public void Should_LoadCompanyData_When_ValidNipIsEntered(){
            page.Invoice.companyNip().fill("6793087624");
            page.Invoice.waitNipLoad();
            assertTrue(page.Invoice.companyName().value().contains("INPOST"), "Company name contains "+page.Invoice.companyName().value());
        }

        @ParameterizedTest
        @ValueSource(strings = {"11-111", "random", "12345678999", "12345678"})
        public void Should_InvoiceCompanyNipBeInvalid_When_FilledWithInvalidData(String str) {
            page.Invoice.companyNip().click().clear().fill(str).clickAbove();
            assertTrue(page.Invoice.errorCompanyNip().waitVisible().isDisplayed());
        }

        @ParameterizedTest
        @ValueSource(strings = {"11-111", "random", "00-000"})
        public void Should_InvoiceCompanyZipCodeBeInvalid_When_FilledWithInvalidData(String str) {
            page.Invoice.companyZipCode().click().clear().fill(str).clickAbove();
            assertTrue(page.Invoice.errorCompanyZipCode().waitVisible().isDisplayed());
        }

        @ParameterizedTest
        @ValueSource(strings = {string10, "123", "aaa"})
        public void Should_InvoiceCompanyBuildingNoBeCorrect_When_FilledWithCorrectData(String str) {
            page.Invoice.companyBuildingNo().clear().fill(str);
            assertThrows(NoSuchElementException.class, () -> page.Invoice.errorCompanyBuildingNo().isDisplayed());
        }

        @ParameterizedTest
        @ValueSource(strings = {string11})
        public void Should_InvoiceCompanyBuildingNoBeInvalid_When_FilledWithInvalidData(String str) {
            page.Invoice.companyBuildingNo().clear().fill(str);
            assertTrue(page.Invoice.errorCompanyBuildingNo().isDisplayed());
        }

        @ParameterizedTest
        @ValueSource(strings = {string10, "123", "aaa"})
        public void Should_InvoiceCompanyFlatNoBeCorrect_When_FilledWithCorrectData(String str) {
            page.Invoice.companyFlatNo().clear().fill(str);
            assertThrows(NoSuchElementException.class, () -> page.Invoice.errorCompanyFlatNo().isDisplayed());
        }

        @ParameterizedTest
        @ValueSource(strings = {string11})
        public void Should_InvoiceCompanyFlatNoBeInvalid_When_FilledWithInvalidData(String str) {
            page.Invoice.companyFlatNo().clear().fill(str);
            assertTrue(page.Invoice.errorCompanyFlatNo().isDisplayed());
        }

        @ParameterizedTest
        @ValueSource(strings = {string51})
        public void Should_InvoiceCompanyTownBeInvalid_When_FilledWithInvalidData(String str) {
            page.Invoice.companyTown().clear().fill(str).confirmDropdown();
            assertTrue(page.Invoice.errorCompanyTown().isDisplayed());
        }

        @ParameterizedTest
        @ValueSource(strings = {"Warszawa", "cokolwiek"})
        public void Should_InvoiceCompanyTownBeCorrect_When_FilledWithCorrectData(String str) {
            page.Invoice
                    .companyZipCode().clear().fill("01-123")
                    .page()
                    .companyTown().waitClickable().fill(str).confirmDropdown().clickAbove();
            assertThrows(NoSuchElementException.class, () -> page.Invoice.errorCompanyTown().isDisplayed());
        }

        @ParameterizedTest
        @ValueSource(strings = {string51})
        public void Should_InvoiceCompanyStreetBeInvalid_When_FilledWithInvalidData(String str) {
            page.Invoice.companyStreet().fill(str).confirmDropdown();
            assertTrue(page.Invoice.errorCompanyStreet().isDisplayed());
        }

        @ParameterizedTest
        @ValueSource(strings = {"Elekcyjna", "cokolwiek"})
        public void Should_InvoiceCompanyStreetBeCorrect_When_FilledWithCorrectData(String str) {
            page.Invoice
                    .companyZipCode().click().clear().fill("01-123")
                    .page()
                    .companyTown().waitClickable().confirmDropdown()
                    .page()
                    .companyStreet().waitClickable().fill(str).confirmDropdown().clickAbove();

            assertThrows(NoSuchElementException.class, () -> page.Invoice.errorCompanyStreet().isDisplayed());
        }


    }

    @Nested
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    public class ForeignCompanyInvoiceTest extends Base{

        private final Invoice foreignCompany = InvoiceDictionary.FOREIGN_COMPANY.invoice;

        @Test
        @Order(1)
        public void Should_DisplayForeignCompanyInvoiceForm_When_CheckboxClicked(){
            page.Form.invoiceCheckbox().click();
            page.Invoice.clickInvoiceForeignCompanyCheckbox();
        }

        @Test
        public void Should_NipBeRequired_When_PrefixIsSelected(){
            page.Invoice.foreignCompanyPrefixInput().clear().page().foreignCompanyCountryInput().clear();
            page.Invoice.foreignCompanyPrefixInput().clear().fill("be").confirmDropdown();
            assertTrue(page.Invoice.errorForeignCompanyNip().waitVisible().isDisplayed());
        }

        @ParameterizedTest
        @ValueSource(strings = {"11-111", "random", "12345678999", "12345678"})
        public void Should_InvoiceForeignCompanyNipBeInvalid_When_FilledWithInvalidData(String str) {
            page.Invoice.foreignCompanyPrefixInput().clear().fill("BE").waitClickable().confirmDropdown();
            page.Invoice.foreignCompanyNip().click().clear().fill(str).clickAbove();
            assertTrue(page.Invoice.errorForeignCompanyNip().waitVisible().isDisplayed());
        }

        @ParameterizedTest
        @ValueSource(strings = {"123456789"})
        public void Should_InvoiceForeignCompanyNipBeCorrect_When_FilledWithCorrectData(String str) {
            page.Invoice.foreignCompanyPrefixInput().clear().fill("DE").waitClickable().confirmDropdown();
            page.Invoice.foreignCompanyNip().clear().fill(str).clickAbove();
            assertThrows(NoSuchElementException.class, () -> page.Invoice.errorForeignCompanyNip().isDisplayed());
        }

        @ParameterizedTest
        @ValueSource(strings = {"be", "lu"})
        public void Should_InvoiceForeignCompanyPrefixBeCorrect_When_FilledWithCorrectData(String str) {
            page.Invoice.foreignCompanyPrefixInput().clear().fill(str).waitClickable().confirmDropdown();
            assertEquals(str.toUpperCase(), page.Invoice.foreignCompanyPrefixInput().value());
        }

        @ParameterizedTest
        @ValueSource(strings = {"belgia", "luksemburg"})
        public void Should_InvoiceForeignCompanyCountryBeCorrect_When_FilledWithCorrectData(String str) {
            page.Invoice.foreignCompanyCountryInput().clear().fill(str).waitClickable().confirmDropdown();
            assertThrows(NoSuchElementException.class, () -> page.Invoice.errorForeignCompanyCountry().isDisplayed());
        }

        @Order(2)
        @ParameterizedTest
        @ValueSource(strings = {"nieistniejace", "panstwo"})
        public void Should_InvoiceForeignCompanyCountryBeInvalid_When_FilledWithInvalidData(String str) {
            page.Invoice.foreignCompanyCountryInput().clear().fill(str);
            boolean result = page.Invoice.isTextFound(Message.DROPDOWN_NOTFOUND.pl)
                    || page.Invoice.isTextFound(Message.DROPDOWN_NOTFOUND.en);
            assertTrue(result);
        }

        @ParameterizedTest
        @ValueSource(strings = {string251})
        public void Should_InvoiceForeignCompanyZipCodeBeInvalid_When_FilledWithInvalidData(String str) {
            page.Invoice.foreignCompanyZipCode().clear().click().fill(str).clickAbove();
            assertDoesNotThrow(
                    ()->assertTrue(page.Invoice.errorForeignCompanyZipCode().waitVisible().isDisplayed())
            );
        }

        @ParameterizedTest
        @ValueSource(strings = {string10, "123", "aaa"})
        public void Should_InvoiceForeignCompanyBuildingNoBeCorrect_When_FilledWithCorrectData(String str) {
            page.Invoice.foreignCompanyBuildingNo().clear().fill(str);
            assertThrows(NoSuchElementException.class, () -> page.Invoice.errorForeignCompanyBuildingNo().isDisplayed());
        }

        @ParameterizedTest
        @ValueSource(strings = {string11})
        public void Should_InvoiceForeignCompanyBuildingNoBeInvalid_When_FilledWithInvalidData(String str) {
            page.Invoice.foreignCompanyBuildingNo().clear().fill(str);
            assertTrue(page.Invoice.errorForeignCompanyBuildingNo().isDisplayed());
        }

        @ParameterizedTest
        @ValueSource(strings = {string10, "123", "aaa"})
        public void Should_InvoiceForeignCompanyFlatNoBeCorrect_When_FilledWithCorrectData(String str) {
            page.Invoice.foreignCompanyFlatNo().clear().fill(str);
            assertThrows(NoSuchElementException.class, () -> page.Invoice.errorForeignCompanyFlatNo().isDisplayed());
        }

        @ParameterizedTest
        @ValueSource(strings = {string11})
        public void Should_InvoiceForeignCompanyFlatNoBeInvalid_When_FilledWithInvalidData(String str) {
            page.Invoice.foreignCompanyFlatNo().clear().fill(str);
            assertTrue(page.Invoice.errorForeignCompanyFlatNo().isDisplayed());
        }

        @ParameterizedTest
        @ValueSource(strings = {string51})
        public void Should_InvoiceForeignCompanyTownBeInvalid_When_FilledWithInvalidData(String str) {
            page.Invoice.foreignCompanyTown().clear().fill(str);
            assertTrue(page.Invoice.errorForeignCompanyTown().isDisplayed());
        }

        @ParameterizedTest
        @ValueSource(strings = {"Warszawa", "cokolwiek"})
        public void Should_InvoiceForeignCompanyTownBeCorrect_When_FilledWithCorrectData(String str) {
            page.Invoice.foreignCompanyTown().clear().waitClickable().fill(str).clickAbove();
            assertThrows(NoSuchElementException.class, () -> page.Invoice.errorForeignCompanyTown().isDisplayed());
        }

        @ParameterizedTest
        @ValueSource(strings = {string51})
        public void Should_InvoiceForeignCompanyStreetBeInvalid_When_FilledWithInvalidData(String str) {
            page.Invoice.foreignCompanyTown().clear().fill(str);
            assertTrue(page.Invoice.errorForeignCompanyTown().isDisplayed());
        }

        @ParameterizedTest
        @ValueSource(strings = {"Elekcyjna", "cokolwiek"})
        public void Should_InvoiceForeignCompanyStreetBeCorrect_When_FilledWithCorrectData(String str) {

            assertThrows(NoSuchElementException.class, () -> page.Invoice.errorForeignCompanyStreet().isDisplayed());
        }


    }

}


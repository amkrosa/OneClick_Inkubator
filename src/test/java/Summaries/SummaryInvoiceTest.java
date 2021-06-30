package Summaries;

import Helpers.Enums.Dictionaries.ClientDictionary;
import Helpers.Enums.Dictionaries.InvoiceDictionary;
import Helpers.Enums.Statics.StaticText;
import Helpers.Enums.Types.DeliveryMethod;
import Helpers.Enums.Types.InvoiceType;
import Models.Client;
import Models.Invoice;
import Pages.Navigate;
import Selenium.Base;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SummaryInvoiceTest {

    private final Client receiverPm = ClientDictionary.BOXMACHINE.client;
    private final Client sender = ClientDictionary.SENDER.client;
    private final Client receiverAddress = ClientDictionary.ADDRESS.client;

    @Nested
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class SummaryInvoiceIndividualTest extends Base {

        private final Invoice invoice = InvoiceDictionary.INDIVIDUAL.invoice;

        @Test
        @Order(1)
        public void Should_DisplayModalSummary_When_FormFilledWithCorrectData_And_SubmitIsClicked() {
            Navigate.FillFormPage(page.Form, DeliveryMethod.BOXMACHINE, receiverPm, sender);
            Navigate.FillInvoice(page.Form, InvoiceType.INDIVIDUAL_PERSON, invoice);
            assertTrue(page.Form.submit(), "Modal was not displayed.");
        }

        @Test
        @Order(2)
        public void Should_DisplayCorrectIndividualInvoiceDataInModalSummary_When_Submitted() {
            page.ModalSummary.setInvoiceType(InvoiceType.INDIVIDUAL_PERSON).setInvoiceFields();
            assertAll(() -> assertEquals(invoice.getName(), page.ModalSummary.invoiceCompanyName().text()),
                    ()->  assertEquals(invoice.getZipCode()+" "+invoice.getCity(), page.ModalSummary.invoiceZipCodeCity().text()),
                    ()->  assertEquals(invoice.getStreet()+" "+invoice.getBuildingNo()+"/"+invoice.getFlatNo(), page.ModalSummary.invoiceStreetBuildingNo().text())
            );
        }

        @Test
        @Order(3)
        public void Should_DisplayCorrectIndividualInvoiceDataInFinalSummary_When_Submitted() {
            page.FinalSummary.setPaymentStatus(StaticText.SUMMARY_TRANSACTION_SUCCESS);
            Navigate.FromModalSummaryToFinalSummary(page.FinalSummary);
            page.FinalSummary.setInvoiceType(InvoiceType.INDIVIDUAL_PERSON).setInvoiceFields();
            assertAll(() -> assertEquals(invoice.getName(), page.FinalSummary.invoiceCompanyName().text()),
                    ()->  assertEquals(invoice.getZipCode()+" "+invoice.getCity(), page.FinalSummary.invoiceZipCodeCity().text()),
                    ()->  assertEquals(invoice.getStreet()+" "+invoice.getBuildingNo()+"/"+invoice.getFlatNo(), page.FinalSummary.invoiceStreetBuildingNo().text())
            );
        }
    }
    @Nested
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class SummaryCompanyInvoiceTest extends Base {

        private final Invoice invoice = InvoiceDictionary.COMPANY.invoice;

        @Test
        @Order(1)
        public void Should_DisplayModalSummary_When_FormFilledWithCorrectData_And_SubmitIsClicked() {
            Navigate.FillFormPage(page.Form, DeliveryMethod.BOXMACHINE, receiverPm, sender);
            Navigate.FillInvoice(page.Form, InvoiceType.COMPANY, invoice);
            assertTrue(page.Form.submit(), "Modal was not displayed.");
        }

        @Test
        @Order(2)
        public void Should_DisplayCorrectCompanyInvoiceDataInModalSummary_When_Submitted() {
            page.ModalSummary.setInvoiceType(InvoiceType.COMPANY).setInvoiceFields();
            assertAll(() -> assertEquals(invoice.getName(), page.ModalSummary.invoiceCompanyName().text()),
                    () -> assertEquals("NIP: "+invoice.getNip(), page.ModalSummary.invoiceNip().text()),
                    ()->  assertEquals(invoice.getZipCode()+" "+invoice.getCity(), page.ModalSummary.invoiceZipCodeCity().text()),
                    ()->  assertEquals(invoice.getStreet()+" "+invoice.getBuildingNo()+"/"+invoice.getFlatNo(), page.ModalSummary.invoiceStreetBuildingNo().text())
            );
        }

        @Test
        @Order(3)
        public void Should_DisplayCorrectCompanyInvoiceDataInFinalSummary_When_Submitted() {
            page.FinalSummary.setPaymentStatus(StaticText.SUMMARY_TRANSACTION_SUCCESS);
            Navigate.FromModalSummaryToFinalSummary(page.FinalSummary);
            page.FinalSummary.setInvoiceType(InvoiceType.COMPANY).setInvoiceFields();
            assertAll(() -> assertEquals(invoice.getName(), page.FinalSummary.invoiceCompanyName().text()),
                    () -> assertEquals("NIP: PL"+invoice.getNip(), page.FinalSummary.invoiceNip().text()),
                    ()->  assertEquals(invoice.getZipCode()+" "+invoice.getCity(), page.FinalSummary.invoiceZipCodeCity().text()),
                    ()->  assertEquals(invoice.getStreet()+" "+invoice.getBuildingNo()+"/"+invoice.getFlatNo(), page.FinalSummary.invoiceStreetBuildingNo().text())
            );
        }
    }
    @Nested
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class SummaryForeignCompanyIndividualTest extends Base {

        private final Invoice invoice = InvoiceDictionary.FOREIGN_COMPANY.invoice;

        @Test
        @Order(1)
        public void Should_DisplayModalSummary_When_FormFilledWithCorrectData_And_SubmitIsClicked() {
            Navigate.FillFormPage(page.Form, DeliveryMethod.BOXMACHINE, receiverPm, sender);
            Navigate.FillInvoice(page.Form, InvoiceType.FOREIGN_COMPANY, invoice);
            assertTrue(page.Form.submit(), "Modal was not displayed.");
        }

        @Test
        @Order(2)
        public void Should_DisplayCorrectIndividualInvoiceDataInModalSummary_When_Submitted() {
            page.ModalSummary.setInvoiceType(InvoiceType.FOREIGN_COMPANY).setInvoiceFields();
            assertAll(() -> assertEquals(invoice.getName(), page.ModalSummary.invoiceCompanyName().text()),
                    () -> assertEquals("NIP: "+invoice.getNip(), page.ModalSummary.invoiceNip().text()),
                    ()->  assertEquals(invoice.getZipCode()+" "+invoice.getCity(), page.ModalSummary.invoiceZipCodeCity().text()),
                    ()->  assertEquals(invoice.getStreet()+" "+invoice.getBuildingNo()+"/"+invoice.getFlatNo(), page.ModalSummary.invoiceStreetBuildingNo().text())
            );
        }

        @Test
        @Order(3)
        public void Should_DisplayCorrectIndividualInvoiceDataInFinalSummary_When_Submitted() {
            page.FinalSummary.setPaymentStatus(StaticText.SUMMARY_TRANSACTION_SUCCESS);
            Navigate.FromModalSummaryToFinalSummary(page.FinalSummary);
            page.FinalSummary.setInvoiceType(InvoiceType.FOREIGN_COMPANY).setInvoiceFields();
            assertAll(() -> assertEquals(invoice.getName(), page.FinalSummary.invoiceCompanyName().text()),
                    () -> assertEquals("NIP: "+invoice.getPrefix()+invoice.getNip(), page.FinalSummary.invoiceNip().text()),
                    ()->  assertEquals(invoice.getZipCode()+" "+invoice.getCity(), page.FinalSummary.invoiceZipCodeCity().text()),
                    ()->  assertEquals(invoice.getStreet()+" "+invoice.getBuildingNo()+"/"+invoice.getFlatNo(), page.FinalSummary.invoiceStreetBuildingNo().text())
            );
        }
    }
}

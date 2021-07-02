package ParcelCreation;

import Helpers.Enums.Dictionaries.ClientDictionary;
import Helpers.Enums.Statics.StaticText;
import Helpers.Enums.Types.DeliveryMethod;
import Helpers.FileHelper;
import Models.Client;
import Pages.Home.FormPage;
import Pages.Navigate;
import Pages.Payment.PaymentFormPage;
import Pages.Summary.SummaryPage;
import Selenium.Base;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ParcelCreationTest {

    private final Client receiverPm = ClientDictionary.BOXMACHINE.client,
            receiverAddress = ClientDictionary.ADDRESS.client,
            sender = ClientDictionary.SENDER.client;

    @Nested
    @Order(1)
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    @DisplayName("Parcelmachine delivery method")
    public class ParcelmachineDeliveryTest extends Base {

        @Test
        @Order(1)
        @DisplayName("Page loaded")
        public void Should_LoadPage() {
            Assertions.assertDoesNotThrow(() ->
                    page.Form.<FormPage>init()
            );
        }

        @Test
        @Order(2)
        public void Should_FormBeFilledCorrectly_When_FilledWithCorrectData() {
            Navigate.FillFormPage(page.Form, DeliveryMethod.BOXMACHINE, receiverPm, sender);
        }

        @Test
        @Order(3)
        public void Should_DisplaySummaryModal_When_FormIsSubmitted() {
            assertTrue(page.Form.submit());
        }

        @Test
        @Order(4)
        public void Should_LoadPaymentPage_When_PayIsClicked() {
            page.ModalSummary.payButton().click();
            assertDoesNotThrow(() ->
                    page.PaymentForm.<PaymentFormPage>init()
            );
        }

        @Test
        @Order(5)
        public void Should_RedirectToFinalSummary_When_PaymentIsDone() {
            Navigate.ThroughPaymentPage(page.PaymentForm, StaticText.SUMMARY_TRANSACTION_SUCCESS);
            page.FinalSummary.setPaymentStatus(StaticText.SUMMARY_TRANSACTION_SUCCESS);
            assertDoesNotThrow(() ->
                    page.FinalSummary.<SummaryPage>init()
            );
        }

        @Test
        @Order(6)
        public void Should_DownloadLabel_When_ButtonClicked() throws IOException {
            FileHelper fileHelper = new FileHelper();
            assertTrue(page.FinalSummary.downloadLabel());
            assertTrue(fileHelper.isLatestFileNew());
        }
    }


    @Nested
    @Order(2)
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    @DisplayName("Address delivery method")
    public class AddressDeliveryTest extends Base {

        @Test
        @Order(1)
        @DisplayName("Page loaded")
        public void Should_LoadPage() {
            Assertions.assertDoesNotThrow(() ->
                    page.Form.<FormPage>init()
            );
        }

        @Test
        @Order(2)
        public void Should_FormBeFilledCorrectly_When_FilledWithCorrectData() {
            Navigate.FillFormPage(page.Form, DeliveryMethod.ADDRESS, receiverAddress, sender);
        }

        @Test
        @Order(3)
        public void Should_DisplaySummaryModal_When_FormIsSubmitted() {
            assertTrue(page.Form.submit());
        }

        @Test
        @Order(4)
        public void Should_LoadPaymentPage_When_PayIsClicked() {
            page.ModalSummary.payButton().click();
            assertDoesNotThrow(() ->
                    page.PaymentForm.<PaymentFormPage>init()
            );
        }

        @Test
        @Order(5)
        public void Should_RedirectToFinalSummary_When_PaymentIsDone() {
            Navigate.ThroughPaymentPage(page.PaymentForm, StaticText.SUMMARY_TRANSACTION_SUCCESS);
            page.FinalSummary.setPaymentStatus(StaticText.SUMMARY_TRANSACTION_SUCCESS);
            assertDoesNotThrow(() ->
                    page.FinalSummary.<SummaryPage>init()
            );
        }

        @Test
        @Order(6)
        public void Should_DownloadLabel_When_ButtonClicked() throws IOException {
            FileHelper fileHelper = new FileHelper();
            assertTrue(page.FinalSummary.downloadLabel());
            assertTrue(fileHelper.isLatestFileNew());
        }
    }

}

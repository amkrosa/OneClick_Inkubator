package Payment;

import Helpers.Enums.Dictionaries.ClientDictionary;
import Helpers.Enums.Types.DeliveryMethod;
import Helpers.Enums.Statics.StaticText;
import Pages.Navigate;
import Models.Client;
import Pages.Home.FormPage;
import Pages.Payment.PaymentFormPage;
import Pages.Summary.SummaryPage;
import Selenium.Base;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.TimeoutException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@Execution(ExecutionMode.CONCURRENT)
public class PaymentTest {

    private final Client receiverPm = ClientDictionary.BOXMACHINE.client;
    private final Client sender = ClientDictionary.SENDER.client;

    @Nested
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    @DisplayName("Payment successful")
    public class PaymentSuccessfulTest extends Base{

        @Test
        @Order(2)
        public void Should_RedirectToPaymentPage_When_FilledFormIsSubmitted(){
            Navigate.FillFormPage(page.Form, DeliveryMethod.BOXMACHINE, receiverPm, sender);
            page.Form.submit();
            page.ModalSummary.payButton().click();
            assertDoesNotThrow(() ->
                    page.PaymentForm.<PaymentFormPage>init()
            );
        }
        @Test
        @Order(3)
        public void Should_RedirectToFinalSummary_When_PaymentIsSuccessful(){
            Navigate.ThroughPaymentPage(page.PaymentForm);
            page.PaymentRedirect.confirmedPaymentButton().click();
            page.FinalSummary.setPaymentStatus(StaticText.SUMMARY_TRANSACTION_SUCCESS);
            assertDoesNotThrow((Executable)page.FinalSummary::<SummaryPage>init);
        }
        @Test
        @Order(4)
        public void Should_DisplaySuccessfulPaymentText_When_InFinalSummary() {
            assertTrue(page.FinalSummary.isTextFound(Base.config.getLanguage().equals("pl")
                    ? StaticText.SUMMARY_TRANSACTION_SUCCESS.pl
                    : StaticText.SUMMARY_TRANSACTION_SUCCESS.en));
        }
    }

    @Nested
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    @DisplayName("Payment failed")
    public class PaymentFailedTest extends Base{

        @Test
        @Order(2)
        public void Should_RedirectToPaymentPage_When_FilledFormIsSubmitted(){
            Navigate.FillFormPage(page.Form, DeliveryMethod.BOXMACHINE, receiverPm, sender);
            page.Form.submit();
            page.ModalSummary.payButton().click();
            assertDoesNotThrow(() ->
                    page.PaymentForm.<PaymentFormPage>init()
            );
        }
        @Test
        @Order(3)
        public void Should_RedirectToFinalSummary_When_PaymentIsFailed(){
            Navigate.ThroughPaymentPage(page.PaymentForm);
            page.PaymentRedirect.rejectedPaymentButton().click();
            page.FinalSummary.setPaymentStatus(StaticText.SUMMARY_TRANSACTION_FAILURE);
            assertDoesNotThrow((Executable)page.FinalSummary::<SummaryPage>init);
        }
        @Test
        @Order(4)
        public void Should_DisplayFailedPaymentText_When_InFinalSummary(){
            assertTrue(page.FinalSummary.isTextFound(Base.config.getLanguage().equals("pl")
                    ? StaticText.SUMMARY_TRANSACTION_FAILURE.pl
                    : StaticText.SUMMARY_TRANSACTION_FAILURE.en));
        }
    }

    @Nested
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    @DisplayName("Payment pending")
    public class PaymentPendingTest extends Base{

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
        public void Should_RedirectToPaymentPage_When_FilledFormIsSubmitted(){
            Navigate.FillFormPage(page.Form, DeliveryMethod.BOXMACHINE, receiverPm, sender);
            page.Form.submit();
            page.ModalSummary.payButton().click();
            assertDoesNotThrow((Executable)page.PaymentForm::<PaymentFormPage>init);
        }
        @Test
        @Order(3)
        public void Should_RedirectToFinalSummary_When_PaymentIsPending(){
            Navigate.ThroughPaymentPage(page.PaymentForm);
            page.PaymentRedirect.pendingPaymentButton().click();
            assertTrue(page.FinalSummary.refreshButton().waitVisible().isDisplayed());
        }
        @Test
        @Order(4)
        public void Should_ThrowTimeoutException_When_InFinalSummaryAndPendingAfterPeriodOfTime(){
            assertThrows(TimeoutException.class,page.FinalSummary::<SummaryPage>init);
        }
    }

}

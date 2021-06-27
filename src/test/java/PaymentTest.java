import Configs.Environment;
import Helpers.Enums.DeliveryMethod;
import Helpers.Enums.StaticText;
import Models.Client;
import Pages.FormPage;
import Pages.PaymentFormPage;
import Pages.PaymentRedirectPage;
import Pages.SummaryPage;
import SeleniumBase.Base;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.function.ThrowingSupplier;
import org.openqa.selenium.TimeoutException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PaymentTest {

    private final Client receiverPm = new Client("Anna Krasowska", "123123123", "anna@anna.pl", "KRA01M");
    private final Client sender = new Client("Magda Asowska", "321321321", "magda@magda.pl");
    private final FormPage formPage = new FormPage();
    private final PaymentFormPage paymentFormPage = new PaymentFormPage();
    private final PaymentRedirectPage paymentRedirectPage = new PaymentRedirectPage();

    @Nested
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    @DisplayName("Payment successful")
    public class PaymentSuccessfulTest extends Base{
        private final SummaryPage finalSummaryPage = new SummaryPage("final", DeliveryMethod.BOXMACHINE);


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
        public void Should_RedirectToPaymentPage_When_FilledFormIsSubmitted(){
            formPage.fillForm(DeliveryMethod.BOXMACHINE, receiverPm, sender);
            formPage.submit();
            new SummaryPage("modal", DeliveryMethod.BOXMACHINE).payButton().click();
            assertDoesNotThrow(() ->
                    paymentFormPage.<PaymentFormPage>init()
            );
        }
        @Test
        @Order(3)
        public void Should_RedirectToFinalSummary_When_PaymentIsSuccessful(){
            paymentFormPage
                    .emailField().fill(sender.getEmail())
                    .page()
                    .mtransferPaymentButton().click()
                    .page()
                    .finishButton().click();
            paymentRedirectPage.confirmedPaymentButton().click();
            assertDoesNotThrow((Executable)finalSummaryPage::<SummaryPage>init);
        }
        @Test
        @Order(4)
        public void Should_DisplaySuccessfulPaymentText_When_InFinalSummary(){
            assertTrue(finalSummaryPage.isTextFound(Base.config.getLanguage().equals("pl")
                    ? StaticText.SUMMARY_TRANSACTION_SUCCESS.pl
                    : StaticText.SUMMARY_TRANSACTION_SUCCESS.en));
        }
    }

    @Nested
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    @DisplayName("Payment failed")
    public class PaymentFailedTest extends Base{
        private final SummaryPage finalSummaryPage = new SummaryPage("final", DeliveryMethod.BOXMACHINE);


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
        public void Should_RedirectToPaymentPage_When_FilledFormIsSubmitted(){
            formPage.fillForm(DeliveryMethod.BOXMACHINE, receiverPm, sender);
            formPage.submit();
            new SummaryPage("modal", DeliveryMethod.BOXMACHINE).payButton().click();
            assertDoesNotThrow(() ->
                    paymentFormPage.<PaymentFormPage>init()
            );
        }
        @Test
        @Order(3)
        public void Should_RedirectToFinalSummary_When_PaymentIsFailed(){
            paymentFormPage
                    .emailField().fill(sender.getEmail())
                    .page()
                    .mtransferPaymentButton().click()
                    .page()
                    .finishButton().click();
            paymentRedirectPage.rejectedPaymentButton().click();
            assertDoesNotThrow((Executable)finalSummaryPage::<SummaryPage>init);
        }
        @Test
        @Order(4)
        public void Should_DisplayFailedPaymentText_When_InFinalSummary(){
            assertTrue(finalSummaryPage.isTextFound(Base.config.getLanguage().equals("pl")
                    ? StaticText.SUMMARY_TRANSACTION_FAILURE.pl
                    : StaticText.SUMMARY_TRANSACTION_FAILURE.en));
        }
    }

    @Nested
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    @DisplayName("Payment pending")
    public class PaymentPendingTest extends Base{
        private final SummaryPage finalSummaryPage = new SummaryPage("final", DeliveryMethod.BOXMACHINE, StaticText.SUMMARY_TRANSACTION_SUCCESS);

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
        public void Should_RedirectToPaymentPage_When_FilledFormIsSubmitted(){
            formPage.fillForm(DeliveryMethod.BOXMACHINE, receiverPm, sender);
            formPage.submit();
            new SummaryPage("modal", DeliveryMethod.BOXMACHINE).payButton().click();
            assertDoesNotThrow(() ->
                    paymentFormPage.<PaymentFormPage>init()
            );
        }
        @Test
        @Order(3)
        public void Should_RedirectToFinalSummary_When_PaymentIsPending(){
            paymentFormPage
                    .emailField().fill(sender.getEmail())
                    .page()
                    .mtransferPaymentButton().click()
                    .page()
                    .finishButton().click();
            paymentRedirectPage.pendingPaymentButton().click();
        }
        @Test
        @Order(4)
        public void Should_ThrowTimeoutException_When_InFinalSummaryAndPendingAfterPeriodOfTime(){
            assertThrows(TimeoutException.class,finalSummaryPage::<SummaryPage>init);
        }
    }

}

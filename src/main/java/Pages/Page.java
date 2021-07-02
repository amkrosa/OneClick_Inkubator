package Pages;

import Helpers.Enums.Types.SummaryType;
import Pages.Home.AddressFormPage;
import Pages.Home.BoxmachineFormPage;
import Pages.Home.FormPage;
import Pages.Home.InvoiceFormPage;
import Pages.Payment.PaymentFormPage;
import Pages.Payment.PaymentRedirectPage;
import Pages.Summary.SummaryPage;
import org.openqa.selenium.WebDriver;

/**
 * Class storing all pages for current test instance.
 */

public class Page {

    public final SummaryPage ModalSummary, FinalSummary;
    public final FormPage Form;
    public final InvoiceFormPage Invoice;
    public final BoxmachineFormPage BoxmachineForm;
    public final PaymentFormPage PaymentForm;
    public final AddressFormPage AddressForm;
    public final PaymentRedirectPage PaymentRedirect;

    public Page(WebDriver driver) {
        ModalSummary = new SummaryPage(SummaryType.MODAL, driver);
        FinalSummary = new SummaryPage(SummaryType.FINAL, driver);
        Form = new FormPage(driver);
        Invoice = new InvoiceFormPage(driver);
        BoxmachineForm = new BoxmachineFormPage(driver);
        PaymentForm = new PaymentFormPage(driver);
        AddressForm = new AddressFormPage(driver);
        PaymentRedirect = new PaymentRedirectPage(driver);
    }
}

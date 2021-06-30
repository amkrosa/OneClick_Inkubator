package Pages;

import Helpers.Enums.Types.SummaryType;
import Pages.Home.AddressFormPage;
import Pages.Home.BoxmachineFormPage;
import Pages.Home.FormPage;
import Pages.Home.InvoiceFormPage;
import Pages.Payment.PaymentFormPage;
import Pages.Payment.PaymentRedirectPage;
import Pages.Summary.SummaryPage;

public class Page {

    public final SummaryPage ModalSummary, FinalSummary;
    public final FormPage Form;
    public final InvoiceFormPage Invoice;
    public final BoxmachineFormPage BoxmachineForm;
    public final PaymentFormPage PaymentForm;
    public final AddressFormPage AddressForm;
    public final PaymentRedirectPage PaymentRedirect;

    public Page() {
        ModalSummary = new SummaryPage(SummaryType.MODAL);
        FinalSummary = new SummaryPage(SummaryType.FINAL);
        Form = new FormPage();
        Invoice = new InvoiceFormPage();
        BoxmachineForm = new BoxmachineFormPage();
        PaymentForm = new PaymentFormPage();
        AddressForm = new AddressFormPage();
        PaymentRedirect = new PaymentRedirectPage();
    }
}

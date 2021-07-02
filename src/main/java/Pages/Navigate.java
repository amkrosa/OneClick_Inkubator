package Pages;

import Helpers.Enums.Statics.StaticText;
import Helpers.Enums.Types.DeliveryMethod;
import Helpers.Enums.Types.InvoiceType;
import Helpers.Enums.Types.SummaryType;
import Models.Client;
import Models.Invoice;
import Pages.Home.AddressFormPage;
import Pages.Home.BoxmachineFormPage;
import Pages.Home.FormPage;
import Pages.Home.InvoiceFormPage;
import Pages.Payment.PaymentFormPage;
import Pages.Payment.PaymentRedirectPage;
import Pages.Summary.SummaryPage;


/**
 * Class with static methods for help with navigation through page and filling out forms.
 */
public class Navigate {

    public static void FromFormToFinalSummary(SummaryPage finalSummaryPage, Client receiver, Client sender) {
        FormPage formPage = new FormPage(finalSummaryPage.getDriver());

        FillFormPage(formPage, finalSummaryPage.getDeliveryMethod(), receiver, sender);
        formPage.submit();
        FromModalSummaryToFinalSummary(finalSummaryPage);
    }

    public static void FromModalSummaryToFinalSummary(SummaryPage finalSummaryPage) {
        new SummaryPage(SummaryType.MODAL, finalSummaryPage.getDriver()).payButton().click();
        ThroughPaymentPage(new PaymentFormPage(finalSummaryPage.getDriver()), StaticText.SUMMARY_TRANSACTION_SUCCESS);
        finalSummaryPage.<SummaryPage>init();
    }

    public static void FillFormPage(FormPage formPage, DeliveryMethod deliveryMethod, Client receiver, Client sender) {
        formPage.init();
        formPage.receiverName().fill(receiver.getName())
                .page()
                .receiverEmail().fill(receiver.getEmail())
                .page()
                .receiverPhone().fill(receiver.getPhone());

        if (deliveryMethod == DeliveryMethod.ADDRESS) {
            formPage.deliveryTypeAddress().click();
            AddressFormPage addressFormPage = new AddressFormPage(formPage.getDriver());
            addressFormPage.receiverZipCode().fill(receiver.getZipCode())
                    .page()
                    .receiverTown().confirmDropdown()
                    .page()
                    .receiverStreet().confirmDropdown()
                    .page()
                    .receiverBuildingNo().fill(receiver.getBuildingNo())
                    .page()
                    .receiverFlatNo().fill(receiver.getFlatNo());
        } else {
            formPage.deliveryTypeBoxmachine().click();
            new BoxmachineFormPage(formPage.getDriver()).parcelmachine().fill(receiver.getParcelmachine()).confirmDropdown();
        }

        formPage.senderName().fill(sender.getName())
                .page()
                .senderEmail().fill(sender.getEmail())
                .page()
                .senderPhone().fill(sender.getPhone());

        formPage
                .terms()
                .click();
    }

    public static void FillInvoice(FormPage formPage, InvoiceType invoiceType, Invoice invoice) {
        InvoiceFormPage invoiceFormPage = new InvoiceFormPage(formPage.getDriver());

        formPage.invoiceCheckbox().click();

        switch (invoiceType) {
            case INDIVIDUAL_PERSON:
                invoiceFormPage
                        .clickInvoiceIndividualCheckbox()
                        .individualEmail().fill(invoice.getEmail())
                        .page()
                        .individualName().fill(invoice.getName())
                        .page()
                        .individualZipCode().fill(invoice.getZipCode())
                        .page()
                        .individualTown().waitClickable().fill(invoice.getCity()).confirmDropdown().clickAbove()
                        .page()
                        .individualStreet().waitClickable().fill(invoice.getStreet()).confirmDropdown().clickAbove()
                        .page()
                        .individualBuildingNo().fill(invoice.getBuildingNo())
                        .page()
                        .individualFlatNo().fill(invoice.getFlatNo());
                break;
            case COMPANY:
                invoiceFormPage.clickInvoiceCompanyCheckbox()
                        .companyNip().fill(invoice.getNip())
                        .page().waitNipLoad()
                        .companyEmail().waitClickable().clear().fill(invoice.getEmail())
                        .page()
                        .companyName().clear().fill(invoice.getName())
                        .page()
                        .companyZipCode().clear().fill(invoice.getZipCode())
                        .page()
                        .companyTown().waitClickable().fill(invoice.getCity()).confirmDropdown().clickAbove()
                        .page()
                        .companyStreet().waitClickable().fill(invoice.getStreet()).confirmDropdown().clickAbove()
                        .page()
                        .companyBuildingNo().clear().fill(invoice.getBuildingNo())
                        .page()
                        .companyFlatNo().clear().fill(invoice.getFlatNo());
                break;
            case FOREIGN_COMPANY:
                invoiceFormPage.clickInvoiceForeignCompanyCheckbox()
                        .foreignCompanyPrefixInput().fill(invoice.getPrefix()).confirmDropdown()
                        .page()
                        .foreignCompanyNip().fill(invoice.getNip())
                        .page()
                        .foreignCompanyCountryInput().fill(invoice.getCountry()).confirmDropdown()
                        .page()
                        .foreignCompanyEmail().fill(invoice.getEmail())
                        .page()
                        .foreignCompanyName().fill(invoice.getName())
                        .page()
                        .foreignCompanyZipCode().fill(invoice.getZipCode())
                        .page()
                        .foreignCompanyTown().waitClickable().fill(invoice.getCity())
                        .page()
                        .foreignCompanyStreet().waitClickable().fill(invoice.getStreet())
                        .page()
                        .foreignCompanyBuildingNo().fill(invoice.getBuildingNo())
                        .page()
                        .foreignCompanyFlatNo().fill(invoice.getFlatNo());
                break;
        }

    }

    public static void ThroughPaymentPage(PaymentFormPage paymentFormPage) {
        paymentFormPage
                .<PaymentFormPage>init()
                .emailField().fill("test@test.pl")
                .page()
                .mtransferPaymentButton().click()
                .page()
                .finishButton().click();
    }

    public static void ThroughPaymentPage(PaymentFormPage paymentFormPage, StaticText paymentStatus) {
        ThroughPaymentPage(paymentFormPage);
        PaymentRedirectPage paymentRedirectPage = new PaymentRedirectPage(paymentFormPage.getDriver());
        paymentRedirectPage.init();
        switch (paymentStatus) {
            case SUMMARY_TRANSACTION_SUCCESS:
                paymentRedirectPage.confirmedPaymentButton().click();
                break;
            case SUMMARY_TRANSACTION_FAILURE:
                paymentRedirectPage.rejectedPaymentButton().click();
                break;
            case SUMMARY_TRANSACTION_PENDING:
                paymentRedirectPage.pendingPaymentButton().click();
                break;
        }
    }

    public static void ClearInvoiceForm(InvoiceType invoiceType, InvoiceFormPage invoiceFormPage) {
        switch (invoiceType) {
            case INDIVIDUAL_PERSON:
                invoiceFormPage.individualEmail().clear()
                        .page()
                        .individualName().clear()
                        .page()
                        .individualZipCode().clear()
                        .page()
                        .individualTown().waitClickable().clear()
                        .page()
                        .individualStreet().waitClickable().clear()
                        .page()
                        .individualBuildingNo().clear()
                        .page()
                        .individualFlatNo().clear();
                break;
            case COMPANY:
                invoiceFormPage.companyNip().clear()
                        .page()
                        .companyEmail().clear()
                        .page()
                        .companyName().clear()
                        .page()
                        .companyZipCode().clear()
                        .page()
                        .companyTown().waitClickable().clear()
                        .page()
                        .companyStreet().waitClickable().clear()
                        .page()
                        .companyBuildingNo().clear()
                        .page()
                        .companyFlatNo().clear();
                break;
            case FOREIGN_COMPANY:
                invoiceFormPage.foreignCompanyPrefixInput().clear()
                        .page()
                        .foreignCompanyNip().clear()
                        .page()
                        .foreignCompanyCountryInput().clear()
                        .page()
                        .foreignCompanyEmail().clear()
                        .page()
                        .foreignCompanyName().clear()
                        .page()
                        .foreignCompanyZipCode().clear()
                        .page()
                        .foreignCompanyTown().waitClickable().clear()
                        .page()
                        .foreignCompanyStreet().waitClickable().clear()
                        .page()
                        .foreignCompanyBuildingNo().clear()
                        .page()
                        .foreignCompanyFlatNo().clear();
                break;
        }
    }

}

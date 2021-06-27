package Pages;

import Helpers.Enums.InvoiceType;
import Helpers.Enums.StaticText;
import Pages.Actions.Action;
import SeleniumBase.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.util.List;

public class SummaryPage extends BasePage{

    private final String deliveryMethod;
    private final InvoiceType invoiceType;
    private final String summaryType;

    //region Receiver data
    @FindBy(how = How.XPATH, using = "(//*[contains(@class, 'first-column') and not(contains(@class, 'summary-column'))])[1]/div[1]")
    private WebElement receiverName;
    @FindBy(how = How.XPATH, using = "(//*[contains(@class, 'first-column') and not(contains(@class, 'summary-column'))])[1]/div[2]")
    private WebElement receiverPhone;
    @FindBy(how = How.XPATH, using = "(//*[contains(@class, 'first-column') and not(contains(@class, 'summary-column'))])[1]/div[3]")
    private WebElement receiverEmail;
    @FindBy(how = How.XPATH, using = "(//*[contains(@class, 'first-column') and not(contains(@class, 'summary-column'))])[1]/div[4]")
    private WebElement receiverZipCodeCity;
    @FindBy(how = How.XPATH, using = "(//*[contains(@class, 'first-column') and not(contains(@class, 'summary-column'))])[1]/div[5]")
    private WebElement receiverStreetBuildingNo;
    //endregion

    //region Sender data
    @FindBy(how = How.XPATH, using = "(//*[contains(@class, 'first-column') and not(contains(@class, 'summary-column'))])[2]/div[1]")
    WebElement senderName;
    @FindBy(how = How.XPATH, using = "(//*[contains(@class, 'first-column') and not(contains(@class, 'summary-column'))])[2]/div[2]")
    WebElement senderPhone;
    @FindBy(how = How.XPATH, using = "(//*[contains(@class, 'first-column') and not(contains(@class, 'summary-column'))])[2]/div[3]")
    WebElement senderEmail;
    //endregion

    //region Parcelmachine data
    @FindAll({
            @FindBy(how = How.XPATH, using = "(//*[contains(@class, 'third-column') and not(contains(@class, 'summary-column'))])[1]/div/div")
    })
    List<WebElement> receiverParcelmachineFields;
    WebElement receiverParcelmachineName;
    WebElement receiverParcelmachineStreetBuldingNo;
    WebElement receiverParcelmachineZipCodeCity;
    WebElement receiverParcelmachineDescription;
    //endregion

    //region Invoice data
    @FindAll({
            @FindBy(how = How.XPATH, using = "(//*[contains(@class, 'third-column') and not(contains(@class, 'summary-column'))])[2]/div/div")
    })
    List<WebElement> invoiceFields;
    WebElement invoiceCompanyName;
    WebElement invoiceNip;
    WebElement invoiceZipCodeCity;
    WebElement invoiceStreetBuildingNo;
    //endregion

    //region Buttons
    @FindBy(how = How.XPATH, using = "//app-summary-print-label//button[1]")
    WebElement downloadLabelButton;
    @FindBy(how = How.XPATH, using = "//app-summary-print-label//button[2]")
    WebElement printLabelButton;
    @FindBy(how = How.XPATH, using = "(//div[contains(@class, 'parcel-form-whole-summary-modal')]//button)[1]")
    WebElement fixDataButton;
    @FindBy(how = How.XPATH, using = "(//div[contains(@class, 'parcel-form-whole-summary-modal')]//button)[2]")
    WebElement payButton;
    //endregion

    //region Policy
    @FindBy(how = How.XPATH, using = "//*[@id='onetrust-accept-btn-handler']")
    WebElement policyButton;
    //endregion

    public SummaryPage(String summaryType, String deliveryMethod){
        super();
        this.summaryType = summaryType;
        this.deliveryMethod = deliveryMethod;
        this.invoiceType = null;
    }

    public SummaryPage(String summaryType, String deliveryMethod, InvoiceType invoiceType){
        super();
        this.summaryType = summaryType;
        this.deliveryMethod = deliveryMethod;
        this.invoiceType = invoiceType;
    }

    public Action receiverName() {
        return new Action(receiverName);
    }

    public Action receiverPhone() {
        return new Action(receiverPhone);
    }

    public Action receiverEmail() {
        return new Action(receiverEmail);
    }

    public Action receiverZipCodeCity() {
        return new Action(receiverZipCodeCity);
    }

    public Action receiverStreetBuildingNo() {
        return new Action(receiverStreetBuildingNo);
    }

    public Action senderName() {
        return new Action(senderName);
    }

    public Action senderPhone() {
        return new Action(senderPhone);
    }

    public Action senderEmail() {
        return new Action(senderEmail);
    }

    public Action receiverParcelmachineName() {
        return new Action(receiverParcelmachineName);
    }

    public Action receiverParcelmachineStreetBuldingNo() {
        return new Action(receiverParcelmachineStreetBuldingNo);
    }

    public Action receiverParcelmachineZipCodeCity() {
        return new Action(receiverParcelmachineZipCodeCity);
    }

    public Action receiverParcelmachineDescription() {
        return new Action(receiverParcelmachineDescription);
    }

    public Action invoiceCompanyName() {
        return new Action(invoiceCompanyName);
    }

    public Action invoiceNip() {
        return new Action(invoiceNip);
    }

    public Action invoiceZipCodeCity() {
        return new Action(invoiceZipCodeCity);
    }

    public Action invoiceStreetBuildingNo() {
        return new Action(invoiceStreetBuildingNo);
    }

    public Action downloadLabelButton() {
        return new Action(downloadLabelButton);
    }

    public Action printLabelButton() {
        return new Action(printLabelButton);
    }

    public Action fixDataButton() {
        return new Action(fixDataButton);
    }

    public Action payButton() {
        return new Action(payButton);
    }

    public Action policyButton() {
        return new Action(policyButton);
    }

    //region Single get text methods
    public String textReceiverName() {
        return receiverName.getText();
    }

    public String textReceiverPhone() {
        return receiverPhone.getText().replace(" ", "");
    }

    public String textReceiverEmail() {
        return receiverEmail.getText();
    }

    public String textReceiverZipCodeCity() {
        return receiverZipCodeCity.getText();
    }

    public String textReceiverStreetBuildingNo() {
        return receiverStreetBuildingNo.getText();
    }

    public String textSenderName() {
        return senderName.getText();
    }

    public String textSenderPhone() {
        return senderPhone.getText().replace(" ", "");
    }

    public String textSenderEmail() {
        return senderEmail.getText();
    }
    //endregion

    //region Compound get text methods
    public String textReceiver(){
        StringBuilder receiver = new StringBuilder();
        receiver.append(textReceiverName()).append(" ").append(textReceiverPhone()).append(" ").append(textReceiverEmail());
        if (deliveryMethod.equals("address"))
            receiver.append(" ").append(textReceiverZipCodeCity()).append(" ").append(textReceiverStreetBuildingNo());
        return receiver.toString();
    }

    public String textSender(){
        StringBuilder sender = new StringBuilder();
        sender.append(textSenderName()).append(" ").append(textSenderPhone()).append(" ").append(textSenderEmail());
        return sender.toString();
    }
    //endregion

    //region Set methods for invoice and parcelmachine fields
    public SummaryPage setInvoiceFields(){
        if (invoiceType==null)
            return null;
        invoiceCompanyName = invoiceFields.get(0);

        switch (invoiceType){
            case INDIVIDUAL_PERSON:
                invoiceZipCodeCity = invoiceFields.get(1);
                invoiceStreetBuildingNo = invoiceFields.get(2);
                break;
            case FOREIGN_COMPANY:
            case COMPANY:
                invoiceNip = invoiceFields.get(1);
                invoiceZipCodeCity = invoiceFields.get(2);
                invoiceStreetBuildingNo = invoiceFields.get(3);
                break;
            default:
                break;
        }
        return this;
    }

    public SummaryPage setReceiverParcelmachineFields(){
        if (deliveryMethod.equals("parcelmachine")){
            receiverParcelmachineName = receiverParcelmachineFields.get(0);
            receiverParcelmachineStreetBuldingNo = receiverParcelmachineFields.get(1);
            receiverParcelmachineZipCodeCity = receiverParcelmachineFields.get(2);
            receiverParcelmachineDescription = receiverParcelmachineFields.get(3);
            return this;
        }
        return null;
    }
    //endregion

    //region Click button methods
    public SummaryPage clickPayButton(){
        getCommonHelper().moveAndClick(payButton);
        return this;
    }

    public SummaryPage clickFixDataButton(){
        getCommonHelper().moveAndClick(fixDataButton);
        return this;
    }

    public SummaryPage clickPrintLabelButton(){
        getCommonHelper().moveAndClick(printLabelButton);
        return this;
    }

    public SummaryPage clickDownloadLabelButton() throws IOException {
        getWaitHelper().waitUntilDownloaded(downloadLabelButton);
        return this;
    }

    public String textDownloadLabelButton() {
        return downloadLabelButton.getText();
    }



    public SummaryPage clickPolicyButton(){
        getCommonHelper().moveAndClick(policyButton);
        return this;
    }
    //endregion


    //region Get text parcelmachine methods
    public String textReceiverParcelmachineName() {
        return receiverParcelmachineName.getText();
    }

    public String textReceiverParcelmachineStreetBuldingNo() {
        return receiverParcelmachineStreetBuldingNo.getText();
    }

    public String textReceiverParcelmachineZipCodeCity() {
        return receiverParcelmachineZipCodeCity.getText();
    }

    public String textReceiverParcelmachineDescription() {
        return receiverParcelmachineDescription.getText();
    }
    //endregion

    //region Invoice get text methods
    public String textInvoiceCompanyName() {
        return invoiceCompanyName.getText();
    }

    public String textInvoiceNip() {
        return invoiceNip.getText();
    }

    public String textInvoiceZipCodeCity() {
        return invoiceZipCodeCity.getText();
    }

    public String textInvoiceStreetBuildingNo() {
        return invoiceStreetBuildingNo.getText();
    }
    //endregion

    public void refreshUntilPaymentIsDone(){
        String textCurrent = Base.config.getLanguage().equals("pl") ? StaticText.SUMMARY_TRANSACTION_PENDING.pl
                : StaticText.SUMMARY_TRANSACTION_PENDING.en;
        String text = Base.config.getLanguage().equals("pl") ? StaticText.SUMMARY_TRANSACTION_SUCCESS.pl
                : StaticText.SUMMARY_TRANSACTION_SUCCESS.en;
        while (true){
                getDriver().navigate().refresh();
                getCommonHelper().waitAndClick(policyButton);
                getWaitHelper().waitUntilVisible(By.xpath("//*[contains(@class, 'mat-wrapper')]"));
                List<WebElement> element = getDriver().findElements(By.xpath("//*[contains(text(),'"+text+"')]"));
            if (element.size() > 0)
                    return;
        }
    }

    @Override
    public WebElement getInitElement() {
        if (summaryType.equals("modal"))
            return payButton;
        else {
            refreshUntilPaymentIsDone();
            return printLabelButton;
        }
    }
}

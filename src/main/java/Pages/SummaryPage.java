package Pages;

import Helpers.Enums.Types.DeliveryMethod;
import Helpers.Enums.Types.InvoiceType;
import Helpers.Enums.Statics.StaticText;
import Helpers.Enums.Types.SummaryType;
import Pages.Actions.Action;
import SeleniumBase.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class SummaryPage extends BasePage{

    private DeliveryMethod deliveryMethod;
    private InvoiceType invoiceType;
    private StaticText paymentStatus;
    private final SummaryType summaryType;

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
    @FindBy(xpath = "//div[contains(@class, 'parcel-summary-container')]//button")
    WebElement refreshButton;
    //endregion

    //region Policy
    @FindBy(how = How.XPATH, using = "//*[@id='onetrust-accept-btn-handler']")
    WebElement policyButton;
    //endregion


    public DeliveryMethod getDeliveryMethod() {
        return deliveryMethod;
    }

    public SummaryPage setDeliveryMethod(DeliveryMethod deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
        return this;
    }

    public InvoiceType getInvoiceType() {
        return invoiceType;
    }

    public SummaryPage setInvoiceType(InvoiceType invoiceType) {
        this.invoiceType = invoiceType;
        return this;
    }

    public StaticText getPaymentStatus() {
        return paymentStatus;
    }

    public SummaryPage setPaymentStatus(StaticText paymentStatus) {
        this.paymentStatus = paymentStatus;
        return this;
    }

    public SummaryPage(SummaryType summaryType){
        super();
        this.summaryType = summaryType;
        this.deliveryMethod = null;
        this.invoiceType = null;
        this.paymentStatus = StaticText.SUMMARY_TRANSACTION_SUCCESS;
    }

    public SummaryPage(SummaryPage summaryPage){
        super();
        this.summaryType = summaryPage.summaryType;
        this.deliveryMethod = summaryPage.deliveryMethod;
        this.invoiceType = summaryPage.invoiceType;
        this.paymentStatus = summaryPage.paymentStatus;
    }

    //region Custom Actions
    public void refreshUntilPaymentIsDone(){
        int iterationTimeout = 20;
        String text = Base.config.getLanguage().equals("pl") ? paymentStatus.pl
                : paymentStatus.en;
        policyButton().waitVisible().click();
        getWaitHelper().waitUntilTextIsPresent(refreshButton, text);
    }
    //endregion

    //region Actions
    public Action<SummaryPage> receiverName() {
        return new Action<>(receiverName, this);
    }

    public Action<SummaryPage> receiverPhone() {
        return new Action<>(receiverPhone, this);
    }

    public Action<SummaryPage> receiverEmail() {
        return new Action<>(receiverEmail, this);
    }

    public Action<SummaryPage> receiverZipCodeCity() {
        return new Action<>(receiverZipCodeCity, this);
    }

    public Action<SummaryPage> receiverStreetBuildingNo() {
        return new Action<>(receiverStreetBuildingNo, this);
    }

    public Action<SummaryPage> senderName() {
        return new Action<>(senderName, this);
    }

    public Action<SummaryPage> senderPhone() {
        return new Action<>(senderPhone, this);
    }

    public Action<SummaryPage> senderEmail() {
        return new Action<>(senderEmail, this);
    }

    public Action<SummaryPage> refreshButton() {
        return new Action<>(refreshButton, this);
    }

    public Action<SummaryPage> receiverParcelmachineName() {
        return new Action<>(receiverParcelmachineName, this);
    }

    public Action<SummaryPage> receiverParcelmachineStreetBuldingNo() {
        return new Action<>(receiverParcelmachineStreetBuldingNo, this);
    }

    public Action<SummaryPage> receiverParcelmachineZipCodeCity() {
        return new Action<>(receiverParcelmachineZipCodeCity, this);
    }

    public Action<SummaryPage> receiverParcelmachineDescription() {
        return new Action<>(receiverParcelmachineDescription, this);
    }

    public Action<SummaryPage> invoiceCompanyName() {
        return new Action<>(invoiceCompanyName, this);
    }

    public Action<SummaryPage> invoiceNip() {
        return new Action<>(invoiceNip, this);
    }

    public Action<SummaryPage> invoiceZipCodeCity() {
        return new Action<>(invoiceZipCodeCity, this);
    }

    public Action<SummaryPage> invoiceStreetBuildingNo() {
        return new Action<>(invoiceStreetBuildingNo, this);
    }

    public Action<SummaryPage> downloadLabelButton() {
        return new Action<>(downloadLabelButton, this);
    }

    public Action<SummaryPage> printLabelButton() {
        return new Action<>(printLabelButton, this);
    }

    public Action<SummaryPage> fixDataButton() {
        return new Action<>(fixDataButton, this);
    }

    public Action<SummaryPage> payButton() {
        return new Action<>(payButton, this);
    }

    public Action<SummaryPage> policyButton() {
        return new Action<>(policyButton, this);
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
        if (deliveryMethod==DeliveryMethod.BOXMACHINE){
            receiverParcelmachineName = receiverParcelmachineFields.get(0);
            receiverParcelmachineStreetBuldingNo = receiverParcelmachineFields.get(1);
            receiverParcelmachineZipCodeCity = receiverParcelmachineFields.get(2);
            receiverParcelmachineDescription = receiverParcelmachineFields.get(3);
            return this;
        }
        return this;
    }
    //endregion

    @Override
    public WebElement getInitElement() {
        if (summaryType == SummaryType.MODAL)
            return payButton;
        else {
            refreshUntilPaymentIsDone();
            if(paymentStatus == StaticText.SUMMARY_TRANSACTION_SUCCESS)
                return printLabelButton;
            else
                return getDriver().findElement(By.xpath("//*[contains(@class, 'btn')]"));
        }
    }
}

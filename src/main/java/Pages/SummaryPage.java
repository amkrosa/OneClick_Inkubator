package Pages;

import Helpers.Enums.InvoiceType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

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
    //endregions

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

    @Override
    public WebElement getInitElement() {
        if (summaryType.equals("modal"))
            return payButton;
        else
            return downloadLabelButton;
    }
}

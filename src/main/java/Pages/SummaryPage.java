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

    @FindBy(how = How.XPATH, using = "(//*[contains(@class, 'first-column') and not(contains(@class, 'summary-column'))])[1]/div[1]")
    WebElement receiverName;
    @FindBy(how = How.XPATH, using = "(//*[contains(@class, 'first-column') and not(contains(@class, 'summary-column'))])[1]/div[2]")
    WebElement receiverPhone;
    @FindBy(how = How.XPATH, using = "(//*[contains(@class, 'first-column') and not(contains(@class, 'summary-column'))])[1]/div[3]")
    WebElement receiverEmail;
    @FindBy(how = How.XPATH, using = "(//*[contains(@class, 'first-column') and not(contains(@class, 'summary-column'))])[1]/div[4]")
    WebElement receiverZipCodeCity;
    @FindBy(how = How.XPATH, using = "(//*[contains(@class, 'first-column') and not(contains(@class, 'summary-column'))])[1]/div[5]")
    WebElement receiverStreetBuildingNo;

    @FindBy(how = How.XPATH, using = "(//*[contains(@class, 'first-column') and not(contains(@class, 'summary-column'))])[2]/div[1]")
    WebElement senderName;
    @FindBy(how = How.XPATH, using = "(//*[contains(@class, 'first-column') and not(contains(@class, 'summary-column'))])[2]/div[2]")
    WebElement senderPhone;
    @FindBy(how = How.XPATH, using = "(//*[contains(@class, 'first-column') and not(contains(@class, 'summary-column'))])[2]/div[3]")
    WebElement senderEmail;

    @FindAll({
            @FindBy(how = How.XPATH, using = "(//*[contains(@class, 'third-column') and not(contains(@class, 'summary-column'))])[1]/div/div")
    })
    List<WebElement> receiverParcelmachineFields;
    WebElement receiverParcelmachineName;
    WebElement receiverParcelmachineStreetBuldingNo;
    WebElement receiverParcelmachineZipCodeCity;
    WebElement receiverParcelmachineDescription;

    @FindAll({
            @FindBy(how = How.XPATH, using = "(//*[contains(@class, 'third-column') and not(contains(@class, 'summary-column'))])[2]/div/div")
    })
    List<WebElement> invoiceFields;
    WebElement invoiceCompanyName;
    WebElement invoiceNip;
    WebElement invoiceZipCodeCity;
    WebElement invoiceStreetBuildingNo;

    @FindBy(how = How.XPATH, using = "//app-summary-print-label//button[1]")
    WebElement downloadLabelButton;
    @FindBy(how = How.XPATH, using = "//app-summary-print-label//button[2]")
    WebElement printLabelButton;

    public SummaryPage(String deliveryMethod){
        super();
        this.deliveryMethod = deliveryMethod;
        this.invoiceType = null;
    }

    public SummaryPage(String deliveryMethod, InvoiceType invoiceType){
        super();
        this.deliveryMethod = deliveryMethod;
        this.invoiceType = invoiceType;
    }

    public String textReceiverName() {
        return receiverName.getText();
    }

    public String textReceiverPhone() {
        return receiverPhone.getText();
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
        return senderPhone.getText();
    }

    public String textSenderEmail() {
        return senderEmail.getText();
    }

    public String textReceiver(){
        String receiver;
        receiver=textReceiverName()+" "+textReceiverPhone()+" "+textReceiverEmail()+" ";
        if (deliveryMethod.equals("address"))
            receiver+=textReceiverZipCodeCity()+" "+textReceiverStreetBuildingNo();
        return receiver;
    }

    public String textSender(){
        String sender;
        sender=textReceiverName()+" "+textReceiverPhone()+" "+textReceiverEmail()+" ";
        return sender;
    }

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
}

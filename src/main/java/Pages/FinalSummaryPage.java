package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FinalSummaryPage extends BasePage{

    private final String deliveryMethod;

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

    public FinalSummaryPage(String deliveryMethod){
        super();
        this.deliveryMethod = deliveryMethod;
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
}

package Pages;

import Helpers.ActionHelper;
import SeleniumBase.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormPage extends BasePage{

    @FindBy(how = How.ID, using = "onetrust-accept-btn-handler")
    WebElement policyButton;
    @FindBy(how = How.CLASS_NAME, using = "btn-cookie-trigger")
    WebElement cookieButton;
    @FindBy(how = How.NAME, using = "senderAddress.name")
    WebElement senderName;
    @FindBy(how = How.NAME, using = "senderAddress.phoneNum")
    WebElement senderPhone;
    @FindBy(how = How.NAME, using = "senderAddress.email")
    WebElement senderEmail;
    @FindBy(how = How.NAME, using = "targetAddress.name")
    WebElement receiverName;
    @FindBy(how = How.NAME, using = "phoneNumber")
    WebElement receiverPhone;
    @FindBy(how = How.NAME, using = "addresseeEmail")
    WebElement receiverEmail;
    @FindBy(how = How.CSS, using = "[for=terms] > .input-checkmark")
    WebElement terms;
    @FindBy(how = How.CSS, using = "[for=newsletter] > .input-checkmark")
    WebElement newsletter;
    @FindBy(how = How.CSS, using = "[for=deliveryTypeboxmachine]")
    WebElement deliveryTypeBoxmachine;
    @FindBy(how = How.CSS, using = "[for=deliveryTypeaddress]")
    WebElement deliveryTypeAddress;
    @FindBy(how = How.CSS, using = "[for=parcelSizeA]")
    WebElement parcelSizeA;
    @FindBy(how = How.CSS, using = "[for=parcelSizeB]")
    WebElement parcelSizeB;
    @FindBy(how = How.CSS, using = "[for=parcelSizeC]")
    WebElement parcelSizeC;
    @FindBy(how = How.CSS, using = "[for=in_changer]")
    WebElement invoiceCheckbox;
    @FindBy(how = How.XPATH, using = "(//span[@class='custom-action-in-title'])[1]")
    WebElement howToSendButton;
    @FindBy(how = How.XPATH, using = "(//span[@class='custom-action-in-title'])[2]")
    WebElement howToPackButton;



    public FormPage() {
        super();
    }

    public FormPage fillSenderName(String text) {
        senderName.sendKeys(text);
        return this;
    }

    public FormPage fillSenderEmail(String text) {
        senderEmail.sendKeys(text);
        return this;
    }


    public FormPage fillSenderPhone(String text) {
        senderPhone.sendKeys(text);
        return this;
    }

    public FormPage fillReceiverName(String text) {
        receiverName.sendKeys(text);
        return this;
    }

    public FormPage fillReceiverEmail(String text) {
        receiverEmail.sendKeys(text);
        return this;
    }

    public FormPage fillReceiverPhone(String text) {
        receiverPhone.sendKeys(text);
        return this;
    }


    public FormPage clickNewsletterCheckbox() {
        getCommonHelper().moveAndClick(newsletter);
        return this;
    }

    public FormPage clickTermsCheckbox() {
        getCommonHelper().moveAndClick(terms);
        return this;
    }

    public FormPage clickBoxmachineDeliveryMethod() {
        getCommonHelper().moveAndClick(deliveryTypeBoxmachine);
        return this;
    }

    public FormPage clickAddressDeliveryMethod() {
        getCommonHelper().moveAndClick(deliveryTypeAddress);
        return this;
    }

    public FormPage clickParcelSizeA() {
        getCommonHelper().moveAndClick(parcelSizeA);
        return this;
    }

    public FormPage clickParcelSizeB() {
        getCommonHelper().moveAndClick(parcelSizeB);
        return this;
    }

    public FormPage clickParcelSizeC() {
        getCommonHelper().moveAndClick(parcelSizeC);
        return this;
    }

    public boolean submit() {
        WebElement button = getDriver().findElement(By.cssSelector("#parcelFormButton > button"));
        getCommonHelper().moveAndClick(button);
        getWaitHelper().waitUntilVisible(By.cssSelector(".parcel-form-whole-summary-modal"));
        return !getDriver().findElements(By.cssSelector(".parcel-form-whole-summary-modal")).isEmpty();
    }

    public FormPage clickPolicyButton() {
        getCommonHelper().waitAndClick(policyButton);
        return this;
    }

    public FormPage clickCookieButton() {
        getCommonHelper().waitAndClick(cookieButton);
        return this;
    }

    public FormPage clickInvoiceCheckbox() {
        getCommonHelper().moveAndClick(invoiceCheckbox);
        return this;
    }

    public FormPage clickHowToSendButton() {
        getCommonHelper().moveAndClick(howToSendButton);
        return this;
    }

    public FormPage clickHowToPackButton() {
        getCommonHelper().moveAndClick(howToPackButton);
        return this;
    }

    public boolean isHowToSendModalVisible(){
        By xpath = By.xpath("(//*[@role='dialog'])[last()]//*[@class='modal-content']");
        return getCommonHelper().isModalVisible(xpath, howToSendButton);
    }

    public boolean isHowToPackModalVisible(){
        By xpath = By.xpath("(//*[@role='dialog'])[last()]//*[@class='modal-content']");
        return getCommonHelper().isModalVisible(xpath, howToPackButton);
    }
}

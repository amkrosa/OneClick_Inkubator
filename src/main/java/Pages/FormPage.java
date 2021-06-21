package Pages;

import Helpers.ActionHelper;
import Helpers.CommonHelper;
import Helpers.WaitHelper;
import SeleniumBase.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormPage {

    private WebDriver driver;
    private CommonHelper commonHelper;
    private WaitHelper waitHelper;
    private ActionHelper actionHelper;

    @FindBy(how = How.ID, using = "onetrust-accept-btn-handler")
    private WebElement policyButton;
    @FindBy(how = How.CLASS_NAME, using = "btn-cookie-trigger")
    private WebElement cookieButton;
    @FindBy(how = How.NAME, using = "senderAddress.name")
    private WebElement senderName;
    @FindBy(how = How.NAME, using = "senderAddress.phoneNum")
    private WebElement senderPhone;
    @FindBy(how = How.NAME, using = "senderAddress.email")
    private WebElement senderEmail;
    @FindBy(how = How.NAME, using = "targetAddress.name")
    private WebElement receiverName;
    @FindBy(how = How.NAME, using = "phoneNumber")
    private WebElement receiverPhone;
    @FindBy(how = How.NAME, using = "addresseeEmail")
    private WebElement receiverEmail;
    @FindBy(how = How.CSS, using = ".ng-input > input")
    private WebElement parcelmachine;
    @FindBy(how = How.CSS, using = "[for=terms] > .input-checkmark")
    private WebElement terms;
    @FindBy(how = How.CSS, using = "[for=newsletter] > .input-checkmark")
    private WebElement newsletter;
    @FindBy(how = How.CSS, using = "[for=deliveryTypeboxmachine]")
    private WebElement deliveryTypeBoxmachine;
    @FindBy(how = How.CSS, using = "[for=deliveryTypeaddress]")
    private WebElement deliveryTypeAddress;
    @FindBy(how = How.CSS, using = "[for=parcelSizeA]")
    private WebElement parcelSizeA;
    @FindBy(how = How.CSS, using = "[for=parcelSizeB]")
    private WebElement parcelSizeB;
    @FindBy(how = How.CSS, using = "[for=parcelSizeC]")
    private WebElement parcelSizeC;
    @FindBy(how = How.CSS, using = "[for=in_changer]")
    private WebElement invoiceCheckbox;



    public FormPage() {
        driver = Base.driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(new WebDriverWait(Base.driver, 3));
        actionHelper = new ActionHelper(new Actions(Base.driver));
        commonHelper = new CommonHelper(actionHelper, waitHelper);
    }

    public void fillSender(String name, String phone, String email) {
        senderName.sendKeys(name);
        senderEmail.sendKeys(email);
        senderPhone.sendKeys(phone);
    }

    public void setParcelmachine(String pm) {
        parcelmachine.sendKeys(pm);
        waitHelper.waitUntilClickable(By.cssSelector("#" + pm.toUpperCase()));
        driver.findElement(By.cssSelector("#" + pm.toUpperCase())).click();
    }

    public void fillReceiverParcelmachine(String name, String phone, String email, String parcelmachine) {
        receiverName.sendKeys(name);
        receiverEmail.sendKeys(email);
        receiverPhone.sendKeys(phone);
        setParcelmachine(parcelmachine);
    }

    public void clickNewsletterCheckbox(){
        commonHelper.moveAndClick(newsletter);
    }

    public void clickTermsCheckbox(){
        commonHelper.moveAndClick(terms);
    }

    public void clickBoxmachineDeliveryMethod(){
        commonHelper.moveAndClick(deliveryTypeBoxmachine);
    }

    public void clickAddressDeliveryMethod(){
        commonHelper.moveAndClick(deliveryTypeAddress);
    }

    public void clickParcelSizeA(){
        commonHelper.moveAndClick(parcelSizeA);
    }

    public void clickParcelSizeB(){
        commonHelper.moveAndClick(parcelSizeB);
    }

    public void clickParcelSizeC(){
        commonHelper.moveAndClick(parcelSizeC);
    }

    public boolean submit() {
        WebElement button = driver.findElement(By.cssSelector("#parcelFormButton > button"));
        commonHelper.moveAndClick(button);
        waitHelper.waitUntilVisible(By.cssSelector(".parcel-form-whole-summary-modal"));
        return !driver.findElements(By.cssSelector(".parcel-form-whole-summary-modal")).isEmpty();
    }

    public void clickPolicyButton(){
        commonHelper.waitAndClick(policyButton);
    }

    public void clickCookieButton(){
        commonHelper.waitAndClick(cookieButton);
    }

    public FormPage clickInvoiceCheckbox(){
        commonHelper.moveAndClick(invoiceCheckbox);
        return this;
    }
    
}

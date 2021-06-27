package Pages;

import Helpers.Enums.Banner;
import Pages.Actions.Action;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class FormPage extends BasePage {

    //region Functional elements
    @FindBy(how = How.ID, using = "onetrust-accept-btn-handler")
    private WebElement policyButton;
    @FindBy(how = How.CSS, using = "#parcelFormButton > button")
    private
    WebElement submitButton;
    @FindBy(how = How.CLASS_NAME, using = "btn-cookie-trigger")
    private
    WebElement cookieButton;
    @FindBy(how = How.NAME, using = "senderAddress.name")
    private
    WebElement senderName;
    @FindBy(how = How.NAME, using = "senderAddress.phoneNum")
    private
    WebElement senderPhone;
    @FindBy(how = How.NAME, using = "senderAddress.email")
    private
    WebElement senderEmail;
    @FindBy(how = How.NAME, using = "targetAddress.name")
    private
    WebElement receiverName;
    @FindBy(how = How.NAME, using = "phoneNumber")
    private
    WebElement receiverPhone;
    @FindBy(how = How.NAME, using = "addresseeEmail")
    private
    WebElement receiverEmail;
    @FindBy(how = How.CSS, using = "[for=terms] > .input-checkmark")
    private
    WebElement terms;
    @FindBy(how = How.CSS, using = "[for=newsletter] > .input-checkmark")
    private
    WebElement newsletter;
    @FindBy(how = How.CSS, using = "[for=deliveryTypeboxmachine]")
    private
    WebElement deliveryTypeBoxmachine;
    @FindBy(how = How.CSS, using = "[for=deliveryTypeaddress]")
    private
    WebElement deliveryTypeAddress;
    @FindBy(how = How.CSS, using = "[for=parcelSizeA]")
    private
    WebElement parcelSizeA;
    @FindBy(how = How.CSS, using = "[for=parcelSizeB]")
    private
    WebElement parcelSizeB;
    @FindBy(how = How.CSS, using = "[for=parcelSizeC]")
    private
    WebElement parcelSizeC;
    @FindBy(how = How.CSS, using = "[for=in_changer]")
    private
    WebElement invoiceCheckbox;
    @FindBy(how = How.XPATH, using = "(//span[@class='custom-action-in-title'])[1]")
    private
    WebElement howToSendButton;
    @FindBy(how = How.XPATH, using = "(//span[@class='custom-action-in-title'])[2]")
    private
    WebElement howToPackButton;
    //endregion

    //region Images
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@id='process']//img")
    })
    private List<WebElement> bannerImages;
    @FindBy(how = How.XPATH, using = "(//*[@class='summaryForm'])[2]//div[contains(@class, 'chosen-icon')]/img[1]")
    private WebElement summarySenderMethodIcon;
    @FindBy(how = How.XPATH, using = "(//*[@class='summaryForm'])[2]//div[contains(@class, 'chosen-icon')]/img[2]")
    private WebElement summaryReceiverMethodIcon;
    @FindBy(how = How.XPATH, using = "((//*[@class='summaryForm'])[2]//*[@class='custom-column-summary'])[2]")
    private WebElement summarySizeIcon;
    //endregion

    //region Text
    @FindBy(how = How.XPATH, using = "((//*[@class='summaryForm'])[2]//*[@class='custom-column-summary'])[1]")
    private WebElement summarySizeText;
    @FindBy(how = How.XPATH, using = "//*[@class='chosen-text-description']")
    private WebElement summarySizeDimension;
    //endregion

    //region Errors
    @FindBy(xpath = "//*[@id='error-targetAddress.name']/..//*[contains(@class, 'errors')]")
    private WebElement errorReceiverName;
    @FindBy(xpath = "//*[@id='error-addresseeEmail']/..//*[contains(@class, 'errors')]")
    private WebElement errorReceiverEmail;
    @FindBy(xpath = "//*[@id='error-phoneNumber']/..//*[contains(@class, 'errors')]")
    private WebElement errorReceiverPhone;
    @FindBy(xpath = "//*[@id='error-senderAddress.name']/..//*[contains(@class, 'errors')]")
    private WebElement errorSenderName;
    @FindBy(xpath = "//*[@id='error-senderAddress.email']/..//*[contains(@class, 'errors')]")
    private WebElement errorSenderEmail;
    @FindBy(xpath = "//*[@id='error-senderAddress.phoneNum']/..//*[contains(@class, 'errors')]")
    private WebElement errorSenderPhone;
    //endregion


    public FormPage() {
        super();
    }

    //region Actions
    public Action policyButton() {
        return new Action(policyButton);
    }

    public Action submitButton() {
        return new Action(submitButton);
    }

    public Action cookieButton() {
        return new Action(cookieButton);
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

    public Action receiverName() {
        return new Action(receiverName);
    }

    public Action receiverPhone() {
        return new Action(receiverPhone);
    }

    public Action receiverEmail() {
        return new Action(receiverEmail);
    }

    public Action terms() {
        return new Action(terms);
    }

    public Action newsletter() {
        return new Action(newsletter);
    }

    public Action deliveryTypeBoxmachine() {
        return new Action(deliveryTypeBoxmachine);
    }

    public Action deliveryTypeAddress() {
        return new Action(deliveryTypeAddress);
    }

    public Action parcelSizeA() {
        return new Action(parcelSizeA);
    }

    public Action parcelSizeB() {
        return new Action(parcelSizeB);
    }

    public Action parcelSizeC() {
        return new Action(parcelSizeC);
    }

    public Action invoiceCheckbox() {
        return new Action(invoiceCheckbox);
    }

    public Action howToSendButton() {
        return new Action(howToSendButton);
    }

    public Action howToPackButton() {
        return new Action(howToPackButton);
    }

    public Action summarySenderMethodIcon() {
        return new Action(summarySenderMethodIcon);
    }

    public Action summaryReceiverMethodIcon() {
        return new Action(summaryReceiverMethodIcon);
    }

    public Action summarySizeIcon() {
        return new Action(summarySizeIcon);
    }

    public Action summarySizeText() {
        return new Action(summarySizeText);
    }

    public Action summarySizeDimension() {
        return new Action(summarySizeDimension);
    }

    public Action errorReceiverName() {
        return new Action(errorReceiverName);
    }

    public Action errorReceiverEmail() {
        return new Action(errorReceiverEmail);
    }

    public Action errorReceiverPhone() {
        return new Action(errorReceiverPhone);
    }

    public Action errorSenderName() {
        return new Action(errorSenderName);
    }

    public Action errorSenderEmail() {
        return new Action(errorSenderEmail);
    }

    public Action errorSenderPhone() {
        return new Action(errorSenderPhone);
    }
    //endregion

    //region isVisible methods
    public boolean isHowToSendModalVisible(){
        By xpath = By.xpath("(//*[@role='dialog'])[last()]//*[@class='modal-content']");
        return getCommonHelper().isModalVisible(xpath, howToSendButton);
    }

    public boolean isHowToPackModalVisible(){
        By xpath = By.xpath("(//*[@role='dialog'])[last()]//*[@class='modal-content']");
        return getCommonHelper().isModalVisible(xpath, howToPackButton);
    }

    public boolean isBannerImagesVisible(){
        Banner[] banners = Banner.values();
        for (int i=0; i<bannerImages.size(); i++){
            if (!bannerImages.get(i).getAttribute("src").equals(banners[i].url))
                return false;
        }
        return true;
    }
    //endregion

    /*
    //region Fill methods
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
    //endregion

    //region Click methods
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

    public FormPage clickPolicyButton() {
        getCommonHelper().waitAndClick(policyButton);
        return this;
    }

    public FormPage clickSubmitButton() {
        getCommonHelper().waitAndClick(submitButton);
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
    //endregion

    //region Text methods
    public String textSummarySizeDimension() {
        return summarySizeDimension.getText();
    }

    public String textSummarySizeText() {
        return summarySizeText.getText();
    }
    //endregion

    //region Value methods
    public String valueSenderName() {
        return senderName.getAttribute("value");
    }

    public String valueSenderPhone() {
        return senderPhone.getAttribute("value").replace(" ", "");
    }

    public String valueSenderEmail() {
        return senderEmail.getAttribute("value");
    }

    public String valueReceiverName() {
        return receiverName.getAttribute("value");
    }

    public String valueReceiverPhone() {
        return receiverPhone.getAttribute("value").replace(" ", "");
    }

    public String valueReceiverEmail() {
        return receiverEmail.getAttribute("value");
    }
    //endregion

    //region Src methods
    public String srcSummarySenderMethodIcon() {
        return summarySenderMethodIcon.getAttribute("src");
    }

    public String srcSummaryReceiverMethodIcon() {
        return summaryReceiverMethodIcon.getAttribute("src");
    }

    public String srcSummarySizeIcon() {
        return summarySizeIcon.getAttribute("src");
    }
    //endregion

    //region Get Error methods
    public WebElement getErrorReceiverName() {
        return errorReceiverName;
    }

    public WebElement getErrorReceiverEmail() {
        return errorReceiverEmail;
    }

    public WebElement getErrorReceiverPhone() {

        //getWaitHelper().waitUntilVisible(errorReceiverPhone);
        return errorReceiverPhone;
    }

    public WebElement getErrorSenderName() {
        return errorSenderName;
    }

    public WebElement getErrorSenderEmail() {
        return errorSenderEmail;
    }

    public WebElement getErrorSenderPhone() {
        return errorSenderPhone;
    }
    //endregion

    //region Clear methods
    public FormPage clearSenderName() {
        senderName.clear();
        return this;
    }

    public FormPage clearSenderEmail() {
        senderEmail.clear();
        return this;
    }

    public FormPage clearSenderPhone() {
        senderPhone.clear();
        return this;
    }

    public FormPage clearReceiverName() {
        receiverName.clear();
        return this;
    }

    public FormPage clearReceiverEmail() {
        receiverEmail.clear();
        return this;
    }

    public FormPage clearReceiverPhone() {
        receiverPhone.clear();
        return this;
    }
    //endregion

     */

    //region Custom methods
    public boolean submit() {
        submitButton().click();
        getWaitHelper().waitUntilClickable(By.xpath("(//div[contains(@class, 'parcel-form-whole-summary-modal')]//button)[2]"));
        return !getDriver().findElements(By.cssSelector(".parcel-form-whole-summary-modal")).isEmpty();
    }
    //endregion

    @Override
    public WebElement getInitElement() {
        return submitButton;
    }

}

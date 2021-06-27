package Pages;

import Helpers.Enums.Banner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class FormPage extends BasePage {

    //region Functional elements
    @FindBy(how = How.ID, using = "onetrust-accept-btn-handler")
    WebElement policyButton;
    @FindBy(how = How.CSS, using = "#parcelFormButton > button")
    WebElement submitButton;
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
    //endregion

    //region Images
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@id='process']//img")
    })
    List<WebElement> bannerImages;
    @FindBy(how = How.XPATH, using = "(//*[@class='summaryForm'])[2]//div[contains(@class, 'chosen-icon')]/img[1]")
    WebElement summarySenderMethodIcon;
    @FindBy(how = How.XPATH, using = "(//*[@class='summaryForm'])[2]//div[contains(@class, 'chosen-icon')]/img[2]")
    WebElement summaryReceiverMethodIcon;
    @FindBy(how = How.XPATH, using = "((//*[@class='summaryForm'])[2]//*[@class='custom-column-summary'])[2]")
    WebElement summarySizeIcon;
    //endregion

    //region Text
    @FindBy(how = How.XPATH, using = "((//*[@class='summaryForm'])[2]//*[@class='custom-column-summary'])[1]")
    WebElement summarySizeText;
    @FindBy(how = How.XPATH, using = "//*[@class='chosen-text-description']")
    WebElement summarySizeDimension;
    //endregion

    //region Errors
    @FindBy(xpath = "//*[@id='error-targetAddress.name']/..//*[contains(@class, 'errors')]")
    WebElement errorReceiverName;
    @FindBy(xpath = "//*[@id='error-addresseeEmail']/..//*[contains(@class, 'errors')]")
    WebElement errorReceiverEmail;
    @FindBy(xpath = "//*[@id='error-phoneNumber']/..//*[contains(@class, 'errors')]")
    WebElement errorReceiverPhone;
    @FindBy(xpath = "//*[@id='error-senderAddress.name']/..//*[contains(@class, 'errors')]")
    WebElement errorSenderName;
    @FindBy(xpath = "//*[@id='error-senderAddress.email']/..//*[contains(@class, 'errors')]")
    WebElement errorSenderEmail;
    @FindBy(xpath = "//*[@id='error-senderAddress.phoneNum']/..//*[contains(@class, 'errors')]")
    WebElement errorSenderPhone;
    //endregion


    public FormPage() {
        super();
    }

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

    //region Custom methods
    public boolean submit() {
        clickSubmitButton();
        getWaitHelper().waitUntilClickable(By.xpath("(//div[contains(@class, 'parcel-form-whole-summary-modal')]//button)[2]"));
        return !getDriver().findElements(By.cssSelector(".parcel-form-whole-summary-modal")).isEmpty();
    }
    //endregion

    @Override
    public WebElement getInitElement() {
        return submitButton;
    }

}

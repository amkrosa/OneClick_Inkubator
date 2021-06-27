package Pages;

import Helpers.Enums.Banner;
import Helpers.Enums.DeliveryMethod;
import Models.Client;
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

    public Action<FormPage> policyButton() {
        return new Action<>(policyButton, this);
    }

    public Action<FormPage> submitButton() {
        return new Action<>(submitButton, this);
    }

    public Action<FormPage> cookieButton() {
        return new Action<>(cookieButton, this);
    }

    public Action<FormPage> senderName() {
        return new Action<>(senderName, this);
    }

    public Action<FormPage> senderPhone() {
        return new Action<>(senderPhone, this);
    }

    public Action<FormPage> senderEmail() {
        return new Action<>(senderEmail, this);
    }

    public Action<FormPage> receiverName() {
        return new Action<>(receiverName, this);
    }

    public Action<FormPage> receiverPhone() {
        return new Action<>(receiverPhone, this);
    }

    public Action<FormPage> receiverEmail() {
        return new Action<>(receiverEmail, this);
    }

    public Action<FormPage> terms() {
        return new Action<>(terms, this);
    }

    public Action<FormPage> newsletter() {
        return new Action<>(newsletter, this);
    }

    public Action<FormPage> deliveryTypeBoxmachine() {
        return new Action<>(deliveryTypeBoxmachine, this);
    }

    public Action<FormPage> deliveryTypeAddress() {
        return new Action<>(deliveryTypeAddress, this);
    }

    public Action<FormPage> parcelSizeA() {
        return new Action<>(parcelSizeA, this);
    }

    public Action<FormPage> parcelSizeB() {
        return new Action<>(parcelSizeB, this);
    }

    public Action<FormPage> parcelSizeC() {
        return new Action<>(parcelSizeC, this);
    }

    public Action<FormPage> invoiceCheckbox() {
        return new Action<>(invoiceCheckbox, this);
    }

    public Action<FormPage> howToSendButton() {
        return new Action<>(howToSendButton, this);
    }

    public Action<FormPage> howToPackButton() {
        return new Action<>(howToPackButton, this);
    }

    public Action<FormPage> summarySenderMethodIcon() {
        return new Action<>(summarySenderMethodIcon, this);
    }

    public Action<FormPage> summaryReceiverMethodIcon() {
        return new Action<>(summaryReceiverMethodIcon, this);
    }

    public Action<FormPage> summarySizeIcon() {
        return new Action<>(summarySizeIcon, this);
    }

    public Action<FormPage> summarySizeText() {
        return new Action<>(summarySizeText, this);
    }

    public Action<FormPage> summarySizeDimension() {
        return new Action<>(summarySizeDimension, this);
    }

    public Action<FormPage> errorReceiverName() {
        return new Action<>(errorReceiverName, this);
    }

    public Action<FormPage> errorReceiverEmail() {
        return new Action<>(errorReceiverEmail, this);
    }

    public Action<FormPage> errorReceiverPhone() {
        return new Action<>(errorReceiverPhone, this);
    }

    public Action<FormPage> errorSenderName() {
        return new Action<>(errorSenderName, this);
    }

    public Action<FormPage> errorSenderEmail() {
        return new Action<>(errorSenderEmail, this);
    }

    public Action<FormPage> errorSenderPhone() {
        return new Action<>(errorSenderPhone, this);
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

    //region Custom methods
    public boolean submit() {
        submitButton().click();
        getWaitHelper().waitUntilClickable(By.xpath("(//div[contains(@class, 'parcel-form-whole-summary-modal')]//button)[2]"));
        return !getDriver().findElements(By.cssSelector(".parcel-form-whole-summary-modal")).isEmpty();
    }

    public FormPage fillForm(DeliveryMethod deliveryMethod, Client receiver, Client sender){
        receiverName().fill(receiver.getName())
                .page()
                .receiverEmail().fill(receiver.getEmail())
                .page()
                .receiverPhone().fill(receiver.getPhone());

        if (deliveryMethod==DeliveryMethod.ADDRESS){
            AddressFormPage addressFormPage = new AddressFormPage();
            addressFormPage.receiverZipCode().fill(receiver.getZipCode())
                    .page()
                    .receiverTown().fill(receiver.getCity())
                    .page()
                    .receiverStreet().fill(receiver.getStreet())
                    .page()
                    .receiverBuildingNo().fill(receiver.getBuildingNo())
                    .page()
                    .receiverFlatNo().fill(receiver.getFlatNo());
        }else {
            new BoxmachineFormPage().parcelmachine().fill(receiver.getParcelmachine()).confirmDropdown();
        }

        senderName().fill(sender.getName())
                .page()
                .senderEmail().fill(sender.getEmail())
                .page()
                .senderPhone().fill(sender.getPhone());

        terms().click();

        return this;
    }
    //endregion

    @Override
    public WebElement getInitElement() {
        return submitButton;
    }

}

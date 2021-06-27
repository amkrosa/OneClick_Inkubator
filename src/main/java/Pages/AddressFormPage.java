package Pages;

import Helpers.ActionHelper;
import Helpers.CommonHelper;
import Helpers.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddressFormPage extends BasePage{


    //region Functional elements
    @FindBy(how = How.NAME, using = "targetAddress.zipCode")
    WebElement receiverZipCode;
    @FindBy(how = How.XPATH, using = "//*[@name='targetAddress.town']//*/input")
    WebElement receiverTown;
    @FindBy(how = How.XPATH, using = "//*[@name='targetAddress.town']//*[@class='ng-value']")
    WebElement receiverTownValue;
    @FindBy(how = How.XPATH, using = "//*[@name='targetAddress.street']//*/input")
    WebElement receiverStreet;
    @FindBy(how = How.XPATH, using = "//*[@name='targetAddress.street']//*[@class='ng-value']")
    WebElement receiverStreetValue;
    @FindBy(how = How.NAME, using = "targetAddress.buildingNo")
    WebElement receiverBuildingNo;
    @FindBy(how = How.NAME, using = "targetAddress.flatNo")
    WebElement receiverFlatNo;
    //endregion

    //region Errors
    @FindBy(xpath = "//*[@id='error-targetAddress.zipCode']/..//*[contains(@class, 'errors')]")
    WebElement errorReceiverZipCode;
    @FindBy(xpath = "//*[@id='error-targetAddress.town']/..//*[contains(@class, 'errors')]")
    WebElement errorReceiverTown;
    @FindBy(xpath = "//*[@id='error-targetAddress.street']/..//*[contains(@class, 'errors')]")
    WebElement errorReceiverStreet;
    @FindBy(xpath = "//*[@id='error-targetAddress.buildingNo']/..//*[contains(@class, 'errors')]")
    WebElement errorBuildingNo;
    @FindBy(xpath = "//*[@id='error-targetAddress.flatNo']/..//*[contains(@class, 'errors')]")
    WebElement errorFlatNo;
    //endregion


    public AddressFormPage(){  super();  }

    public AddressFormPage fillReceiverZipCode(String text) {
        receiverZipCode.sendKeys(text);
        return this;
    }

    public AddressFormPage fillReceiverTown(String text) {
        getCommonHelper().confirmDropdown(receiverTown);
        return this;
    }

    public AddressFormPage fillReceiverStreet(String text) {
        getCommonHelper().confirmDropdown(receiverStreet);
        return this;
    }

    public AddressFormPage fillReceiverBuildingNo(String text) {
        receiverBuildingNo.sendKeys(text);
        return this;
    }

    public AddressFormPage fillReceiverFlatNo(String text) {
        receiverFlatNo.sendKeys(text);
        return this;
    }


    public String valueReceiverZipCode() {
        return receiverZipCode.getAttribute("value");
    }

    public String textReceiverTownValue() {
        return receiverTownValue.getText();
    }

    public String textReceiverStreetValue() {
        return receiverStreetValue.getText();
    }

    public String valueReceiverBuildingNo() {
        return receiverBuildingNo.getAttribute("value");
    }

    public String valueReceiverFlatNo() {
        return receiverFlatNo.getAttribute("value");
    }

    public WebElement getErrorReceiverZipCode() {
        return errorReceiverZipCode;
    }

    public WebElement getErrorReceiverTown() {
        return errorReceiverTown;
    }

    public WebElement getErrorReceiverStreet() {
        return errorReceiverStreet;
    }

    public WebElement getErrorBuildingNo() {
        return errorBuildingNo;
    }

    public WebElement getErrorFlatNo() {
        return errorFlatNo;
    }

    public AddressFormPage clearReceiverZipCode() {
        receiverZipCode.clear();
        return this;
    }

    public AddressFormPage clearReceiverTown() {
        receiverTown.clear();
        return this;
    }

    public AddressFormPage clearReceiverStreet() {
        receiverStreet.clear();
        return this;
    }

    public AddressFormPage clearReceiverBuildingNo() {
        receiverBuildingNo.clear();
        return this;
    }

    public AddressFormPage clearReceiverFlatNo() {
        receiverFlatNo.clear();
        return this;
    }

    @Override
    public WebElement getInitElement() {
        return receiverStreet;
    }
}

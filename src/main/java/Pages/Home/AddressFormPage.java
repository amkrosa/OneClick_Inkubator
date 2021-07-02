package Pages.Home;

import Pages.Actions.Action;
import Pages.Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddressFormPage extends BasePage {


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


    public AddressFormPage(WebDriver driver) {
        super(driver);
    }

    //region Actions
    public Action<AddressFormPage> receiverZipCode() {
        return new Action<>(receiverZipCode, this);
    }

    public Action<AddressFormPage> receiverTown() {
        return new Action<>(receiverTown, this);
    }

    public Action<AddressFormPage> receiverTownValue() {
        return new Action<>(receiverTownValue, this);
    }

    public Action<AddressFormPage> receiverStreet() {
        return new Action<>(receiverStreet, this);
    }

    public Action<AddressFormPage> receiverStreetValue() {
        return new Action<>(receiverStreetValue, this);
    }

    public Action<AddressFormPage> receiverBuildingNo() {
        return new Action<>(receiverBuildingNo, this);
    }

    public Action<AddressFormPage> receiverFlatNo() {
        return new Action<>(receiverFlatNo, this);
    }

    public Action<AddressFormPage> errorReceiverZipCode() {
        return new Action<>(errorReceiverZipCode, this);
    }

    public Action<AddressFormPage> errorReceiverTown() {
        return new Action<>(errorReceiverTown, this);
    }

    public Action<AddressFormPage> errorReceiverStreet() {
        return new Action<>(errorReceiverStreet, this);
    }

    public Action<AddressFormPage> errorBuildingNo() {
        return new Action<>(errorBuildingNo, this);
    }

    public Action<AddressFormPage> errorFlatNo() {
        return new Action<>(errorFlatNo, this);
    }

    //endregion

    @Override
    public WebElement getInitElement() {
        return receiverStreet;
    }
}

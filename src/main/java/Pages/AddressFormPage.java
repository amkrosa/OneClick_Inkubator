package Pages;

import Helpers.ActionHelper;
import Helpers.CommonHelper;
import Helpers.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddressFormPage extends BasePage{

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

    public AddressFormPage(){  super();  }

    public AddressFormPage fillReceiverZipCode(String text) {
        receiverZipCode.sendKeys(text);
        return this;
    }

    public AddressFormPage fillReceiverTown(String text) {
        getCommonHelper().writeAndConfirmDropdown(receiverTown, text);
        return this;
    }

    public AddressFormPage fillReceiverStreet(String text) {
        getCommonHelper().writeAndConfirmDropdown(receiverStreet, text);
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

    public String valueReceiverTown() {
        return receiverTown.getAttribute("value");
    }

    public String valueReceiverStreet() {
        return receiverStreet.getAttribute("value");
    }

    public String valueReceiverBuildingNo() {
        return receiverBuildingNo.getAttribute("value");
    }

    public String valueReceiverFlatNo() {
        return receiverFlatNo.getAttribute("value");
    }

    @Override
    public WebElement getInitElement() {
        return receiverStreet;
    }
}

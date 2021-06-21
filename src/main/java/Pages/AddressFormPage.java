package Pages;

import Helpers.ActionHelper;
import Helpers.CommonHelper;
import Helpers.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddressFormPage extends FormPage{

    private WebDriver driver;
    private CommonHelper commonHelper;
    private WaitHelper waitHelper;
    private ActionHelper actionHelper;

    @FindBy(how = How.NAME, using = "targetAddress.zipCode")
    WebElement receiverZipCode;
    @FindBy(how = How.XPATH, using = "//*[@name='targetAddress.town']//*/input")
    WebElement receiverTown;
    @FindBy(how = How.XPATH, using = "//*[@name='targetAddress.street']//*/input")
    WebElement receiverStreet;
    @FindBy(how = How.NAME, using = "targetAddress.buildingNo")
    WebElement receiverBuildingNo;
    @FindBy(how = How.NAME, using = "targetAddress.flatNo")
    WebElement receiverFlatNo;

    public AddressFormPage(){  super();  }

    public FormPage fillReceiverZipCode(String text) {
        receiverZipCode.sendKeys(text);
        return this;
    }

    public FormPage fillReceiverTown(String text) {
        commonHelper.writeAndConfirmDropdown(receiverTown, text);
        return this;
    }

    public FormPage fillReceiverStreet(String text) {
        commonHelper.writeAndConfirmDropdown(receiverStreet, text);
        return this;
    }

    public FormPage fillReceiverBuildingNo(String text) {
        receiverBuildingNo.sendKeys(text);
        return this;
    }

    public FormPage fillReceiverFlatNo(String text) {
        receiverFlatNo.sendKeys(text);
        return this;
    }




}

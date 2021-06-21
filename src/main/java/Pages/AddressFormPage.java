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
    @FindBy(how = How.NAME, using = "targetAddress.town")
    WebElement receiverTown;
    @FindBy(how = How.NAME, using = "targetAddress.street")
    WebElement receiverStreet;
    @FindBy(how = How.NAME, using = "targetAddress.buildingNo")
    WebElement receiverBuildingNo;
    @FindBy(how = How.NAME, using = "targetAddress.flatNo")
    WebElement receiverFlatNo;

    AddressFormPage(){  super();  }




}

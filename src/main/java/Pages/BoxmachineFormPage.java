package Pages;

import Helpers.ActionHelper;
import Helpers.CommonHelper;
import Helpers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BoxmachineFormPage extends FormPage {

    private WebDriver driver;
    private CommonHelper commonHelper;
    private WaitHelper waitHelper;
    private ActionHelper actionHelper;

    @FindBy(how = How.CSS, using = ".ng-input > input")
    WebElement parcelmachine;
    @FindBy(how = How.CSS, using = "app-geowidget")
    WebElement geowidget;

    BoxmachineFormPage(){  super(); }

    public BoxmachineFormPage setParcelmachine(String pm) {
        parcelmachine.sendKeys(pm);
        waitHelper.waitUntilClickable(By.cssSelector("#" + pm.toUpperCase()));
        driver.findElement(By.cssSelector("#" + pm.toUpperCase())).click();
        return this;
    }

    public BoxmachineFormPage fillReceiverParcelmachine(String name, String phone, String email, String parcelmachine) {
        super.receiverName.sendKeys(name);
        receiverEmail.sendKeys(email);
        receiverPhone.sendKeys(phone);
        setParcelmachine(parcelmachine);
        return this;
    }

}

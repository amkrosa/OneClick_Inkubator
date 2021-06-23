package Pages;

import Helpers.ActionHelper;
import Helpers.CommonHelper;
import Helpers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BoxmachineFormPage extends BasePage {

    @FindBy(how = How.CSS, using = ".ng-input > input")
    WebElement parcelmachine;
    @FindBy(how = How.CSS, using = ".ng-value")
    WebElement parcelmachineFieldValue;
    @FindBy(how = How.CSS, using = "app-geowidget")
    WebElement geowidget;

    public BoxmachineFormPage(){  super(); }

    public BoxmachineFormPage setParcelmachine(String pm) {
        parcelmachine.sendKeys(pm);
        getWaitHelper().waitUntilClickable(By.cssSelector("#" + pm.toUpperCase()));
        getDriver().findElement(By.cssSelector("#" + pm.toUpperCase())).click();
        return this;
    }

    public String textParcelmachineFieldValue() {
        return parcelmachineFieldValue.getText();
    }
}

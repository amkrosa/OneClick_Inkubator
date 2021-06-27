package Pages;

import Pages.Actions.Action;
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

    @FindBy(xpath = "//*[@id='error-boxMachineName']/..//*[contains(@class, 'errors')]")
    WebElement errorReceiverBoxmachine;

    public BoxmachineFormPage(){  super(); }

    //region Actions
    public Action<BoxmachineFormPage> parcelmachine() {
        return new Action<>(parcelmachine, this);
    }

    public Action<BoxmachineFormPage> parcelmachineFieldValue() {
        return new Action<>(parcelmachineFieldValue, this);
    }

    public Action<BoxmachineFormPage> geowidget() {
        return new Action<>(geowidget, this);
    }

    public Action<BoxmachineFormPage> errorReceiverBoxmachine() {
        return new Action<>(errorReceiverBoxmachine, this);
    }
    //endregion

    @Override
    public WebElement getInitElement() {
        return parcelmachine;
    }
}

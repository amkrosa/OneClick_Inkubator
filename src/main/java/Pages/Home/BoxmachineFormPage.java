package Pages.Home;

import Pages.Actions.Action;
import Pages.Base.BasePage;
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
    @FindBy(xpath = "//*[contains(@class, 'ng-option-disabled')]")
    private WebElement parcelmachineDropDownDisabled;
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
    public Action<BoxmachineFormPage> parcelmachineDropDownDisabled() {
        return new Action<BoxmachineFormPage>(parcelmachineDropDownDisabled, this);
    }
    //endregion

    @Override
    public WebElement getInitElement() {
        return parcelmachine;
    }
}

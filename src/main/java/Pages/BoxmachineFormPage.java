package Pages;

import Pages.Actions.Action;
import org.openqa.selenium.By;
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

    public Action parcelmachine() {
        return new Action(parcelmachine);
    }

    public Action parcelmachineFieldValue() {
        return new Action(parcelmachineFieldValue);
    }

    public Action geowidget() {
        return new Action(geowidget);
    }

    public Action errorReceiverBoxmachine() {
        return new Action(errorReceiverBoxmachine);
    }

    public BoxmachineFormPage setParcelmachine(String pm) {
        getCommonHelper().writeAndConfirmDropdown(parcelmachine, pm);
        return this;
    }

    public String textParcelmachineFieldValue() {
        return parcelmachineFieldValue.getText();
    }

    public WebElement getErrorReceiverBoxmachine() {
        return errorReceiverBoxmachine;
    }

    public BoxmachineFormPage clearParcelmachine() {
        parcelmachine.clear();
        return this;
    }

    @Override
    public WebElement getInitElement() {
        return parcelmachine;
    }
}

package Pages.Actions;

import Helpers.CommonHelper;
import Helpers.WaitHelper;
import org.openqa.selenium.WebElement;

public class Action implements IAction{

    private WaitHelper waitHelper = new WaitHelper();
    private CommonHelper commonHelper = new CommonHelper();
    private final WebElement element;

    public Action(WebElement element){
        this.element = element;
    }

    @Override
    public IAction fill(String text) {
        element.sendKeys(text);
        return this;
    }

    @Override
    public IAction click() {
        commonHelper.moveAndClick(element);
        return this;
    }

    @Override
    public IAction clear() {
        element.clear();
        return this;
    }

    @Override
    public IAction waitVisible() {
        waitHelper.waitUntilVisible(element);
        return this;
    }

    @Override
    public IAction waitClickable() {
        waitHelper.waitUntilClickable(element);
        return this;
    }

    @Override
    public IAction confirmDropdown() {
        commonHelper.confirmDropdown(element);
        return this;
    }

    @Override
    public String text() {
        return element.getText();
    }

    @Override
    public String value() {
        return element.getAttribute("value");
    }

    @Override
    public String src(){
        return element.getAttribute("src");
    }

    @Override
    public boolean isDisplayed() {
        return element.isDisplayed();
    }



}

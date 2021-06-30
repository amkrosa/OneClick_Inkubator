package Pages.Actions;

import Helpers.ActionHelper;
import Helpers.CommonHelper;
import Helpers.WaitHelper;
import Pages.Base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Action<T extends BasePage> implements IAction<T>{
    private final T page;
    private final WaitHelper waitHelper;
    private final CommonHelper commonHelper;
    private final ActionHelper actionHelper;
    private final WebElement element;

    public Action(WebElement element, BasePage page){
        this.element = element;
        this.page = (T) page;
        waitHelper = page.getWaitHelper();
        commonHelper = page.getCommonHelper();
        actionHelper = page.getActionHelper();
    }

    @Override
    public T page() {
        return page;
    }

    @Override
    public IAction<T> fill(String text) {
        element.sendKeys(text);
        return this;
    }

    @Override
    public IAction<T> click() {
        //waitHelper.waitUntilVisible(element);
        commonHelper.moveAndClick(element);
        return this;
    }

    @Override
    public IAction<T> clear() {
        element.clear();
        return this;
    }

    @Override
    public IAction<T> waitVisible() {
        waitHelper.waitUntilVisible(element);
        return this;
    }

    @Override
    public IAction<T> waitClickable() {
        waitHelper.waitUntilClickable(element);
        return this;
    }

    @Override
    public IAction<T> waitInvisible() {
        waitHelper.waitUntilInvisible(element);
        return this;
    }

    @Override
    public IAction<T> confirmDropdown() {
        commonHelper.confirmDropdown(element);
        return this;
    }

    @Override
    public IAction<T> enter() {
        element.sendKeys(Keys.ENTER);
        return this;
    }

    @Override
    public IAction<T> clickAbove() {
        actionHelper.clickWithOffset(element, 0, -30);
        return this;
    }

    @Override
    public IAction<T> tab() {
        element.sendKeys(Keys.TAB);
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

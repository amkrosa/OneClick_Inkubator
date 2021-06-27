package Helpers;

import SeleniumBase.Base;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonHelper {
    ActionHelper actionHelper;
    WaitHelper waitHelper;

    public CommonHelper() {
        this.actionHelper = new ActionHelper();
        this.waitHelper = new WaitHelper();
    }

    public CommonHelper(ActionHelper actionHelper, WaitHelper waitHelper){
        this.actionHelper = actionHelper;
        this.waitHelper = waitHelper;
    }

    public void waitAndClick(WebElement elementToClick, WebElement elementToWait){
        waitHelper.waitUntilVisible(elementToWait);
        elementToClick.click();
    }

    public void waitAndClick(WebElement elementToClick){
        WebElement elementToWait = elementToClick;
        waitHelper.waitUntilVisible(elementToWait);
        elementToClick.click();
    }

    public void moveAndClick(WebElement element){
        actionHelper.moveToElement(element);
        waitHelper.waitUntilClickable(element);
        element.click();
    }

    public void writeAndConfirmDropdown(WebElement inputElement, String text) throws UnsupportedOperationException {
        inputElement.sendKeys(text);
        confirmDropdown(inputElement);
    }

    public void confirmDropdown(WebElement inputElement) throws UnsupportedOperationException{
        inputElement.click();
        By path = By.xpath("//div[@role='option']");
        waitHelper.waitUntilVisible(waitHelper.waitUntilLocated(path));
        inputElement.sendKeys(Keys.ENTER);
    }

    public boolean isVisible(By by){
        return !Base.driver.findElements(by).isEmpty();
    }

    public boolean isModalVisible(By byxpath, WebElement openModalButton){
            moveAndClick(openModalButton);
            try {
                waitHelper.waitUntilLocated(byxpath);
                return true;
            }catch (Exception e){
                return false;
            }
    }

}

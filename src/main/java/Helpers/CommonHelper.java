package Helpers;

import SeleniumBase.Base;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonHelper {
    ActionHelper actionHelper;
    WaitHelper waitHelper;

    public CommonHelper() {
        this.actionHelper = new ActionHelper(new Actions(Base.driver));
        this.waitHelper = new WaitHelper(new WebDriverWait(Base.driver, 3));
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
        element.click();
    }

    public void writeAndConfirmDropdown(WebElement inputElement, String text) throws UnsupportedOperationException {
        inputElement.sendKeys(text);

        WebElement listBoxElement = inputElement.findElement(By.xpath("./../../../../*[@role='listbox']"));
        if (!listBoxElement.findElements(By.cssSelector(".ng-option-disabled")).isEmpty())
            throw new UnsupportedOperationException("listbox is empty");
        inputElement.sendKeys(Keys.ENTER);
    }

    public boolean isVisible(By by){
        return !Base.driver.findElements(by).isEmpty();
    }

    public boolean isModalVisible(By byxpath, WebElement openModalButton){
            moveAndClick(openModalButton);
            try {
                waitHelper.waitUntilVisible(byxpath);
                return true;
            }catch (Exception e){
                return false;
            }
    }

}

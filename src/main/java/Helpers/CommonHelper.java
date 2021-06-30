package Helpers;

import Selenium.Base;
import org.openqa.selenium.*;

public class CommonHelper {
    ActionHelper actionHelper;
    WaitHelper waitHelper;
    private WebDriver driver;

    public CommonHelper(WebDriver driver) {
        this.driver = driver;
        this.actionHelper = new ActionHelper(driver);
        this.waitHelper = new WaitHelper(driver);
    }

    public CommonHelper(WebDriver driver, ActionHelper actionHelper, WaitHelper waitHelper){
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
        return !driver.findElements(by).isEmpty();
    }

    public boolean isModalVisible(By byxpath){
            try {
                waitHelper.waitUntilLocated(byxpath);
                return true;
            }catch (Exception e){
                return false;
            }
    }

}

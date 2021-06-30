package Helpers;

import Selenium.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionHelper {

    private final Actions actions;

    public ActionHelper(WebDriver driver){
        this.actions = new Actions(driver);
    }

    public void moveToElement(WebElement element){
        actions.moveToElement(element).build().perform();
    }

    public void clickWithOffset(WebElement element, int x, int y){
        actions.moveToElement(element, x,y).click().build().perform();
    }



}

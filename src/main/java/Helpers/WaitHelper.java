package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

    WebDriverWait wait;

    public WaitHelper(WebDriverWait wait){
        this.wait = wait;
    }

    public void waitUntilVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilVisible(By by){
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitUntilClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilClickable(By by){
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }


}

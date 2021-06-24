package Helpers;

import SeleniumBase.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class WaitHelper {

    FluentWait<WebDriver> fluentWait;

    public WaitHelper(){
        fluentWait = new FluentWait<>(Base.driver);
        fluentWait.withTimeout(Duration.ofSeconds(3))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(Exception.class);
    }

    public void waitUntilVisible(WebElement element){
        fluentWait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitUntilLocated(By by){
        return fluentWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitUntilClickable(WebElement element){
        fluentWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilClickable(By by){
        fluentWait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitUntilTextIsPresent(WebElement webElement, String text) {
        fluentWait.until(ExpectedConditions.textToBePresentInElement(webElement, text));
    }


}

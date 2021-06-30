package Helpers;

import Selenium.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.time.Duration;

public class WaitHelper {

    private FluentWait<WebDriver> fluentWait;
    private WebDriver driver;

    public WaitHelper(WebDriver driver){
        this.driver = driver;
        fluentWait = new FluentWait<>(driver);
        fluentWait.withTimeout(Duration.ofSeconds(Base.config.getTimeout()))
                .pollingEvery(Duration.ofMillis(750))
                .ignoring(Exception.class);
    }

    public void waitUntilVisible(WebElement element){
        fluentWait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitUntilInvisible(WebElement element){
        fluentWait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitUntilZeroElements(By by){
        fluentWait.until(ExpectedConditions.numberOfElementsToBe(by, 0));
    }

    public void waitUntilVisible(By by){
        fluentWait.until(ExpectedConditions.visibilityOf(
                waitUntilLocated(by)
        ));
    }

    public WebElement waitUntilLocated(By by){
        return fluentWait.until(driver -> driver.findElement(by));
    }

    public void waitUntilTextIsPresent(WebElement element, String text){
        int iterationTimeout = 10;
        while (iterationTimeout!=0) {
            try {
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(Base.config.getTimeout()/4))
                        .pollingEvery(Duration.ofMillis(500))
                        .ignoring(Exception.class)
                        .until(driver ->
                                driver.findElement(By.xpath("//*[contains(text(),'" + text + "')]")));
                return;
            }catch (Exception e){
                element.click();
                iterationTimeout--;
            }
        }
        throw new TimeoutException();
    }

    public boolean waitUntilDownloaded(WebElement elementInitializingDownload) throws IOException {
        FileHelper fileHelper = new FileHelper();
        final Path targetFolder = Path.of(Base.downloadFolder);
        FileTime before = Files.getLastModifiedTime(fileHelper.getLatestFile());
        waitUntilClickable(elementInitializingDownload);
        elementInitializingDownload.click();
        return fluentWait.until(driver -> {
            try {
                FileTime after = Files.getLastModifiedTime(fileHelper.getLatestFile());
                int result = fileHelper.countFilesWithExtension("crdownload");
                if (before.compareTo(after)<0 && result==0)
                    return true;
            } catch (IOException ignored) {}
            return false;
        });
    }

    public void waitUntilClickable(WebElement element){
        fluentWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilClickable(By by){
        fluentWait.until(ExpectedConditions.elementToBeClickable(by));
    }

}

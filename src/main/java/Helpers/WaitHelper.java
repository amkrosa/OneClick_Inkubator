package Helpers;

import SeleniumBase.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.time.Duration;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class WaitHelper {

    FluentWait<WebDriver> fluentWait;

    public WaitHelper(){
        fluentWait = new FluentWait<>(Base.driver);
        fluentWait.withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(Exception.class);
    }

    public void waitUntilVisible(WebElement element){
        fluentWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilVisible(By by){
        fluentWait.until(ExpectedConditions.visibilityOf(
                waitUntilLocated(by)
        ));
    }

    public WebElement waitUntilLocated(By by){
        return fluentWait.until(driver -> driver.findElement(by));
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

    public void waitUntilTextIsPresent(WebElement webElement, String text) {
        fluentWait.until(ExpectedConditions.textToBePresentInElement(webElement, text));
    }


}

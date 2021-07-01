package Pages.Base;

import Helpers.ActionHelper;
import Helpers.CommonHelper;
import Helpers.WaitHelper;
import Selenium.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {
    private WebDriver driver;
    private CommonHelper commonHelper;
    private WaitHelper waitHelper;
    private ActionHelper actionHelper;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        actionHelper = new ActionHelper(driver);
        commonHelper = new CommonHelper(driver, actionHelper, waitHelper);
    }

    public CommonHelper getCommonHelper() {
        return commonHelper;
    }

    public WaitHelper getWaitHelper() {
        return waitHelper;
    }

    public ActionHelper getActionHelper() {
        return actionHelper;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public boolean isTextFound(String text) {
        List<WebElement> element = driver.findElements(By.xpath("//*[contains(text(),'"+text+"')]"));
        return element.size() > 0;
    }

    public <T extends BasePage> T init(){
        waitHelper.waitUntilVisibleLong(getInitElement());
        return (T)this;
    }

    public abstract WebElement getInitElement();
}

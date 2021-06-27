package Pages;

import Helpers.ActionHelper;
import Helpers.CommonHelper;
import Helpers.WaitHelper;
import SeleniumBase.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BasePage {
    private WebDriver driver;
    private CommonHelper commonHelper;
    private WaitHelper waitHelper;
    private ActionHelper actionHelper;

    public BasePage(){
        driver = Base.driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper();
        actionHelper = new ActionHelper();
        commonHelper = new CommonHelper(actionHelper, waitHelper);
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
        List<WebElement> element = this.getDriver().findElements(By.xpath("//*[contains(text(),'"+text+"')]"));
        return element.size() > 0;
    }

    public <T extends BasePage> T init(){
        waitHelper.waitUntilVisible(getInitElement());
        return (T)this;
    }

    public abstract WebElement getInitElement();
}

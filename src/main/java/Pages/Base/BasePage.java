package Pages.Base;

import Helpers.ActionHelper;
import Helpers.CommonHelper;
import Helpers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Base from which all Page classes inherits. Stores helpers and <code>init()</code>
 * methods for initializing Page, by waiting until specified element from child
 * class is visible.
 */
public abstract class BasePage {
    private WebDriver driver;
    private CommonHelper commonHelper;
    private WaitHelper waitHelper;
    private ActionHelper actionHelper;

    public BasePage(WebDriver driver) {
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
        List<WebElement> element = driver.findElements(By.xpath("//*[contains(text(),'" + text + "')]"));
        return element.size() > 0;
    }

    /**
     * Wait until element from <code>getInitElement()</code> method is visible,
     * with timeout twice of that specified in config
     * @param <T> Page class
     * @return <code>T</code> parameter
     */
    public <T extends BasePage> T init() {
        waitHelper.waitUntilVisibleLong(getInitElement());
        return (T) this;
    }

    /**
     * Specifies element which <code>init()</code> should apply to <code>waitUntilVisibleLong()</code>
     * method.
     * @return <code>WebElement</code> specified in child class
     */
    public abstract WebElement getInitElement();
}

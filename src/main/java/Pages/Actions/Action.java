package Pages.Actions;

import Helpers.ActionHelper;
import Helpers.CommonHelper;
import Helpers.WaitHelper;
import Pages.Base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

/**
 *
 * Action class defining typical actions made on Page Object Models extending IAction interface.
 * <p>
 *
 * Example for  WebElement invoiceCompanyName in SummaryPage POM class:
 * <pre>{@code
 *     public Action<SummaryPage> invoiceCompanyName() {
 *         return new Action<>(invoiceCompanyName, this);
 *     }
 * }</pre>
 * @see Pages.Actions.IAction
 * @param <T> PageObjectModel that extends BasePage
 */

public class Action<T extends BasePage> implements IAction<T> {
    private final T page;
    private final WaitHelper waitHelper;
    private final CommonHelper commonHelper;
    private final ActionHelper actionHelper;
    private final WebElement element;

    public Action(WebElement element, BasePage page) {
        this.element = element;
        this.page = (T) page;
        waitHelper = page.getWaitHelper();
        commonHelper = page.getCommonHelper();
        actionHelper = page.getActionHelper();
    }

    @Override
    public T page() {
        return page;
    }

    @Override
    public IAction<T> fill(String text) {
        element.sendKeys(text);
        return this;
    }

    /**
     * Move to element and click it.
     * @return <code>this</code>
     */
    @Override
    public IAction<T> click() {
        commonHelper.moveAndClick(element);
        return this;
    }

    /**
     * Clear element (if input).
     * @return <code>this</code>
     */
    @Override
    public IAction<T> clear() {
        element.clear();
        return this;
    }

    /**
     * Wait until element is visible.
     * @return <code>this</code>
     */
    @Override
    public IAction<T> waitVisible() {
        waitHelper.waitUntilVisible(element);
        return this;
    }

    /**
     * Wait until element is clickable.
     * @return <code>this</code>
     */
    @Override
    public IAction<T> waitClickable() {
        waitHelper.waitUntilClickable(element);
        return this;
    }

    /**
     * Wait until element is invisible.
     * @return <code>this</code>
     */
    @Override
    public IAction<T> waitInvisible() {
        waitHelper.waitUntilInvisible(element);
        return this;
    }

    /**
     * Confirms dropdown if combobox was displayed.
     * @return <code>this</code>
     */
    @Override
    public IAction<T> confirmDropdown() {
        commonHelper.confirmDropdown(element);
        return this;
    }

    /**
     * Inputs <code>ENTER</code> key.
     * @return <code>this</code>
     */
    @Override
    public IAction<T> enter() {
        element.sendKeys(Keys.ENTER);
        return this;
    }

    /**
     * Clicks 30 pixels above element.
     * @return <code>this</code>
     */
    @Override
    public IAction<T> clickAbove() {
        actionHelper.clickWithOffset(element, 0, -30);
        return this;
    }

    /**
     * Inputs <code>TAB</code> key.
     * @return <code>this</code>
     */
    @Override
    public IAction<T> tab() {
        element.sendKeys(Keys.TAB);
        return this;
    }

    /**
     * Gets text value from element.
     * @return <code>String</code>
     */
    @Override
    public String text() {
        return element.getText();
    }

    /**
     * Gets attribute <code>value</code> from element as <code>String</code>.
     * @return <code>String</code>
     */
    @Override
    public String value() {
        return element.getAttribute("value");
    }

    /**
     * Gets attribute <code>src</code> from element as <code>String</code>.
     * @return <code>String</code>
     */
    @Override
    public String src() {
        return element.getAttribute("src");
    }

    /**
     * Allows to ascertain if element is displayed.
     * @return <code>true</code> if element is displayed.
     */
    @Override
    public boolean isDisplayed() {
        return element.isDisplayed();
    }

}

package Pages.Actions;

import Pages.BasePage;

public interface IAction<T extends BasePage> {

    T page();

    IAction<T> fill(String text);
    IAction<T> click();
    IAction<T> clear();
    IAction<T> waitVisible();
    IAction<T> waitClickable();
    IAction<T> confirmDropdown();

    String text();
    String value();
    String src();
    boolean isDisplayed();
}

package Pages.Actions;

import Pages.Base.BasePage;

public interface IAction<T extends BasePage> {

    T page();

    IAction<T> fill(String text);

    IAction<T> click();

    IAction<T> clear();

    IAction<T> waitVisible();

    IAction<T> waitClickable();

    IAction<T> waitInvisible();

    IAction<T> confirmDropdown();

    IAction<T> enter();

    IAction<T> clickAbove();

    IAction<T> tab();

    String text();

    String value();

    String src();

    boolean isDisplayed();
}

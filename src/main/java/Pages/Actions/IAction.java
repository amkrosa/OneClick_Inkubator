package Pages.Actions;

public interface IAction {

    IAction fill(String text);
    IAction click();
    IAction clear();
    IAction waitVisible();
    IAction waitClickable();
    IAction confirmDropdown();

    String text();
    String value();
    String src();
    boolean isDisplayed();
}

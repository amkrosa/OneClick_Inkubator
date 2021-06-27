package Helpers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionHelper {

    private final Actions actions;

    public ActionHelper(Actions actions){
        this.actions = actions;
    }

    public void moveToElement(WebElement element){
        actions.moveToElement(element).build().perform();
    }



}

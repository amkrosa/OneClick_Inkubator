package Pages;

import Pages.Actions.Action;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PaymentRedirectPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//button[@value='1']")
    WebElement confirmedPaymentButton;
    @FindBy(how = How.XPATH, using = "//button[@value='2']")
    WebElement rejectedPaymentButton;
    @FindBy(how = How.XPATH, using = "//button[@value='3']")
    WebElement pendingPaymentButton;

    public PaymentRedirectPage(){super();}

    public Action confirmedPaymentButton() {
        return new Action(confirmedPaymentButton);
    }

    public Action rejectedPaymentButton() {
        return new Action(rejectedPaymentButton);
    }

    public Action pendingPaymentButton() {
        return new Action(pendingPaymentButton);
    }

    public PaymentRedirectPage clickConfirmedPaymentButton() {
        getCommonHelper().moveAndClick(confirmedPaymentButton);
        return this;
    }

    public PaymentRedirectPage clickRejectedPaymentButton() {
        getCommonHelper().moveAndClick(rejectedPaymentButton);
        return this;
    }

    public PaymentRedirectPage clickPendingPaymentButton() {
        getCommonHelper().moveAndClick(pendingPaymentButton);
        return this;
    }

    @Override
    public WebElement getInitElement() {
        return pendingPaymentButton;
    }
}

package Pages.Payment;

import Pages.Actions.Action;
import Pages.Base.BasePage;
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

    //region Actions
    public Action<PaymentRedirectPage> confirmedPaymentButton() {
        return new Action<>(confirmedPaymentButton, this);
    }

    public Action<PaymentRedirectPage> rejectedPaymentButton() {
        return new Action<>(rejectedPaymentButton, this);
    }

    public Action<PaymentRedirectPage> pendingPaymentButton() {
        return new Action<>(pendingPaymentButton, this);
    }
    //endregion

    @Override
    public WebElement getInitElement() {
        return pendingPaymentButton;
    }
}

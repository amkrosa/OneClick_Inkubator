package Pages.Payment;

import Pages.Actions.Action;
import Pages.Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PaymentFormPage extends BasePage {

    @FindBy(how = How.ID, using = "data-processing-agreement")
    WebElement dataProcessingAgreementCheckbox;
    @FindBy(how = How.XPATH, using = "//*[@title='mTransfer']")
    WebElement mtransferPaymentButton;
    @FindBy(how = How.NAME, using = "EMAIL")
    WebElement emailField;
    @FindBy(how = How.XPATH, using = "//*[contains(@class,'finish-button')]")
    WebElement finishButton;

    public PaymentFormPage(WebDriver driver) {
        super(driver);
    }

    //region Actions
    public Action<PaymentFormPage> dataProcessingAgreementCheckbox() {
        return new Action<>(dataProcessingAgreementCheckbox, this);
    }

    public Action<PaymentFormPage> mtransferPaymentButton() {
        return new Action<>(mtransferPaymentButton, this);
    }

    public Action<PaymentFormPage> emailField() {
        return new Action<>(emailField, this);
    }

    public Action<PaymentFormPage> finishButton() {
        return new Action<>(finishButton, this);
    }
    //endregion


    @Override
    public WebElement getInitElement() {
        return finishButton;
    }
}

package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PaymentFormPage extends BasePage{

    @FindBy(how = How.ID, using = "data-processing-agreement")
    WebElement dataProcessingAgreementCheckbox;
    @FindBy(how = How.XPATH, using = "//*[@title='mTransfer']/input")
    WebElement mtransferPaymentButton;
    @FindBy(how = How.NAME, using = "EMAIL")
    WebElement emailField;
    @FindBy(how = How.XPATH, using = "//*[@class='finish-button']")
    WebElement finishButton;

    public PaymentFormPage(){super();}

    public PaymentFormPage fillEmailField(String text) {
        emailField.sendKeys(text);
        return this;
    }

    public PaymentFormPage clickDataProcessingAgreementCheckbox() {
        if (!dataProcessingAgreementCheckbox.getAttribute("checked").equals("checked"))
            getCommonHelper().moveAndClick(dataProcessingAgreementCheckbox);
        return this;
    }

    public PaymentFormPage clickMtransferPaymentButton() {
        getCommonHelper().moveAndClick(mtransferPaymentButton);
        return this;
    }

    public PaymentFormPage clickFinishButton() {
        getCommonHelper().moveAndClick(finishButton);
        return this;
    }

    @Override
    public WebElement getInitElement() {
        return finishButton;
    }
}

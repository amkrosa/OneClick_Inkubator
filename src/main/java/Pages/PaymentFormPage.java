package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PaymentFormPage {

    @FindBy(how = How.ID, using = "data-processing-agreement")
    WebElement dataProcessingAgreementCheckbox;
    @FindBy(how = How.XPATH, using = "//*[@title='mTransfer']/input")
    WebElement mtransferPaymentButton;
    @FindBy(how = How.NAME, using = "EMAIL")
    WebElement emailField;
    @FindBy(how = How.XPATH, using = "//*[@class='finish-button']")
    WebElement finishButton;



}

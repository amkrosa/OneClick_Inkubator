package Pages;

import Helpers.ActionHelper;
import Helpers.CommonHelper;
import Helpers.WaitHelper;
import SeleniumBase.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InvoiceFormPage {

    private WebDriver driver;
    private CommonHelper commonHelper;
    private WaitHelper waitHelper;
    private ActionHelper actionHelper;

    @FindBy(how = How.CSS, using = "[for=legalStatusforeignCompany]")
    private WebElement invoiceForeignCompanyCheckbox;
    @FindBy(how = How.CSS, using = "[for=legalStatusindividual]")
    private WebElement invoiceIndividualCheckbox;
    @FindBy(how = How.CSS, using = "[for=legalStatuscompany]")
    private WebElement invoicePolishCompanyCheckbox;

    //region Foreign company WebElements
    @FindBy(how = How.XPATH, using = "//*[@id='error-invoice.foreignCompany.prefixNip']/../..//*[@role='combobox']/input")
    private WebElement foreignCompanyPrefixInput;
    @FindBy(how = How.NAME, using = "invoice.foreignCompany.nip")
    private WebElement foreignCompanyNip;
    @FindBy(how = How.NAME, using = "invoice.foreignCompany.companyName")
    private WebElement foreignCompanyName;
    @FindBy(how = How.XPATH, using = "//*[@id='error-invoice.foreignCompany.countryCode']/../..//*[@role='combobox']/input")
    private WebElement foreignCompanyCountryInput;
    @FindBy(how = How.NAME, using = "invoice.foreignCompany.zipCode")
    private WebElement foreignCompanyPostalCode;
    @FindBy(how = How.NAME, using = "invoice.foreignCompany.town")
    private WebElement foreignCompanyTown;
    @FindBy(how = How.NAME, using = "invoice.foreignCompany.street")
    private WebElement foreignCompanyStreet;
    @FindBy(how = How.NAME, using = "invoice.foreignCompany.buildingNo")
    private WebElement foreignCompanyBuilding;
    @FindBy(how = How.NAME, using = "invoice.foreignCompany.flatNo")
    private WebElement foreignCompanyFlat;
    @FindBy(how = How.NAME, using = "invoice.foreignCompany.email")
    private WebElement foreignCompanyEmail;
    //endregion

    public InvoiceFormPage() {
        driver = Base.driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(new WebDriverWait(Base.driver, 3));
        actionHelper = new ActionHelper(new Actions(Base.driver));
        commonHelper = new CommonHelper(actionHelper, waitHelper);
    }

    public InvoiceFormPage clickInvoiceForeignCompanyCheckbox(){
        commonHelper.moveAndClick(invoiceForeignCompanyCheckbox);
        return this;
    }

    //region Foreign company fill methods
    public InvoiceFormPage fillInvoiceForeignCompanyPrefix(String text) {
        commonHelper.writeAndConfirmDropdown(foreignCompanyPrefixInput, text);
        return this;
    }
    public InvoiceFormPage fillInvoiceForeignCompanyNip(String text){
        foreignCompanyNip.sendKeys(text);
        return this;
    }
    public InvoiceFormPage fillInvoiceForeignCompanyName(String text){
        foreignCompanyName.sendKeys(text);
        return this;
    }
    public InvoiceFormPage fillInvoiceForeignCompanyCountry(String text) {
        commonHelper.writeAndConfirmDropdown(foreignCompanyCountryInput, text);
        return this;
    }
    public InvoiceFormPage fillInvoiceForeignCompanyPostalCode(String text) {
        foreignCompanyPostalCode.sendKeys(text);
        return this;
    }
    public InvoiceFormPage fillInvoiceForeignCompanyTown(String text){
        foreignCompanyTown.sendKeys(text);
        return this;
    }
    public InvoiceFormPage fillInvoiceForeignCompanyStreet(String text){
        foreignCompanyStreet.sendKeys(text);
        return this;
    }
    public InvoiceFormPage fillInvoiceForeignCompanyBuildingNo(String text){
        foreignCompanyBuilding.sendKeys(text);
        return this;
    }
    public InvoiceFormPage fillInvoiceForeignCompanyFlatNo(String text){
        foreignCompanyFlat.sendKeys(text);
        return this;
    }
    public InvoiceFormPage fillInvoiceForeignCompanyEmail(String text){
        foreignCompanyEmail.sendKeys(text);
        return this;
    }
    //endregion


}

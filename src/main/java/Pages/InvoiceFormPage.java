package Pages;

import Helpers.ActionHelper;
import Helpers.CommonHelper;
import Helpers.WaitHelper;
import Pages.Actions.Action;
import SeleniumBase.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;

public class InvoiceFormPage extends BasePage{

    @FindBy(how = How.CSS, using = "[for=legalStatusforeignCompany]")
    private WebElement invoiceForeignCompanyCheckbox;
    @FindBy(how = How.CSS, using = "[for=legalStatusindividual]")
    private WebElement invoiceIndividualCheckbox;
    @FindBy(how = How.CSS, using = "[for=legalStatuscompany]")
    private WebElement invoiceCompanyCheckbox;

    //region Foreign company WebElements
    @FindBy(how = How.XPATH, using = "//*[@id='error-invoice.foreignCompany.prefixNip']/../..//*[@role='combobox']/input")
    private WebElement foreignCompanyPrefixInput;
    @FindBy(how = How.XPATH, using = "//*[@id='error-invoice.foreignCompany.prefixNip']/../..//*[@class='ng-value']")
    private WebElement foreignCompanyPrefixValue;
    @FindBy(how = How.NAME, using = "invoice.foreignCompany.nip")
    private WebElement foreignCompanyNip;
    @FindBy(how = How.NAME, using = "invoice.foreignCompany.companyName")
    private WebElement foreignCompanyName;
    @FindBy(how = How.XPATH, using = "//*[@id='error-invoice.foreignCompany.countryCode']/../..//*[@role='combobox']/input")
    private WebElement foreignCompanyCountryInput;
    @FindBy(how = How.XPATH, using = "//*[@id='error-invoice.foreignCompany.countryCode']/../..//*[@class='ng-value']")
    private WebElement foreignCompanyCountryValue;
    @FindBy(how = How.NAME, using = "invoice.foreignCompany.zipCode")
    private WebElement foreignCompanyPostalCode;
    @FindBy(how = How.NAME, using = "invoice.foreignCompany.town")
    private WebElement foreignCompanyTown;
    @FindBy(how = How.NAME, using = "invoice.foreignCompany.street")
    private WebElement foreignCompanyStreet;
    @FindBy(how = How.NAME, using = "invoice.foreignCompany.buildingNo")
    private WebElement foreignCompanyBuildingNo;
    @FindBy(how = How.NAME, using = "invoice.foreignCompany.flatNo")
    private WebElement foreignCompanyFlatNo;
    @FindBy(how = How.NAME, using = "invoice.foreignCompany.email")
    private WebElement foreignCompanyEmail;
    //endregion

    //region Private person WebElements
    @FindBy(how = How.NAME, using = "invoice.individual.companyName")
    private WebElement individualName;
    @FindBy(how = How.NAME, using = "invoice.individual.email")
    private WebElement individualEmail;
    @FindBy(how = How.XPATH, using = "//*[@name='invoice.individual.town']//*/input")
    private WebElement individualTown;
    @FindBy(how = How.XPATH, using = "//*[@name='invoice.individual.town']//div[@class='ng-value']")
    private WebElement individualTownValue;
    @FindBy(how = How.XPATH, using = "//*[@name='invoice.individual.street']//*/input")
    private WebElement individualStreet;
    @FindBy(how = How.XPATH, using = "//*[@name='invoice.individual.street']//div[@class='ng-value']")
    private WebElement individualStreetValue;
    @FindBy(how = How.NAME, using = "invoice.individual.buildingNo")
    private WebElement individualBuildingNo;
    @FindBy(how = How.NAME, using = "invoice.individual.flatNo")
    private WebElement individualFlatNo;
    //endregion

    //region Company WebElements
    @FindBy(how = How.NAME, using = "invoice.company.nip")
    private WebElement companyNip;
    @FindBy(how = How.NAME, using = "invoice.company.companyName")
    private WebElement companyName;
    @FindBy(how = How.NAME, using = "invoice.company.zipCode")
    private WebElement companyPostalCode;
    @FindBy(how = How.XPATH, using = "//*[@name='invoice.company.town']//input")
    private WebElement companyTownInput;
    @FindBy(how = How.XPATH, using = "//*[@name='invoice.company.town']//*[@class='ng-value']")
    private WebElement companyTownValue;
    @FindBy(how = How.NAME, using = "//*[@name='invoice.company.street']//input")
    private WebElement companyStreetInput;
    @FindBy(how = How.XPATH, using = "//*[@name='invoice.company.street']//*[@class='ng-value']")
    private WebElement companyStreetValue;
    @FindBy(how = How.NAME, using = "invoice.company.buildingNo")
    private WebElement companyBuildingNo;
    @FindBy(how = How.NAME, using = "invoice.company.flatNo")
    private WebElement companyFlatNo;
    @FindBy(how = How.NAME, using = "invoice.company.email")
    private WebElement companyEmail;
    //endregion

    private WebElement initElement;

    public InvoiceFormPage() {
        super();
    }


    //region Custom actions
    public InvoiceFormPage clickInvoiceForeignCompanyCheckbox(){
        getCommonHelper().moveAndClick(invoiceForeignCompanyCheckbox);
        initElement = foreignCompanyTown;
        return this;
    }

    public InvoiceFormPage clickInvoiceIndividualCheckbox(){
        getCommonHelper().moveAndClick(invoiceForeignCompanyCheckbox);
        initElement = individualTown;
        return this;
    }

    public InvoiceFormPage clickInvoiceCompanyCheckbox(){
        getCommonHelper().moveAndClick(invoiceForeignCompanyCheckbox);
        initElement = companyTownInput;
        return this;
    }
    //endregion

    //region Actions
    public Action<InvoiceFormPage> foreignCompanyPrefixInput() {
        return new Action<>(foreignCompanyPrefixInput, this);
    }

    public Action<InvoiceFormPage> foreignCompanyPrefixValue() {
        return new Action<>(foreignCompanyPrefixValue, this);
    }

    public Action<InvoiceFormPage> foreignCompanyNip() {
        return new Action<>(foreignCompanyNip, this);
    }

    public Action<InvoiceFormPage> foreignCompanyName() {
        return new Action<>(foreignCompanyName, this);
    }

    public Action<InvoiceFormPage> foreignCompanyCountryInput() {
        return new Action<>(foreignCompanyCountryInput, this);
    }

    public Action<InvoiceFormPage> foreignCompanyCountryValue() {
        return new Action<>(foreignCompanyCountryValue, this);
    }

    public Action<InvoiceFormPage> foreignCompanyPostalCode() {
        return new Action<>(foreignCompanyPostalCode, this);
    }

    public Action<InvoiceFormPage> foreignCompanyTown() {
        return new Action<>(foreignCompanyTown, this);
    }

    public Action<InvoiceFormPage> foreignCompanyStreet() {
        return new Action<>(foreignCompanyStreet, this);
    }

    public Action<InvoiceFormPage> foreignCompanyBuildingNo() {
        return new Action<>(foreignCompanyBuildingNo, this);
    }

    public Action<InvoiceFormPage> foreignCompanyFlatNo() {
        return new Action<>(foreignCompanyFlatNo, this);
    }

    public Action<InvoiceFormPage> foreignCompanyEmail() {
        return new Action<>(foreignCompanyEmail, this);
    }

    public Action<InvoiceFormPage> individualName() {
        return new Action<>(individualName, this);
    }

    public Action<InvoiceFormPage> individualEmail() {
        return new Action<>(individualEmail, this);
    }

    public Action<InvoiceFormPage> individualTown() {
        return new Action<>(individualTown, this);
    }

    public Action<InvoiceFormPage> individualTownValue() {
        return new Action<>(individualTownValue, this);
    }

    public Action<InvoiceFormPage> individualStreet() {
        return new Action<>(individualStreet, this);
    }

    public Action<InvoiceFormPage> individualStreetValue() {
        return new Action<>(individualStreetValue, this);
    }

    public Action<InvoiceFormPage> individualBuildingNo() {
        return new Action<>(individualBuildingNo, this);
    }

    public Action<InvoiceFormPage> individualFlatNo() {
        return new Action<>(individualFlatNo, this);
    }

    public Action<InvoiceFormPage> companyNip() {
        return new Action<>(companyNip, this);
    }

    public Action<InvoiceFormPage> companyName() {
        return new Action<>(companyName, this);
    }

    public Action<InvoiceFormPage> companyPostalCode() {
        return new Action<>(companyPostalCode, this);
    }

    public Action<InvoiceFormPage> companyTownInput() {
        return new Action<>(companyTownInput, this);
    }

    public Action<InvoiceFormPage> companyTownValue() {
        return new Action<>(companyTownValue, this);
    }

    public Action<InvoiceFormPage> companyStreetInput() {
        return new Action<>(companyStreetInput, this);
    }

    public Action<InvoiceFormPage> companyStreetValue() {
        return new Action<>(companyStreetValue, this);
    }

    public Action<InvoiceFormPage> companyBuildingNo() {
        return new Action<>(companyBuildingNo, this);
    }

    public Action<InvoiceFormPage> companyFlatNo() {
        return new Action<>(companyFlatNo, this);
    }

    public Action<InvoiceFormPage> companyEmail() {
        return new Action<>(companyEmail, this);
    }
    //endregion

    @Override
    public WebElement getInitElement() {
        return null;
    }
}

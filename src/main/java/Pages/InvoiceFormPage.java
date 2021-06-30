package Pages;

import Helpers.Enums.Types.InvoiceType;
import Models.Invoice;
import Pages.Actions.Action;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class InvoiceFormPage extends BasePage{

    private boolean isOptionSelected;

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
    private WebElement foreignCompanyZipCode;
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
    @FindBy(name = "invoice.individual.zipCode")
    private WebElement individualZipCode;
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
    @FindBy(xpath = "//*[contains(@class, 'link-action')]")
    private WebElement copySenderData;
    //endregion

    //region Company WebElements
    @FindBy(how = How.NAME, using = "invoice.company.nip")
    private WebElement companyNip;
    @FindBy(how = How.NAME, using = "invoice.company.companyName")
    private WebElement companyName;
    @FindBy(how = How.NAME, using = "invoice.company.zipCode")
    private WebElement companyZipCode;
    @FindBy(how = How.XPATH, using = "//*[@name='invoice.company.town']//*/input")
    private WebElement companyTown;
    @FindBy(how = How.XPATH, using = "//*[@name='invoice.company.town']//*[@class='ng-value']")
    private WebElement companyTownValue;
    @FindBy(how = How.NAME, using = "//*[@name='invoice.company.street']//*/input")
    private WebElement companyStreet;
    @FindBy(how = How.XPATH, using = "//*[@name='invoice.company.street']//*[@class='ng-value']")
    private WebElement companyStreetValue;
    @FindBy(how = How.NAME, using = "invoice.company.buildingNo")
    private WebElement companyBuildingNo;
    @FindBy(how = How.NAME, using = "invoice.company.flatNo")
    private WebElement companyFlatNo;
    @FindBy(how = How.NAME, using = "invoice.company.email")
    private WebElement companyEmail;
    //endregion

    //region Errors

    @FindBy(xpath = "//*[@id='error-invoice.foreignCompany.name']/..//*[contains(@class, 'errors')]")
    private WebElement errorForeignCompanyName;
    @FindBy(xpath = "//*[@id='error-invoice.foreignCompany.email']/..//*[contains(@class, 'errors')]")
    private WebElement errorForeignCompanyEmail;
    @FindBy(xpath = "//*[@id='error-invoice.foreignCompany.zipCode']/..//*[contains(@class, 'errors')]")
    private WebElement errorForeignCompanyZipCode;
    @FindBy(xpath = "//*[@id='error-invoice.foreignCompany.nip']/..//*[contains(@class, 'errors')]")
    private WebElement errorForeignCompanyNip;
    @FindBy(xpath = "//*[@id='error-invoice.foreignCompany.buildingNo']/..//*[contains(@class, 'errors')]")
    private WebElement errorForeignCompanyBuildingNo;
    @FindBy(xpath = "//*[@id='error-invoice.foreignCompany.flatNo']/..//*[contains(@class, 'errors')]")
    private WebElement errorForeignCompanyFlatNo;
    @FindBy(xpath = "//*[@id='error-invoice.foreignCompany.street']/..//*[contains(@class, 'errors')]")
    private WebElement errorForeignCompanyStreet;
    @FindBy(xpath = "//*[@id='error-invoice.foreignCompany.town']/..//*[contains(@class, 'errors')]")
    private WebElement errorForeignCompanyTown;

    @FindBy(xpath = "//*[@id='error-invoice.company.name']/..//*[contains(@class, 'errors')]")
    private WebElement errorCompanyName;
    @FindBy(xpath = "//*[@id='error-invoice.company.email']/..//*[contains(@class, 'errors')]")
    private WebElement errorCompanyEmail;
    @FindBy(xpath = "//*[@id='error-invoice.company.zipCode']/..//*[contains(@class, 'errors')]")
    private WebElement errorCompanyZipCode;
    @FindBy(xpath = "//*[@id='error-invoice.company.nip']/..//*[contains(@class, 'errors')]")
    private WebElement errorCompanyNip;
    @FindBy(xpath = "//*[@id='error-invoice.company.buildingNo']/..//*[contains(@class, 'errors')]")
    private WebElement errorCompanyBuildingNo;
    @FindBy(xpath = "//*[@id='error-invoice.company.flatNo']/..//*[contains(@class, 'errors')]")
    private WebElement errorCompanyFlatNo;
    @FindBy(xpath = "//*[@id='error-invoice.company.street']/..//*[contains(@class, 'errors')]")
    private WebElement errorCompanyStreet;
    @FindBy(xpath = "//*[@id='error-invoice.company.town']/..//*[contains(@class, 'errors')]")
    private WebElement errorCompanyTown;

    @FindBy(xpath = "//*[@id='error-invoice.individual.name']/..//*[contains(@class, 'errors')]")
    private WebElement errorIndividualName;
    @FindBy(xpath = "//*[@id='error-invoice.individual.email']/..//*[contains(@class, 'errors')]")
    private WebElement errorIndividualEmail;
    @FindBy(xpath = "//*[@id='error-invoice.individual.zipCode']/..//*[contains(@class, 'errors')]")
    private WebElement errorIndividualZipCode;
    @FindBy(xpath = "//*[@id='error-invoice.individual.buildingNo']/..//*[contains(@class, 'errors')]")
    private WebElement errorIndividualBuildingNo;
    @FindBy(xpath = "//*[@id='error-invoice.individual.flatNo']/..//*[contains(@class, 'errors')]")
    private WebElement errorIndividualFlatNo;
    @FindBy(xpath = "//*[@id='error-invoice.individual.street']/..//*[contains(@class, 'errors')]")
    private WebElement errorIndividualStreet;
    @FindBy(xpath = "//*[@id='error-invoice.individual.town']/..//*[contains(@class, 'errors')]")
    private WebElement errorIndividualTown;
    //endregion

    private WebElement initElement;

    public InvoiceFormPage() {
        super();
        isOptionSelected = false;
    }


    //region Custom actions
    public InvoiceFormPage clickInvoiceForeignCompanyCheckbox(){
        getCommonHelper().moveAndClick(invoiceForeignCompanyCheckbox);
        initElement = foreignCompanyTown;
        isOptionSelected = true;
        return this;
    }

    public InvoiceFormPage clickInvoiceIndividualCheckbox(){
        getCommonHelper().moveAndClick(invoiceIndividualCheckbox);
        initElement = individualTown;
        isOptionSelected = true;
        return this;
    }

    public InvoiceFormPage clickInvoiceCompanyCheckbox(){
        getCommonHelper().moveAndClick(invoiceCompanyCheckbox);
        initElement = companyTown;
        isOptionSelected = true;
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

    public Action<InvoiceFormPage> foreignCompanyZipCode() {
        return new Action<>(foreignCompanyZipCode, this);
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

    public Action<InvoiceFormPage> individualZipCode() {
        return new Action<>(individualZipCode, this);
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

    public Action<InvoiceFormPage> companyZipCode() {
        return new Action<>(companyZipCode, this);
    }

    public Action<InvoiceFormPage> companyTown() {
        return new Action<>(companyTown, this);
    }

    public Action<InvoiceFormPage> companyTownValue() {
        return new Action<>(companyTownValue, this);
    }

    public Action<InvoiceFormPage> companyStreet() {
        return new Action<>(companyStreet, this);
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

    public Action<InvoiceFormPage> errorForeignCompanyName() {
        return new Action<>(errorForeignCompanyName, this);
    }

    public Action<InvoiceFormPage> errorForeignCompanyEmail() {
        return new Action<>(errorForeignCompanyEmail, this);
    }

    public Action<InvoiceFormPage> errorForeignCompanyZipCode() {
        return new Action<>(errorForeignCompanyZipCode, this);
    }

    public Action<InvoiceFormPage> errorForeignCompanyNip() {
        return new Action<>(errorForeignCompanyNip, this);
    }

    public Action<InvoiceFormPage> errorForeignCompanyBuildingNo() {
        return new Action<>(errorForeignCompanyBuildingNo, this);
    }

    public Action<InvoiceFormPage> errorForeignCompanyFlatNo() {
        return new Action<>(errorForeignCompanyFlatNo, this);
    }

    public Action<InvoiceFormPage> errorForeignCompanyStreet() {
        return new Action<>(errorForeignCompanyStreet, this);
    }

    public Action<InvoiceFormPage> errorForeignCompanyTown() {
        return new Action<>(errorForeignCompanyTown, this);
    }

    public Action<InvoiceFormPage> errorCompanyName() {
        return new Action<>(errorCompanyName, this);
    }

    public Action<InvoiceFormPage> errorCompanyEmail() {
        return new Action<>(errorCompanyEmail, this);
    }

    public Action<InvoiceFormPage> errorCompanyZipCode() {
        return new Action<>(errorCompanyZipCode, this);
    }

    public Action<InvoiceFormPage> errorCompanyNip() {
        return new Action<>(errorCompanyNip, this);
    }

    public Action<InvoiceFormPage> errorCompanyBuildingNo() {
        return new Action<>(errorCompanyBuildingNo, this);
    }

    public Action<InvoiceFormPage> errorCompanyFlatNo() {
        return new Action<>(errorCompanyFlatNo, this);
    }

    public Action<InvoiceFormPage> errorCompanyStreet() {
        return new Action<>(errorCompanyStreet, this);
    }

    public Action<InvoiceFormPage> errorCompanyTown() {
        return new Action<>(errorCompanyTown, this);
    }

    public Action<InvoiceFormPage> errorIndividualName() {
        return new Action<>(errorIndividualName, this);
    }

    public Action<InvoiceFormPage> errorIndividualEmail() {
        return new Action<>(errorIndividualEmail, this);
    }

    public Action<InvoiceFormPage> errorIndividualZipCode() {
        return new Action<>(errorIndividualZipCode, this);
    }

    public Action<InvoiceFormPage> errorIndividualBuildingNo() {
        return new Action<>(errorIndividualBuildingNo, this);
    }

    public Action<InvoiceFormPage> errorIndividualFlatNo() {
        return new Action<>(errorIndividualFlatNo, this);
    }

    public Action<InvoiceFormPage> errorIndividualStreet() {
        return new Action<>(errorIndividualStreet, this);
    }

    public Action<InvoiceFormPage> errorIndividualTown() {
        return new Action<>(errorIndividualTown, this);
    }

    public Action<InvoiceFormPage> copySenderData() {
        return new Action<>(copySenderData, this);
    }

    //endregion


    public void waitNipLoad() {
       getWaitHelper().waitUntilZeroElements(By.xpath("//*[contains(@class,'fixed-loader')]"));
    }

    @Override
    public WebElement getInitElement() {
        return null;
    }
}

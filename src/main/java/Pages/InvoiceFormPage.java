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

import javax.xml.xpath.XPath;

public class InvoiceFormPage extends BasePage{

    @FindBy(how = How.CSS, using = "[for=legalStatusforeignCompany]")
    private WebElement invoiceForeignCompanyCheckbox;
    @FindBy(how = How.CSS, using = "[for=legalStatusindividual]")
    private WebElement invoiceIndividualCheckbox;
    @FindBy(how = How.CSS, using = "[for=legalStatuscompany]")
    private WebElement invoicePolishCompanyCheckbox;

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

    public InvoiceFormPage() {
        super();
    }

    public InvoiceFormPage clickInvoiceForeignCompanyCheckbox(){
        getCommonHelper().moveAndClick(invoiceForeignCompanyCheckbox);
        return this;
    }

    //region Foreign company fill methods
    public InvoiceFormPage fillInvoiceForeignCompanyPrefix(String text) {
        getCommonHelper().writeAndConfirmDropdown(foreignCompanyPrefixInput, text);
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
        getCommonHelper().writeAndConfirmDropdown(foreignCompanyCountryInput, text);
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
        foreignCompanyBuildingNo.sendKeys(text);
        return this;
    }
    public InvoiceFormPage fillInvoiceForeignCompanyFlatNo(String text){
        foreignCompanyFlatNo.sendKeys(text);
        return this;
    }
    public InvoiceFormPage fillInvoiceForeignCompanyEmail(String text){
        foreignCompanyEmail.sendKeys(text);
        return this;
    }
    //endregion

    //region Foreign company value&text methods

    public String valueForeignCompanyNip() {
        return foreignCompanyNip.getAttribute("value");
    }

    public String valueForeignCompanyName() {
        return foreignCompanyName.getAttribute("value");
    }

    public String valueForeignCompanyPostalCode() {
        return foreignCompanyPostalCode.getAttribute("value");
    }

    public String valueForeignCompanyTown() {
        return foreignCompanyTown.getAttribute("value");
    }

    public String valueForeignCompanyStreet() {
        return foreignCompanyStreet.getAttribute("value");
    }

    public String valueForeignCompanyBuildingNo() {
        return foreignCompanyBuildingNo.getAttribute("value");
    }

    public String valueForeignCompanyFlatNo() {
        return foreignCompanyFlatNo.getAttribute("value");
    }

    public String valueForeignCompanyEmail() {
        return foreignCompanyEmail.getAttribute("value");
    }

    public String textForeignCompanyPrefixValue() {
        return foreignCompanyPrefixValue.getText();
    }

    public String textForeignCompanyCountryValue() {
        return foreignCompanyCountryValue.getText();
    }

    //endregion

    //region Private person fill methods

    public InvoiceFormPage fillIndividualName(String text) {
        individualName.sendKeys(text);
        return this;
    }

    public InvoiceFormPage fillIndividualEmail(String text) {
        individualEmail.sendKeys(text);
        return this;
    }

    public InvoiceFormPage fillIndividualBuildingNo(String text) {
        individualBuildingNo.sendKeys(text);
        return this;
    }

    public InvoiceFormPage fillIndividualFlatNo(String text) {
        individualFlatNo.sendKeys(text);
        return this;
    }

    public InvoiceFormPage fillIndividualTown(String text) {
        getCommonHelper().writeAndConfirmDropdown(individualTown, text);
        return this;
    }

    public InvoiceFormPage fillIndividualStreet(String text) {
        getCommonHelper().writeAndConfirmDropdown(individualStreet, text);
        return this;
    }
    //endregion

    //region Private person value&text methods
    public String valueIndividualName() {
        return individualName.getAttribute("value");
    }

    public String valueIndividualEmail() {
        return individualEmail.getAttribute("value");
    }

    public String valueIndividualBuildingNo() {
        return individualBuildingNo.getAttribute("value");
    }

    public String valueIndividualFlatNo() {
        return individualFlatNo.getAttribute("value");
    }

    public String textIndividualTownValue() {
        return individualTownValue.getText();
    }

    public String textIndividualStreetValue() {
        return individualStreetValue.getText();
    }
    //endregion

    //region Company fill methods
    public InvoiceFormPage fillInvoiceCompanyTown(String text) {
        getCommonHelper().writeAndConfirmDropdown(companyTownInput, text);
        return this;
    }
    public InvoiceFormPage fillInvoiceCompanyStreet(String text) {
        getCommonHelper().writeAndConfirmDropdown(companyStreetInput, text);
        return this;
    }
    public InvoiceFormPage fillCompanyNip(String text) {
        companyNip.sendKeys(text);
        return this;
    }

    public InvoiceFormPage fillCompanyName(String text) {
        companyName.sendKeys(text);
        return this;
    }

    public InvoiceFormPage fillCompanyPostalCode(String text) {
        companyPostalCode.sendKeys(text);
        return this;
    }

    public InvoiceFormPage fillCompanyBuildingNo(String text) {
        companyBuildingNo.sendKeys(text);
        return this;
    }

    public InvoiceFormPage fillCompanyFlatNo(String text) {
        companyFlatNo.sendKeys(text);
        return this;
    }

    public InvoiceFormPage fillCompanyEmail(String text) {
        companyEmail.sendKeys(text);
        return this;
    }
    //endregion

    //region Company value&text methods

    public String valueCompanyNip() {
        return companyNip.getAttribute("value");
    }

    public String valueCompanyName() {
        return companyName.getAttribute("value");
    }

    public String valueCompanyPostalCode() {
        return companyPostalCode.getAttribute("value");
    }

    public String valueCompanyBuildingNo() {
        return companyBuildingNo.getAttribute("value");
    }

    public String valueCompanyFlatNo() {
        return companyFlatNo.getAttribute("value");
    }

    public String valueCompanyEmail() {
        return companyEmail.getAttribute("value");
    }

    public String textCompanyTownValue() {
        return companyTownValue.getText();
    }

    public String textCompanyStreetValue() {
        return companyStreetValue.getText();
    }

    //endregion

}

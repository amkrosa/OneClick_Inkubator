import Helpers.WaitHelper;
import Pages.FormPage;
import SeleniumBase.Base;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormTest extends Base {
    private FormPage formPage = new FormPage();
    private WaitHelper waitHelper = new WaitHelper(new WebDriverWait(Base.driver, 3));


    @Test
    @DisplayName("Page loaded")
    public void pageloaded(){
        Assertions.assertDoesNotThrow(()->
                waitHelper.waitUntilClickable(By.cssSelector("#parcelFormButton"))
        );
    }

    @Nested
    @DisplayName("Delivery method")
    public class DeliveryMethodTest{

        @Test
        @DisplayName("Given page loaded correctly when data is correct then input is valid")
        public void Given_PageLoaded_When_DataIsCorrect_Then_InputIsValid(){
            formPage.clickBoxmachineDeliveryMethod();
        }
        @Test
        @DisplayName("Given page loaded correctly when data is correct then input is valid")
        public void Given2_PageLoaded_When_DataIsCorrect_Then_InputIsValid(){
            formPage.clickAddressDeliveryMethod();
        }
    }

}

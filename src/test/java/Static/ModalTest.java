package Static;

import Helpers.Enums.Statics.StaticText;
import Selenium.Base;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ModalTest {

    @Nested
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class HowToSendModalTest extends Base {

        @Test
        @Order(1)
        public void Should_DisplayHowToSendModal_When_ButtonClicked() {
            page.Form.howToSendButton().click();
            assertTrue(page.Form.isHowToSendModalVisible());
        }

        @Test
        @Order(2)
        public void Should_DisplayHowToSendText_When_ModalIsDisplayed() {
            assertTrue(page.Form.isTextFound(StaticText.MODAL_HOWTOSEND.current()));
        }
    }

    @Nested
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class HowToPackModalTest extends Base {

        @Test
        @Order(1)
        public void Should_DisplayHowToPackModal_When_ButtonClicked() {
            page.Form.howToPackButton().click();
            assertTrue(page.Form.isHowToPackModalVisible());
        }

        @Test
        @Order(2)
        public void Should_DisplayHowToPackNext_When_ModalIsDisplayed() {
            assertTrue(page.Form.isTextFound(StaticText.MODAL_HOWTOPACK.current()));
        }

    }

}

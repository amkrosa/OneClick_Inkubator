package Static;

import Selenium.Base;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class ImagesTest {

    @Nested
    public class ImagesFormPageTest extends Base {

        @Test
        public void Should_BannerBeDisplayed_When_PageIsLoaded() {
            page.Form.init();
            assertTrue(page.Form.isBannerImagesVisible(), "Banner is not visible");
        }

    }

}

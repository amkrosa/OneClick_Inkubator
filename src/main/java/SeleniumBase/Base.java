package SeleniumBase;

import Configs.Config;
import Configs.ConfigHandler;
import Configs.Environment;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;

import java.io.FileNotFoundException;
import java.io.ObjectInputFilter;
import java.util.Map;

public class Base {

    public static WebDriver driver;
    public static Environment environment;

    @BeforeAll
    public static void setUp() throws FileNotFoundException {
        ConfigHandler handler = ConfigHandler.getInstance();
        Config config = handler.getConfig();

        for(var entry : config.getEnvs().entrySet()){
            if (entry.getValue().isActive())
                environment = entry.getValue();
        }

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        LocalStorage local = ((WebStorage) driver).getLocalStorage();

        driver.get(environment.getUrl());
        local.setItem("sn_lang", config.getLanguage());
    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
}

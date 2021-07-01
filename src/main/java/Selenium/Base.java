package Selenium;

import Configs.Config;
import Configs.ConfigHandler;
import Configs.Environment;
import Configs.EnvironmentType;
import Helpers.FileHelper;
import Pages.Home.FormPage;
import Pages.Page;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class Base {

    public WebDriver driver;
    public Page page;
    public static Environment environment;
    public static Config config;
    public static final String downloadFolder = System.getProperty("user.dir")+
            File.separator+"src"+
            File.separator+"test"+
            File.separator+"resources"+
            File.separator+"Download";

    @BeforeAll
    public void setUp() throws FileNotFoundException {
        ConfigHandler handler = ConfigHandler.getInstance();
        config = handler.getConfig();

        for(var entry : config.getEnvs().entrySet()){
            if (entry.getValue().isActive())
                environment = entry.getValue();
        }

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadFolder);
        prefs.put("download.prompt_for_download", false);
        options.setExperimentalOption("prefs", prefs);
        this.driver = new ChromeDriver(options);
        LocalStorage local = ((WebStorage) driver).getLocalStorage();
        driver.manage().window().maximize();
        driver.get(environment.getUrl());
        local.setItem("sn_lang", config.getLanguage());

        page = new Page(this.driver);

        page.Form.init();
        if (!(Base.environment.getEnv() == EnvironmentType.PRODUCTION)) {
            page.Form.policyButton().click();
        }
        page.Form.cookieButton().click();
    }

    @AfterAll
    public void tearDown() throws IOException {
        driver.quit();
        final Path targetFolder = Path.of(Base.downloadFolder);
        if (Files.exists(targetFolder) && Files.isDirectory(targetFolder)) {
            new FileHelper().deleteFilesWithExtension("crdownload");
        }
    }
}

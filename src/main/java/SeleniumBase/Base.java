package SeleniumBase;

import Configs.Config;
import Configs.ConfigHandler;
import Configs.Environment;
import Configs.EnvironmentType;
import Helpers.ActionHelper;
import Helpers.CommonHelper;
import Helpers.WaitHelper;
import Pages.FormPage;
import Pages.Page;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputFilter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Base {

    public static WebDriver driver;
    public final Page page = new Page();
    public static Environment environment;
    public static Config config;
    public static final String downloadFolder = System.getProperty("user.dir")+
            File.separator+"src"+
            File.separator+"test"+
            File.separator+"resources"+
            File.separator+"Download";

    @BeforeAll
    public static void setUp() throws FileNotFoundException {
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
        driver = new ChromeDriver(options);
        LocalStorage local = ((WebStorage) driver).getLocalStorage();
        driver.manage().window().maximize();

        driver.get(environment.getUrl());
        local.setItem("sn_lang", config.getLanguage());
        FormPage formPage = new FormPage();
        formPage.init();
        if (!(Base.environment.getEnv() == EnvironmentType.PRODUCTION)) {
            formPage.policyButton().click();
        }
        formPage.cookieButton().click();
    }

    @AfterAll
    public static void tearDown() throws IOException {

        driver.quit();

        final Path targetFolder = Path.of(Base.downloadFolder);
        List<String> result;
        if (Files.exists(targetFolder) && Files.isDirectory(targetFolder)) {
            try (Stream<Path> walk = Files.walk(targetFolder)) {
                result = walk
                        .filter(p -> !Files.isDirectory(p))
                        .map(p -> p.toString().toLowerCase())
                        .filter(f -> f.endsWith("crdownload"))
                        .collect(Collectors.toList());
            }
            result.forEach(e -> {
                try {
                    Files.deleteIfExists(Path.of(e));
                } catch (IOException ignored) {
                }
            });
        }
    }
}

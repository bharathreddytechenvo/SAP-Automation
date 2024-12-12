package Tests;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class TestBase {

    protected WebDriver driver;

    public static class Config {
        public String browser;
        public String url;
        public int timeout;
        public String driver;
        public Options options;

        public static class Options {
            @JsonProperty("headless")
            public boolean headless;

            @JsonProperty("disable-extensions")
            public boolean disableExtensions;

            @JsonProperty("start-maximized")
            public boolean startMaximized;

            @JsonProperty("incognito")
            public boolean incognito;

            @JsonProperty("disable-gpu")
            public boolean disableGpu;

            @JsonProperty("no-sandbox")
            public boolean noSandbox;
        }
    }

    public void loadConfig() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Config config = objectMapper.readValue(new File("src\\main\\resources\\config.json"), Config.class);

        //String driverPath = config.driver != null ? config.driver : TestData.chromeDriverPath;
        System.setProperty("webdriver.chrome.driver", config.driver);

        /*ChromeOptions options = new ChromeOptions();
        if (!config.options.headless) options.addArguments("--headless");  // Ensure this is false
        if (config.options.disableExtensions) options.addArguments("--disable-extensions");
        if (config.options.startMaximized) options.addArguments("--start-maximized");
        if (config.options.incognito) options.addArguments("--incognito");
        if (config.options.disableGpu) options.addArguments("--disable-gpu");
        if (config.options.noSandbox) options.addArguments("--no-sandbox");*/
        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(config.url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            System.out.println("WebDriver instance has been terminated.");
        }
    }
}

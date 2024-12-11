package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Utils.TestData;

public class TestBase {

    protected WebDriver driver;

    public void LaunchApplication() {
        System.setProperty("webdriver.chrome.driver", TestData.chromeDriverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(TestData.url);
    }

    public WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is not initialized!");
        }
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

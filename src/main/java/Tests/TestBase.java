package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;

import Utils.TestData;

public class TestBase {

    protected WebDriver driver;
    
    public void launchApplication() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", TestData.chromeDriverPath);

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-gpu", "--window-size=1920x1080");
            driver = new ChromeDriver(options);

            System.out.println("Initializing ChromeDriver...");
            driver.manage().window().maximize();
            driver.get(TestData.url);

            System.out.println("Title of the page: " + driver.getTitle());
        } else {
            System.out.println("WebDriver is already initialized.");
        }
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
            System.out.println("WebDriver instance has been terminated.");
        }
    }
}

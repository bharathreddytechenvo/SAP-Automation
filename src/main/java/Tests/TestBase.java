package Tests;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import Base.BasePage;
import Pages.LoginPage;
import PagesConfiguration.PageObjectManager;
import Utils.TestData;
import Utils.Utilities;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.ExecutionException;

public class TestBase {

    protected WebDriver driver;
    protected BasePage basePage;
    private LoginPage loginPage;
    private PageObjectManager pageObjectManager;

    // Launch the application
    public void LaunchApplication() throws InterruptedException, TimeoutException, MalformedURLException, IOException, ExecutionException, AWTException {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", TestData.chromeDriverPath);
            System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
            System.setProperty("webdriver.chrome.verboseLogging", "true");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.get(TestData.url);
        }

        pageObjectManager = new PageObjectManager(driver);  // Ensure PageObjectManager is initialized after the driver
        loginPage = pageObjectManager.getLoginPage();
        loginPage.login();
    }

    public WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("Driver is not initialized. Please call LaunchApplication() first.");
        }
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}

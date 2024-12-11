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
    public void LaunchApp() throws InterruptedException, TimeoutException, MalformedURLException, IOException, ExecutionException, AWTException {
        System.setProperty("webdriver.chrome.driver", TestData.chromeDriverPath);
        //System.setProperty("webdriver.http.factory", "jdk-http-client");
       /*ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");*/

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(TestData.url);

        // Ensure PageObjectManager is initialized only after the driver is set
        pageObjectManager = new PageObjectManager(getDriver());

        // Ensure loginPage is initialized after PageObjectManager
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

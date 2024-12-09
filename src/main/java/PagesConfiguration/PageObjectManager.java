package PagesConfiguration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import Pages.AddNewEmployeePage;
import Pages.HomePage;
import Pages.LoginPage;
import Tests.TestBase;
import Utils.Utilities;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.ExecutionException;

public class PageObjectManager extends TestBase {

    private LoginPage loginPage;
    private HomePage homePage;
    private AddNewEmployeePage addNewEmployeePage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }
    
    public LoginPage getLoginPage()
            throws TimeoutException, MalformedURLException, InterruptedException, IOException, ExecutionException, AWTException {
        if (loginPage == null) {
            loginPage = new LoginPage(getDriver());
        }
        return loginPage;
    }
    
    public HomePage getHomePage()
            throws TimeoutException, MalformedURLException, InterruptedException, IOException, ExecutionException, AWTException {
        if (homePage == null) {
            homePage = new HomePage(getDriver());
        }
        return homePage;
    }
    
    public AddNewEmployeePage getAddNewEmployeePage()
            throws TimeoutException, MalformedURLException, InterruptedException, IOException, ExecutionException, AWTException {
        if (addNewEmployeePage == null) {
            addNewEmployeePage = new AddNewEmployeePage(getDriver());
        }
        return addNewEmployeePage;
    }
}

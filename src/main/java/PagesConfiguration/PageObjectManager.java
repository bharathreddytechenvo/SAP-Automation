package PagesConfiguration;

import org.openqa.selenium.WebDriver;
import Pages.AddNewEmployeePage;
import Pages.HomePage;
import Pages.LoginPage;

public class PageObjectManager {

    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private AddNewEmployeePage addNewEmployeePage;

    public PageObjectManager(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver instance is null!");
        }
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage(driver);
        }
        return homePage;
    }

    public AddNewEmployeePage getAddNewEmployeePage() {
        if (addNewEmployeePage == null) {
            addNewEmployeePage = new AddNewEmployeePage(driver);
        }
        return addNewEmployeePage;
    }
}

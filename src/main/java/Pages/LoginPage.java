package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utils.TestData;


public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver instance is null!");
        }
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "//input[@placeholder='Enter Company ID']")
    private WebElement companyId;

    @FindBy(xpath = "//bdi[text()='Continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//input[@id='j_username']")
    private WebElement userName;

    @FindBy(xpath = "//input[@id='j_password']")
    private WebElement passwordField;
    
    @FindBy(xpath = "//div[text()='Continue']")
    private WebElement signincontinueButton;

    public void login() {
        wait.until(ExpectedConditions.visibilityOf(companyId));

        companyId.clear();
        companyId.sendKeys(TestData.companyId);

        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();

        wait.until(ExpectedConditions.visibilityOf(userName));
        userName.clear();
        userName.sendKeys(TestData.userName);

        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.clear();
        passwordField.sendKeys(TestData.password);

        wait.until(ExpectedConditions.elementToBeClickable(signincontinueButton)).click();
    }
}

package SAP;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Listeners.TestListener;
import Pages.AddNewEmployeePage;
import Pages.HomePage;
import Pages.LoginPage;
import PagesConfiguration.PageObjectManager;
import Tests.TestBase;
import Utils.TestData;
import Utils.Utilities;


@Listeners(TestListener.class)
public class TC_01_VerifyEmployeeHireTest extends TestBase {
	
	private PageObjectManager pageObjectManager;
    private HomePage homePage;
    private LoginPage loginPage;
    private AddNewEmployeePage addNewEmployeePage;
    
    @BeforeMethod
    public void setup() throws Exception  {
    	loadConfig();
        pageObjectManager = new PageObjectManager(driver);
    }

    @Test
    public void VerifyEmployeeHireTest() throws Throwable {
        try {
            loginPage = pageObjectManager.getLoginPage();
            loginPage.login();
            homePage = pageObjectManager.getHomePage(); 
            homePage.searchForActionsOrPeople(TestData.addnewEmployee);
            addNewEmployeePage = pageObjectManager.getAddNewEmployeePage(); 
            addNewEmployeePage.selectCompanyFromDropdown("BestRun Germany", "BestRun Germany (1000)");
            addNewEmployeePage.selectEventReasonFromDropdown("New Hire (HIRNEW)");
            addNewEmployeePage.fillNameInformation(Utilities.generateRandomValue(8), Utilities.generateRandomValue(8), Utilities.generateRandomValue(8), "Mr.", "II");
            addNewEmployeePage.selectDateOfBirth(30, "India");
            addNewEmployeePage.fillEmployeeInformation(Utilities.generateIntegers(8), Utilities.generateRandomValue(8));
            addNewEmployeePage.clickNationalIdAddButton();
            addNewEmployeePage.SelectCountryNationalIdInformation("India");
            addNewEmployeePage.SelectNationalIdCardtype("Aadhar Number");
            addNewEmployeePage.fillNationalId(Utilities.generateIntegers(12));
            addNewEmployeePage.SelectIsPrimaryNationalIdInformation("Yes");
            addNewEmployeePage.clickContinueButton();
            addNewEmployeePage.SelectGenderPersonalInformation("Male");
            addNewEmployeePage.SelectMaritalStatusPersonalInformation("Married", "Married");
            addNewEmployeePage.SelectPreferedLanguagePersonalInformation("English (UK)", "English (UK)");
            addNewEmployeePage.fillPreferredName(Utilities.generateRandomValue(8));
            addNewEmployeePage.SelectNationalityInPersonalInformation("India", "India");
            addNewEmployeePage.selectCountryInGlobalInformation("India");
            addNewEmployeePage.selectDateLearnedInGlobalInformation();
            addNewEmployeePage.SelectChallengeGroupInGlobalInformation("Night-Shift - Challenged", "Night-Shift - Challenged");
            addNewEmployeePage.fillDegreeOfChallengeInGlobalInformation(Utilities.generateIntegers(1));
            addNewEmployeePage.selectTypeOfChallengeGlobalInformation("Unlimited Work Capability");
            addNewEmployeePage.fillIssuingAuthorityInGlobalInformation(Utilities.generateIntegers(3));
            addNewEmployeePage.fillReferenceNumberInGlobalInformation(Utilities.generateIntegers(9));
            addNewEmployeePage.SelectReligionInGlobalInformation("Hindu", "Hindu");
            addNewEmployeePage.fillNumberOfChilderInGlobalInformation(Utilities.generateIntegers(1));
            addNewEmployeePage.SelectOcupationalCodeInGlobalInformation("Engineers", "Engineers");
            addNewEmployeePage.fillNameOfFatherhusbandLegalGuarrdianInGlobalInformation(Utilities.generateRandomFatherName());
            addNewEmployeePage.SelectBloodGroupInGlobalInformation("O Positive", "O Positive");
            addNewEmployeePage.clickAddButtonInEmailInformation();
            addNewEmployeePage.selectEmailTypeInEmailInformation("Personal");
            addNewEmployeePage.fillEmailAddressInEmailInformation(Utilities.generateRandomGmail());
            addNewEmployeePage.selectIsPrimaryInEmailInformation("Yes");
            addNewEmployeePage.clickAddButtonInPhoneformation();
            addNewEmployeePage.selectPhoneTypeInPhoneInformation("Private Mobile", "Private Mobile");
            addNewEmployeePage.fillCountryCodeInPhoneInformation("+91");
            addNewEmployeePage.fillPhoneNumberInEmailInformation(Utilities.generatePhoneNumber());
            addNewEmployeePage.selectIsPrimaryInPhoneInformation("Yes");
            addNewEmployeePage.clickContinueButtonPersonalPhoneformation();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
    
    @AfterMethod
    public void tearDown() {
            quitDriver();
    }
}

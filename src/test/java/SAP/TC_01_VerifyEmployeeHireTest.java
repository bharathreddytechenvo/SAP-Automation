package SAP;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.ExecutionException;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.AddNewEmployeePage;
import Pages.HomePage;
import PagesConfiguration.PageObjectManager;
import Tests.TestBase;
import Utils.TestData;
import Utils.Utilities;

public class TC_01_VerifyEmployeeHireTest extends TestBase {
	
	private PageObjectManager pageObjectManager;
    private HomePage homePage;
    private AddNewEmployeePage addNewEmployeePage;
    
    
    @BeforeMethod
    public void LaunchApplication() throws TimeoutException, MalformedURLException, InterruptedException, IOException, ExecutionException, AWTException {
        super.LaunchApplication();
    }

    @Test
    public void VerifyEmployeeHireTest() {
        try {
        	Thread.sleep(5000);
			pageObjectManager = new PageObjectManager(getDriver());
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
            throw new AssertionError("Test Failed due to: " + e.getMessage());
        }
    }

    @AfterMethod
    public void CloseApplication() {
    	super.quitDriver();
    }
}

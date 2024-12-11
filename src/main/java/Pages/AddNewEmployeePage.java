package Pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AddNewEmployeePage  {
	
	private WebDriver driver;
    private WebDriverWait wait;
   

    public AddNewEmployeePage(WebDriver driver) {
    	if (driver == null) {
            throw new IllegalArgumentException("WebDriver instance is null!");
        }
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Add New Employee']")
    private WebElement addnewEmployee;
    
    @FindBy(xpath = "//input[@id='__input0-inner']")
    private WebElement FirstName;
    
    @FindBy(xpath = "//input[@id='__input1-inner']")
    private WebElement MiddleName;
    
    @FindBy(xpath = "//input[@id='__input2-inner']")
    private WebElement LastName;
    
    @FindBy(xpath = "(//span[text()='2'])[1]")
    private WebElement selectDate;
    
    @FindBy(xpath = "//input[@id='__input7-inner']")
    private WebElement personid;
    
    @FindBy(xpath = "//input[@id='__input8-inner']")
    private WebElement username;
    
    @FindBy(xpath = "//span[@id='__button16-content']")
    private WebElement nationalIdAddbutton;
    
    @FindBy(xpath = "//div[@class='sapUiVltCell sapuiVltCell']//div[@id='__panel0']//div[@id='__input11-content']//input[@id='__input11-inner']")
    private WebElement nationalIdInput;
  
    @FindBy(xpath = "//bdi[text()= 'Continue']")
    private WebElement continueButton;
    
    @FindBy(xpath = "//div[@class='sapUiVltCell sapuiVltCell']//div[@id='__input14']//input[@id='__input14-inner']")
    private WebElement preferredNameInput;
    
    @FindBy(xpath = "//div[@class='sapMInputBaseContentWrapper']//input[@id='__input36-inner']")
    private WebElement degreeOfChallenge;
    
    @FindBy(xpath = "//div[@id='__input35']//input[@id='__input35-inner']")
    private WebElement issuingAuthorityinput;
    
    @FindBy(xpath = "//div[@id='__input34']//input[@id='__input34-inner']")
    private WebElement referenceNumberinput;
    
    @FindBy(xpath = "//div[@id='__input33']//input[@id='__input33-inner']")
    private WebElement numberOfChildreninput;
    
    @FindBy(xpath = "//div[@id='__input32']//input[@id='__input32-inner']")
    private WebElement nameOfFatherHusbandlegalGuradianinput;
    
    @FindBy(xpath = "//span[@id='__button40-content']//bdi[text()='Add']")
    private WebElement addButtonInEmailInformation;
    
    @FindBy(xpath = "//div[@id='__input37']//input[@id='__input37-inner']")
    private WebElement EmailAddressinput;
 
    @FindBy(xpath = "//span[@id='__button41-content']//bdi[text()='Add']")
    private WebElement addButtonInPhoneInformation;
    
    @FindBy(xpath = "//div[@id='__input40']//input[@id='__input40-inner']")
    private WebElement CountryCodeinput;
    
    @FindBy(xpath = "//div[@id='__input42']//input[@id='__input42-inner']")
    private WebElement PhoneNumberinput;
    
    @FindBy(xpath = "//span[@id='__button38-content']//bdi[text()= 'Continue']")
    private WebElement continueButtonPersonalInformation;
  
    
    public void selectFromDropdown(String inputValue, String inputFieldIdentifier, String itemToSelect, String itemIdentifierTemplate) {
        try {
        	Thread.sleep(5000);
            WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(inputFieldIdentifier)));
            inputField.clear();
            inputField.sendKeys(inputValue);
            String dropdownOptionXpath = itemIdentifierTemplate.replace("{item}", itemToSelect);
            WebElement dropdownOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dropdownOptionXpath)));
            dropdownOption.click();
        } catch (Exception e) {
            System.err.println("Error interacting with the dropdown: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void selectDropdownOption(String dropdownXpath, String listContainerXpath, String optionToSelect) {
        try {
        	Thread.sleep(5000);
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dropdownXpath)));
            dropdown.click();
            WebElement dropdownListContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(listContainerXpath)));
            List<WebElement> dropdownItems = dropdownListContainer.findElements(By.tagName("li"));
            boolean optionFound = false;
            for (WebElement item : dropdownItems) {
                String itemText = item.getText().trim();
                System.out.println("Dropdown item: " + itemText);
                if (itemText.equals(optionToSelect)) {
                    Thread.sleep(5000);  // Optional, ensure the dropdown items are loaded before clicking
                    wait.until(ExpectedConditions.elementToBeClickable(item)).click(); 
                    optionFound = true;
                    break;
                }
            }
            if (!optionFound) {
                throw new NoSuchElementException("Option '" + optionToSelect + "' not found in dropdown.");
            }
        } catch (Exception e) {
            System.err.println("Error selecting dropdown option: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static void switchToNewWindowAndPerformActions(WebDriver driver) {
        Set<String> windowHandles = driver.getWindowHandles();
        String originalWindow = driver.getWindowHandle(); // Store the original window handle
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        System.out.println("Title of the new page: " + driver.getTitle());
    }
    
    public void selectCompanyFromDropdown(String EventReasonNameinput, String EventReasonName) throws InterruptedException {
    Thread.sleep(10000);
    switchToNewWindowAndPerformActions(driver);
    wait.until(ExpectedConditions.visibilityOf(addnewEmployee));
    String EventReasonInputXpath = "//div[@id='__grid0-wrapperfor-__layout11']//div[@class='sapMInputBaseContentWrapper']//input[@id='__box0-inner']";
    String EventReasonListXpathTemplate = "//div[text()='{item}']"; 
    selectFromDropdown(EventReasonNameinput, EventReasonInputXpath, EventReasonName, EventReasonListXpathTemplate);
    }
    
    public void selectEventReasonFromDropdown(String EventReasonName) throws InterruptedException {
        try {
        	Thread.sleep(5000);
            WebElement EventReasonDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sapUiVltCell sapuiVltCell']//div[@id='__box1-content']//div[@class='sapMInputBaseIconContainer']")));
            EventReasonDropdown.click();
            String EventReasonNameXPath = "//div[text()='" + EventReasonName + "']";
            WebElement selectEventReasonName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EventReasonNameXPath)));
            selectEventReasonName.click();
        } catch (Exception e) {
            System.out.println("Error interacting with the dropdown: " + e.getMessage());
        }
    }
    
    public void fillNameInformation(String firstname, String middlename, String lastName, String salutationValue, String suffixValue) {
        try {
        	Thread.sleep(5000);
            Actions actions = new Actions(driver);
            FirstName.clear();
            actions.moveToElement(FirstName).click().sendKeys(firstname).perform();
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            Thread.sleep(10000);
            
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            Thread.sleep(10000);
            
            String textToType = middlename;
            
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_A);
            robot.keyRelease(KeyEvent.VK_A);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_BACK_SPACE);
            robot.keyRelease(KeyEvent.VK_BACK_SPACE);
            
            for (char c : textToType.toCharArray()) {
                robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
                robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
                Thread.sleep(100);  
            }
            LastName.clear();
            actions.moveToElement(LastName).click().sendKeys(lastName).perform();
            WebElement salutation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sapUiVltCell sapuiVltCell']//div[@id='__box2']//div[@class='sapMInputBaseIconContainer']")));
            salutation.click();
            String salutationValueXPath = "//div[text()='" + salutationValue + "']";
            WebElement salutationvalueselect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(salutationValueXPath)));
            salutationvalueselect.click();
            WebElement suffix = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sapUiVltCell sapuiVltCell']//div[@id='__box3']//div[@class='sapMInputBaseIconContainer']")));
            suffix.click();
            String suffixValueXPath = "//div[text()='" + suffixValue + "']";
            WebElement suffixValueselect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(suffixValueXPath)));
            suffixValueselect.click();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void selectDateOfBirth(int yearsAgo, String CountryOfBirth) {
        try {
        	Thread.sleep(5000);
            WebElement dobIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='__picker1-icon']")));
            dobIcon.click();
            Thread.sleep(3000);
            WebElement yearPickerButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='__picker1-cal--Head-B2']")));
            yearPickerButton.click();
            Thread.sleep(3000);
            int currentYear = LocalDate.now().getYear();
            int targetYear = currentYear - yearsAgo;

            while (true) {
                try {
                	Thread.sleep(3000);
                    WebElement yearElement = driver.findElement(By.xpath("//div[@aria-label='" + targetYear + "']"));
                    if (yearElement.isDisplayed()) {
                        yearElement.click(); 
                        break; 
                    }
                } catch (Exception e) {
                	Thread.sleep(3000);
                    WebElement prevButton = driver.findElement(By.xpath("//button[@id='__picker1-cal--Head-prev']"));
                    prevButton.click();
                    Thread.sleep(500); 
                }
            }
            
            Thread.sleep(3000);
            WebElement selectdate = wait.until(ExpectedConditions.visibilityOf(selectDate));
            selectdate.click();
            
            Thread.sleep(5000);
            WebElement countryofBirthdropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='sapUiVltCell sapuiVltCell']//div[@class=\"sapMInputBaseIconContainer\"]/span[@id='__box4-arrow']")));
            countryofBirthdropdown.click();
            String countryofBirthXPath = "//span[text()='" + CountryOfBirth + "']";
            WebElement countryOfBirthselect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(countryofBirthXPath)));
            countryOfBirthselect.click();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to select the date of birth: " + e.getMessage(), e);
        }
    }

    public void fillEmployeeInformation(String personId, String userName) {
        try {
        	Thread.sleep(5000);
        	wait.until(ExpectedConditions.visibilityOf(personid));
        	Actions actions = new Actions(driver);
        	personid.clear();
        	actions.moveToElement(personid).click().sendKeys(personId).perform();

        	wait.until(ExpectedConditions.visibilityOf(username));
        	username.clear();
        	actions.moveToElement(username).click().sendKeys(userName).perform();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void clickNationalIdAddButton() {
        try {
        	Thread.sleep(5000);
        	WebElement addButton = wait.until(ExpectedConditions.visibilityOf(nationalIdAddbutton));
        	addButton.click();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void SelectCountryNationalIdInformation(String country) {
    	String selectCountrydropdown = "//div[@class='sapUiVltCell sapuiVltCell']//div[@id='__box5']//div[@id='__box5-content']//div[@class='sapMInputBaseIconContainer']";
        String selectCountrydropdownList = "//ul[@id='__box5-popup-list-listUl']";
        selectDropdownOption(selectCountrydropdown, selectCountrydropdownList, country);
    }

    
    public void SelectNationalIdCardtype(String NationalIdCardType) {
    	String selectNationalIdDropdown = "//div[@class='sapUiVltCell sapuiVltCell']//div[@id='__box6']//div[@class='sapMInputBaseIconContainer']";
        String selectNationalIdDropdownList = "//ul[@id='__box6-popup-list-listUl']";
        selectDropdownOption(selectNationalIdDropdown, selectNationalIdDropdownList, NationalIdCardType);
    }
    
    public void fillNationalId(String NationalId) {
        try {
        	Thread.sleep(5000);
        	WebElement nationalId = wait.until(ExpectedConditions.visibilityOf(nationalIdInput));
        	nationalId.clear();
        	nationalId.sendKeys(NationalId);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void SelectIsPrimaryNationalIdInformation(String isPrimary) {
        	String selectIsPrimarydropdown = "//div[@class='sapUiVltCell sapuiVltCell']//div[@id='__box7']//div[@id='__box7-content']//div[@class='sapMInputBaseIconContainer']";
            String selectIsPriimarydropdownList = "//ul[@id='__box7-popup-list-listUl']";
            selectDropdownOption(selectIsPrimarydropdown, selectIsPriimarydropdownList, isPrimary);
        }
    
    public void clickContinueButton() {
        try {
        	Thread.sleep(5000);
        	WebElement nationalId = wait.until(ExpectedConditions.visibilityOf(continueButton));
        	nationalId.click();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void SelectGenderPersonalInformation(String gender) {
    	String selectGenderdropdown = "//div[@class='sapUiVltCell sapuiVltCell']//div[@id='__box8']//div[@class='sapMInputBaseIconContainer']";
        String selectGenderdropdownList = "//ul[@id='__box8-popup-list-listUl']";
        selectDropdownOption(selectGenderdropdown, selectGenderdropdownList, gender);
    }
    
    public void SelectMaritalStatusPersonalInformation(String maritalStatusinput, String maritalStatus) throws InterruptedException {
        String MaritalStatusinput = "//div[@id='__grid4-wrapperfor-__layout55']//div[@class='sapMInputBaseContentWrapper']//input[@id='__box9-inner']";
        String MaritalStatusSelect = "//div[text()='{item}']"; 
        selectFromDropdown(maritalStatusinput, MaritalStatusinput, maritalStatus, MaritalStatusSelect);
        }
    
    public void SelectPreferedLanguagePersonalInformation(String preferredLanguageinput, String preferredLanguageStatus) throws InterruptedException {
        String preferredlanguageinput = "//div[@id='__grid4-wrapperfor-__layout56']//div[@class='sapMInputBaseContentWrapper']//input[@id='__box10-inner']";
        String preferredLanguageSelect = "//div[text()='{item}']"; 
        selectFromDropdown(preferredLanguageinput, preferredlanguageinput, preferredLanguageStatus, preferredLanguageSelect);
        }
    
    public void fillPreferredName(String PreferredName) {
        try {
        	Thread.sleep(5000);
        	WebElement preferredname = wait.until(ExpectedConditions.visibilityOf(preferredNameInput));
        	preferredname.clear();
        	preferredname.sendKeys(PreferredName);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void SelectNationalityInPersonalInformation(String Nationalityinput, String Nationality) throws InterruptedException { 
        String NationalityInput = "//div[@id='__grid4-wrapperfor-__layout58']//div[@class='sapMInputBaseContentWrapper']//input[@id='__box11-inner']";
        String NationalityinputList = "//div[text()='{item}']"; 
        selectFromDropdown(Nationalityinput, NationalityInput, Nationality, NationalityinputList);
        }
    
    public void selectCountryInGlobalInformation(String countryName) {
        String countrydropdownXpath = "//div[@class='sapUiVltCell sapuiVltCell']//div[@id='__panel0']/following::span[@id='__box12-arrow']";
        String countrylistContainerXpath = "//div[@id='__box12-popup-list']";
        selectDropdownOption(countrydropdownXpath, countrylistContainerXpath, countryName);
    }

    public void selectDateLearnedInGlobalInformation() {
        try {
            LocalDate today = LocalDate.now();
            LocalDate tomorrow = today.plusDays(1);
            int tomorrowDay = tomorrow.getDayOfMonth();
            WebElement datePicker = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='__picker4-content']//div[@class='sapMInputBaseIconContainer']")));
            datePicker.click();
            String tomorrowXPath = "(//div[@id='__picker4-cal-content']//div[@id='__picker4-cal--Month0']//div//span[text()='" + tomorrowDay + "'])[1]";
            WebElement tomorrowDateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(tomorrowXPath)));
            tomorrowDateElement.click();
        } catch (Exception e) {
            System.out.println("Error selecting tomorrow's date: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void SelectChallengeGroupInGlobalInformation(String Challengeinput, String Challenge) throws InterruptedException { 
        String ChallengeInputxpath = "//div[@class='sapUiVltCell sapuiVltCell']//input[@id='__box25-inner']";
        String ChallengeinputList = "//div[text()='{item}']"; 
        selectFromDropdown(Challengeinput, ChallengeInputxpath, Challenge, ChallengeinputList);
        }

    public void fillDegreeOfChallengeInGlobalInformation(String DegreeOfChallenge) {
        try {
        	Thread.sleep(5000);
        	WebElement degreeofchallenge= wait.until(ExpectedConditions.visibilityOf(degreeOfChallenge));
        	degreeofchallenge.clear();
        	degreeofchallenge.sendKeys(DegreeOfChallenge);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void selectTypeOfChallengeGlobalInformation(String typeofchallenege) throws InterruptedException {
        try {
        	Thread.sleep(20000);
            WebElement typeofChallenegeDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='__box24']//div[@class='sapMInputBaseIconContainer']")));
            typeofChallenegeDropdown.click();
            String TypeOfChallenegeXPath = "//div[text()='" + typeofchallenege + "']";
            WebElement selectTypeOfChallenege = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(TypeOfChallenegeXPath)));
            selectTypeOfChallenege.click();
        } catch (Exception e) {
            System.out.println("Error interacting with the dropdown: " + e.getMessage());
        }
    }
    
    public void fillIssuingAuthorityInGlobalInformation(String IssuingAuthority) {
        try {
        	Thread.sleep(5000);
        	WebElement issuingauthority= wait.until(ExpectedConditions.visibilityOf(issuingAuthorityinput));
        	issuingauthority.clear();
        	issuingauthority.sendKeys(IssuingAuthority);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void fillReferenceNumberInGlobalInformation(String ReferenceNumber) {
        try {
        	Thread.sleep(5000);
        	WebElement Referencenumber= wait.until(ExpectedConditions.visibilityOf(referenceNumberinput));
        	Referencenumber.clear();
        	Referencenumber.sendKeys(ReferenceNumber);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void SelectReligionInGlobalInformation(String Religioninput, String Religion) throws InterruptedException { 
        String ReligionInputxpath = "//div[@id='__box23']//input[@id='__box23-inner']";
        String ReligioninputList = "//div[text()='{item}']"; 
        selectFromDropdown(Religioninput, ReligionInputxpath, Religion, ReligioninputList);
        }
    
    public void fillNumberOfChilderInGlobalInformation(String numberOfChildren) {
        try {
        	Thread.sleep(5000);
        	WebElement numberofChildren= wait.until(ExpectedConditions.visibilityOf(numberOfChildreninput));
        	numberofChildren.clear();
        	numberofChildren.sendKeys(numberOfChildren);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void SelectOcupationalCodeInGlobalInformation(String OcupationalCodeinput, String OcupationalCode) throws InterruptedException { 
        String OcupationalCodeInputxpath = "//div[@id='__box22']//div[@id='__box22-content']//input[@id='__box22-inner']";
        String OcupationalCodeinputList = "//div[text()='{item}']"; 
        selectFromDropdown(OcupationalCodeinput, OcupationalCodeInputxpath, OcupationalCode, OcupationalCodeinputList);
        }
    
    public void fillNameOfFatherhusbandLegalGuarrdianInGlobalInformation(String nameoffatherhusbandlegalguarrdian) {
        try {
        	Thread.sleep(5000);
        	WebElement NameOfFatherHusbandLegalGuarrdian= wait.until(ExpectedConditions.visibilityOf(nameOfFatherHusbandlegalGuradianinput));
        	NameOfFatherHusbandLegalGuarrdian.clear();
        	NameOfFatherHusbandLegalGuarrdian.sendKeys(nameoffatherhusbandlegalguarrdian);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void SelectBloodGroupInGlobalInformation(String BloodGroupinput, String BloodGroup) throws InterruptedException { 
        String BloodGroupInputxpath = "//div[@id='__box21']//div[@id='__box21-content']//input[@id='__box21-inner']";
        String BloodGroupinputList = "//div[text()='{item}']"; 
        selectFromDropdown(BloodGroupinput, BloodGroupInputxpath, BloodGroup, BloodGroupinputList);
        }
    
    public void clickAddButtonInEmailInformation() {
        try {
        	wait.until(ExpectedConditions.visibilityOf(addButtonInEmailInformation));
        	Actions actions = new Actions(driver);
        	actions.moveToElement(addButtonInEmailInformation).click().perform();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void selectEmailTypeInEmailInformation(String EmailType) {
        String emailTypedropdownXpath = "//div[@id='__box26-content']//div[@class='sapMInputBaseIconContainer']";
        String emailTypelistContainerXpath = "//ul[@id='__box26-popup-list-listUl']";
        selectDropdownOption(emailTypedropdownXpath, emailTypelistContainerXpath, EmailType);
    }
    
    public void fillEmailAddressInEmailInformation(String emailAddress) {
        try {
        	Thread.sleep(5000);
        	WebElement EmailAddress= wait.until(ExpectedConditions.visibilityOf(EmailAddressinput));
        	EmailAddress.clear();
        	EmailAddress.sendKeys(emailAddress);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void selectIsPrimaryInEmailInformation(String IsPrimary) {
        String isPrimarydropdownXpath = "//div[@id='__box27-content']//div[@class='sapMInputBaseIconContainer']";
        String isPrimarylistContainerXpath = "//ul[@id='__box27-popup-list-listUl']";
        selectDropdownOption(isPrimarydropdownXpath, isPrimarylistContainerXpath, IsPrimary);
    }
    
    public void clickAddButtonInPhoneformation() {
        try {
        	wait.until(ExpectedConditions.visibilityOf(addButtonInPhoneInformation));
        	Actions actions = new Actions(driver);
        	actions.moveToElement(addButtonInPhoneInformation).click().perform();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void selectPhoneTypeInPhoneInformation(String PhoneTypeinput, String PhoneType) throws InterruptedException { 
        String PhoneTypeInputxpath = "//div[@id='__box28']//div[@id='__box28-content']//input[@id='__box28-inner']";
        String PhoneTypeinputList = "//div[text()='{item}']"; 
        selectFromDropdown(PhoneTypeinput, PhoneTypeInputxpath, PhoneType, PhoneTypeinputList);
        }
    
    public void fillCountryCodeInPhoneInformation(String countryCode) {
        try {
        	Thread.sleep(5000);
        	WebElement CountryCode= wait.until(ExpectedConditions.visibilityOf(CountryCodeinput));
        	CountryCode.clear();
        	CountryCode.sendKeys(countryCode);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void fillPhoneNumberInEmailInformation(String PhoneNumber) {
        try {
        	Thread.sleep(5000);
        	WebElement phoneNumber= wait.until(ExpectedConditions.visibilityOf(PhoneNumberinput));
        	phoneNumber.clear();
        	phoneNumber.sendKeys(PhoneNumber);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void selectIsPrimaryInPhoneInformation(String IsPrimary) {
        String isPrimarydropdownXpath = "//div[@id='__box29-content']//div[@class='sapMInputBaseIconContainer']";
        String isPrimarylistContainerXpath = "//ul[@id='__box29-popup-list-listUl']";
        selectDropdownOption(isPrimarydropdownXpath, isPrimarylistContainerXpath, IsPrimary);
    }
    
    public void clickContinueButtonPersonalPhoneformation() {
        try {
        	wait.until(ExpectedConditions.visibilityOf(continueButtonPersonalInformation));
        	Actions actions = new Actions(driver);
        	actions.moveToElement(continueButtonPersonalInformation).click().perform();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    
}  
    
    
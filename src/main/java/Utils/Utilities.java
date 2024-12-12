package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class Utilities {

    private WebDriverWait wait;

    public Utilities(WebDriver driver) {
    	   this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int MAX_NAME_LENGTH = 10;
    private static final int MAX_NUMBER = 9999;   

    public static String generateRandomValue(int length) {
        String lowercaseCharacters = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuilder randomText = new StringBuilder();
        if (length > 0) {
            int firstLetterIndex = random.nextInt(uppercaseCharacters.length());
            randomText.append(uppercaseCharacters.charAt(firstLetterIndex));
        }
        for (int i = 1; i < length; i++) {
            int index = random.nextInt(lowercaseCharacters.length());
            randomText.append(lowercaseCharacters.charAt(index));
        }
        return randomText.toString();
    }

    public static String generateIntegers(int length) {
        Random random = new Random();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomInt = random.nextInt(10);
            result.append(randomInt);
        }
        return result.toString();
    }

    public static String generateRandomFatherName() {
        String surname = generateRandomString(6, 10);   
        String firstName = generateRandomString(4, 8); 
        String middleName = generateRandomString(5, 9); 
        return surname + " " + firstName + " " + middleName;
    }

    private static String generateRandomString(int minLength, int maxLength) {
        Random random = new Random();
        int length = random.nextInt(maxLength - minLength + 1) + minLength; 
        StringBuilder randomString = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            randomString.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }
        return randomString.toString();
    }

    public static String generateRandomGmail() {
        String namePart = generateRandomString(6, MAX_NAME_LENGTH); 
        int numberPart = generateRandomNumber(1000, MAX_NUMBER);   
        return namePart + numberPart + "@gmail.com";
    }

    private static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
    
    public static String generatePhoneNumber() {
        Random random = new Random();
        StringBuilder phoneNumber = new StringBuilder("9");
        for (int i = 0; i < 9; i++) {
            int digit = random.nextInt(10); 
            phoneNumber.append(digit);
        }
        return phoneNumber.toString();
    }

}

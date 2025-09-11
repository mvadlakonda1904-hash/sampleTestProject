package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        int expWait = Integer.parseInt(System.getProperty("explicitWait", "15"));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(expWait));
    }

    // Locators
    private By genderMale = By.id("gender-male");
    private By genderFemale = By.id("gender-female");
    private By firstName = By.id("FirstName");
    private By lastName = By.id("LastName");
    private By email = By.id("Email");
    private By password = By.id("Password");
    private By confirmPassword = By.id("ConfirmPassword");
    private By registerButton = By.id("register-button");
    private By successMessage = By.cssSelector(".result");

    // Actions
    public void open() {
        driver.get(System.getProperty("baseUrl", "https://demowebshop.tricentis.com") + "/register");
    }

    public void selectGender(String gender) {
        if ("Male".equalsIgnoreCase(gender)) {
            wait.until(ExpectedConditions.elementToBeClickable(genderMale)).click();
        } else {
            wait.until(ExpectedConditions.elementToBeClickable(genderFemale)).click();
        }
    }

    public void enterFirstName(String fname) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).clear();
        driver.findElement(firstName).sendKeys(fname);
    }

    public void enterLastName(String lname) {
        driver.findElement(lastName).clear();
        driver.findElement(lastName).sendKeys(lname);
    }

    public void enterEmail(String mail) {
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(mail);
    }

    public void enterPassword(String pwd) {
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pwd);
    }

    public void enterConfirmPassword(String cpwd) {
        driver.findElement(confirmPassword).clear();
        driver.findElement(confirmPassword).sendKeys(cpwd);
    }

    public void clickRegister() {
        driver.findElement(registerButton).click();
    }

    public String getSuccessMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).getText();
    }

}

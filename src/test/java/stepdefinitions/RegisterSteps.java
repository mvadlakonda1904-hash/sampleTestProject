package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pages.RegisterPage;
import utilities.DriverFactory;
import utilities.TestUtils;

public class RegisterSteps {
	
	private RegisterPage registerPage;
    private WebDriver driver;

    @Given("I am on the registration page")
    public void i_am_on_the_registration_page() {
        driver = DriverFactory.getDriver();
        
        System.setProperty("baseUrl", System.getProperty("baseUrl", utilities.ConfigReader.get("baseUrl")));
        registerPage = new RegisterPage(driver);
        registerPage.open();
    }

    @When("I select {string} as gender")
    public void i_select_as_gender(String gender) {
        registerPage.selectGender(gender);
    }

    @When("I enter {string} as first name")
    public void i_enter_as_first_name(String firstName) {
        registerPage.enterFirstName(firstName);
    }

    @When("I enter {string} as last name")
    public void i_enter_as_last_name(String lastName) {
        registerPage.enterLastName(lastName);
    }

    @When("I enter {string} as email")
    public void i_enter_as_email(String email) {
        // optionally generate unique email to avoid duplicates
        String unique = TestUtils.uniqueEmail(email);
        registerPage.enterEmail(unique);
    }

    @When("I enter {string} as password")
    public void i_enter_as_password(String password) {
        registerPage.enterPassword(password);
    }

    @When("I enter {string} as confirm password")
    public void i_enter_as_confirm_password(String confirmPassword) {
        registerPage.enterConfirmPassword(confirmPassword);
    }

    @When("I click the Register button")
    public void i_click_the_register_button() {
        registerPage.clickRegister();
    }

    @Then("I should see the registration confirmation message")
    public void i_should_see_the_registration_confirmation_message() {
        String message = registerPage.getSuccessMessage();
        Assert.assertTrue(message.contains("Your registration completed"),
                "Expected registration success message but found: " + message);
    }
	
}

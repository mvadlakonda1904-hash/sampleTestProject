package stepdefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.ConfigReader;
import utilities.DriverFactory;

public class Hooks {
	@Before
    public void setUp() {
       
        System.setProperty("baseUrl", ConfigReader.get("baseUrl"));
        System.setProperty("explicitWait", ConfigReader.get("explicitWait"));
        DriverFactory.initDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "failed-screenshot");
            }
        } catch (Exception e) {
            
        } finally {
            DriverFactory.quitDriver();
        }
    }
}

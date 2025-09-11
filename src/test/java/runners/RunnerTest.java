package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/resources/Features",
	    glue = {"stepdefinitions"},
	    plugin = {
	        "pretty",
	        "html:target/cucumber-reports/cucumber.html",
	        "json:target/cucumber-reports/cucumber.json"
	    },
	    monochrome = true
	)
public class RunnerTest extends AbstractTestNGCucumberTests {
	
	
}

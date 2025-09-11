package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	private static final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static void initDriver() {
        String browser = ConfigReader.get("browser");
        if (browser == null) browser = "chrome";

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            if (Boolean.parseBoolean(ConfigReader.get("headless"))) {
                options.addArguments("--headless=new"); // modern headless for Chrome
            }
            options.addArguments("--window-size=1920,1080");
            tlDriver.set(new ChromeDriver(options));
        } else {
            throw new RuntimeException("Browser not supported: " + browser);
        }
        getDriver().manage().deleteAllCookies();
    }

    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    public static void quitDriver() {
        WebDriver driver = tlDriver.get();
        if (driver != null) {
            driver.quit();
            tlDriver.remove();
        }
    }

}

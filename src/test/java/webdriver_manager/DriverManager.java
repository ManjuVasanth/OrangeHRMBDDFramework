package webdriver_manager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import step_definitions.Common_Step_Definition;
import constants.Constants;

public class DriverManager {
	private static final Logger LOGGER = LogManager.getLogger(DriverManager.class);
	private static WebDriver driver = null;

	public static void launchBrowser() {

		try {
			switch (Constants.BROWSER) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				LOGGER.info("Launching" + Constants.BROWSER);
				driver = new ChromeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				LOGGER.info("Launching" + Constants.BROWSER);
				driver = new FirefoxDriver();
				break;
			case "ie":

				WebDriverManager.iedriver().setup();
				LOGGER.info("Launching" + Constants.BROWSER);
				driver = new InternetExplorerDriver();
				break;
			default:
				WebDriverManager.chromedriver().setup();
				LOGGER.info("Launching" + Constants.BROWSER);
				driver = new ChromeDriver();
				break;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static WebDriver getDriver() {
		return driver;
	}

}

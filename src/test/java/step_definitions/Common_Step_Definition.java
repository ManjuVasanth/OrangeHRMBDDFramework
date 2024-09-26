package step_definitions;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import constants.Constants;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import page_objects.LoginPage;
import utilities.CommonUtils;
import webdriver_manager.DriverManager;

public class Common_Step_Definition {

	private static String scenarioName = null;
	
	
	public static String getScenarioName() {
		return scenarioName;
	}
	private static final Logger LOGGER = LogManager.getLogger(Common_Step_Definition.class);
	
	@Before
	public void beforeScenario(Scenario scenario) {
		LOGGER.info("Execution started");
		
		try {
			scenarioName = scenario.getName();
			LOGGER.info("Instantiating the CommonUtils");
			
			LOGGER.info("Loading the properties file");
			CommonUtils.getInstance().loadProperties();
			LOGGER.info("Checking Driver is null or not?");
			if(DriverManager.getDriver()==null) {
				LOGGER.info("Driver is null.Instantiating");
			DriverManager.launchBrowser();
			DriverManager.getDriver().manage().timeouts().implicitlyWait(30,TimeUnit.MILLISECONDS);
			CommonUtils.getInstance().initWebElements();
			login();
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void login() {
		DriverManager.getDriver().get(Constants.APP_URL);
		DriverManager.getDriver().manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		LoginPage.getInstance().enterUserName(Constants.Username);
		LoginPage.getInstance().enterPassword(Constants.Password);
		LoginPage.getInstance().clickLoginButton();
		
	}

}

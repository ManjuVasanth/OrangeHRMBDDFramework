package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import page_objects.DirectoryPage;
import page_objects.HomePage;
import page_objects.LoginPage;
import step_definitions.Common_Step_Definition;
import webdriver_manager.DriverManager;

public class CommonUtils {
//Lazy intialization singleton pattern is used
	
	private static CommonUtils commonUtilsInstance = null;
	private CommonUtils() {
		
	}
	public static CommonUtils getInstance() {
		if(commonUtilsInstance==null) {
			commonUtilsInstance = new CommonUtils();
	}
		return commonUtilsInstance;
	}
		
	
	public void loadProperties() {
//properties file will load from resources folder
		Properties properties = new Properties();
		try {
			properties.load(getClass().getResourceAsStream("/config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Constants.APP_URL = properties.getProperty("APP_URL");
		Constants.BROWSER = properties.getProperty("BROWSER");
		Constants.Username = properties.getProperty("Username");
		Constants.Password = properties.getProperty("Password");
		Constants.CHROME_DRIVER_LOCATION = properties.getProperty("CHROME_DRIVER_LOCATION");
		Constants.FIREFOX_DRIVER_LOCATION = properties.getProperty("FIREFOX_DRIVER_LOCATION");
		Constants.INTERNETEXPLORER_DRIVER_LOCATION = properties.getProperty("INTERNETEXPLORER_DRIVER_LOCATION");

	}
	public void initWebElements() {
		PageFactory.initElements(DriverManager.getDriver(), LoginPage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), HomePage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), DirectoryPage.getInstance());
	}
	public void takeScreenshot() {
		File screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
		FileUtils.copyFile(screenshot,new File(Common_Step_Definition.getScenarioName()+".png"));
		
	}catch(IOException e) {
		System.out.println(e.getMessage());
	}
}
	public void highlightElement(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
		executor.executeScript("arguments[0].setAttribute('style','border:2px solid red');",element);
		
	}
} 

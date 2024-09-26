package page_objects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.CommonUtils;
import webdriver_manager.DriverManager;

public class LoginPage {
	
	private static LoginPage loginInstance;
	
	
	private LoginPage() {
		
	}
	
	public static LoginPage getInstance() {
		
		if(loginInstance==null) {
			loginInstance = new LoginPage();
		}
		return loginInstance;
		
	}
	//Using PageFactory
/*	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")
	private WebElement USERNAME;
	
	@FindBy(xpath= "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")
	private WebElement PASSWORD;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
	private WebElement LOGIN_BUTTON; */
	
	
	//Using locators
	By USERNAME = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input");
	By PASSWORD = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input");
	By LOGIN_BUTTON = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");
	
	WebDriver driver = DriverManager.getDriver();
	/*public WebElement getUSERNAME() {
		return USERNAME;
	}
	public WebElement getPASSWORD() {
		return PASSWORD;
	}
	public WebElement getLOGIN_BUTTON() {
		return LOGIN_BUTTON;
	}*/
	public void enterUserName(String userName) {
		try {
		/*CommonUtils.getInstance().highlightElement(USERNAME);
			USERNAME.sendKeys(userName);*/
			//CommonUtils.getInstance().highlightElement();
			CommonUtils.getInstance().highlightElement((WebElement) USERNAME);
			((WebElement) USERNAME).sendKeys(userName);
			
		
	}catch(Exception e) {
		e.printStackTrace();	
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
			wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME));
		}catch(Exception e2) {
			e2.printStackTrace();	
		}
	}
	}
public void enterPassword(String password) {
	CommonUtils.getInstance().highlightElement(driver.findElement(PASSWORD));
		((WebElement) PASSWORD).sendKeys(password);
	}
public void clickLoginButton() {
	CommonUtils.getInstance().highlightElement((WebElement) LOGIN_BUTTON);
	((WebElement) LOGIN_BUTTON).click();
	
}
}

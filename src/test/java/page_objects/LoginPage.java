package page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.CommonUtils;

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
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")
	private WebElement USERNAME;
	
	@FindBy(xpath= "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")
	private WebElement PASSWORD;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
	private WebElement LOGIN_BUTTON;
	
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
		CommonUtils.getInstance().highlightElement(USERNAME);
		USERNAME.sendKeys(userName);
	}
public void enterPassword(String password) {
	CommonUtils.getInstance().highlightElement(PASSWORD);
		PASSWORD.sendKeys(password);
	}
public void clickLoginButton() {
	CommonUtils.getInstance().highlightElement(LOGIN_BUTTON);
	LOGIN_BUTTON.click();
	
}
}

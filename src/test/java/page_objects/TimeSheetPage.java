package page_objects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import utilities.CommonUtils;
import webdriver_manager.DriverManager;

public class TimeSheetPage {

	private static TimeSheetPage timeInstance;

	private TimeSheetPage() {
		
	}
public static TimeSheetPage getInstance() {
		
		
		if(timeInstance==null) {
			timeInstance = new TimeSheetPage();
		}
		return timeInstance ;
		
	}
@FindBy(xpath = "//input[@placeholder='Type for hints...']")
private WebElement EMPLOYEE_NAME;

@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/form/div[2]/button")
private WebElement VIEW;

@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/form/div[2]/div/div[1]/p")
private WebElement MESSAGE;


/*public void selectingEmployee() {
	EmployeeName.sendKeys("Peter");
	Actions action = new Actions(DriverManager.getDriver());
	action.sendKeys(EmployeeName, Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	
}*/
public void enterEmployeeName(String name) {
	CommonUtils.getInstance().highlightElement(EMPLOYEE_NAME);
	EMPLOYEE_NAME.sendKeys(name);
}

public void clickView() {
	CommonUtils.getInstance().highlightElement(VIEW);
	VIEW.click();
}
public String getMessage() {
	CommonUtils.getInstance().highlightElement(MESSAGE);
	return MESSAGE.getText();
}
	


}

package page_objects;

import java.util.concurrent.Flow.Publisher;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.CommonUtils;

public class HomePage {
	
	private static HomePage homeInstance;
	
	private HomePage() {
		
	}
	
	public static HomePage getInstance() {
		if(homeInstance==null) {
			homeInstance = new HomePage();
		}
		
		return homeInstance;
		
	}
	
	@FindBy(linkText = "Directory")
	private WebElement DIRECTORY;

	/*public WebElement getDIRECTORY() {
		return DIRECTORY;
	}*/
	@FindBy(linkText ="Time")
	private WebElement TIME;
public void clickDirectory() {
	CommonUtils.getInstance().highlightElement(DIRECTORY);
	DIRECTORY.click();
}
public void clickTime() {
	CommonUtils.getInstance().highlightElement(TIME);
	TIME.click();
	
}
}

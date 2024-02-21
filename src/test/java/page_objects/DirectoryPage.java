package page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utilities.CommonUtils;

public class DirectoryPage {
	
	private static DirectoryPage directoryInstance;
	
	private DirectoryPage() {
		
	}
	public static DirectoryPage getInstance() {
		if(directoryInstance==null) {
			directoryInstance = new DirectoryPage();
		}
		
		return directoryInstance;
		
	}
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div")
	private WebElement JOB_TITLE;
	
	/*public WebElement getJOB_TITLE() {
		return JOB_TITLE;
	}

	public WebElement getSEARCH() {
		return SEARCH;
	}

	public WebElement getNAME() {
		return NAME;
	}*/

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")
	private WebElement SEARCH;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/div/p[1]" )
	private WebElement NAME;
	
	public void selectJobTitle(String jobTitle) {
Select selectJob = new Select(JOB_TITLE);
		
		selectJob.selectByVisibleText(jobTitle);
	}
	public void clickSearch() {
		CommonUtils.getInstance().highlightElement(SEARCH);
		SEARCH.click();
	}
	public String getCFOName() {
		CommonUtils.getInstance().highlightElement(NAME);
		return NAME.getText();
	}
}

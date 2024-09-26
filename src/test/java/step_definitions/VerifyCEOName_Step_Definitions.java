package step_definitions;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import constants.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_objects.DirectoryPage;
import page_objects.HomePage;
import page_objects.LoginPage;
import utilities.CommonUtils;
import webdriver_manager.DriverManager;

public class VerifyCEOName_Step_Definitions {
	CommonUtils commonUtils;
	private static final Logger LOGGER = LogManager.getLogger(VerifyCEOName_Step_Definitions.class);
	@Given("the user is logged in successfully and is on Home Page")
	public void the_user_is_logged_in_successfully_and_is_on_home_page() {
	  //login
		
		
		try {
		String url = DriverManager.getDriver().getCurrentUrl();
		if(url.contains("dashboard")) {
			LOGGER.info("the user is logged in successfully and is on Home Page");
		}
	}catch(Exception e) {
		LOGGER.error(e);
		CommonUtils.getInstance().takeScreenshot();
	}
	}

	@When("the user clicks the directory option from the Menu bar")
	public void the_user_clicks_the_directory_option_from_the_menu_bar() {
		try {
		HomePage.getInstance().clickDirectory();
		LOGGER.info("the user clicks the directory option from the Menu bar ");
	}catch(Exception e) {
		LOGGER.error(e);
		CommonUtils.getInstance().takeScreenshot();
	}
	}
	@When("the user selects the job title as {string} from the drop down")
	public void the_user_selects_the_job_title_as_from_the_drop_down(String jobTitle) {
		
		try {
		DriverManager.getDriver().manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		DirectoryPage.getInstance().selectJobTitle(jobTitle);
		
		LOGGER.info("the user selects the job title as {string} from the drop down");
	}catch(Exception e) {
		LOGGER.error(e);
		CommonUtils.getInstance().takeScreenshot();
	}
	}

	@When("clicks the search button")
	public void clicks_the_search_button() {
		try {
		DirectoryPage.getInstance().clickSearch();
		LOGGER.info(" clicks the search button");
	}catch(Exception e) {
		LOGGER.error(e);
		CommonUtils.getInstance().takeScreenshot();
	}
	}

	@Then("the user should see the CFO name as {string}")
	public void the_user_should_see_the_cfo_name_as(String expectedName) {
		try {
		String actualName =	 DirectoryPage.getInstance().getCFOName();
		if(actualName.equalsIgnoreCase(expectedName))
		LOGGER.info("the user should see the CFO name as {string} ");
	}catch(Exception e) {
		LOGGER.error(e);
		CommonUtils.getInstance().takeScreenshot();
	}
}
}

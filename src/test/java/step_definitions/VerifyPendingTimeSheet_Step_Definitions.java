package step_definitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_objects.HomePage;
import page_objects.TimeSheetPage;
import utilities.CommonUtils;
import webdriver_manager.DriverManager;

public class VerifyPendingTimeSheet_Step_Definitions {
	private static Logger LOGGER = (Logger) LogManager.getLogger(VerifyPendingTimeSheet_Step_Definitions.class);

	@Given("the user is on the homepage")
	public void the_user_is_on_the_homepage() {
		try {
		String url = DriverManager.getDriver().getCurrentUrl();
		if(url.contains("dashboard")) {
	    LOGGER.info("the user is on the homepage");
	}
	}catch(Exception e) {
		LOGGER.error(e);
		CommonUtils.getInstance().takeScreenshot();
	}
	}

	@When("the user clicks on the time option from the menu")
	public void the_user_clicks_on_the_time_option_from_the_menu() {
		try {
		HomePage.getInstance().clickTime();
		LOGGER.info("the user clicks on the time option from the menu");
	}catch(Exception e) {
		LOGGER.error(e);
		CommonUtils.getInstance().takeScreenshot();
	}
	}

	@When("the user enters the name as {string}")
	public void the_user_enters_the_name_as(String name) {
		try {
		TimeSheetPage.getInstance().enterEmployeeName(name);
		LOGGER.info("the user enters the name as {string}");
	}catch(Exception e) {
		LOGGER.error(e);
		CommonUtils.getInstance().takeScreenshot();
	}
	}

	@When("clicks on the View button")
	public void clicks_on_the_view_button() {
		try {
		TimeSheetPage.getInstance().clickView();
		LOGGER.info("clicks on the View button");
	}catch(Exception e) {
		LOGGER.error(e);
		CommonUtils.getInstance().takeScreenshot();
	}
	}

	@Then("the user should see the message as {string}")
	public void the_user_should_see_the_message_as(String expectedMessage) {
		try {
	
		String actualMessage = TimeSheetPage.getInstance().getMessage();
		if(expectedMessage.equals(actualMessage)) {
		LOGGER.info("the user should see the expectedMessage");
	}
} 
catch(Exception e) {
	LOGGER.error(e);
	CommonUtils.getInstance().takeScreenshot();
}
}
	}
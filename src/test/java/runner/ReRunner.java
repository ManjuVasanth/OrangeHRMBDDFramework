package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "@target/failed_scenarios.txt",
		glue = "step_definitions",
		dryRun = false,
		monochrome = true
		
		)
public class ReRunner {

}

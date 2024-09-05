package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features="src/test/java/features", plugin ="json:target/jsonReports/cucumber-report.json", glue={"StepDefinitions"})

//@CucumberOptions(features="src/test/java/features", plugin ="json:target/jsonReports/cucumber-report.json", glue={"StepDefinitions"},tags="@AddPlace")

public class TestRunner {
	//@CucumberOptions(features="src/test/java/features", glue={"StepDefinitions"},tags="@DeletePlace")
	


}

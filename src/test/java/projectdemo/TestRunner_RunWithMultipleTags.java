package projectdemo;



import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "/src/test/resources/Tags",  // Ensure this path is correct
	    glue = {"StepDefinitions"},
	    tags = "@smoke"  // Correct tag expression
	    )
public class TestRunner_RunWithMultipleTags {
}
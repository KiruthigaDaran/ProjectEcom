package StepDefinitions;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Feature",
        glue = "StepDefinitions",
        plugin = {"pretty", "html:target/cucumber-report.html"},//Generate report
        publish = true
        //monochrome = true
)
public class TestRunner {

}

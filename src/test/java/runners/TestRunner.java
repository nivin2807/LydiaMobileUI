package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features", // Path to your feature files
    glue = "Lydia.LydiaMobilelUI.stepdefinitions",      // Path to your step definition classes
    plugin = {
        "pretty", // Console output
        "html:target/cucumber-reports/cucumber-html-report.html", // HTML report
        "html:target/cucumber-reports/cucumber-html-report-2.html", // HTML report
     
    },
    monochrome = true,
    tags = "@Mobile" // Only run scenarios tagged with @Mobile
)
public class TestRunner {
   // It's used by JUnit to run the tests.
}
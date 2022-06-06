package testRunner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import stepDefinitions.BaseClass;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features",
        glue = {"stepDefinitions"},
       // tags = "@SmokeTest",
       // tags = "@PromptAlert",
       // tags = "@SimpleAlert or @ConfirmAlert",
        tags = "@activity3",
        plugin = {"pretty","html:reports/HTML_report.html"},
        monochrome = true
)
public class TestRunner extends BaseClass{
    @AfterClass
    public static void tearDown() {
        System.out.println("Entering the tearDown method");
        driver.quit();
    }
}


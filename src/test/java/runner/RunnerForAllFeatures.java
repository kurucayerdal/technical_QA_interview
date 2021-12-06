package runner;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;

@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"stepDefinitions"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/ExtentReport/ExtentReportCapitoleConsulting.html"}
)
public class RunnerForAllFeatures extends AbstractTestNGCucumberTests {
    @AfterClass
    public static void afterClass() {
        Reporter.loadXMLConfig("src/test/java/xmlFiles/ExtentReport.xml");
        Reporter.setSystemInfo("User Name", "Erdal Kurucay");
        Reporter.setSystemInfo("Project Name", "Capitole Consulting Test Project");
        Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
        Reporter.setSystemInfo("Department", "QA");
        Reporter.setSystemInfo("Explanation", "API and UI Testing Tasks");
        Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
    }
}

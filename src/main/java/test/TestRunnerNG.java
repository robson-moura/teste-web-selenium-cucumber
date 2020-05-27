package test;

import org.testng.annotations.*;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;
import utils.DriverSetUp;
import cucumber.api.testng.CucumberFeatureWrapper;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;

@CucumberOptions(features = "src/test/resource/features/Home.feature", glue = {"steps"}, tags = {
        "~@Ignore"}, format = {"pretty", "html:target/cucumber-reports/cucumber-pretty",
        "json:target/cucumber-reports/CucumberTestReport.json", "rerun:target/cucumber-reports/rerun.txt"})

@Listeners(ExtentITestListenerClassAdapter.class)
public class TestRunnerNG {

    private TestNGCucumberRunner testNGCucumberRunner;

    @Test
    public void feature() {
        new DriverSetUp().setUP();
    }

    @BeforeTest(alwaysRun = true)
    public void setUpClass() throws Exception {

        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
}

package test;

import org.testng.annotations.*;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.api.testng.CucumberFeatureWrapper;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import utils.DriverSetUp;

@CucumberOptions(features = "src/test/resources/features", glue = {"steps"}, tags = {
        "~@Ignore"}, format = {"pretty", "html:target/cucumber-reports/cucumber-pretty",
        "json:target/cucumber-reports/CucumberTestReport.json", "rerun:target/cucumber-reports/rerun.txt"})

@Listeners(ExtentITestListenerClassAdapter.class)
public class TestRunnerNG {

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        System.err.print("\n>>>>>>BEFORE CLASS<<<<<<\n");
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        System.err.print("\n>>>>>>AFTER CLASS<<<<<<\n");
        testNGCucumberRunner.finish();
    }

    @AfterTest(alwaysRun = true)
    public void tearDownTest() throws Exception {
        System.err.print("KILL DRIVER HERE:");
        DriverSetUp.killDriver();
    }

}

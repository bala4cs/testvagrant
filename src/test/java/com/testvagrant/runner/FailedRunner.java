package com.testvagrant.runner;

import com.testvagrant.utils.Browsers;
import com.testvagrant.utils.ConfigurationUtil;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.*;

@CucumberOptions(
        features = {"@target/destination/rerun.txt"},
        plugin = {"json:target/destination/cucumber-rerun.json"},
//        tags = "",
        glue = {"com.testvagrant.hooks", "com.testvagrant.steps"})
public class FailedRunner {

    private TestNGCucumberRunner testNGCucumberRunner;
    Browsers browser = new Browsers();

    @BeforeClass()
    @Parameters({ "CONFIG", "SL4J", "BROWSER" })
    public void setup(String configProperty, String logProperties, String browserType) throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        ConfigurationUtil.setFileName(configProperty);
        browser.setDriver(browserType);
    }

    @Test(description = "Runs Cucumber Features", dataProvider = "features")
    @Parameters({ "CONFIG", "BROWSER" })
    public void run_cukes(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider(name = "features")
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void teardown() {
        testNGCucumberRunner.finish();
        browser.closeDriver();
    }

}
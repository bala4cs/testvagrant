package com.testvagrant.runner;

import com.testvagrant.utils.ConfigurationUtil;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.*;
import com.testvagrant.utils.Browsers;
import com.testvagrant.logger.CustomLogger;
import java.util.logging.Logger;


@CucumberOptions(
        features = {"src/test/resources"},
        plugin = {"json:target/destination/cucumber.json", "rerun:target/destination/rerun.txt"},
//        tags = "",
        glue = {"com.testvagrant.hooks", "com.testvagrant.steps"})
public class CucumberRunner {

    private static final CustomLogger LOGGER = new CustomLogger(CucumberRunner.class);

    private TestNGCucumberRunner testNGCucumberRunner;
    Browsers browser = new Browsers();

    @BeforeClass()
    @Parameters({ "CONFIG", "SL4J", "BROWSER" })
    public void setup(String configProperty, String logProperties, String browserType) throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        CustomLogger.initializeLogger(logProperties);
        ConfigurationUtil.setFileName(configProperty);
        browser.setDriver(browserType);
    }

    @Test(description = "Runs Cucumber Features", dataProvider = "features")
    @Parameters({ "CONFIG", "BROWSER" })
    public void run_cukes(CucumberFeatureWrapper cucumberFeature) {
        LOGGER.info("Start Test Suite ---> " + cucumberFeature.getCucumberFeature().getGherkinFeature().getName());
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
        LOGGER.info("End Test Suite ---> " + cucumberFeature.getCucumberFeature().getGherkinFeature().getName());
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

package testrunner;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("features")
@ConfigurationParameter(
        key = GLUE_PROPERTY_NAME,
        value = "stepdefinitions,hooks"
)
@ConfigurationParameter(
        key = PLUGIN_PROPERTY_NAME,
        value = "pretty," +
                "summary," +
                "html:target/cucumber-reports/cucumber.html," +
                "json:target/cucumber-reports/cucumber.json," +
                "junit:target/cucumber-reports/cucumber.xml"
                //"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter"
)
public class RunCucumberTest {
    //test comment
}
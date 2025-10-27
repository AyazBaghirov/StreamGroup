package io.stream.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/html-reports/cucumber-report.html",
                  "json:target/json-reports/json-report.json",
                  "rerun:target/rerun.txt",
                   "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        features = "src/test/resources/features",
        glue = "io/stream/step_definitions",
        dryRun = false,
        tags = "@ui",
        monochrome = true,
        publish = false
)

/*
junit 5 version
@Suite
@SelectClasspathResource("features")   // looks under src/test/resources/features
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "io/loop/step_definitions")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME,
        value = "html:target/html-reports/cucumber-report.html, json:target/json-reports/json-report.json")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@listOfMap")
@ConfigurationParameter(key = MONOCHROME_PROPERTY_NAME, value = "true")
@ConfigurationParameter(key = PLUGIN_PUBLISH_ENABLED_PROPERTY_NAME, value = "false")
@ConfigurationParameter(key = EXECUTION_DRY_RUN_PROPERTY_NAME, value = "false")
 */

public class CukesRunner {
}







































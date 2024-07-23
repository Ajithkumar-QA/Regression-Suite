package com.nopecommercedemo.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
        features = "src/test/resources/featurefile",
        glue = "com.nopecommercedemo.cucumber",
        plugin = {"html:target/cucumber-report/cucumber.html",
                "json:target/cucumber-report/cucumber.json"},
        tags = ""
)
public class RegressionRunner extends AbstractTestNGCucumberTests {



}

package com.kgcorner.Demo.BDD;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by admin on 3/15/2018.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources",
        glue="com.hyland.Demo.BDD",
        format = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        }
)
public class CucumberTestRoot {
}

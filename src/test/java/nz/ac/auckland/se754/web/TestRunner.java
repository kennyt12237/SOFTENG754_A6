package nz.ac.auckland.se754.web;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/features",
        glue={"nz.ac.auckland.se754.web"},
        plugin={"pretty", "html:target/cucumber-reports.html",
                "de.monochromata.cucumber.report.PrettyReports:target/cucumber",
        },
        tags = "@UserAuthentication"
)
public class TestRunner {}
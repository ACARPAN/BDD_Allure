package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true,
features = "src/test/resources/FeaturesFile/E2Eadmin.feature",
glue = {"stepDefination" },
plugin = {"pretty", "io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm" 
})
public class Runnerbdd {

}

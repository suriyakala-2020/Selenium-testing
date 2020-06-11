package Trivago_Cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src/main/java/feature/Trivago.feature", glue="steps", monochrome=true)
public class Runner extends AbstractTestNGCucumberTests {


}

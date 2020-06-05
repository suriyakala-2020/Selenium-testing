package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features= {"src/main/java/feature/Carwale.feature"},
	glue="steps", 
	monochrome = true
	)
public class RunnerFile extends AbstractTestNGCucumberTests{



}

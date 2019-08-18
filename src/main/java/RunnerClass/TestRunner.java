package RunnerClass;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		 
		features = "D:\\Eclips instalation setup\\Cucumber_nopcommerce_Application_POM\\Feature\\All_Feature.feature",
		glue = "StepDefination",
		monochrome = true,
		plugin = {"pretty","html:Report-output"},
		dryRun = false,
		tags = {"@Test1"}

		
		)



public class TestRunner {

}

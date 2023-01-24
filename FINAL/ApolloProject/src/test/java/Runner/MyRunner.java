package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"html:target/CucumberReport.html"},
		   features="src/test/java/features", 
           glue = "stepdefinations" ,
           tags = "@ALL")

public class MyRunner extends AbstractTestNGCucumberTests{

}

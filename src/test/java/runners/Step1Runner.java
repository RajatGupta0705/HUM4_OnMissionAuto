package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/resourceFiles/featureFiles"},
glue={"glueCode"},
monochrome = true,
plugin = {"pretty", "html:target\\report"}
)
public class Step1Runner extends AbstractTestNGCucumberTests
{

}

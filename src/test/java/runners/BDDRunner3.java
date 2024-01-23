package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/resourceFiles/featureFiles"},
        tags = "@smoketest and @regression",
        glue={"glueCode"},
        monochrome = false,
        plugin = {"pretty", "html:target\\report"}
)
public class BDDRunner3 extends AbstractTestNGCucumberTests
{
}

package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/resourceFiles/featureFiles/feature1.feature"},
        tags = "@smoketest",
        glue={"glueCode"},
        monochrome = true,
        plugin = {"pretty", "html:target\\report"}
)
public class RunnerStepDef1 extends AbstractTestNGCucumberTests
{
}

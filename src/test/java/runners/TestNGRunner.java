package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps","utilities"},
        plugin = {"pretty","html:target/cucumber-reports-testng.html"},
        monochrome = true,
        dryRun = false
)

public class TestNGRunner extends AbstractTestNGCucumberTests {
@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() { return super.scenarios(); }
}

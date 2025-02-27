package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import utilities.TestBase;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps","utilities"},
        plugin = {"pretty","html:target/cucumber-reports-testng.html"},
        monochrome = true,
        dryRun = false,
        tags = "@hepsiburada1"
)

public class TestNGRunner extends TestBase {
@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() { return super.scenarios(); }
}

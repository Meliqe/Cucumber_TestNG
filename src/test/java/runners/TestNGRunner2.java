package runners;


import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import utilities.TestBase;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps","utilities"},
        plugin = {"pretty","html:target/cucumber-reports-testng.html"},
        monochrome = true,
        dryRun = false,
        tags = "@hepsiburada2"
)

public class TestNGRunner2 extends TestBase {
@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() { return super.scenarios(); }
}

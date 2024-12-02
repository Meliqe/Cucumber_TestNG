package utilities;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
public class TestBase extends AbstractTestNGCucumberTests {

    @BeforeTest
    @Parameters({"deviceName","platformName","platformVersion","port"})
    public void beforeMethod(String deviceName,String platformName,String platformVersion,String port){
        try {
            DriverManager.setDriver(deviceName,platformName,platformVersion,port);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

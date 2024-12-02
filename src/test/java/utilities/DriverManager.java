package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.URL;
import java.time.Duration;

public class DriverManager {

    private static ThreadLocal<AndroidDriver> driver = new ThreadLocal<>();
    public static void setDriver () {
        if (driver.get() == null) {
            try {
                UiAutomator2Options options = new UiAutomator2Options();
                options.setPlatformName(ConfigReader.getProperty("platformName"));
                options.setPlatformVersion(ConfigReader.getProperty("platformVersion"));
                options.setDeviceName(ConfigReader.getProperty("deviceName"));
                options.setAppPackage(ConfigReader.getProperty("appPackage"));
                options.setAppActivity(ConfigReader.getProperty("appActivity"));
                options.setAutomationName("UiAutomator2");
                options.setNewCommandTimeout(Duration.ofSeconds(3600));
                options.setAutoGrantPermissions(true);
                options.setApp(ConfigReader.getProperty("app"));
                options.setFullReset(true);
                String appiumServerURL = ConfigReader.getProperty("appiumServerURL");
                AndroidDriver driverInstance = new AndroidDriver(new URL(appiumServerURL), options);
                driverInstance.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.set(driverInstance);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Driver başlatılamadı: " + e.getMessage());
            }
        }
    }

    public static void setDriver (String deviceName,String platformName,String platformVersion,String port) {
        if (driver.get() == null) {
            try {
                UiAutomator2Options options = new UiAutomator2Options();
                options.setPlatformName(platformName);
                options.setPlatformVersion(platformVersion);
                options.setDeviceName(deviceName);
                options.setAppPackage(ConfigReader.getProperty("appPackage"));
                options.setAppActivity(ConfigReader.getProperty("appActivity"));
                options.setAutomationName("UiAutomator2");
                options.setNewCommandTimeout(Duration.ofSeconds(3600));
                options.setAutoGrantPermissions(true);
                options.setApp(ConfigReader.getProperty("app"));
                options.setFullReset(true);
                String appiumServerURL = ConfigReader.getProperty("appiumServerURL");
                String url="http://"+ConfigReader.getProperty("ip")+":"+port+"/wd/hub";
                AndroidDriver driverInstance = new AndroidDriver(new URL(url), options);
                driverInstance.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.set(driverInstance);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Driver başlatılamadı: " + e.getMessage());
            }
        }
    }

    public static AndroidDriver getDriver() {
        return driver.get();
    }
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }



}

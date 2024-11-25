package functions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.DriverManager;
import utilities.LocatorUtils;

import static utilities.Wait.waitUntilVisibleByLocator;

public class BaseMethods {
    AndroidDriver driver;
    public BaseMethods() {
        this.driver= DriverManager.getDriver();
    }

    public void click(String locatorKey){
        try{
            By locator= LocatorUtils.getLocator(locatorKey);
            WebElement element = waitUntilVisibleByLocator(driver,locator);
            element.click();
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new AssertionError("error occurred (click)"+e.getMessage());
        }
    }

    public void search(String locatorKey,String searchText){
        try{
            By locator= LocatorUtils.getLocator(locatorKey);
            WebElement element = waitUntilVisibleByLocator(driver,locator);
            if (element == null) {
                throw new AssertionError("Element bulunamadı: " + locatorKey);
            }
            element.sendKeys(searchText);
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new AssertionError("error occurred (searc)"+e.getMessage());
        }
    }






}

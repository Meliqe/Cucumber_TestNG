package pageFunctions;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.DriverManager;
import utilities.LocatorUtils;
import static utilities.Wait.waitUntilVisibleByLocator;

public class samsungPageMethods {
    private AndroidDriver driver;
    public samsungPageMethods() {
        this.driver = DriverManager.getDriver();
    }
    public void displayFirstProduct(String productDesc, String productPrice) {
        try {

            By locator_Name = LocatorUtils.getLocator(productDesc);
            By locator_Price = LocatorUtils.getLocator(productPrice);

            WebElement firstProductDesc = waitUntilVisibleByLocator(driver, locator_Name);
            WebElement firstProductPrice = waitUntilVisibleByLocator(driver, locator_Price);

            String desc = firstProductDesc.getText();
            String price = firstProductPrice.getText();

            System.out.println("İlk Ürün: " + desc + ", Fiyat: " + price);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new AssertionError("Hata oluştu (getFirstElementInfo): " + e.getMessage());
        }
    }
}

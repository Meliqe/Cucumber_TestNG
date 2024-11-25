package pageFunctions;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.LocatorUtils;
import static utilities.Wait.waitUntilVisibleByLocator;
import java.util.List;

public class samsungPageMethods {
    private AndroidDriver driver;

    public void displayFirstProduct(String productBox, String productDesc, String productPrice) {
        try {
            By locator_Box = LocatorUtils.getLocator(productBox);
            By locator_Name = LocatorUtils.getLocator(productDesc);
            By locator_Price = LocatorUtils.getLocator(productPrice);

            List<WebElement> productBoxes = driver.findElements(locator_Box);

            if (productBoxes.isEmpty()) {
                throw new AssertionError("Ürün kutuları bulunamadı.");
            }

            WebElement firstProductBox = productBoxes.get(0);

            WebElement firstProductDesc = firstProductBox.findElement(locator_Name);
            WebElement firstProductPrice = firstProductBox.findElement(locator_Price);

            String desc = firstProductDesc.getText();
            String price = firstProductPrice.getText();

            System.out.println("İlk Ürün: " + desc + ", Fiyat: " + price);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new AssertionError("Hata oluştu (getFirstElementInfo): " + e.getMessage());
        }
    }
}

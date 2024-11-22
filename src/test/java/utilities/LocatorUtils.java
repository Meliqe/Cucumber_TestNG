package utilities;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class LocatorUtils {
private static Map<String, By> locators= new HashMap<>();

static {
    try
    {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootArray= mapper.readTree(new File("src/test/resources/locators.json"));

        for(JsonNode node : rootArray){

            String key =node.get("key").asText();
            String value =node.get("value").asText();
            String locatorType= node.get("locatorType").asText();

            By locator;
            switch (locatorType.toLowerCase()){
                case "id" :
                    locator = By.id(value);
                    break;
                case "xpath" :
                    locator = By.xpath(value);
                    break;
                default :
                    System.out.println("Unknown locator type: " + locatorType);
                    throw new IllegalArgumentException("Unknown locator type: " + locatorType);
            }
            locators.put(key, locator);
        }
    }
    catch(Exception e)
    {
       e.printStackTrace();
       throw new RuntimeException("Locator File could not be loaded");
    }
}

public static By getLocator(String key){
    if(!locators.containsKey(key))
    {
        throw new IllegalArgumentException("Specified locator key not found:"+key);
    }
    return locators.get(key);
}

}

package utilities;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    public static Properties properties;

    static {
        try(InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")){
            if(input == null){
                throw new RuntimeException("Config file not found! Please make sure the file is in the correct directory.");
            }
            properties = new Properties();
            properties.load(input);
        }
        catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("Config file could not be loaded!");
        }
    }

    public static String getProperty(String key){
        String value = properties.getProperty(key);
        if(value == null || value.trim().isEmpty()){
            throw new RuntimeException("Incomplete or faulty property:"+ key);
        }
        return value;
    }
}

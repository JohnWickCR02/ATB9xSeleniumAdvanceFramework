package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    public static String readKey(String key)
    {

        String fileLocation = System.getProperty("user.dir") +"/src/test/java/resources/data.properties";
        try {
            FileInputStream file = new FileInputStream(fileLocation);
            Properties p = new Properties();
            p.load(file);
            return p.getProperty(key);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}

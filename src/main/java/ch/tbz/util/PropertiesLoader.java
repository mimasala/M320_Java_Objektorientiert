package ch.tbz.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {
    public static Properties loadProperties() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}

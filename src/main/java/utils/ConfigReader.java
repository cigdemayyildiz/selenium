package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static String readProperty(String key){
        // File class assign given file to the Java object.
        File file = new File("configuration.properties");
        // Properties object will read the properties file.
        Properties properties = new Properties();

        try {
            // load() method will load every file values from the file object to properties object.
            properties.load(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(key); // I can read the values from properties object using the key.
    }
}

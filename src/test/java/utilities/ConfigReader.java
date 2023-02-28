package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();

    static {
        try {
            // Open the 'config' file
            FileInputStream fileInputStream = new FileInputStream("config.properties");

            // Read the 'config' file
            properties.load(fileInputStream);

            // Close the file
            fileInputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
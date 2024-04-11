package config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    public static Properties properties = new Properties();
    private static final String ROAD_TO_CFG_FILE = "./src/test/resources/Config.properties";
    public static String readPropertiesFile(String strName) {
        try {
            InputStream input = new FileInputStream(ROAD_TO_CFG_FILE);
            properties.load(input);
            return properties.getProperty(strName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
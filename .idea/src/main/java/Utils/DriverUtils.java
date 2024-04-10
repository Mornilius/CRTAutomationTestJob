package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static config.ConfigReader.readPropertiesFile;

public class DriverUtils {

    public static WebDriver driver = getWebDriver();

    public static WebDriver getWebDriver() {
        switch (readPropertiesFile("BrowserType")) {
            case "Firefox":
                return new FirefoxDriver();
            case "Edge":
                return new EdgeDriver();
            case "Chrome":
                return new ChromeDriver();
            default:
                throw new RuntimeException("Incorrect browser name");
        }
    }
}
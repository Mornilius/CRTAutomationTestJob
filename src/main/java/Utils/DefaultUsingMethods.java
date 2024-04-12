package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

import static Page.HomePage.HOME_TEXT_LOCATOR;
import static Utils.DriverUtils.driver;
import static Utils.DriverUtils.getWebDriver;
import static config.ConfigReader.readPropertiesFile;

public class DefaultUsingMethods {

    public static boolean isDisplay(By XPATH) {
        return driver.findElement(XPATH).isDisplayed();
    }

    public static boolean isEnable(By XPATH) {
        return driver.findElement(XPATH).isEnabled();
    }

    public static void clickInteractiveElement(By XPATH, By checkpointWait) {
        driver.findElement(XPATH).click();
        explicitWait(checkpointWait);
    }

    public static boolean elementIsSelected(By XPATH) {
        return driver.findElement(XPATH).isSelected();
    }

    public static void sendKeys(By xpath, String str) {
        driver.findElement(xpath).sendKeys(str);
    }

    public static int getResponseCode() {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(driver.getCurrentUrl()).openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            return connection.getResponseCode();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void JSClick(By xpath) {
        WebElement element = driver.findElement(xpath);
        JavascriptExecutor jsex = (JavascriptExecutor) driver;
        jsex.executeScript("arguments[0].click();", element);
    }

    public static void openSite() {
        driver = getWebDriver();
        driver.get(readPropertiesFile("URL"));
        explicitWait(HOME_TEXT_LOCATOR);
    }

    public static void browserQuit() {
        if(driver != null) {
            driver.quit();
        }
    }

    public static void browserClose() {
        driver.close();
    }


    public static void explicitWait(By xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath)).isDisplayed();
    }

    public static void timeOut(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    public static By gettingParentsLocator(String defLocator, By xpath) {
        return By.xpath(String.format(defLocator + "%s", xpath));
    }
}
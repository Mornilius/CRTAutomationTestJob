package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Page.CatalogMenuPhoneAndGadgetsPage.PHONE_CONTAINER_LOCATOR;
import static Page.CatalogOfProductPage.CATALOG_TITLE_LOCATOR;
import static Page.MainPage.CATALOG_LOCATOR;
import static Page.MainPage.LOGO_LOCATOR;
import static Utils.DriverUtils.driver;
import static config.ConfigReader.readPropertiesFile;

public class DefaultUsingMethods {

    public static boolean isDisplay(By XPATH) {
        return driver.findElement(XPATH).isDisplayed();
    }

    public static boolean isEnable(By XPATH) {
        return driver.findElement(XPATH).isEnabled();
    }

    public static void clickInteractiveElement(By XPATH) {
        driver.findElement(XPATH).click();
    }

    public static void sendKeys(By xpath, String str, By checkpointWait) {
        driver.findElement(xpath).sendKeys(str, Keys.ENTER);
        explicitWait(checkpointWait);
    }

    public static int getResponseCode() {
        try{
            HttpURLConnection connection = (HttpURLConnection) new URL(driver.getCurrentUrl()).openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            return connection.getResponseCode();
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public static void JSClick(By xpath) {
        WebElement element = driver.findElement(xpath);
        JavascriptExecutor jsex = (JavascriptExecutor) driver;
        jsex.executeScript("arguments[0].click();", element);
    }

    public static void displayResponseCode() {
        System.out.println(getResponseCode());
    }

    public static void openSite() {
        driver.get(readPropertiesFile("URL"));
        explicitWait(LOGO_LOCATOR);
    }

    public static void browserQuit() {
        driver.quit();
    }

    public static void timeOut() {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(DefaultUsingConstants.TIME_MILLIS));
    }

    public static void explicitWait(By xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath)).isDisplayed();
    }

    public static void findAndAddToShoppingCart(By searchLine, String product, By sendKeysCheckPointWait , By addButton, By checkPointWait2) {
        sendKeys(searchLine, product, sendKeysCheckPointWait);
        JSClick(addButton);
        explicitWait(checkPointWait2);
    }

    public static By gettingParentsLocator(String defLocator, By xpath) {
        return By.xpath(String.format(defLocator+"%s", xpath));
    }

    public static List convertList(By xpath, List<WebElement> WebElementlist, List<String> elements_string) {
        WebElementlist = driver.findElements(xpath);
        for(WebElement element : WebElementlist){
            elements_string.add(Arrays.toString(((element.getText().toLowerCase().split("\n")))));
        }
        return elements_string;
    }

    public static List getConvertedListOfProducts(By clickXpath, By waitXpath, By convertXpath ){
        List<WebElement> WEBELEMENTS_STRING =new ArrayList<>();
        List<String> ELEMENTS_STRING =new ArrayList<>();
        clickInteractiveElement(clickXpath);
        explicitWait(waitXpath);
        return convertList(convertXpath, WEBELEMENTS_STRING, ELEMENTS_STRING);
    }
}
//TODO: в след версиях разобраться с этим классом (более грамотное размещение методов по классам)
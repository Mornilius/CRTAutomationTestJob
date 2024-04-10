package PageTest;

import Utils.DefaultUsingMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static Page.MainPage.ADD_BUTTON_LOCATOR;
import static Page.MainPage.CATALOG_LOCATOR;
import static Page.MainPage.CHECKPOINT_AFTER_SEARCH_LOCATOR;
import static Page.MainPage.COMPARE_LOCATOR;
import static Page.MainPage.CONFIG_LOCATOR;
import static Page.MainPage.DELIVERY_LOCATOR;
import static Page.MainPage.FAVORITES_LOCATOR;
import static Page.MainPage.FEEDBACK_LOCATOR;
import static Page.MainPage.FIND_PRODUCT_LOCATOR;
import static Page.MainPage.INPUT_ACCOUNT_LOCATOR;
import static Page.MainPage.LOGO_LOCATOR;
import static Page.MainPage.MAGAZINE_LOCATOR;
import static Page.MainPage.PRODUCT_DESCRIPTION_LOCATOR;
import static Page.MainPage.SALES_LOCATOR;
import static Page.MainPage.SHOPPING_CART_LOCATOR;
import static Page.MainPage.SHOPS_LOCATOR;
import static Page.MainPage.SNIPPET_PRODUCT_VERTICAL_LAYOUT;
import static Utils.MassageConstants.FAIL_CODE_MASSAGE;
import static Utils.DefaultUsingMethods.JSClick;
import static Utils.DefaultUsingMethods.browserQuit;
import static Utils.DefaultUsingMethods.convertList;
import static Utils.DefaultUsingMethods.explicitWait;
import static Utils.DefaultUsingMethods.getResponseCode;
import static Utils.DefaultUsingMethods.isDisplay;
import static Utils.DefaultUsingMethods.isEnable;
import static Utils.MassageConstants.NOT_ENABLE_MASSAGE;
import static Utils.MassageConstants.NOT_VISIBLE_MASSAGE;
import static Utils.DefaultUsingMethods.sendKeys;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class MainPageTest {

    @DataProvider(name = "checkSite")
    public static Object[] arrayXpath() {
        return new Object[] {
                LOGO_LOCATOR,
                CATALOG_LOCATOR,
                FIND_PRODUCT_LOCATOR,
                INPUT_ACCOUNT_LOCATOR,
                FAVORITES_LOCATOR,
                COMPARE_LOCATOR,
                SHOPPING_CART_LOCATOR,
                FEEDBACK_LOCATOR,
                SHOPS_LOCATOR,
                DELIVERY_LOCATOR,
                CONFIG_LOCATOR,
                SALES_LOCATOR,
                MAGAZINE_LOCATOR
        };
    }

    @BeforeTest
    public static void openSite() {
        DefaultUsingMethods.openSite();
        assertEquals(getResponseCode(), 200, String.format(FAIL_CODE_MASSAGE, 200));
    }

    @Test(dataProvider = "checkSite")
    public static void checkOpenSite(By xpath) {
        //TODO: в строке 55 дублирование статус кода, чекнуть интерфейс HttpsStatus
        assertTrue(isDisplay(xpath));
    }

    @Test(dataProvider = "checkSite")
    public static void checkClickableElementOnTopBar(By xpath) {
        assertTrue(isEnable(xpath));
    }
    @Ignore
    public static void findAndAddToShoppingCart() {
        DefaultUsingMethods.findAndAddToShoppingCart(
                FIND_PRODUCT_LOCATOR,
                "iphone 13",
                CHECKPOINT_AFTER_SEARCH_LOCATOR,
                ADD_BUTTON_LOCATOR,
                SNIPPET_PRODUCT_VERTICAL_LAYOUT);

        assertTrue(isDisplay(PRODUCT_DESCRIPTION_LOCATOR), NOT_VISIBLE_MASSAGE);
    }

    @Ignore
    public static void testMethod() {
        List<WebElement> WEBELEMENTS_STRING =new ArrayList<>();
        List<WebElement> WEB_ELEMENTS_STRING =new ArrayList<>();
        List<String> ELEMENTS_STRING =new ArrayList<>();
        sendKeys(FIND_PRODUCT_LOCATOR, "iphone 13", By.xpath("//div[contains(@data-meta-name,'ProductVerticalSnippet')]"));
        convertList(By.xpath("//button[contains(@data-meta-name, 'Snippet__cart-button')]/ancestor::div[@data-meta-product-id='1901131']"), WEBELEMENTS_STRING, ELEMENTS_STRING);
        JSClick(ADD_BUTTON_LOCATOR);
        explicitWait(By.xpath("//div[contains(@data-meta-name, 'UpsaleBasketLayout')]"));
        convertList(By.xpath("//div[contains(@data-meta-name, 'UpsaleBasketProductDetails')]"), WEB_ELEMENTS_STRING, ELEMENTS_STRING);
    }

        @AfterTest
        public static void exitBrowser() {
            browserQuit();
        }
}
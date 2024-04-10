package PageTest;

import Utils.DefaultUsingMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static Page.CatalogMenuPhoneAndGadgetsPage.PHONE_CONTAINER_LOCATOR;
import static Utils.DefaultUsingMethods.convertList;
import static Page.CatalogOfProductPage.CATALOG_TITLE_LOCATOR;
import static Page.MainPage.CATALOG_LOCATOR;
import static Page.MainPage.LOGO_LOCATOR;
import static Utils.DefaultUsingMethods.clickInteractiveElement;
import static Utils.DefaultUsingMethods.browserQuit;
import static Utils.DefaultUsingMethods.explicitWait;
import static Page.CatalogMenuPhoneAndGadgetsPage.PRODUCT_LIST_PHONE_CHAPTER;
import static Utils.DefaultUsingMethods.getConvertedListOfProducts;
import static Utils.MassageConstants.FAIL_EQUALS_MASSAGE;
import static org.testng.Assert.assertEquals;

public class CatalogMenuPhoneAndGadgetsPageTest {

    @BeforeClass
    public static void openSite() {
        DefaultUsingMethods.openSite();
    }

    @Test
    public static void checkElemetsIsDisplay() {
        assertEquals(getConvertedListOfProducts(CATALOG_LOCATOR, CATALOG_TITLE_LOCATOR,PHONE_CONTAINER_LOCATOR).toString(), PRODUCT_LIST_PHONE_CHAPTER.toString().toLowerCase(), FAIL_EQUALS_MASSAGE);
    }

    @AfterTest
    public static void exitBrowser() {
        browserQuit();
    }
}
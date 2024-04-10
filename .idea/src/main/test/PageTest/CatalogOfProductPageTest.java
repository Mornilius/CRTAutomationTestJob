package PageTest;

import Utils.DefaultUsingMethods;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import static Page.CatalogOfProductPage.BEAUTY_AND_HEALTH_LOCATOR;
import static Page.CatalogOfProductPage.CATALOG_TITLE_LOCATOR;
import static Page.CatalogOfProductPage.CONSTRUCTION_AND_RENOVATION_LOCATOR;
import static Page.CatalogOfProductPage.FIND_PRODUCT_LOCATOR;
import static Page.CatalogOfProductPage.GAMING_LOCATOR;
import static Page.CatalogOfProductPage.GIFT_LOCATOR;
import static Page.CatalogOfProductPage.HOME_APPLIANCES_LOCATOR;
import static Page.CatalogOfProductPage.HOME_AUTO_LOCATOR;
import static Page.CatalogOfProductPage.LAPTOPS_AND_PC_LOCATOR;
import static Page.CatalogOfProductPage.OFFICE_EQUIPMENTS_AND_FURNITURE_LOCATOR;
import static Page.CatalogOfProductPage.OFFICE_SUPPLIES_LOCATOR;
import static Page.CatalogOfProductPage.SALES_PRODUCTS_LOCATOR;
import static Page.CatalogOfProductPage.SERVICE_LOCATOR;
import static Page.CatalogOfProductPage.SMARTHOME_AND_GUARD_SYSTEM_LOCATOR;
import static Page.CatalogOfProductPage.SMARTPHONE_AND_GADGETS_LOCATOR;
import static Page.CatalogOfProductPage.TV_AUDIO_VIDEO_PHOTO_LOCATOR;
import static Page.MainPage.CATALOG_LOCATOR;
import static Utils.DefaultUsingMethods.JSClick;
import static Utils.DefaultUsingMethods.browserQuit;
import static Utils.DefaultUsingMethods.explicitWait;
import static Utils.DefaultUsingMethods.isDisplay;
import static Utils.MassageConstants.NOT_ENABLE_MASSAGE;
import static org.testng.Assert.assertTrue;

public class CatalogOfProductPageTest {

    @DataProvider(name = "checkCatalogOfProduct")
    public static Object[] arrayXpath() {
        return new Object[] {
                CATALOG_TITLE_LOCATOR,
                FIND_PRODUCT_LOCATOR,
                SMARTPHONE_AND_GADGETS_LOCATOR,
                LAPTOPS_AND_PC_LOCATOR,
                TV_AUDIO_VIDEO_PHOTO_LOCATOR,
                GAMING_LOCATOR,
                HOME_APPLIANCES_LOCATOR,
                BEAUTY_AND_HEALTH_LOCATOR,
                SMARTHOME_AND_GUARD_SYSTEM_LOCATOR,
                OFFICE_EQUIPMENTS_AND_FURNITURE_LOCATOR,
                OFFICE_SUPPLIES_LOCATOR,
                CONSTRUCTION_AND_RENOVATION_LOCATOR,
                HOME_AUTO_LOCATOR,
                SALES_PRODUCTS_LOCATOR,
                GIFT_LOCATOR,
                SERVICE_LOCATOR,
                CATALOG_TITLE_LOCATOR,
        };
    }

    @BeforeTest
    public static void openSite() {
        DefaultUsingMethods.openSite();
    }

    @Test(dataProvider = "checkCatalogOfProduct")
    public static void checkCatalogOfProduct(By xpath) {
        JSClick(CATALOG_LOCATOR);
        explicitWait(CATALOG_LOCATOR);
        explicitWait(CATALOG_TITLE_LOCATOR);
        assertTrue(isDisplay(xpath));
    }

    @AfterTest
    public static void quitBrowser() {
        browserQuit();
    }
}
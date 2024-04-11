package PageTest;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static Page.HomePage.HOME_BUTTON_LOCATOR;
import static Page.HomePage.HOME_STRING_LOCATOR;
import static Page.HomePage.LOGIN_BUTTON_LOCATOR;
import static Page.HomePage.SIGN_UP_BUTTON_LOCATOR;
import static Utils.DefaultUsingMethods.browserQuit;
import static Utils.DefaultUsingMethods.isDisplay;
import static Utils.DefaultUsingMethods.openSite;
import static Utils.MassageConstants.NOT_VISIBLE_MASSAGE;
import static org.testng.Assert.assertTrue;

public class HomePageTest {

    @DataProvider(name = "HomePageLocators")
    public static Object[] arrayHomePageXpath() {
        return new Object[]{
                HOME_BUTTON_LOCATOR,
                LOGIN_BUTTON_LOCATOR,
                SIGN_UP_BUTTON_LOCATOR,
                HOME_STRING_LOCATOR
        };
    }

    @BeforeClass
    public static void openMainPage() {
        openSite();
    }

    @Test(dataProvider = "HomePageLocators")
    public static void checkElementsIsDisplay(By xpath) {
        assertTrue(isDisplay(xpath),NOT_VISIBLE_MASSAGE);
    }

    @AfterTest
    public static void exitBrowser() {
        browserQuit();
    }
}
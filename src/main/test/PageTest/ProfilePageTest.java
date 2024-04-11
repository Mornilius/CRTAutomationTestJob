package PageTest;

import Page.HomePage;
import Page.LoginPage;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static Page.HomePage.SIGN_UP_BUTTON_LOCATOR;
import static Page.LoginPage.INPUT_EMAIL_FIELD_LOCATOR;
import static Page.LoginPage.INPUT_PASSWORD_FIELD_LOCATOR;
import static Page.LoginPage.LOGIN_STRING_LOCATOR;
import static Page.ProfilePage.HOME_BUTTON_LOCATOR;
import static Page.ProfilePage.LOGOUT_BUTTON_LOCATOR;
import static Page.ProfilePage.PROFILE_BUTTON_LOCATOR;
import static Page.ProfilePage.WELCOME_STRING_LOCATOR;
import static Page.SignUpPage.SIGN_UP_STRING_LOCATOR;
import static Utils.DataUserConstants.USER_EMAIL;
import static Utils.DataUserConstants.USER_PASSWORD;
import static Utils.DefaultUsingMethods.browserQuit;
import static Utils.DefaultUsingMethods.clickInteractiveElement;
import static Utils.DefaultUsingMethods.isDisplay;
import static Utils.DefaultUsingMethods.openSite;
import static Utils.DefaultUsingMethods.sendKeys;
import static org.testng.Assert.assertTrue;

public class ProfilePageTest {

    @DataProvider(name = "ProfilePageLocators")
    public static Object[] arrayXpathProfilePage(){
        return new Object[]{
                HOME_BUTTON_LOCATOR,
                PROFILE_BUTTON_LOCATOR,
                LOGOUT_BUTTON_LOCATOR,
                WELCOME_STRING_LOCATOR
        };
    }

    @BeforeClass
    public static void openMainPage() {
        openSite();
        clickInteractiveElement(HomePage.LOGIN_BUTTON_LOCATOR, LOGIN_STRING_LOCATOR);
        sendKeys(INPUT_EMAIL_FIELD_LOCATOR, USER_EMAIL);
        sendKeys(INPUT_PASSWORD_FIELD_LOCATOR, USER_PASSWORD);
        clickInteractiveElement(LoginPage.LOGIN_BUTTON_LOCATOR, WELCOME_STRING_LOCATOR);
    }

    @Test(dataProvider = "ProfilePageLocators")
    public static void checkProfileElementsIsDisplay(By xpath) {
        assertTrue(isDisplay(xpath));
    }
    @AfterTest
    public static void exitBrowser() {
        browserQuit();
    }
}
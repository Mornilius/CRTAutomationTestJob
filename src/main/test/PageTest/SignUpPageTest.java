package PageTest;

import Page.HomePage;
import Page.SignUpPage;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static Page.HomePage.SIGN_UP_BUTTON_LOCATOR;
import static Page.LoginPage.LOGIN_STRING_LOCATOR;
import static Page.ProfilePage.WELCOME_STRING_LOCATOR;
import static Page.SignUpPage.INPUT_EMAIL_FIELD_LOCATOR;
import static Page.SignUpPage.INPUT_NAME_FIELD_LOCATOR;
import static Page.SignUpPage.INPUT_PASSWORD_FIELD_LOCATOR;
import static Page.SignUpPage.SIGN_UP_STRING_LOCATOR;
import static Utils.DataUserConstants.USER_EMAIL;
import static Utils.DataUserConstants.USER_PASSWORD;
import static Utils.DefaultUsingMethods.browserQuit;
import static Utils.DefaultUsingMethods.clickInteractiveElement;
import static Utils.DefaultUsingMethods.isDisplay;
import static Utils.DefaultUsingMethods.openSite;
import static Utils.DefaultUsingMethods.sendKeys;
import static org.testng.Assert.assertTrue;

public class SignUpPageTest {

    @DataProvider(name = "SignUpLocator")
    public static Object[] arrayXpath() {
        return new Object[]{
                INPUT_EMAIL_FIELD_LOCATOR,
                INPUT_PASSWORD_FIELD_LOCATOR,
                INPUT_NAME_FIELD_LOCATOR,
                SIGN_UP_STRING_LOCATOR
        };
    }

    @DataProvider(name = "userDataTest")
    public static Object[][] dataTestUser() {
        return new Object[][]{
                {USER_EMAIL, USER_PASSWORD}
        };
    }

    @BeforeClass
    public static void openMainPage() {
        openSite();
    }

    @Test(dataProvider = "SignUpLocator")
    public static void checkSignUpElementsIsDisplay(By xpath) {
        clickInteractiveElement(SIGN_UP_BUTTON_LOCATOR, SIGN_UP_STRING_LOCATOR);
        assertTrue(isDisplay(xpath));
    }

    @Test(dataProvider = "userDataTest")
    public static void signUp(String userEmail, String userPassword){
        clickInteractiveElement(SIGN_UP_BUTTON_LOCATOR, SIGN_UP_STRING_LOCATOR);
        sendKeys(INPUT_EMAIL_FIELD_LOCATOR, userEmail);
        sendKeys(INPUT_PASSWORD_FIELD_LOCATOR, userPassword);
        clickInteractiveElement(SignUpPage.SIGN_UP_BUTTON_LOCATOR, LOGIN_STRING_LOCATOR);
        assertTrue(isDisplay(LOGIN_STRING_LOCATOR));
    }

    @AfterTest
    public static void exitBrowser() {
        browserQuit();
    }
}

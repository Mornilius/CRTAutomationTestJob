package PageTest;

import Page.HomePage;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static Page.ProfilePage.WELCOME_STRING_LOCATOR;
import static Page.SignUpPage.*;
import static Utils.DataUserConstants.USER_EMAIL;
import static Utils.DataUserConstants.USER_PASSWORD;
import static Utils.DefaultUsingMethods.*;
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
        clickInteractiveElement(HomePage.SIGN_UP_BUTTON_LOCATOR, SIGN_UP_STRING_LOCATOR);
        assertTrue(isDisplay(xpath));
    }

    @Test(dataProvider = "userDataTest")
    public static void signUp(String userEmail, String userPassword){
        clickInteractiveElement(HomePage.SIGN_UP_BUTTON_LOCATOR, SIGN_UP_STRING_LOCATOR);
        sendKeys(INPUT_EMAIL_FIELD_LOCATOR, userEmail);
        sendKeys(INPUT_PASSWORD_FIELD_LOCATOR, userPassword);
        clickInteractiveElement(SIGN_UP_BUTTON_LOCATOR, WELCOME_STRING_LOCATOR);
    }

    @AfterTest
    public static void exitBrowser() {
        browserQuit();
    }
}

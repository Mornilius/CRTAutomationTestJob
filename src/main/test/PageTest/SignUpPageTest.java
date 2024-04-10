package PageTest;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static Page.HomePage.SIGN_UP_BUTTON;
import static Page.SignUpPage.*;
import static Utils.DefaultUsingMethods.*;
import static org.testng.Assert.assertTrue;

public class SignUpPageTest {

    @DataProvider(name = "SignUpLocator")
    public static Object[] arrayXpath() {
        return new Object[]{
                INPUT_EMAIL_FIELD,
                INPUT_PASSWORD_FIELD,
                INPUT_NAME_FIELD,
                SIGN_UP_STRING
        };
    }
    @DataProvider(name = "userDataTest")
    public static Object[][] dataTestUser() {
        return new Object[][]{
                {"", ""},
                {" ", " "}
        };
    }

    @BeforeClass
    public static void openMainPage() {
        openSite();
    }

    @Test(dataProvider = "SignUpLocator")
    public static void checkSignUpElementsIsDisplay(By xpath) {
        clickInteractiveElement(SIGN_UP_BUTTON, SIGN_UP_STRING);
        assertTrue(isDisplay(xpath));
    }

    @Test
    public static void signUp(){
        clickInteractiveElement(SIGN_UP_BUTTON, SIGN_UP_STRING);

    }

    @AfterTest
    public static void exitBrowser() {
        browserQuit();
    }
}

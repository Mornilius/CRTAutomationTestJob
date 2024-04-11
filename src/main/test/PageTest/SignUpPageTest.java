package PageTest;

import Page.SignUpPage;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static Page.HomePage.SIGN_UP_BUTTON_LOCATOR;
import static Page.LoginPage.LOGIN_STRING_LOCATOR;
import static Page.SignUpPage.INPUT_EMAIL_FIELD_LOCATOR;
import static Page.SignUpPage.INPUT_NAME_FIELD_LOCATOR;
import static Page.SignUpPage.INPUT_PASSWORD_FIELD_LOCATOR;
import static Page.SignUpPage.SIGN_UP_STRING_LOCATOR;
import static Utils.DataUserConstants.USER_EMAIL;
import static Utils.DataUserConstants.USER_PASSWORD;
import static Utils.DefaultUsingMethods.browserQuit;
import static Utils.DefaultUsingMethods.clickInteractiveElement;
import static Utils.DefaultUsingMethods.isDisplay;
import static Utils.DefaultUsingMethods.isEnable;
import static Utils.DefaultUsingMethods.openSite;
import static Utils.DefaultUsingMethods.sendKeys;
import static org.testng.Assert.assertTrue;

public class SignUpPageTest {

    /**
     *
     * набор локаторов со страницы регистрации нового пользователя
     */
    @DataProvider(name = "SignUpLocator")
    public static Object[] arrayXpath() {
        return new Object[]{
                INPUT_EMAIL_FIELD_LOCATOR,
                INPUT_PASSWORD_FIELD_LOCATOR,
                INPUT_NAME_FIELD_LOCATOR,
                SIGN_UP_STRING_LOCATOR
        };
    }

    /**
     *
     *Данные для регистрации нового пользователя из класса DataUserConstants
     */
    @DataProvider(name = "userDataTest")
    public static Object[][] dataTestUser() {
        return new Object[][]{
                {USER_EMAIL, USER_PASSWORD}
        };
    }

    @BeforeClass
    public static void openMainPage() {
        openSite();
        clickInteractiveElement(SIGN_UP_BUTTON_LOCATOR, SIGN_UP_STRING_LOCATOR);
    }

    /**
     *
     * Проверка на то, что все элементы на странице отображены
     */
    @Test(dataProvider = "SignUpLocator", priority = 1)
    public static void checkSignUpElementsIsDisplay(By xpath) {
        assertTrue(isDisplay(xpath));
    }

    /**
     *
     * Проверка на то, что все элементы на странице активны - Enable
     */
    @Test(dataProvider = "SignUpLocator", priority = 2)
    public static void checkSignUpElementsIsEnable(By xpath) {
        assertTrue(isEnable(xpath));
    }

    /**
     *
     * Тестовый метод регистрации нового пользователя
     */
    @Test(dataProvider = "userDataTest", priority = 3)
    public static void signUp(String userEmail, String userPassword){
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

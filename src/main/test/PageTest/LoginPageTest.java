package PageTest;

import Page.HomePage;
import Page.LoginPage;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static Page.HomePage.LOGIN_BUTTON_LOCATOR;
import static Page.LoginPage.CHECKBOX_REMEMBER_ME_LOCATOR;
import static Page.LoginPage.INPUT_EMAIL_FIELD_LOCATOR;
import static Page.LoginPage.INPUT_PASSWORD_FIELD_LOCATOR;
import static Page.LoginPage.LOGIN_STRING_LOCATOR;
import static Page.ProfilePage.WELCOME_STRING_LOCATOR;
import static Utils.DataUserConstants.USER_EMAIL;
import static Utils.DataUserConstants.USER_PASSWORD;
import static Utils.DefaultUsingMethods.browserQuit;
import static Utils.DefaultUsingMethods.clickInteractiveElement;
import static Utils.DefaultUsingMethods.isDisplay;
import static Utils.DefaultUsingMethods.isEnable;
import static Utils.DefaultUsingMethods.openSite;
import static Utils.DefaultUsingMethods.sendKeys;
import static Utils.MassageConstants.NOT_ENABLE_MASSAGE;
import static Utils.MassageConstants.NOT_VISIBLE_MASSAGE;
import static org.testng.Assert.assertTrue;

public class LoginPageTest {

    /**
     *
     * набор локаторов со страницы авторизации пользователя
     */
    @DataProvider(name = "LoginPageXpath")
    public static Object[] arrayLoginPageXpath() {
        return new Object[]{
                LOGIN_STRING_LOCATOR,
                INPUT_EMAIL_FIELD_LOCATOR,
                INPUT_PASSWORD_FIELD_LOCATOR,
                CHECKBOX_REMEMBER_ME_LOCATOR,
                LOGIN_BUTTON_LOCATOR
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
        clickInteractiveElement(HomePage.LOGIN_BUTTON_LOCATOR, LOGIN_STRING_LOCATOR);
    }

    /**
     *
     * Проверка на то, что все элементы на странице активны - Enable
     */
    @Test(dataProvider = "LoginPageXpath", priority = 1)
    public static void checkElementsIsEnable(By xpath) {
        assertTrue(isEnable(xpath),NOT_ENABLE_MASSAGE);
    }

    /**
     *
     * Проверка на то, что все элементы на странице отображены
     */
    @Test(dataProvider = "LoginPageXpath", priority = 2)
    public static void checkElementsIsDisplay(By xpath) {
        assertTrue(isDisplay(xpath),NOT_VISIBLE_MASSAGE);
    }

    /**
     * Тестовый метод авторизации пользователя
     * @param userEmail
     * @param userPassword
     */
    @Test(dataProvider = "userDataTest", priority = 3)
    public static void LogIn(String userEmail, String userPassword) {
        sendKeys(INPUT_EMAIL_FIELD_LOCATOR, userEmail);
        sendKeys(INPUT_PASSWORD_FIELD_LOCATOR, userPassword);
        clickInteractiveElement(LoginPage.LOGIN_BUTTON_LOCATOR, WELCOME_STRING_LOCATOR);

        assertTrue(isDisplay(WELCOME_STRING_LOCATOR),NOT_VISIBLE_MASSAGE);
    }

    @AfterTest
    public static void exitBrowser() {
        browserQuit();
    }
}
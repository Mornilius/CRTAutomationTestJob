package PageTest;

import Page.LoginPage;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static Page.HomePage.HEAD_LOGIN_BUTTON_LOCATOR;
import static Page.LoginPage.CHECKBOX_REMEMBER_ME_LOCATOR;
import static Page.LoginPage.INPUT_EMAIL_FIELD_LOCATOR;
import static Page.LoginPage.INPUT_PASSWORD_FIELD_LOCATOR;
import static Page.LoginPage.LOGIN_TEXT_LOCATOR;
import static Page.ProfilePage.WELCOME_TEXT_LOCATOR;
import static Utils.DataUserConstants.USER2_EMAIL;
import static Utils.DataUserConstants.USER2_PASSWORD;
import static Utils.DataUserConstants.USER_EMAIL;
import static Utils.DataUserConstants.USER_PASSWORD;
import static Utils.DefaultUsingMethods.JSClick;
import static Utils.DefaultUsingMethods.browserClose;
import static Utils.DefaultUsingMethods.browserQuit;
import static Utils.DefaultUsingMethods.clickInteractiveElement;
import static Utils.DefaultUsingMethods.elementIsSelected;
import static Utils.DefaultUsingMethods.isDisplay;
import static Utils.DefaultUsingMethods.isEnable;
import static Utils.DefaultUsingMethods.openSite;
import static Utils.DefaultUsingMethods.sendKeys;
import static Utils.MassageConstants.NOT_ENABLE_MASSAGE;
import static Utils.MassageConstants.NOT_VISIBLE_MASSAGE;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class LoginPageTest {

    @BeforeMethod
    public static void openMainPage() throws InterruptedException {
        openSite();
        clickInteractiveElement(HEAD_LOGIN_BUTTON_LOCATOR, LOGIN_TEXT_LOCATOR);
    }

    /**
     *
     * Проверка на то, что все элементы на странице кликабильны
     */
    @Test(dataProvider = "LoginPageLocators", priority = 1)
    public static void checkElementsIsEnable(By xpath) {
        assertTrue(isEnable(xpath), NOT_ENABLE_MASSAGE);
    }

    /**
     * Проверка корректной работы чекбокса
     */
    @Test
    public static void checkElementIsSelected(){
        assertFalse(elementIsSelected(CHECKBOX_REMEMBER_ME_LOCATOR));

        JSClick(CHECKBOX_REMEMBER_ME_LOCATOR);

        assertTrue(elementIsSelected(CHECKBOX_REMEMBER_ME_LOCATOR));
    }

    /**
     *
     * Проверка на то, что все элементы на странице отображены
     */
    @Test(dataProvider = "LoginPageLocators", priority = 2)
    public static void checkElementsIsDisplay(By xpath) {
        assertTrue(isDisplay(xpath), NOT_VISIBLE_MASSAGE);
    }

    /**
     * Тестовый метод авторизации пользователя
     * @param userEmail
     * @param userPassword
     */
    @Test(dataProvider = "userDataTest")
    public static void LogIn(String userEmail, String userPassword) {
        sendKeys(INPUT_EMAIL_FIELD_LOCATOR, userEmail);
        sendKeys(INPUT_PASSWORD_FIELD_LOCATOR, userPassword);
        clickInteractiveElement(LoginPage.LOGIN_BUTTON_LOCATOR, WELCOME_TEXT_LOCATOR);

        assertTrue(isDisplay(WELCOME_TEXT_LOCATOR), NOT_VISIBLE_MASSAGE);
    }

    @AfterMethod
    public static void driverQuit() {
        browserQuit();
    }

    /**
     *
     * набор локаторов со страницы авторизации пользователя
     */
    @DataProvider(name = "LoginPageLocators")
    public static Object[] arrayLoginPageXpath() {
        return new Object[]{
                LOGIN_TEXT_LOCATOR,
                INPUT_EMAIL_FIELD_LOCATOR,
                INPUT_PASSWORD_FIELD_LOCATOR,
                CHECKBOX_REMEMBER_ME_LOCATOR,
                HEAD_LOGIN_BUTTON_LOCATOR
        };
    }

    /**
     *
     *Данные для регистрации нового пользователя из класса DataUserConstants
     */
    @DataProvider(name = "userDataTest")
    public static Object[][] dataTestUser() {
        return new Object[][]{
                {USER_EMAIL, USER_PASSWORD},
                {USER2_EMAIL, USER2_PASSWORD}
        };
    }
}
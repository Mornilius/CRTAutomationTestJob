package PageTest;

import Page.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static Page.HomePage.HEAD_LOGIN_BUTTON_LOCATOR;
import static Page.LoginPage.CHECKBOX_REMEMBER_ME_LOCATOR;
import static Page.LoginPage.ERROR_TEXT_LOCATOR;
import static Page.LoginPage.INPUT_EMAIL_FIELD_LOCATOR;
import static Page.LoginPage.INPUT_PASSWORD_FIELD_LOCATOR;
import static Page.LoginPage.LOGIN_TEXT_LOCATOR;
import static Page.ProfilePage.WELCOME_TEXT_LOCATOR;
import static Utils.DataUserConstants.USER2_EMAIL;
import static Utils.DataUserConstants.USER2_PASSWORD;
import static Utils.DataUserConstants.USER_EMAIL;
import static Utils.DataUserConstants.USER_PASSWORD;
import static Utils.DefaultUsingMethods.JSClick;
import static Utils.DefaultUsingMethods.browserQuit;
import static Utils.DefaultUsingMethods.clickInteractiveElement;
import static Utils.DefaultUsingMethods.elementIsSelected;
import static Utils.DefaultUsingMethods.isDisplay;
import static Utils.DefaultUsingMethods.openSite;
import static Utils.DefaultUsingMethods.sendKeys;
import static Utils.MassageConstants.NOT_SELECT_MASSAGE;
import static Utils.MassageConstants.NOT_VISIBLE_MASSAGE;
import static Utils.MassageConstants.SELECT_MASSAGE;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class LoginPageTest {

    @BeforeMethod
    public static void openMainPage() throws InterruptedException {
        openSite();
        clickInteractiveElement(HEAD_LOGIN_BUTTON_LOCATOR, LOGIN_TEXT_LOCATOR);
    }

    /**
     * Проверка корректной работы чекбокса
     */
    @Test
    public static void checkElementIsSelecting() {
        assertFalse(elementIsSelected(CHECKBOX_REMEMBER_ME_LOCATOR), SELECT_MASSAGE);

        JSClick(CHECKBOX_REMEMBER_ME_LOCATOR);

        assertTrue(elementIsSelected(CHECKBOX_REMEMBER_ME_LOCATOR), NOT_SELECT_MASSAGE);
    }

    /**
     *
     * Проверка на то, что все элементы на странице отображены
     */
    @Test(dataProvider = "LoginPageLocators")
    public static void checkElementsIsDisplay(By xpath) {
        assertTrue(isDisplay(xpath), NOT_VISIBLE_MASSAGE);
    }

    /**
     * Тестовый метод авторизации пользователя, с разными тестовыми данными (позитивными и негативными)
     * @param userEmail
     * @param userPassword
     */
    @Test(dataProvider = "userDataTest")
    public static void LogIn(String userEmail, String userPassword) {
        boolean loginTrue;
        try {
            sendKeys(INPUT_EMAIL_FIELD_LOCATOR, userEmail);
            sendKeys(INPUT_PASSWORD_FIELD_LOCATOR, userPassword);
            clickInteractiveElement(LoginPage.LOGIN_BUTTON_LOCATOR, WELCOME_TEXT_LOCATOR);
            isDisplay(WELCOME_TEXT_LOCATOR);
            loginTrue = true;
        }catch(TimeoutException e) {
            isDisplay(ERROR_TEXT_LOCATOR);
            loginTrue = false;
        }

        if (loginTrue) {
            assertTrue(isDisplay(WELCOME_TEXT_LOCATOR), NOT_VISIBLE_MASSAGE);
        }else {
            assertTrue(isDisplay(ERROR_TEXT_LOCATOR), NOT_VISIBLE_MASSAGE);
        }
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
     *Данные для авторизации пользователя(ей) из класса DataUserConstants(позитивные + негативные)
     */
    @DataProvider(name = "userDataTest")
    public static Object[][] dataTestUser() {
        return new Object[][]{
                {USER_EMAIL, USER_PASSWORD},
                {USER2_EMAIL, USER2_PASSWORD}
        };
    }
}
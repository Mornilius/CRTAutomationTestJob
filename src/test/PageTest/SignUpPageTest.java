package PageTest;

import Page.SignUpPage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static Page.HomePage.HEAD_SIGN_UP_BUTTON_LOCATOR;
import static Page.LoginPage.LOGIN_TEXT_LOCATOR;
import static Page.SignUpPage.ERROR_SIGN_UP_TEXT_LOCATOR;
import static Page.SignUpPage.INPUT_EMAIL_FIELD_LOCATOR;
import static Page.SignUpPage.INPUT_NAME_FIELD_LOCATOR;
import static Page.SignUpPage.INPUT_PASSWORD_FIELD_LOCATOR;
import static Page.SignUpPage.SIGN_UP_TEXT_LOCATOR;
import static Utils.DataUserConstants.USER2_EMAIL;
import static Utils.DataUserConstants.USER2_PASSWORD;
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

public class SignUpPageTest {

    @BeforeMethod
    public static void openMainPage() {
        openSite();
        clickInteractiveElement(HEAD_SIGN_UP_BUTTON_LOCATOR, SIGN_UP_TEXT_LOCATOR);
    }

    /**
     *
     * Проверка на то, что элементы на странице отображены
     */
    @Test(dataProvider = "SignUpLocators")
    public static void checkSignUpElementsIsDisplay(By xpath) {
        assertTrue(isDisplay(xpath), NOT_VISIBLE_MASSAGE);
    }

    /**
     *
     * Тестовый метод регистрации нового пользователя
     */
    @Test(dataProvider = "userDataTest")
    public static void signUp(String userName, String userPassword) {
        try {
            sendKeys(INPUT_EMAIL_FIELD_LOCATOR, userName);
            sendKeys(INPUT_PASSWORD_FIELD_LOCATOR, userPassword);
            clickInteractiveElement(SignUpPage.SIGN_UP_BUTTON_LOCATOR, LOGIN_TEXT_LOCATOR);

            assertTrue(isDisplay(LOGIN_TEXT_LOCATOR), NOT_VISIBLE_MASSAGE);
        }catch(TimeoutException e) {
            assertTrue(isDisplay(ERROR_SIGN_UP_TEXT_LOCATOR), NOT_VISIBLE_MASSAGE);
        }
    }

    @AfterMethod
    public static void exitBrowser() {
        browserQuit();
    }

    /**
     *
     * набор локаторов со страницы регистрации нового пользователя
     */
    @DataProvider(name = "SignUpLocators")
    public static Object[] arrayXpath() {
        return new Object[]{
                INPUT_EMAIL_FIELD_LOCATOR,
                INPUT_PASSWORD_FIELD_LOCATOR,
                INPUT_NAME_FIELD_LOCATOR,
                SIGN_UP_TEXT_LOCATOR
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
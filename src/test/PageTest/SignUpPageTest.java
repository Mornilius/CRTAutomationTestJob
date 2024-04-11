package PageTest;

import Page.SignUpPage;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static Page.HomePage.HEAD_SIGN_UP_BUTTON_LOCATOR;
import static Page.LoginPage.LOGIN_TEXT_LOCATOR;
import static Page.SignUpPage.INPUT_EMAIL_FIELD_LOCATOR;
import static Page.SignUpPage.INPUT_NAME_FIELD_LOCATOR;
import static Page.SignUpPage.INPUT_PASSWORD_FIELD_LOCATOR;
import static Page.SignUpPage.SIGN_UP_TEXT_LOCATOR;
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

    @BeforeClass
    public static void openMainPage() {
        openSite();
        clickInteractiveElement(HEAD_SIGN_UP_BUTTON_LOCATOR, SIGN_UP_TEXT_LOCATOR);
    }

    /**
     *
     * Проверка на то, что все элементы на странице отображены
     */
    @Test(dataProvider = "SignUpLocators", priority = 1)
    public static void checkSignUpElementsIsDisplay(By xpath) {
        assertTrue(isDisplay(xpath), NOT_VISIBLE_MASSAGE);
    }

    /**
     *
     * Проверка на то, что все элементы на странице активны - Enable
     */
    @Test(dataProvider = "SignUpLocators", priority = 2)
    public static void checkSignUpElementsIsEnable(By xpath) {
        assertTrue(isEnable(xpath), NOT_ENABLE_MASSAGE);
    }

    /**
     *
     * Тестовый метод регистрации нового пользователя
     */
    @Test(dataProvider = "userDataTest", priority = 3)
    public static void signUp() {
        sendKeys(INPUT_EMAIL_FIELD_LOCATOR, USER_EMAIL);
        sendKeys(INPUT_PASSWORD_FIELD_LOCATOR, USER_PASSWORD);
        clickInteractiveElement(SignUpPage.SIGN_UP_BUTTON_LOCATOR, LOGIN_TEXT_LOCATOR);

        assertTrue(isDisplay(LOGIN_TEXT_LOCATOR), NOT_VISIBLE_MASSAGE);
    }

    @AfterTest
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
}
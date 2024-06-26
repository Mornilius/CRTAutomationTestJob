package Page;

import org.openqa.selenium.By;

import static Page.LoginPage.INPUT_FIELD;

public class SignUpPage {

    public static final By INPUT_EMAIL_FIELD_LOCATOR = By.xpath(String.format(INPUT_FIELD, "email"));
    public static final By INPUT_PASSWORD_FIELD_LOCATOR = By.xpath(String.format(INPUT_FIELD, "password"));
    public static final By INPUT_NAME_FIELD_LOCATOR = By.xpath(String.format(INPUT_FIELD, "text"));
    public static final By SIGN_UP_TEXT_LOCATOR = By.xpath("//h3[normalize-space(text())='Sign Up']");
    public static final By SIGN_UP_BUTTON_LOCATOR = By.xpath("//button[normalize-space(text())='Sign Up']");
    public static final By ERROR_SIGN_UP_TEXT_LOCATOR = By.xpath("//div[@class='notification is-danger']");
}
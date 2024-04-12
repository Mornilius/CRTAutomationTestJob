package Page;

import org.openqa.selenium.By;

public class LoginPage {

    public static final String INPUT_FIELD = "//input[@type='%s']";
    public static final By INPUT_EMAIL_FIELD_LOCATOR = By.xpath(String.format(INPUT_FIELD, "email"));
    public static final By INPUT_PASSWORD_FIELD_LOCATOR = By.xpath(String.format(INPUT_FIELD, "password"));
    public static final By CHECKBOX_REMEMBER_ME_LOCATOR = By.xpath(String.format(INPUT_FIELD, "checkbox"));
    public static final By LOGIN_BUTTON_LOCATOR = By.xpath("//button[normalize-space(text())='Login']");
    public static final By LOGIN_TEXT_LOCATOR = By.xpath("//h3[normalize-space(text())='Login']");
    public static final By ERROR_TEXT_LOCATOR = By.xpath("//div[@class='notification is-danger']");
}
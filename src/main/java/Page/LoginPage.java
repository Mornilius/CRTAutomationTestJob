package Page;

import org.openqa.selenium.By;

public class LoginPage {

    public static final String INPUT_FIELD = "//input[@type='%s']";
    public static final By INPUT_EMAIL_FIELD = By.xpath(String.format(INPUT_FIELD, "email"));
    public static final By INPUT_PASSWORD_FIELD = By.xpath(String.format(INPUT_FIELD, "password"));
    public static final By CHECKBOX_REMEMBER_ME = By.xpath(String.format(INPUT_FIELD, "checkbox"));
    public static final By LOGIN_BUTTON = By.xpath("//button[normalize-space(text())='Login']");
    public static final By LOGIN_STRING = By.xpath("//h3[normalize-space(text())='Login']");

}

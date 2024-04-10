package Page;

import org.openqa.selenium.By;
import static Page.LoginPage.INPUT_FIELD;

public class SignUpPage {

    public static final By INPUT_EMAIL_FIELD = By.xpath(String.format(INPUT_FIELD, "email"));
    public static final By INPUT_PASSWORD_FIELD = By.xpath(String.format(INPUT_FIELD, "password"));
    public static final By INPUT_NAME_FIELD = By.xpath(String.format(INPUT_FIELD, "text"));
    public static final By SIGN_UP_STRING = By.xpath("//h3[normalize-space(text())='Sign Up']");
}

package Page;

import org.openqa.selenium.By;

public class HomePage {

    public static final String HOME_HEAD = "//a[normalize-space(text())='%s']";
    public static final By HEAD_HOME_BUTTON_LOCATOR = By.xpath(String.format(HOME_HEAD, "Home"));
    public static final By HEAD_LOGIN_BUTTON_LOCATOR = By.xpath(String.format(HOME_HEAD, "Login"));
    public static final By HEAD_SIGN_UP_BUTTON_LOCATOR = By.xpath(String.format(HOME_HEAD, "Sign Up"));
    public static final By HOME_TEXT_LOCATOR = By.xpath("//h1[normalize-space(text())='Test home page']");
}
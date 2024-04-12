package Page;

import org.openqa.selenium.By;

public class ProfilePage {

    public static final String HOME_HEAD = "//a[normalize-space(text())='%s']";
    public static final By HOME_BUTTON_LOCATOR = By.xpath(String.format(HOME_HEAD, "Home"));
    public static final By PROFILE_BUTTON_LOCATOR = By.xpath(String.format(HOME_HEAD, "Profile"));
    public static final By LOGOUT_BUTTON_LOCATOR = By.xpath(String.format(HOME_HEAD, "Logout"));
    public static final By WELCOME_TEXT_LOCATOR = By.xpath("//h1[contains(text(), 'Welcome')]");
}
package Page;

import org.openqa.selenium.By;

public class HomePage {

    public static final By HOME_STRING = By.xpath("//h1[normalize-space(text())='Test home page']");
    public static final By HOME_BUTTON = By.xpath("//a[normalize-space(text())='Home']");
    public static final By LOGIN_BUTTON = By.xpath("//a[normalize-space(text())='Login']");
    public static final By SIGN_UP_BUTTON = By.xpath("//a[normalize-space(text())='Sign Up']");
}

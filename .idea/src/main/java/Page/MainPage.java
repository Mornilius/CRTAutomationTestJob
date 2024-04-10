package Page;

import org.openqa.selenium.By;

public class MainPage {

    public static final String USER_PANEL = "//div[contains(@class,'css-1cs774w e10bp8150')]//*[normalize-space(text())='%s']";

    public static final By LOGO_LOCATOR = By.xpath("//div[contains(@class,'fresnel-container fresnel-greaterThanOrEqual-tabletL ')]//div[contains(@data-meta-name,'Logo')]");
    public static final By CATALOG_LOCATOR = By.xpath("//a[contains(@data-meta-name,'DesktopHeaderFixed__catalog-menu')]//*[text()='Каталог товаров']");
    public static final By FIND_PRODUCT_LOCATOR = By.xpath("//div[contains(@data-meta-name,'HeaderBottom__search')]//input[contains(@type,'search')]");
    public static final By INPUT_ACCOUNT_LOCATOR = By.xpath(String.format(USER_PANEL, "Войти"));
    public static final By FAVORITES_LOCATOR = By.xpath(String.format(USER_PANEL, "Избранное"));
    public static final By COMPARE_LOCATOR = By.xpath(String.format(USER_PANEL, "Сравнение"));
    public static final By SHOPPING_CART_LOCATOR = By.xpath(String.format(USER_PANEL, "Корзина"));
    public static final By FEEDBACK_LOCATOR = By.xpath("//span[text()='Обратная связь']");
    public static final By SHOPS_LOCATOR = By.xpath("//span[text()='Магазины']");
    public static final By DELIVERY_LOCATOR = By.xpath("//span[text()='Доставка']");
    public static final By CONFIG_LOCATOR = By.xpath("//span[text()='Конфигуратор']");
    public static final By SALES_LOCATOR = By.xpath("//span[text()='Акции']");
    public static final By MAGAZINE_LOCATOR = By.xpath("//span[text()='Журнал']");
    public static final By SEARCH_RESULT_LOCATOR = By.xpath("//div[contains(@class, 'app-catalog-dyg8ga ev21ige0')]");
    public static final By ADD_BUTTON_LOCATOR = By.xpath("//button[contains(@data-meta-name, 'Snippet__cart-button')]");
    public static final By PRODUCT_DESCRIPTION_LOCATOR = By.xpath("//*[contains(text(),'Смартфон Apple iPhone 13 128Gb,  A2633,  темная ночь')]");
    public static final By CHECKPOINT_AFTER_SEARCH_LOCATOR = By.xpath("//div[contains(@data-meta-name,'ProductListLayout')]");
    public static final By SNIPPET_PRODUCT_VERTICAL_LAYOUT = By.xpath("(//div[contains(@data-meta-name, 'SnippetProductVerticalLayout')])");
}
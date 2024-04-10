package Page;

import org.openqa.selenium.By;

import java.util.List;

public class CatalogMenuPhoneAndGadgetsPage {

    public static final List<String> PRODUCT_LIST_PHONE_CHAPTER = List.of("[Смартфоны, Премиум смартфоны, APPLE iPhone, Смартфоны HUAWEI, Смартфоны SAMSUNG, Смартфоны XIAOMI, Смартфоны REALME, Смартфоны HONOR, Смартфоны INFINIX, Смартфоны TECNO, Недорогие смартфоны, Смартфоны на Android]");
    public static final String PRODUCT_GROUP = "//div[contains(@data-meta-name, 'CatalogMenuDesktopLayout__body')]//*[normalize-space(text())='%s']";

    public static final By LOGO_SMARTPHONE_AND_GADGETS_LOCATOR = By.xpath("//a[contains(@data-meta-name,'DesktopMenu__category--title')]//*[contains(text(),'Смартфоны и гаджеты')]");
    public static final By SMARTPHONE_LOCATOR = By.xpath(String.format(PRODUCT_GROUP, "Смартфоны"));
    public static final By ACCESSORIES_FOR_TABLET_LOCATOR = By.xpath(String.format(PRODUCT_GROUP, "Аксессуары для планшетов"));
    public static final By EARPHONE_LOCATOR = By.xpath(String.format(PRODUCT_GROUP, "Наушники"));
    public static final By CELLPHONE_LOCATOR = By.xpath(String.format(PRODUCT_GROUP, "Сотовые телефоны"));
    public static final By ACCESSORIES_FOR_SMARTPHONE_LOCATOR = By.xpath(String.format(PRODUCT_GROUP, "Аксессуары для смартфонов"));
    public static final By CABLE_FOR_SMARTPHONE_LOCATOR = By.xpath(String.format(PRODUCT_GROUP, "Кабели для смартфонов и планшетов"));
    public static final By POWERBANK_LOCATOR = By.xpath(String.format(PRODUCT_GROUP, "Power bank"));
    public static final By GADGETS_LOCATOR = By.xpath(String.format(PRODUCT_GROUP, "Гаджеты"));
    public static final By EBOOK_LOCATOR = By.xpath(String.format(PRODUCT_GROUP, "Электронные книги и аксессуары"));
    public static final By PHONE_CONTAINER_LOCATOR = By.xpath("(//div[contains(@class, 'css-1xb55jt e1ko8f5e0')])[1]");
}
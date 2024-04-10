package Page;

import org.openqa.selenium.By;

import static Utils.DriverUtils.driver;

public class CatalogOfProductPage {

    public static final String CATEGORY_MENU = "//div[contains(@data-meta-name,'CatalogMenuDesktopLayout__menu')]//*[normalize-space(text())='%s']";

    public static final By CATALOG_TITLE_LOCATOR = By.xpath("//div[contains(@data-meta-name,'CatalogMenuDesktopLayout__title')]");
    public static final By FIND_PRODUCT_LOCATOR = By.xpath("//div[@data-meta-name='CatalogMenuDesktopLayout__search']//input[@placeholder='Поиск по товарам']");
    public static final By CLOSE_BUTTON_LOCATOR = By.xpath("//div[contains(@data-meta-name,'CatalogMenuDesktopLayout__close')]");
    public static final By SMARTPHONE_AND_GADGETS_LOCATOR = By.xpath(String.format(CATEGORY_MENU,"Смартфоны и планшеты"));
    public static final By LAPTOPS_AND_PC_LOCATOR = By.xpath(String.format(CATEGORY_MENU,"Ноутбуки и компьютеры"));
    public static final By TV_AUDIO_VIDEO_PHOTO_LOCATOR = By.xpath(String.format(CATEGORY_MENU,"Телевизоры, аудио-видео техника"));
    public static final By GAMING_LOCATOR = By.xpath(String.format(CATEGORY_MENU,"Товары для геймеров"));
    public static final By HOME_APPLIANCES_LOCATOR = By.xpath(String.format(CATEGORY_MENU,"Бытовая техника"));
    public static final By BEAUTY_AND_HEALTH_LOCATOR = By.xpath(String.format(CATEGORY_MENU,"Красота и здоровье"));
    public static final By SMARTHOME_AND_GUARD_SYSTEM_LOCATOR = By.xpath(String.format(CATEGORY_MENU,"Умный дом и системы безопасности"));
    public static final By OFFICE_EQUIPMENTS_AND_FURNITURE_LOCATOR = By.xpath(String.format(CATEGORY_MENU,"Офисная техника и мебель"));
    public static final By OFFICE_SUPPLIES_LOCATOR = By.xpath(String.format(CATEGORY_MENU,"Канцтовары"));
    public static final By CONSTRUCTION_AND_RENOVATION_LOCATOR = By.xpath(String.format(CATEGORY_MENU,"Строительство и ремонт"));
    public static final By HOME_AUTO_LOCATOR = By.xpath(String.format(CATEGORY_MENU,"Дом, дача и авто"));
    public static final By SALES_PRODUCTS_LOCATOR = By.xpath(String.format(CATEGORY_MENU,"Уцененные товары"));
    public static final By GIFT_LOCATOR = By.xpath(String.format(CATEGORY_MENU,"Подарочные сертификаты"));
    public static final By SERVICE_LOCATOR = By.xpath(String.format(CATEGORY_MENU,"Сервисы и услуги"));
}
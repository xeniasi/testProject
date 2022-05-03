package org.example.homework5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Tests {

    static WebDriver driver;

    @BeforeAll
    static void init(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @BeforeEach
    void getPage(){
        driver.get("https://magazintrav.ru/");
    }

    @Test
    void addingToCartTest() throws InterruptedException {
        WebElement clickingNavMenuItem = driver.findElement(By.xpath(".//nav//li[@class='catalog_product']"));
        clickingNavMenuItem.click();

        WebElement selectionItem = driver.findElement(By.xpath(".//nav//a[@href='novinki']"));
        selectionItem.click();

        WebElement addingToCart = driver.findElement(By.xpath(".//li[1]//button[@value='cart/add']"));
        addingToCart.click();

        WebElement closingPopUp = driver.findElement(By.xpath(".//div[@id='add_cart']//span[@class='modal_close']"));
        closingPopUp.click();

        WebElement openingCart = driver.findElement(By.id("msMiniCart"));
        openingCart.click();
        Thread.sleep(3000);

        Assertions.assertEquals("https://magazintrav.ru/checkout",driver.getCurrentUrl(),"Wrong page opened");
    }

    @Test
    void searchAndFilterTest() throws InterruptedException {
        WebElement searchField = driver.findElement(By.xpath(".//div[@class='head']//input[@type='search']"));
        searchField.click();
        searchField.sendKeys("витамин д");

        WebElement seeResults = driver.findElement(By.xpath(".//button[contains(text(), 'Смотреть все результаты')]"));
        seeResults.click();
        Thread.sleep(5000);

        WebElement filterByBrand = driver.findElement(By.xpath(".//div[3]/ul/li[1]/label/span[1]"));
        filterByBrand.click();
        Thread.sleep(5000);
    }

    @Test
    void addingToFavoritesTest() throws InterruptedException {
        WebElement clickingNavMenuItem = driver.findElement(By.xpath(".//nav//li[@class='catalog_product']"));
        clickingNavMenuItem.click();

        WebElement selectionItem = driver.findElement(By.xpath(".//nav//a[@href='novinki']"));
        selectionItem.click();

        WebElement addingToFavorites = driver.findElement(By.xpath(".//li[1]//i[@title=\"В избранное\"]"));
        addingToFavorites.click();

        WebElement clickingNavMenuFavorites = driver.findElement(By.xpath(".//nav//li[@class='top_menu__favorite']"));
        clickingNavMenuFavorites.click();

        Assertions.assertEquals("https://magazintrav.ru/izbrannoe",driver.getCurrentUrl(),"Wrong page opened");
    }

    @Test
    void questionsAndAnswersPageTest() throws InterruptedException {
        WebElement clickingNavMenuHelp = driver.findElement(By.xpath(".//nav//li[@class='about_company'][1]"));
        clickingNavMenuHelp.click();

        WebElement selectionItem = driver.findElement(By.xpath(".//nav//a[@href='faq']"));
        selectionItem.click();

        WebElement clickingQuestion = driver.findElement(By.xpath(".//div[@class=\"box_faq\"][1]"));
        clickingQuestion.click();
        Thread.sleep(5000);

        Assertions.assertEquals("https://magazintrav.ru/faq",driver.getCurrentUrl(),"Wrong page opened");
    }

    @Test
    void removingFromCartTest() throws InterruptedException {
        WebElement clickingNavMenuItem = driver.findElement(By.xpath(".//nav//li[@class='catalog_product']"));
        clickingNavMenuItem.click();

        WebElement selectionItem = driver.findElement(By.xpath(".//nav//a[@href='novinki']"));
        selectionItem.click();

        WebElement addingToCart = driver.findElement(By.xpath(".//li[1]//button[@value='cart/add']"));
        addingToCart.click();

        WebElement closingPopUp = driver.findElement(By.xpath(".//div[@id='add_cart']//span[@class='modal_close']"));
        closingPopUp.click();

        WebElement openingCart = driver.findElement(By.id("msMiniCart"));
        openingCart.click();
        Thread.sleep(3000);

        Assertions.assertEquals("https://magazintrav.ru/checkout",driver.getCurrentUrl(),"Wrong page opened");

        WebElement removingItem = driver.findElement(By.xpath(".//button[@value='cart/remove'][1]"));
        removingItem.click();
        Thread.sleep(3000);

        Assertions.assertEquals("https://magazintrav.ru/checkout",driver.getCurrentUrl(),"Wrong page opened");
    }

    @Test
    void openingDiseasesTest() throws InterruptedException {
        WebElement clickingNavMenuDisease = driver.findElement(By.xpath(".//nav//li[@class='disease'][1]"));
        clickingNavMenuDisease.click();

        WebElement selectionItem = driver.findElement(By.xpath(".//nav//div[@class='subitem-letters']//a[contains(text(), 'С')]"));
        selectionItem.click();
        Thread.sleep(5000);

        Assertions.assertEquals("https://magazintrav.ru/po-zabolevanijam#letter%D0%A1",driver.getCurrentUrl(),"Wrong page opened");
    }

    @AfterAll
    static void close(){
        driver.quit();
    }

}

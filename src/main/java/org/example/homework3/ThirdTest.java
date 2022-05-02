package org.example.homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ThirdTest {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://magazintrav.ru/");

        WebElement clickingNavMenuItem = driver.findElement(By.xpath(".//nav//li[@class='catalog_product']"));
        clickingNavMenuItem.click();

        WebElement selectionItem = driver.findElement(By.xpath(".//nav//a[@href='novinki']"));
        selectionItem.click();

        WebElement addingToFavorites = driver.findElement(By.xpath(".//li[1]//i[@title=\"В избранное\"]"));
        addingToFavorites.click();

        WebElement clickingNavMenuFavorites = driver.findElement(By.xpath(".//nav//li[@class='top_menu__favorite']"));
        clickingNavMenuFavorites.click();

        driver.quit();

    }

}

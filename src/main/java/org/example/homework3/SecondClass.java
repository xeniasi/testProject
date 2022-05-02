package org.example.homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class SecondClass {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://magazintrav.ru/");

        WebElement searchField = driver.findElement(By.xpath(".//div[@class='head']//input[@type='search']"));
        searchField.click();
        searchField.sendKeys("витамин д");

        WebElement seeResults = driver.findElement(By.xpath(".//button[contains(text(), 'Смотреть все результаты')]"));
        seeResults.click();
        Thread.sleep(5000);

        WebElement filterByBrand = driver.findElement(By.xpath(".//div[3]/ul/li[1]/label/span[1]"));
        filterByBrand.click();
        Thread.sleep(5000);

        driver.quit();
    }

}

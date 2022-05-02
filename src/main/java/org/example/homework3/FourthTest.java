package org.example.homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class FourthTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://magazintrav.ru/");

        WebElement clickingNavMenuHelp = driver.findElement(By.xpath(".//nav//li[@class='about_company'][1]"));
        clickingNavMenuHelp.click();

        WebElement selectionItem = driver.findElement(By.xpath(".//nav//a[@href='faq']"));
        selectionItem.click();

        WebElement clickingQuestion = driver.findElement(By.xpath(".//div[@class=\"box_faq\"][1]"));
        clickingQuestion.click();
        Thread.sleep(5000);

        driver.quit();

    }

}

package lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class Schedule {

    static WebDriver driver;

    @BeforeAll
    static void init(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }
    @BeforeEach
    void getPage(){
            Assertions.assertDoesNotThrow( ()-> driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login"),
                    "Страница не доступна");
        }



    @Test
    void test() throws InterruptedException {

        WebElement webElement1 = driver.findElement(By.xpath("//button[contains(.,'Customer Login')]"));
        webElement1.click();
        Thread.sleep(10000l);
        WebElement webElement2 = driver.findElement(By.xpath("//select[@id='userSelect']"));
        webElement2.click();
        WebElement webElement3 = driver.findElement(By.xpath("//*[@id=\"userSelect\"]/option[3]"));
        webElement3.click();
        WebElement webElement4 = driver.findElement(By.xpath("//button[@type='submit']"));
        webElement4.click();






    }
    @AfterAll
    static void close(){

        driver.quit();
    }
}

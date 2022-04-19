package Lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Transactions {
    public static void main(String[] args) throws InterruptedException {



        WebDriverManager.chromedriver().setup();//установка драйвера
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");//размер

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // ожидание

        //driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer");


        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");


        //найти все элементы
        WebElement webElement1 = driver.findElement(By.xpath("//button[contains(.,'Customer Login')]"));

//регестрация
        WebElement webElement2 = driver.findElement(By.xpath("//select[@id='userSelect']"));
        WebElement webElement3 = driver.findElement(By.xpath("//*[@id=\"userSelect\"]/option[3]"));
        WebElement webElement4 = driver.findElement(By.xpath("//button[@type='submit']"));
//депозит
        WebElement webElement5 = driver.findElement(By.xpath("//button[contains(.,'Deposit')]"));
        WebElement webElement6 = driver.findElement(By.xpath("//input[@type='number']"));

        WebElement webElement7 = driver.findElement(By.xpath("//input[@type='number']"));
        WebElement webElement8 = driver.findElement(By.xpath("//button[@value='']"));


        //вывод

        WebElement webElement9 = driver.findElement(By.xpath("//input[@type='number']"));
        WebElement webElement10 = driver.findElement(By.xpath("//button[@value='']"));

        //просмотр истории

        WebElement webElement11 = driver.findElement(By.xpath("//button[contains(.,'Transactions')]"));



        try {
            WebElement webElementError = driver.findElement(By.xpath("//*[@id=\"userSelect\"]/option[3]"));
        } catch (NoSuchElementException e){
            System.out.println(e.getSupportUrl());
        }




// клик по элемнетам
        webElement1.click();
        webElement2.click();

        webElement3.click();
        webElement4.click();

        webElement5.click();
        webElement7.sendKeys("100");
        webElement8.click();

        webElement9.click();
        webElement8.sendKeys("50");
        webElement10.click();
        webElement11.click();


        try {
            webElement3.click();
        } catch (StaleElementReferenceException e){
            System.out.println(e.getSupportUrl());
        }



        Thread.sleep(10000l);
        //driver.quit();


    }


}

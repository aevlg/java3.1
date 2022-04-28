package Lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Registration {
    public static void main(String[] args) throws InterruptedException {




        WebDriverManager.chromedriver().setup();//установка драйвера
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");//размер

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); // ожидание

        //driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer");

        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");


        //найти все элементы
        WebElement webElement1 = driver.findElement(By.xpath("//button[contains(.,'Customer Login')]"));
        webElement1.click();
        Thread.sleep(10000l);
        WebElement webElement2 = driver.findElement(By.xpath("//select[@id='userSelect']"));
        WebElement webElement3 = driver.findElement(By.xpath("//*[@id=\"userSelect\"]/option[3]"));
        WebElement webElement4 = driver.findElement(By.xpath("//button[@type='submit']"));

        try {
            WebElement webElement22 = driver.findElement(By.xpath("//select[@id='userSelect']"));
        } catch (NoSuchElementException e){
            System.out.println(e.getSupportUrl());
        }

        List<WebElement> webElements = driver.findElements(By.xpath("//select[@id='userSelect']"));
        if(webElements.size()>1){
            //todo
        }




// клик по элемнетам
        webElement1.click();
        webElement2.click();

        webElement3.click();
        webElement4.click();

        new WebDriverWait(driver, 5).until(ExpectedConditions
                .urlContains("Your Name :"));

        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer");

        try {
            webElement2.click();
        } catch (StaleElementReferenceException e){
            System.out.println(e.getSupportUrl());
        }

        try {
            driver.findElement(By.xpath(".//textarea")).click();
        } catch (ElementNotInteractableException e){
            System.out.println(e.getSupportUrl());
        }




        Thread.sleep(10000l);
        //driver.quit();









    }
}

package lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



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
    void getPage() throws InterruptedException {
        Assertions.assertDoesNotThrow( ()-> driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login"),
                    "Страница не доступна");
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



    @Test
    void Deposit() {
        WebElement webElement5 = driver.findElement(By.xpath("//button[contains(.,'Deposit')]"));
        webElement5.click();
        WebElement webElement6 = driver.findElement(By.xpath("//input[@type='number']"));
        webElement6.click();
        WebElement webElement7 = driver.findElement(By.xpath("//input[@type='number']"));
        webElement7.sendKeys("100");
        WebElement webElement8 = driver.findElement(By.xpath("//button[@value='']"));
        webElement8.click();
//        Assertions.assertEquals("сто",driver.getTitle(),"не корректно введеные данные");
    }
    @Test
    void Withdraw() {
        WebElement webElement11 = driver.findElement(By.xpath("//button[contains(.,'Withdrawl')]"));
        webElement11.click();
        WebElement webElement9 = driver.findElement(By.xpath("//input[@type='number']"));
        webElement9.click();
        webElement9.sendKeys("50");
        WebElement webElement10 = driver.findElement(By.xpath("//button[@value='']"));
        webElement10.click();
    }

    @Test
    void Transactions() {
        WebElement webElement11 = driver.findElement(By.xpath("//button[contains(.,'Transactions')]"));
        webElement11.click();
    }

    @Test
    void Logout(){
        WebElement webElement12 = driver.findElement(By.xpath("//button[contains(.,'Logout')]"));
        webElement12.click();

    }
    @Test
    void Select(){
        WebElement webElement13 = driver.findElement(By.xpath("//*[@id=\"accountSelect\"]"));
        webElement13.click();
        WebElement webElement14 = driver.findElement(By.xpath("//*[@id=\"accountSelect\"]/option[2]"));
        webElement14.click();
        WebElement webElement15 = driver.findElement(By.xpath("//button[contains(.,'Deposit')]"));
        webElement15.click();
        WebElement webElement16 = driver.findElement(By.xpath("//input[@type='number']"));
        webElement16.click();
        webElement16.sendKeys("100");
        WebElement webElement17 = driver.findElement(By.xpath("//button[@value='']"));
        webElement17.click();
        WebElement webElement18 = driver.findElement(By.xpath("//button[contains(.,'Transactions')]"));
        webElement18.click();
        WebElement webElement19 = driver.findElement(By.xpath("//button[contains(.,'Logout')]"));
        webElement19.click();


    }




    @AfterAll
    static void close(){

        driver.quit();
    }
}

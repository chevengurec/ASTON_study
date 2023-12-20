import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class OnlinePayTest {

    public static WebDriver driver;

    @BeforeAll
    public static void init() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mts.by");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void titleTest() {
        WebElement webElement = driver.findElement(By.className("pay"));
        assertTrue(webElement
                .getText()
                .contains("Онлайн пополнение\n" +
                        "без комиссии"));

    }

    @Test
    public void imageTest() {

        WebElement visa = driver.findElement(By.xpath("//img[@alt='Visa']"));
        assertTrue(visa.isDisplayed());

        WebElement verifiedByVisa = driver.findElement(By.xpath("//img[@alt='Verified By Visa']"));
        assertTrue(verifiedByVisa.isDisplayed());

        WebElement masterCard = driver.findElement(By.xpath("//img[@alt='MasterCard']"));
        assertTrue(masterCard.isDisplayed());

        WebElement belcard = driver.findElement(By.xpath("//img[@alt='Белкарт']"));
        assertTrue(belcard.isDisplayed());

        WebElement mir = driver.findElement(By.xpath("//img[@alt='МИР']"));
        assertTrue(mir.isDisplayed());

    }

    @Test
    public void linkTest() {
        WebElement link = driver.findElement(By.linkText("Подробнее о сервисе"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", link);
        String url = driver.getCurrentUrl();
        assertEquals(url, "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/");

    }

    @Test
    public void buttonAndFieldsTest() {
        WebElement numberInputField = driver.findElement(By.xpath("//input[@id='connection-phone']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", numberInputField);
        numberInputField.sendKeys("297777777");

        WebElement sumInputField = driver.findElement(By.xpath("//input[@id='connection-sum']"));
        sumInputField.click();
        sumInputField.sendKeys("100");

        WebElement contButton = driver.findElement(By.xpath("//button[contains(text(), 'Продолжить')]"));
        contButton.click();
    }

}

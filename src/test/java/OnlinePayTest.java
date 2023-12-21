import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OnlinePayTest {

    public static WebDriver driver;
    JavascriptExecutor js = (JavascriptExecutor) driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @BeforeAll
    public static void init() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mts.by");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testTextInFields() {

        WebElement connectionNumberInputField = driver.findElement(By.xpath("//input[@id='connection-phone']"));
        WebElement connectionSumInputField = driver.findElement(By.xpath("//input[@id='connection-sum']"));
        WebElement connectionEmailField = driver.findElement(By.xpath("//input[@id='connection-email']"));
        assertEquals("Номер телефона", connectionNumberInputField.getAttribute("placeholder"));
        assertEquals("Сумма", connectionSumInputField.getAttribute("placeholder"));
        assertEquals("E-mail для отправки чека", connectionEmailField.getAttribute("placeholder"));

        WebElement internetNumberInputField = driver.findElement(By.xpath("//input[@id='internet-phone']"));
        WebElement internetSumInputField = driver.findElement(By.xpath("//input[@id='internet-sum']"));
        WebElement internetEmailField = driver.findElement(By.xpath("//input[@id='internet-email']"));
        assertEquals("Номер абонента", internetNumberInputField.getAttribute("placeholder"));
        assertEquals("Сумма", internetSumInputField.getAttribute("placeholder"));
        assertEquals("E-mail для отправки чека", internetEmailField.getAttribute("placeholder"));

        WebElement instalmentNumberInputField = driver.findElement(By.xpath("//input[@id='score-instalment']"));
        WebElement instalmentSumInputField = driver.findElement(By.xpath("//input[@id='instalment-sum']"));
        WebElement instalmentEmailField = driver.findElement(By.xpath("//input[@id='instalment-email']"));
        assertEquals("Номер счета на 44", instalmentNumberInputField.getAttribute("placeholder"));
        assertEquals("Сумма", instalmentSumInputField.getAttribute("placeholder"));
        assertEquals("E-mail для отправки чека", instalmentEmailField.getAttribute("placeholder"));

        WebElement arrearsNumberInputField = driver.findElement(By.xpath("//input[@id='score-arrears']"));
        WebElement arrearsSumInputField = driver.findElement(By.xpath("//input[@id='arrears-sum']"));
        WebElement arrearsEmailField = driver.findElement(By.xpath("//input[@id='arrears-email']"));
        assertEquals("Номер счета на 2073", arrearsNumberInputField.getAttribute("placeholder"));
        assertEquals("Сумма", arrearsSumInputField.getAttribute("placeholder"));
        assertEquals("E-mail для отправки чека", arrearsEmailField.getAttribute("placeholder"));

    }

    @Test
    public void testConnectionFields()  {
        WebElement list= driver.findElement(By.className("select"));
        js.executeScript("arguments[0].click();", list);
        WebElement connection = driver.findElement(By.xpath("//p[text()='Услуги связи']"));
        js.executeScript("arguments[0].click();", connection);

        WebElement numberInputField = driver.findElement(By.xpath("//input[@id='connection-phone']"));

        js.executeScript("arguments[0].click();", numberInputField);
        numberInputField.sendKeys("297777777");

        WebElement sumInputField = driver.findElement(By.xpath("//input[@id='connection-sum']"));
        sumInputField.click();
        sumInputField.sendKeys("100");

        WebElement emailField = driver.findElement(By.xpath("//input[@id='connection-email']"));
        emailField.click();
        sumInputField.sendKeys("evgeniyperevalov@gmail.com");

        WebElement contButton = driver.findElement(By.xpath("//button[contains(text(), 'Продолжить')]"));
        contButton.click();    }

    @Test
    public void testPaymentFrame() {

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("bepaid-iframe")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//app-payment-container//p[1]")));
        WebElement sum = driver.findElement(By.xpath("//app-payment-container//p[1]"));
        String sumSubString = sum.getText().substring(0,3);
        assertEquals(sumSubString, "100");

        WebElement info = driver.findElement(By.xpath("//app-payment-container//p[2]"));
        String infoString = info.getText();
        String phoneNumber = infoString.substring(infoString.length()-9);
        assertEquals(phoneNumber, "297777777");

        WebElement inputPhoneNumber = driver.findElement(By.xpath("//label[@class='ng-tns-c47-1 ng-star-inserted']"));
        assertEquals("Номер карты", inputPhoneNumber.getText());

        WebElement iconMasterCard = driver.findElement(By.xpath("//img[@src='assets/images/payment-icons/card-types/mastercard-system.svg']"));
        assertTrue(iconMasterCard.isDisplayed());

        WebElement iconVisa = driver.findElement(By.xpath("//img[@src='assets/images/payment-icons/card-types/visa-system.svg']"));
        assertTrue(iconVisa.isDisplayed());

        WebElement iconBelCart = driver.findElement(By.xpath("//img[@src='assets/images/payment-icons/card-types/belkart-system.svg']"));
        assertTrue(iconBelCart.isDisplayed());

        WebElement iconMir = driver.findElement(By.xpath("//img[@src='assets/images/payment-icons/card-types/mir-system-ru.svg']"));
        wait.until(ExpectedConditions.visibilityOf(iconMir));
        assertTrue(iconMir.isDisplayed());

        WebElement iconMaestro = driver.findElement(By.xpath("//img[@src='assets/images/payment-icons/card-types/maestro-system.svg']"));
        wait.until(ExpectedConditions.visibilityOf(iconMaestro));
        assertTrue(iconMaestro.isDisplayed());

        WebElement validityPeriod = driver.findElement(By.xpath("//label[@class='ng-tns-c47-4 ng-star-inserted']"));
        assertEquals("Срок действия", validityPeriod.getText());

        WebElement cvc = driver.findElement(By.xpath("//label[@class='ng-tns-c47-5 ng-star-inserted']"));
        assertEquals("CVC", cvc.getText());

        WebElement nameOfHolder = driver.findElement(By.xpath("//label[@class='ng-tns-c47-3 ng-star-inserted']"));
        assertEquals("Имя держателя (как на карте)", nameOfHolder.getText());

        WebElement button = driver.findElement(By.xpath("//button[@class='colored disabled ng-star-inserted']"));
        assertTrue(button.getText().contains("100."));

        WebElement gPay = driver.findElement(By.xpath("//button[@class='gpay-button black plain short ru']"));
        assertTrue(gPay.isDisplayed());

        WebElement yPay = driver.findElement(By.xpath("//button[@class='ya-pay-button ya-pay-button_black']"));
        assertTrue(yPay.isDisplayed());


    }

}

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalcTest {
    static AndroidDriver<AndroidElement> driver = null;

    public void initialize() {
        DesiredCapabilities capabilities = new
                DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy A34 5G");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.calculator");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.calculator2.Calculator");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);

        try {
            driver = new AndroidDriver<>(new
                    URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(50,
                    TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }

    }

    By three = By.id("com.google.android.calculator:id/digit_3");
    By nine = By.id("com.google.android.calculator:id/digit_9");
    By plus = By.id("com.google.android.calculator:id/op_add");
    By minus = By.id("com.google.android.calculator:id/op_sub");
    By multiply = By.id("com.google.android.calculator:id/op_mul");
    By divide = By.id("com.google.android.calculator:id/op_div");
    By equal = By.id("com.google.android.calculator:id/eq");
    By result = By.id("com.google.android.calculator:id/result_final");

    @Test
    public void checkCalculatePlus() {
        initialize();
        driver.findElement(nine).click();
        driver.findElement(plus).click();
        driver.findElement(three).click();
        driver.findElement(equal).click();
        assertEquals("12", driver.findElement(result).getText());
    }

    @Test
    public void checkCalculateMinus() {
        initialize();
        driver.findElement(nine).click();
        driver.findElement(minus).click();
        driver.findElement(three).click();
        driver.findElement(equal).click();
        assertEquals("6", driver.findElement(result).getText());
    }

    @Test
    public void checkCalculateMultiply() {
        initialize();
        driver.findElement(nine).click();
        driver.findElement(multiply).click();
        driver.findElement(three).click();
        driver.findElement(equal).click();
        assertEquals("27", driver.findElement(result).getText());
    }

    @Test
    public void checkCalculateDivide() {
        initialize();
        driver.findElement(nine).click();
        driver.findElement(divide).click();
        driver.findElement(three).click();
        driver.findElement(equal).click();
        assertEquals("3", driver.findElement(result).getText());

    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }

}




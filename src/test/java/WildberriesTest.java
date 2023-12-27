import org.example.BasketPage;
import org.example.HomePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class WildberriesTest {
    static WebDriver driver;
    public List<String> expectedNames;
    public List<String> expectedPrices;
    public List<String> actualPrices;
    public List<String> actualNames;
    public static int totalSum;
    private static BasketPage basket;

    @BeforeAll
    public static void init() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        basket = new BasketPage(driver);
    }
    @Test
    public void selectProductsTest() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.initElements();
        homePage.addProduct(0);
        homePage.addProduct(1);
        homePage.addProduct(2);
        expectedNames = homePage.getProductsNames().stream().map(WebElement -> WebElement.getText().substring(2)).collect(Collectors.toList());
        expectedPrices = homePage.getProductsPrices().stream().map(WebElement::getText).collect(Collectors.toList());
        totalSum(expectedPrices);
        homePage.openBasket();
        actualNames = basket.getItemNames().stream().map(WebElement::getText).collect(Collectors.toList());
        actualPrices = basket.getItemPrices().stream().map(WebElement::getText).collect(Collectors.toList());
    }
    @Test
    public void compareProductsNames() {
        assertEquals(expectedNames, actualNames);
        assertEquals(expectedPrices, actualPrices);
    }
    @Test
    public void compareProductsPrices() {
        assertEquals(expectedPrices, actualPrices);
    }
    @Test
    public void compareProductsQuantity() {
        assertEquals("Товары, 3 шт.", basket.getTotalQuantity().getText());
    }
    @Test
    public void compareTotalPrices() throws InterruptedException {
        String totalSumActual = basket.getTotalPrice().getText().replaceAll("\\s", "");
        assertEquals(totalSum, Integer.parseInt(totalSumActual.substring(0, totalSumActual.length()-1)));
    }
    @AfterAll
    static void teardown() {
        driver.quit();
    }
    public static void totalSum(List<String> prices) {
        totalSum = 0;
        for (String price : prices) {
            String priceWithoutSymbol = price.replace(" ₽", "");
            int priceValue = Integer.parseInt(priceWithoutSymbol);
            totalSum += priceValue;
        }
    }
}
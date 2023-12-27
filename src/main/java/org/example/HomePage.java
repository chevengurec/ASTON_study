package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.Collections;
import java.util.List;


public class HomePage {
    private WebDriver driver;
    private Wait<WebDriver> wait;
    private JavascriptExecutor js;
    private Actions actions;
    private List<WebElement> productNames;
    private List<WebElement> productsPrices;
    private List<WebElement> productsWrappers;
    private WebElement basketLink;
    private WebElement products;
    private WebElement productWrapper;
    private WebElement addToBasketBtn;


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.wildberries.ru/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        js = (JavascriptExecutor) driver;
        actions = new Actions(driver);
    }

    public void initElements() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'main-page__content')]")));
        products = driver.findElement(By.xpath("//div[contains(@class,'main-page__content')]"));


        js.executeScript("arguments[0].scrollIntoView();", products);

        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='product-card__name']")));
    }

    public List<WebElement> getProductsNames() {
        productNames = driver.findElements(By.xpath("//*[@class='product-card__name']"));
        Collections.reverse(productNames.subList(0,3));
        return productNames.subList(0,3);
    }

    public List<WebElement> getProductsPrices() {
        productsPrices = driver.findElements(By.xpath("//*[contains(@class,'price__lower-price')]"));

        Collections.reverse(productsPrices.subList(0,3));
        return productsPrices.subList(0,3);
    }

    WebElement getProductsWrapper(int i) {
        productsWrappers = driver.findElements(By.xpath("//*[@class='product-card__wrapper']"));
        return productsWrappers.get(i);
    }

    WebElement getAddButtons(int i) {
        List<WebElement> addButtons = driver.findElements(By.xpath("//*[contains(@class,'product-card__add-basket')]"));
        return addButtons.get(i);
    }
    public void addProduct(int number) {
        productWrapper = getProductsWrapper(number);
        actions.moveToElement(productWrapper).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.product-card__add-basket.j-add-to-basket.btn-main-sm")));
        addToBasketBtn = getAddButtons(number);
        addToBasketBtn.click();
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class, 'popup-list-of-sizes')]//ul/li[1]")));
            driver.findElement(By.xpath("//*[contains(@class, 'popup-list-of-sizes')]//ul/li[1]")).click();
        }
        catch (TimeoutException timeoutException){
            timeoutException.getStackTrace();
        }
    }
    public void openBasket() {
        basketLink = driver.findElement(By.xpath("//*[@id='basketContent']//*[@href='/lk/basket']"));
        basketLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'list-item__good')]")));
    }
}
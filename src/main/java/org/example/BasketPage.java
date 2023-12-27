package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasketPage {
    private WebDriver driver;
    private List<String> itemNamesList;
    private List<WebElement> itemNames;
    private List<WebElement> itemPrices;
    private List<WebElement> itemQuantity;

    public BasketPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getItemNames() {
        itemNames = driver.findElements(By.cssSelector(".good-info__good-name"));
        return itemNames;
    }

    public List<WebElement> getItemPrices() {
        itemPrices = driver.findElements(By.xpath("//*[@class='list-item__price-new']"));
        return itemPrices;
    }

    public WebElement getTotalQuantity() {
        return driver.findElement(By.xpath("//p[@class='b-top_count line']/span[1]"));
    }

    public WebElement getTotalPrice() {

        return driver.findElement(By.xpath("//*[@class='b-right']"));


    }
}

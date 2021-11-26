package homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.*;

public class TestCase3_1 {

    /*
    Steps
    Navigate to "https://www.saucedemo.com/" -- OK
    Enter username "standard_user" -- OK
    Enter password "secret_sauce" -- OK
    Click Login button -- OK
    Find the cheapest two product on the page -- OK
    Add them to the cart -- OK
    Click cart button -- OK
    Validate these two products is added to the cart -- OK
     */

    @Test
    public void test() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        Thread.sleep(2000);

        Select productSort = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
        productSort.selectByVisibleText("Price (low to high)");

        List<WebElement> addToCartButtons = driver.findElements(By.xpath("//*[.='Add to cart']"));
        List<WebElement> itemNames = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<WebElement> itemPrices = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

        String firstProductName = itemNames.get(0).getText();
        double firstProductPrice = Double.parseDouble(itemPrices.get(0).getText().trim().substring(1));
        String secondProductName = itemNames.get(1).getText();
        double secondProductPrice=Double.parseDouble(itemPrices.get(1).getText().trim().substring(1));

        addToCartButtons.get(0).click();
        addToCartButtons.get(1).click();

        WebElement shoppingCartLink = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        shoppingCartLink.click();

        List<WebElement> productNamesOnCart = driver.findElements(By.xpath("//*[@class='inventory_item_name']"));
        List<WebElement> productPricesOnCart = driver.findElements(By.xpath("//*[@class='inventory_item_price']"));

        Map<String, Double> cartMap = new HashMap<>();
        cartMap.put(productNamesOnCart.get(0).getText(),
                Double.parseDouble(productPricesOnCart.get(0).getText().trim().substring(1)));
        cartMap.put(productNamesOnCart.get(1).getText(),
                Double.parseDouble(productPricesOnCart.get(1).getText().trim().substring(1)));
        boolean price1 = cartMap.get(firstProductName) == firstProductPrice;
        boolean price2 = cartMap.get(secondProductName) == secondProductPrice;
        if (price1&&price2){
            System.out.println("Test passed successfully");
        }else {
            throw new AssertionError("Price on cart and price on shopping page is not matched");
        }
    }
}

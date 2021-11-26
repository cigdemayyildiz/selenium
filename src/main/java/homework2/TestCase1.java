package homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class TestCase1 {
    /*
    Navigate to "https://www.saucedemo.com/" -- OK
    Enter username "standard_user" -- OK
    Enter password "secret_sauce" -- OK
    Click Login button -- OK
    Select Name (Z-A) from drop down box -- OK
    Validate the products are displayed in descending order -- OK
    */

    @Test
    public void test(){
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement selectName = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(selectName);
        select.selectByValue("za");

        List<WebElement> allProducts = driver.findElements(By.className("inventory_item_name"));

        List<String> actualAllProducts = new LinkedList<>();
        List<String> expectedAllProducts = new LinkedList<>();
        expectedAllProducts.add("Test.allTheThings() T-Shirt (Red)");
        expectedAllProducts.add("Sauce Labs Onesie");
        expectedAllProducts.add("Sauce Labs Fleece Jacket");
        expectedAllProducts.add("Sauce Labs Bolt T-Shirt");
        expectedAllProducts.add("Sauce Labs Bike Light");
        expectedAllProducts.add("Sauce Labs Backpack");

        for (WebElement product : allProducts){
            Assert.assertTrue(product.isDisplayed());
        }

        for (WebElement product : allProducts){
            System.out.println(product.getText());
            actualAllProducts.add(product.getText());
        }
        Assert.assertEquals(expectedAllProducts, actualAllProducts);

    }
}

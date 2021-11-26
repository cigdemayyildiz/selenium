package homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.*;


public class TestCase5 {

    public static void main(String[] args) {
        /*
        Navigate to "https://www.saucedemo.com/" -- OK
        Enter username "standard_user" -- OK
        Enter password "secret_sauce" -- OK
        Click Login button -- OK
        Get the all product name from home page -- OK
        Validate the product names are unique values -- OK
        Validate the product names are displayed in ascending order -- !!
         */

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        List<WebElement> allProducts = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        Set<String> actualAllProduct = new TreeSet<>();
        Set<String> expectedAllProduct = new TreeSet<>();
        expectedAllProduct.add("Sauce Labs Backpack");
        expectedAllProduct.add("Sauce Labs Bike Light");
        expectedAllProduct.add("Sauce Labs Bolt T-Shirt");
        expectedAllProduct.add("Sauce Labs Fleece Jacket");
        expectedAllProduct.add("Sauce Labs Onesie");
        expectedAllProduct.add("Test.allTheThings() T-Shirt (Red)");

        for (WebElement product : allProducts){
            System.out.println(product.getText());
            actualAllProduct.add(product.getText());
        }

        boolean isEquals = actualAllProduct.equals(expectedAllProduct);
        if (isEquals){
            System.out.println(true);
        }else{
            System.out.println(false);
        }

    }
}

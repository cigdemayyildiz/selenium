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

public class TestCase2 {

    /*
    Steps
    Navigate to "https://www.saucedemo.com/" -- OK
    Enter username "standard_user" -- OK
    Enter password "secret_sauce" -- OK
    Click Login button -- OK
    Select Price (low-high) from drop down box -- OK
    Validate the products are displayed according to their price and they are displayed low price to high price -- OK
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

        WebElement selectPrice = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(selectPrice);
        select.selectByValue("lohi");

        List<WebElement> allPrices = driver.findElements(By.className("inventory_item_price"));

        List<String> actualAllPrices = new LinkedList<>();
        List<String> expectedAllPrices = new LinkedList<>();
        expectedAllPrices.add("$7.99");
        expectedAllPrices.add("$9.99");
        expectedAllPrices.add("$15.99");
        expectedAllPrices.add("$15.99");
        expectedAllPrices.add("$29.99");
        expectedAllPrices.add("$49.99");

        for (WebElement price : allPrices){
            Assert.assertTrue(price.isDisplayed());
        }

        for (WebElement price : allPrices){
            System.out.println(price.getText());
            actualAllPrices.add(price.getText());
        }

        Assert.assertEquals(actualAllPrices, expectedAllPrices);
    }
}

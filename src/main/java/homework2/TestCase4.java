package homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestCase4 {

    /*
    Navigate to "https://www.saucedemo.com/" -- OK
    Enter username "standard_user" -- OK
    Enter password "secret_sauce" -- OK
    Click Login button -- OK
    Find the highest priced two product on the page -- OK
    Add them to the cart -- OK
    Click cart button -- OK
    Click CheckOut Button -- OK
    Fill out First Name, Last Name and Zip Code -- OK
    Click continue button -- OK
    Validate Item total price is equals to total price of selected product -- OK
    Validate Total is equals to Item Total price plus Tax amount -- OK
    Validate the Url contains "checkout" -- OK
    Click finish button -- OK
    Validate "THANK YOU FOR YOUR ORDER" message is displayed -- OK
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

        WebElement selectPrice = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select sortProduct = new Select(selectPrice);
        sortProduct.selectByValue("hilo");

        List<WebElement> itemNames = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<WebElement> itemPrices = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        List<WebElement> addToCartButton = driver.findElements(By.xpath("//*[.='Add to cart']"));

        String firstItem = itemNames.get(0).getText();
        double firstPrice = Double.parseDouble(itemPrices.get(0).getText().trim().substring(1));
        String secondItem = itemNames.get(1).getText();
        double secondPrice = Double.parseDouble(itemPrices.get(1).getText().trim().substring(1));

        addToCartButton.get(0).click();
        addToCartButton.get(1).click();

        WebElement cartButton = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        cartButton.click();

        WebElement checkOutButton = driver.findElement(By.id("checkout"));
        checkOutButton.click();

        WebElement firsName = driver.findElement(By.id("first-name"));
        firsName.sendKeys("Cigdem");
        WebElement lastName = driver.findElement(By.id("last-name"));
        lastName.sendKeys("Ayyildiz");
        WebElement zipCode = driver.findElement(By.id("postal-code"));
        zipCode.sendKeys("78660");

        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();

        WebElement subTotalPrice = driver.findElement(By.xpath("//div[@class='summary_subtotal_label']"));
        double actualSubTotalPrice = Double.parseDouble(subTotalPrice.getText().trim().substring(13));
        double expectedSubTotalPrice = firstPrice + secondPrice;
        Assert.assertEquals(actualSubTotalPrice,expectedSubTotalPrice, "SubTotal price validation");

        WebElement totalPrice = driver.findElement(By.xpath("//div[@class='summary_total_label']"));
        WebElement taxLoc = driver.findElement(By.xpath("//div[@class='summary_tax_label']"));
        double tax = Double.parseDouble(taxLoc.getText().trim().substring(6));

        double actualTotalPrice = Double.parseDouble(totalPrice.getText().trim().substring(8));
        double expectedTotalPrice = actualSubTotalPrice + tax;

        Assert.assertEquals((int)actualTotalPrice*100, (int)expectedTotalPrice*100,
                "Total price validation");

        Assert.assertTrue(driver.getCurrentUrl().contains("checkout"));

        WebElement finishButton = driver.findElement(By.id("finish"));
        finishButton.click();

        WebElement thankYouTex = driver.findElement(By.tagName("h2"));
        String actualText = thankYouTex.getText();
        String expectedText = "THANK YOU FOR YOUR ORDER";
        Assert.assertEquals(actualText,expectedText, "Thank you message validation");


    }
}

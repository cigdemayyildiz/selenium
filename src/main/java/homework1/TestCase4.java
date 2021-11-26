package homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase4 {

    public static void main(String[] args) throws InterruptedException {
        /*
        Navigate to "https://www.saucedemo.com/" -- OK
        Enter username "standard_user" -- OK
        Enter password "secret_sauce" -- OK
        Click Login button -- OK
        Validate current url is "https://www.saucedemo.com/inventory.html" -- OK
         */

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";

        if (actualUrl.equals(expectedUrl)){
            System.out.println(true);
        }else{
            System.out.println(false);
        }


    }
}

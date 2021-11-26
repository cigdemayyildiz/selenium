package homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase3 {

    public static void main(String[] args) {
        /*
        Navigate to "https://www.saucedemo.com/" -- OK
        Enter username "Java" -- OK
        Enter password "Selenium" -- OK
        Click Login button -- OK
        Validate "Epic sadface: Username and password do not match any user in this service" message -- OK
         */

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("Java");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Selenium");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement message = driver.findElement(By.tagName("h3"));
        String actualMessage = message.getText();
        String expectedMessage = "Epic sadface: Username and password do not match any user in this service";

        if (actualMessage.equals(expectedMessage)){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
}

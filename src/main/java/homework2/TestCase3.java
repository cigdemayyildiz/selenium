package homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase3 {

    /*
    Functionality-Acceptance Criteria(Gherkin Language)
    Given the user on saucedemo home page
    Then user click the burger button on saucedemo home page -- OK
    And the user will click the logout button -- OK
    And user should see the login page -- OK
    When the user navigate back from login page -- OK
    Then the user still should see login page -- OK
    SELENIUM TECHTORIAL
    Description: The user should not see the home page after logout since the user already click the logout button.
    Write the test case to test this function and validate it is working correctly or not.
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

        WebElement burgerButton = driver.findElement(By.id("react-burger-menu-btn"));
        burgerButton.click();
        Thread.sleep(2000);

        WebElement logoutButton = driver.findElement(By.id("logout_sidebar_link"));
        logoutButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");

        driver.navigate().back();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");

    }
}

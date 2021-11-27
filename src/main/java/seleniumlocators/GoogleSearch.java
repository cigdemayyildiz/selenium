package seleniumlocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleSearch {

    public static void main(String[] args) {

        // Go to the google and get the text from the googleSearch button and validate It is "Google Search"

        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("https://www.google.com/");

        WebElement text = driver.findElement(By.name("btnK"));
        String actualText = text.getAttribute("value");
        String expectedText = "Google Search";

        if (actualText.equals(expectedText)){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
}

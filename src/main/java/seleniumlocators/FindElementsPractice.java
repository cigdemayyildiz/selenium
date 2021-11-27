package seleniumlocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementsPractice {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        // driver.findElement(); --> singular
        // driver.findElements() --> plural
        // we use findElements(); method to store all matching element from the locator.
        driver.navigate().to("https://the-internet.herokuapp.com/");

        List<WebElement> links = driver.findElements(By.xpath("//li/a"));
        // print all the text from the list which has less than 12 characters
        System.out.println(links.size());
        int count = 0;
        for (WebElement link : links){
            if (link.getText().length()<12) {
                System.out.println(link.getText());
                System.out.println(link.getAttribute("href"));
                count++;
            }
        }
        System.out.println("There are " +count+" elements less than 12 characters.");
    }
}

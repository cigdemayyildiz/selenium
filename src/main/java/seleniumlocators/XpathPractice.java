package seleniumlocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathPractice {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://the-internet.herokuapp.com/horizontal_slider");

        WebElement slider = driver.findElement(By.xpath("/html/body/div[2]/div/div/h3")); // absolute path

        System.out.println(slider.getText());

        WebElement content = driver.findElement(By.xpath("//h4[@class='subheader']")); // relative path

        System.out.println(content.getText());

    }
}

package iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NestedIframe {

    @Test
    public void nestedFrameValidation(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame(0); // using index
        driver.switchTo().frame(driver.findElement(By.name("frame-middle"))); // using WebElement

        WebElement middle = driver.findElement(By.id("content"));
        String actualText = middle.getText();
        String expectedText = "MIDDLE";
        Assert.assertEquals(actualText, expectedText, "middle text validation");

//        driver.switchTo().parentFrame();
//        driver.switchTo().parentFrame();
        // yukaridaki gibi iki kere ust parent a cikarak da HTML e ulasabiliriz,
        // asagidaki gibi defaultContent() methodu ile direkt de HTML e ulasabiliriz.
        driver.switchTo().defaultContent(); // it will switch to the main html.

        driver.switchTo().frame("frame-bottom");

        WebElement bottom = driver.findElement(By.tagName("body"));
        Assert.assertEquals(bottom.getText().trim(), "BOTTOM", "bottom text validation");
    }

    @Test
    public void printRightAndLeft(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame(0);
        driver.switchTo().frame(driver.findElement(By.name("frame-right")));

        WebElement right = driver.findElement(By.tagName("body"));
        String actualRightText = right.getText().trim();
        String expectedRightText = "RIGHT";
        Assert.assertEquals(actualRightText, expectedRightText, "right text validation");

        driver.switchTo().parentFrame();

        driver.switchTo().frame(driver.findElement(By.name("frame-left")));

        WebElement left = driver.findElement(By.tagName("body"));
        Assert.assertEquals(left.getText().trim(), "LEFT", "left text validation");

    }

}

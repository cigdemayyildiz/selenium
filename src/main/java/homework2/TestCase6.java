package homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class TestCase6 {

    /*
    Navigate to "https://demoqa.com/droppable" -- OK
    Select drag and drop to box -- OK
    Validate color is changed of the box -- OK
    Validate the text is "Dropped!" -- OK
     */

    @Test
    public void test(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/droppable");

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable, droppable).perform();

        String droppableColor = droppable.getCssValue("background-color");
        Assert.assertEquals(droppableColor, "rgba(70, 130, 180, 1)");

        String actualMessage = BrowserUtils.getText(droppable);
        String expectedMessage = "Dropped!";
        Assert.assertEquals(actualMessage, expectedMessage);
    }
}

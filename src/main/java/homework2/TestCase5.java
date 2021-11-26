package homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase5 {

    /*
    Navigate to "https://demoqa.com/select-menu" -- OK
    Select Group 2, option 1 -- OK
    Select Prof. and validate they are selected.
     */

    @Test
    public void test() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/select-menu");

        WebElement selectOption = driver.findElement(By.cssSelector("#withOptGroup > div > div.css-1hwfws3 > div.css-1wa3eu0-placeholder"));
        selectOption.click();

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).perform();

        WebElement selectOne = driver.findElement(By.id("selectOne"));
        selectOne.click();
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
                                    .sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).perform();

    }
}

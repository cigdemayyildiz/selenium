package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionMethods {

    @Test
    public void test(){
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com/");

        WebElement searchBox = driver.findElement(By.name("q"));

        Actions actions = new Actions(driver);
        actions.moveToElement(searchBox)
                .click()
                .keyDown(Keys.SHIFT) // shift e bas
                .sendKeys("s") // s ye bas
                .keyUp(Keys.SHIFT) // shiftten kaldir
                .sendKeys("elenium") // elenium yaz
                .doubleClick()
                .keyDown(Keys.COMMAND) // command a bas
                .sendKeys("c") // copy icin c ye bas
                .keyUp(Keys.COMMAND) // command dan kaldir
                .sendKeys(Keys.ARROW_RIGHT) // sag yon tusuna bas
                .keyDown(Keys.COMMAND) // command a bas
                .sendKeys("v") // paste icin v ye bas
                .keyUp(Keys.COMMAND) // command dan kaldir
                .sendKeys(Keys.RETURN) // enter a bas
                .perform();
    }
}

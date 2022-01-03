package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class DragAndDrop {

    @Test
    public void test() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");

        driver.manage().window().fullscreen();

        WebElement draggable = driver.findElement(By.id("draggable")); // mavi top
        WebElement orangeBox = driver.findElement(By.className("test2"));

        String actualTextForOrange = BrowserUtils.getText(orangeBox);
        String expectedTextForOrange = "... Or here.";

        Assert.assertEquals(actualTextForOrange,expectedTextForOrange);

        // eger cookies mesajini kapatmak istiyorsan bunu kullan
        WebElement cookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
        cookies.click();
        Thread.sleep(1000);

        Actions actions = new Actions(driver); // dragAndDrop methodu Actions sinifina ait oldugu icin bunu cagirdik
        actions.dragAndDrop(draggable, orangeBox).perform();
        //dragAndDrop methodu parametre olarak bir kaynak bir de hedef webElementi istiyor
        // burada kaynak mavi top hedef orangeBox

        // we should reinitialize the orangeBox to overcome the StaleElementReferenceException
        orangeBox = driver.findElement(By.className("test2")); // dragAndDrop methodunu uygulamadan once
        // orangeBox un text i ...Or here. di ama dragAndDrop methodunu uyguladiktan sonra text You did great! olarak
        // degisti. Bu degisimi gorebilmek icin orangeBox locationunu yeniden cagirmak gerekiyor ki guncellenmis
        // halini gorebilelim.
        String actualSuccessMessage = BrowserUtils.getText(orangeBox);
        String expectedSuccessMessage = "You did great!";
        Assert.assertEquals(actualSuccessMessage,expectedSuccessMessage);

        // orangeBox in rengi orange mi?
        String cssValue = orangeBox.getCssValue("background-color");
        System.out.println(cssValue);
        Assert.assertEquals(cssValue,"rgba(238, 111, 11, 1)");
    }

    @Test
    public void test2() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");

        driver.manage().window().fullscreen();

        WebElement draggable = driver.findElement(By.id("draggable")); // mavi top
        WebElement blueBox = driver.findElement(By.className("test1"));

        WebElement cookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
        cookies.click();
        Thread.sleep(1000);

        String actualBlueBoxText = blueBox.getText();
        String expectedBlueBoxText = "Drag the small circle here ...";
        Assert.assertEquals(actualBlueBoxText, expectedBlueBoxText);

        Actions actions = new Actions(driver);
        actions.clickAndHold(draggable).moveToElement(blueBox).release().perform();
    }
}

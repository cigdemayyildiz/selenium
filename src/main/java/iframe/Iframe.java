package iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Iframe {

    @Test
    public void test(){
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");

        // textbox icinde var olan bir veriyi silip baska bir veri yazmak istiyoruz
        // bu iframe page HTML icinde bir iframe altinda oldugu icin once o lokasyona gidebilmek icin
        // o iframe icine switch etmemiz gerekiyor.
        driver.switchTo().frame("mce_0_ifr");

        WebElement text = driver.findElement(By.id("tinymce"));

        text.clear();
        text.sendKeys("Hello Java!");

        driver.switchTo().parentFrame(); // burada parentFrame e switch ettigimizde ana HTML e dondu cunku iframe
        // in parent i yoktu. eger icinde test yaptigimiz iframe in kendi parent i olsaydi ona donecekti.
        // parentFrame() goes one parent up in the inner HTML.
        WebElement header = driver.findElement(By.tagName("h3"));
        String actualHeader = header.getText().trim();
        String expectedHeader = "An iFrame containing the TinyMCE WYSIWYG Editor";
        Assert.assertEquals(actualHeader, expectedHeader, "header validation");
    }
}

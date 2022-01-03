package alert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeMethodAnnotation {

    WebDriver driver;


    @BeforeMethod
    public void setUp(){
        System.out.println("It will run before each @Test annotation");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://sweetalert.js.org/");
    }

    @Test
    public void sweetAlert() throws InterruptedException {

        WebElement swal = driver.findElement(By.xpath("//button[contains(@onclick, 'swal')]"));
        swal.click();
        Thread.sleep(1000);

        WebElement popUpMessage = driver.findElement(By.xpath("//div[@class='swal-text']"));
        String actualMessage = popUpMessage.getText().trim();
        Assert.assertEquals(actualMessage, "Something went wrong!", "swal pop-up message validation");

        WebElement okButton = driver.findElement(By.xpath("//button[.='OK']"));
        okButton.click();
        Thread.sleep(1000);
        Assert.assertFalse(okButton.isDisplayed());
    }

    @Test
    public void jsAlert() throws InterruptedException {

        WebElement alert = driver.findElement(By.xpath("//button[contains(@onclick, 'alert')]"));
        alert.click();
        Thread.sleep(1000);

        Alert alert1 = driver.switchTo().alert();
        alert1.accept();
    }
}

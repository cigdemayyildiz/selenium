package alert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SweetAlert {

    @Test
    public void sweetAlert() throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.get("https://sweetalert.js.org/");

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

        WebDriver driver = new ChromeDriver();
        driver.get("https://sweetalert.js.org/");

        WebElement alert = driver.findElement(By.xpath("//button[contains(@onclick, 'alert')]"));
        alert.click();
        Thread.sleep(1000);

        Alert alert1 = driver.switchTo().alert();
        alert1.accept();
    }
}

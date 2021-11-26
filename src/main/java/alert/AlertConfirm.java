package alert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertConfirm {

    @Test
    public void jsConfirmValidation() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsConfirm = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        jsConfirm.click();

        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        // sayfanin header ini JS Confirm button ina bastiktan sonra JS Alert acildiginda almak istersen
        // UnhandledAlertException hatasini alirsin. Cunku Js alert acildiginda sayfa ile baglanti kurmak icin
        // ya Js alerti access ya da dismiss ile kapatman gerekiyor.
        WebElement header = driver.findElement(By.tagName("h3"));
        System.out.println(header.getText());

        WebElement result = driver.findElement(By.id("result"));
        String resultText = result.getText().trim();
        Assert.assertEquals(resultText, "You clicked: Cancel", "result text validation");
    }
}

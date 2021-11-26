package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Resume {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("file:///Users/cigdemayyildiz/Desktop/Techtorial/Selenium/Projects/Project1/resume.html");

        WebElement clickContact = driver.findElement(By.partialLinkText("Contact"));
        clickContact.click();

        WebElement date = driver.findElement(By.name("date"));
        WebElement name = driver.findElement(By.name("name"));
        WebElement email = driver.findElement(By.name("email"));
        WebElement message = driver.findElement(By.name("message"));

        date.sendKeys("11/01/2021");
        name.sendKeys("John");
        email.sendKeys("john@gmail.com");
        message.sendKeys("quick learner");

        Thread.sleep(3000);

        WebElement clickSubmit = driver.findElement(By.id("btn-sub"));
        clickSubmit.click();

        Thread.sleep(2000);
        driver.quit();
    }
}

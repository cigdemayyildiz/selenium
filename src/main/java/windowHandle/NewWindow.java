package windowHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.util.Set;

public class NewWindow {

    @Test
    public void test() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement clickHere = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHere.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://www.techtorialacademy.com')");
        js.executeScript("window.open('https://www.techtorialacademy.com/about-us')");
        js.executeScript("window.open('https://www.techtorialacademy.com/programs')");

        // switch to window till it is equals to about-us

        Set<String> ids = driver.getWindowHandles();

        for (String id : ids) {
            driver.switchTo().window(id);
            if (driver.getTitle().contains("About Us")) {
                break;
            }
        }
        System.out.println(driver.getTitle());


    }

    @Test
    public void test2() {
        // close all the windows except main one.
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");

        String mainTitle = driver.getTitle();
        WebElement clickHere = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHere.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://www.techtorialacademy.com')");
        js.executeScript("window.open('https://www.techtorialacademy.com/about-us')");
        js.executeScript("window.open('https://www.techtorialacademy.com/programs')");

        // switch to window till it is equals to about-us

        Set<String> ids = driver.getWindowHandles();

        for (String id : ids) {
            driver.switchTo().window(id);
            if (driver.getTitle().contains("About Us")) {
                break;
            }
        }
        System.out.println(driver.getTitle());

        for (String id : ids) {
            driver.switchTo().window(id);
            if (!driver.getTitle().contains(mainTitle)) {
                driver.close();
            }
        }
    }

    @Test
    public void test3() {
        // close all the windows except main one.
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        String mainTitle = driver.getTitle();
        WebElement clickHere = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHere.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://www.techtorialacademy.com')");
        js.executeScript("window.open('https://www.techtorialacademy.com/about-us')");
        js.executeScript("window.open('https://www.techtorialacademy.com/programs')");

        // test2 den farkli olarak buraya method cagirarak yaptik
        BrowserUtils.switchByTitle(driver, "About Us");

        System.out.println(driver.getTitle());

        // test2 den farkli olarak buraya method cagirarak yaptik
        BrowserUtils.closeWindowsByTitle(driver, mainTitle);

    }
}
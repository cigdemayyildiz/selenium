package javascriptexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class JavaScript {

    @Test
    public void test() {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.techtorialacademy.com/");

        // get title
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver; // casting
        //String title = (String) javascriptExecutor.executeScript("return document.title"); // get title
        String title = javascriptExecutor.executeScript("return document.title").toString();
        // yukaridaki iki sekilde de string e cevirebiliyoruz, casting ile ya da toString(); methodu ile
        System.out.println(title); // Home Page - Techtorial
        // sadece ogrenmek icin yapiyoruz normalde title getirmek icin javaScript kullanmiyoruz


        // click
        WebElement browseCourse = driver.findElement(By.linkText("Browse Course"));
        javascriptExecutor.executeScript("arguments[0].click()",browseCourse);
        // ana sayfadaki Browse Course button inina tikladik javaScript ile


        // scroll page
        WebElement copyright = driver.findElement(By.xpath("//p[contains(.,'Copyrights')]"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", copyright);

        WebElement studentLogin = driver.findElement(By.xpath("(//a[.='Student login'])[2]"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", studentLogin);

    }

    @Test
    public void test2() {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.techtorialacademy.com/");

        // get title
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver; // casting
        //String title = (String) javascriptExecutor.executeScript("return document.title"); // get title
        String title = javascriptExecutor.executeScript("return document.title").toString();
        // yukaridaki iki sekilde de string e cevirebiliyoruz, casting ile ya da toString(); methodu ile
        System.out.println(title); // Home Page - Techtorial
        // sadece ogrenmek icin yapiyoruz normalde title getirmek icin javaScript kullanmiyoruz


        // click
        WebElement browseCourse = driver.findElement(By.linkText("Browse Course"));
        javascriptExecutor.executeScript("arguments[0].click()",browseCourse);
        // ana sayfadaki Browse Course button inina tikladik javaScript ile


        // scroll page
        WebElement copyright = driver.findElement(By.xpath("//p[contains(.,'Copyrights')]"));
        // test ten farkli olarak burada method cagirarak ayni islemi yaptirdik
        BrowserUtils.scrollToView(driver,copyright);

        WebElement studentLogin = driver.findElement(By.xpath("(//a[.='Student login'])[2]"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", studentLogin);

    }
}

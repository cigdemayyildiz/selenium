package javascriptexecutor;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JavaScriptMethods {

    @Test
    public void test() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.techtorialacademy.com/");

        WebElement copyright = driver.findElement(By.xpath("//p[contains(.,'Copyrights')]"));

        Point location = copyright.getLocation();
        int xCoordinate = location.getX();
        System.out.println(xCoordinate);
        int yCoordinate = location.getY();
        System.out.println(yCoordinate);

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

        Thread.sleep(2000);
        javascriptExecutor.executeScript("window.scrollTo("+xCoordinate+","+yCoordinate+")");

        javascriptExecutor.executeScript("history.go(0)"); // refresh
    }
}

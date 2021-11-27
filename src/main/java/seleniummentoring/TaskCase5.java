package seleniummentoring;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskCase5 {

    /*
    Test Case2 - Automate all the Menu links of techlistic.com
    Steps to Automate:
    1. Launch browser of your choice say., firefox, chrome etc.
    2. Open this URL -  https://www.techlistic.com/
    3. Maximize or set size of browser window.
    4. Click on 'Java Tutorial' link and validate page title.
    5. Navigate back to Home Page.
    6. Click on 'Selenium Tutorial' link and validate page title.
    7. Navigate back to Home Page.
    8. Click on 'Selenium Blogs' link and validate page title.
    9. Navigate back to Home Page.
    10. Click on 'TestNG Blogs' link and validate page title.
    11. Close the browser.
     */

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.techlistic.com/");

        //driver.manage().window().fullscreen();

        WebElement clickJava = driver.findElement(By.xpath("//a[text()='Java']"));
        //JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        //javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)",clickJava);
        clickJava.click();

        String actualJavaPageTitle = driver.getTitle();
        System.out.println(actualJavaPageTitle);
        String expectedJavaPageTitle = "";

        /*
         WebElement submitButton=driver.findElement(By.id("submit"));
        JavascriptExecutor javascriptExecutor= (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", submitButton);
        submitButton.click();
         */
    }
}

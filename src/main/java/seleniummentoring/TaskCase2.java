package seleniummentoring;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskCase2 {

    /*
    Test Case2 - Open godaddy.com and Print it's Page title.
    Steps to Automate:
    1. Launch browser of your choice say., Firefox, chrome etc.
    2. Open this URL - https://www.godaddy.com/
    3. Maximize or set size of browser window.
    4. Get Title of page and print it.
    4. Get URL of current page and print it.
    5. Close browser.
     */

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.godaddy.com/");
        driver.manage().window().maximize();
        // What is the driver methods?
        // navigate(); findElement(); findElements(); get(); getCurrentUrl(); getTitle(); close(); quit();
        String title = driver.getTitle();
        System.out.println(title);

        String currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);

        Thread.sleep(1000);
        driver.close();

    }
}

package seleniummentoring;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskCase3 {

    /*
    Test Case3 - Open godaddy.com and Validate Page Title
    Steps to Automate:
    1. Launch browser of your choice say., Firefox, chrome etc.
    2. Open this URL - https://www.godaddy.com/
    3. Maximize or set size of browser window.
    4. Get Title of page and validate it with expected value.
    5. Get URL of current page and validate it with expected value.
    6. Get Page source of web page.
    7. And Validate that page title is present in page source.
    8. Close browser.
     */

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.godaddy.com/");

        driver.manage().window().maximize();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy";
                             // Domain Names, Websites, Hosting &amp; Online Marketing Tools - GoDaddy
        if (actualTitle.equalsIgnoreCase(expectedTitle)){
            System.out.println("Your test is passed");
        }else {
            System.out.println("Your test is failed");
        }

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.godaddy.com/";
        if (actualUrl.equals(expectedUrl)){
            System.out.println(true);
        }else{
            System.out.println(false);
        }

        Thread.sleep(1000);

        System.out.println(driver.getPageSource());

        String pageSource = driver.getPageSource(); // ??????????????
        if (pageSource.contains(expectedTitle)){
            System.out.println(true);
        }else{
            System.out.println(false);
        }

        driver.close();


    }
}

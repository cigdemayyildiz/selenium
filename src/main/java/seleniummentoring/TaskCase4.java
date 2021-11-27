package seleniummentoring;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskCase4 {

    /*
    Try writing program for above assignments and execute. If you find any difficulty in writing code for above
    assignments, you can refer following link for help: Selenium Webdriver Browser Commands
    2. Automate Amazon Website Menu links with Selenium
    This assignment helps you learn those Selenium commands which are useful in clicking on links and navigate to
    different pages. It is the most usual thing testers do. By automating this assignment, you will verify that,
    clicking on menu links landing users on correct web pages. I am assuming that you have already gone through
    Assignment 1 and aware of basic commands of Selenium. Try to automate all the 3 test cases shared in this post,
    the more you practice more you get confidence.

    Test Case1 - Automate first Menu link of amazon.in and print page title
    Steps to Automate:
    1. Launch browser of your choice say., firefox, chrome etc.
    2. Open this URL -  www.amazon.in
    3. Maximize or set size of browser window.
    4. Get the page title and print it.
    5. Now, click on first menu link say 'Amazon Pay' (or choose any other link from the menu list)
    6. Get the page title and print it.
    7. Navigate back to Home Page.
    8. Get the page title and print it. Verify that value matches with output of point no. 4
    9. Close the browser.
     */

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");

        driver.manage().window().maximize();

        String homePageTitle = driver.getTitle();
        System.out.println(homePageTitle);

        WebElement mobiles = driver.findElement(By.linkText("Mobiles"));
        mobiles.click();

        String mobilePageTitle = driver.getTitle();
        System.out.println(mobilePageTitle);

        driver.navigate().back();

        String homePageTitle2 = driver.getTitle();
        System.out.println(homePageTitle2);

        if (homePageTitle2.equals(homePageTitle)){
            System.out.println(true);
        }else{
            System.out.println(false);
        }

        driver.close();
    }
}

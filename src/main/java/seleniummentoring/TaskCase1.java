package seleniummentoring;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskCase1 {

    /*
    Assignment Level - Beginner
    Test Case1 - Open godaddy.com and maximize browser window.
    Steps to Automate:
    1. Launch browser of your choice say., Firefox, chrome etc.
    2. Open this URL - https://www.godaddy.com/
    3. Maximize or set size of browser window.
    4. Close browser.
     */

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        // What is the function of WebDriver?
        // WebDriver is a way of manipulating(changing) the web browser
        // What is the FireFox driver? --> Geckho Driver
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.godaddy.com/");
        // Suggestion: If you put all the element location correct and still they are not working, make it fullscreen
        // Suggestion2: Put the Thread.sleep(3000);
        driver.manage().window().maximize();
        Thread.sleep(1000);
        // What is the difference between close(); and quit();?
        // close(); closes the current web browser(tab)
        // quit(); closes the driver(it means all of the web browsers(tabs).
        driver.close();

        // What is the difference between navigate().to() and get();?
        // get(); waits all elements to be loaded on the website
        // get(); doesn't have methods
        // navigate().to(); waits for the specific element that you are looking for
        // navigate() has also some methods like forward, refresh, back...

    }
}

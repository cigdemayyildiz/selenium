package seleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumMethods {

    public static void main(String[] args) throws InterruptedException {

        //System.setProperty("webDriver.chrome.driver","chromedriver"); --> her sinifta tekrar tekrar yapmaya gerek yok

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");

        System.out.println(driver.getCurrentUrl()); // https://www.google.com/
        Thread.sleep(1000); // it will wait 1 sec on the google page before go to techtorial page

        driver.navigate().to("https://www.techtorialacademy.com/");

        System.out.println(driver.getCurrentUrl()); // https://www.techtorialacademy.com/

        driver.navigate().back(); // we will go back google

        System.out.println(driver.getCurrentUrl()); // https://www.google.com/

        driver.navigate().forward(); // we will go back techtorialacademy

        System.out.println(driver.getCurrentUrl()); // https://www.techtorialacademy.com/

        driver.navigate().refresh(); // it refreshes very last one

        System.out.println(driver.getCurrentUrl()); // https://www.techtorialacademy.com/

        System.out.println(driver.getPageSource()); // returns the html from the page




    }

}

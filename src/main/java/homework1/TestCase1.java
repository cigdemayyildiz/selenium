package homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCase1 {

    public static void main(String[] args) throws InterruptedException {
        /*
        Navigate to "https://demoqa.com/text-box" -- OK
        Enter your full name, email, current and permanent address -- OK
        Click submit button. -- OK
        Validate that your information is displayed. if everything is correct print true, otherwise print false. -- OK
        Example:
        Name:David
        Email:david@gmail.com
        Current Address:Current Address
        Permanent Address:permanent address
         */

        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/text-box");

        driver.manage().window().fullscreen();

        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Cigdem Ayyildiz");

        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("cigdem@gmail.com");

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("1234 West E St.");

        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("4567 East E St.");

        WebElement clickSubmit = driver.findElement(By.id("submit"));
        clickSubmit.click();

        if(driver.findElement(By.id("output")).isDisplayed()){
            System.out.println(true);
        }else{
            System.out.println(false);
        }

        /*
        WebElement actualResult = driver.findElement(By.xpath("//div[@class='border col-md-12 col-sm-12']"));
        String expectedResult = "Name:Cigdem Ayyildiz\n"+"Email:cigdem@gmail.com\n"+
                "Current Address :1234 West E St.\n"+"Permananet Address :4567 East E St.";

        if (actualResult.equals(expectedResult)){
            System.out.println(true);
        }else {
            System.out.println(false);
        }

        String actualFullName = fullName.getAttribute("value");
        String expectedFullName = "Cigdem Ayyildiz";

        if (actualFullName.equals(expectedFullName)){
            System.out.println("Full Name: "+true);
        }else{
            System.out.println("Full Name: "+false);
        }

        String actualEmail = email.getAttribute("value");
        String expectedEmail = "cigdem@gmail.com";

        if (actualEmail.equals(expectedEmail)){
            System.out.println("Email: "+true);
        }else{
            System.out.println("Email: "+false);
        }

        String actualCurrentAddress = currentAddress.getAttribute("value");
        String expectedCurrentAddress = "1234 West E St.";

        if (actualCurrentAddress.equals(expectedCurrentAddress)){
            System.out.println("Current Address: "+true);
        }else{
            System.out.println("Current Address: "+false);
        }

        String actualPermanentAddress = permanentAddress.getAttribute("value");
        String expectedPermanentAddress = "4567 East E St.";

        if (actualPermanentAddress.equals(expectedPermanentAddress)){
            System.out.println("Permanent Address: "+true);
        }else{
            System.out.println("Permanent Address: "+false);
        }
        */
    }
}

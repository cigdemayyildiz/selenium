package seleniumlocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("file:///Users/cigdemayyildiz/Desktop/Techtorial/Selenium/Techtorial.html");

        WebElement header = driver.findElement(By.id("techtorial1"));

        System.out.println(header.getText()); // Techtorial Academy
        // Yazdirmak degil text dogru mu yanlis mi diye kontrol etmek bizim isimiz

        String actualHeader = header.getText(); // sistemde var olan, developer in yazdigi
        String expected = "Techtorial Academy"; // expected value comes from Business Requirement
        if (actualHeader.equals(expected)){
            System.out.println("true");
        }else {
            System.out.println("false");
        }

        WebElement checkBoxTitle = driver.findElement(By.className("group_checkbox"));
        String actualTitle = checkBoxTitle.getText();
        String expectedTitle = "All Tools";
        if (actualTitle.equals(expectedTitle)){
            System.out.println("true");
        }else {
            System.out.println("false");
        }

        WebElement checkFirstNameBox = driver.findElement(By.name("firstName"));
        WebElement checkLastNameBox = driver.findElement(By.name("lastName"));
        WebElement checkPhoneNumberBox = driver.findElement(By.name("phone"));
        WebElement checkEmailBox = driver.findElement(By.name("userName"));

        checkFirstNameBox.sendKeys("David");
        checkLastNameBox.sendKeys("Turan");
        checkPhoneNumberBox.sendKeys("2345673345");
        checkEmailBox.sendKeys("trn@gmail.com");

        // store webElement for checkbox --> Java, Selenium, TestNG...

        WebElement checkJavaBox = driver.findElement(By.id("cond1"));
        WebElement checkSeleniumBox = driver.findElement(By.id("cond2"));
        WebElement checkTestNgBox = driver.findElement(By.id("cond3"));
        WebElement checkCucumberBox = driver.findElement(By.id("cond4"));

        checkJavaBox.click();
        System.out.println(checkJavaBox.isSelected()); // true --> it returns boolean
        System.out.println(checkTestNgBox.isSelected()); // false
        // selected kutu secilmis mi secilmemis mi onu kontrol ediyor

        System.out.println(checkCucumberBox.isDisplayed()); // true --> it will return true since cucumber element is
                                                           // displayed on the page.
        // displayed sayfa da var mi yok mu goruntuleniyor mu onu kontrol ediyor

    }
}

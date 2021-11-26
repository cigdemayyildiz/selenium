package selectclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class MultipleSelect {

    @Test
    public void test(){
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("file:///Users/cigdemayyildiz/Desktop/Techtorial/Selenium/Techtorial.html");

        WebElement multiple = driver.findElement(By.className("select"));
        // multiple attribute olan elementlerde birden fazla options olacagi icin multiple elementi WebElementle bul
        // Select ile object olustur ve multiple WebElementini select objectinin parametresi yap
        Select select = new Select(multiple);
        select.selectByIndex(0);
        select.selectByVisibleText("Three");
        select.selectByValue("4");

        select.deselectByVisibleText("Three"); // use deselect method to unselect
        select.deselectByValue("4");

    }
}

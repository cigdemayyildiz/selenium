package selectclass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectClassIntro {

    @Test
    public void test() throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement dropdown = driver.findElement(By.id("dropdown"));

        Select select = new Select(dropdown);
        String actualFirstSelected = select.getFirstSelectedOption().getText().trim();
        String expectedFirstSelected = "Please select an option";

        Thread.sleep(1000); // code will pause on this line for 2 sec.
        select.selectByValue("1");
        Thread.sleep(1000); // normalde test yaparken kullanmak tercih edilmiyor cunku testin hizli olmasi tercih
        select.selectByVisibleText("Option 2");
        Thread.sleep(1000);
        select.selectByIndex(1); // it is for Option 1 --> index starts 1 not 0

        Assert.assertEquals(actualFirstSelected,expectedFirstSelected,"first selected"); // message will appear
        // if code will be failed, we put assertion at the end of the codes
    }

}

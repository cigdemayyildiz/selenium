package homework3.com.test.openemr;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

    // Navigate to "https://demo.openemr.io/openemr"

public class TestBase {

    public static WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.openemr.io/openemr");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

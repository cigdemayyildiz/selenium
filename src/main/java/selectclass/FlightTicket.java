package selectclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FlightTicket {

    @Test
    public void test(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spicejet.com/");

    }

}

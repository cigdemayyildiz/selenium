package homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase2 {

    public static void main(String[] args) {
        /*
        Navigate to "https://demoqa.com/radio-button" -- OK
        Click Yes radio button -- OK
        Validate text is : You have selected Yes -- OK
        Click Impressive radio button -- OK
        Validate text is : You have selected Impressive -- OK
        Validate No button is disabled using. -- OK
         */

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demoqa.com/radio-button");

        WebElement clickYes = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        clickYes.click();

        WebElement textClickYes = driver.findElement(By.className("mt-3"));
        String actualClickYesText = textClickYes.getText();
        String expectedClickYesText = "You have selected Yes";

        if (actualClickYesText.equals(expectedClickYesText)){
            System.out.println(true);
        }else{
            System.out.println(false);
        }

        WebElement clickImpressive = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        clickImpressive.click();

        WebElement textClickImpressive = driver.findElement(By.className("mt-3"));
        String actualClickImpressiveText = textClickImpressive.getText();
        String expectedClickImpressiveText = "You have selected Impressive";

        if (actualClickImpressiveText.equals(expectedClickImpressiveText)){
            System.out.println(true);
        }else{
            System.out.println(false);
        }

        WebElement clickNo = driver.findElement(By.xpath("//label[@for='noRadio']"));
        boolean disabled = clickNo.isEnabled();
        System.out.println(disabled); // true

        if (disabled){
            System.out.println(true);
        }else{
            System.out.println(false);
        }

    }
}

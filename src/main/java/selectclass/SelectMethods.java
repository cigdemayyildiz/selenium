package selectclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.util.*;

public class SelectMethods {

    @Test
    public void test(){
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.cars.com/");

        WebElement price = driver.findElement(By.id("make-model-max-price"));

        Select select = new Select(price);
        List<WebElement> prices = select.getOptions();

        Set<String> actualOrder = new LinkedHashSet<>();
        Set<String> expectedOrder = new TreeSet<>(); // ??????????????????

        for (WebElement prc : prices){
            actualOrder.add(BrowserUtils.getText(prc));
            expectedOrder.add(BrowserUtils.getText(prc));
        }
        Assert.assertEquals(actualOrder,expectedOrder);
    }

    // Majd in methodu
    public static boolean isSorted(List<WebElement> listOfStrings, int index) {
        if (index < 2) {
            return true;
        } else if (listOfStrings.get(index - 2).getText().compareTo(listOfStrings.get(index - 1).getText()) > 0) {
            return false;
        } else {
            return isSorted(listOfStrings, index - 1);
        }
    }


}

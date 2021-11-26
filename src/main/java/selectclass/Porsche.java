package selectclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class Porsche {

    /*
    TASK: https://www.cars.com/
    Select New car - Porsche - 911
    Click search button
    Validate header is equals to "New Porsche 911 for sale"
     */

    @Test
    public void test(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.cars.com/");

        WebElement selectNewUsed = driver.findElement(By.id("make-model-search-stocktype"));
        WebElement selectMake = driver.findElement(By.id("makes"));
        WebElement selectModel = driver.findElement(By.id("models"));

        // tum bu asagidaki satirlari yazmak yerine bunlari yapacak bir method yazarak
//        Select select = new Select(selectNewUsed);
//        select.selectByValue("new");
//        Select select1 = new Select(selectMake);
//        select1.selectByValue("porsche");
//        Select select2 = new Select(selectModel);
//        select2.selectByValue("porsche-911");

        // bu sekle getirebiliriz. selectBy diye bir method yazdik ve o methodu ustteki satirlarin tamamini yazabilecek
        // sekilde dizayn ettik ve sadece methodu cagirarak parametrelerini dogru yerlere girerek kod fazlaligindan
        // kurtulduk
        BrowserUtils.selectBy(selectNewUsed,"new","value");
        BrowserUtils.selectBy(selectMake,"porsche","value");
        BrowserUtils.selectBy(selectModel,"porsche-911","value");

        WebElement clickSearch = driver.findElement(By.xpath("//button[@data-linkname='search-new-make']"));
        clickSearch.click();

        WebElement header = driver.findElement(By.tagName("h1"));
        //String actualHeaderText = header.getText().trim(); --> normalde bu sekilde yapiyoruz ama sona ekledigimiz
        // trim(); methodunu unutma ihtimalimize karsilik her defasinda ekstra kontrol etmek zorunda kalmayalim diye
        // BrowserUtils class icinde bir method olusturduk ve onu cagirarak tek kalemde o methodun icindeki islemleri
        // yapmasini sagladik. alttaki satir
        String actualHeaderText = BrowserUtils.getText(header);
        String expectedHeaderText = "New Porsche 911 for sale";
        Assert.assertEquals(actualHeaderText, expectedHeaderText, "header text");

        String actualTitle = driver.getTitle();
        String expectedTitle = "New Porsche 911 for Sale Near Me | Cars.com";
        Assert.assertEquals(actualTitle,expectedTitle,"porsche title");
    }
}

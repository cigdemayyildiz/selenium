package seleniumlocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksAndTags {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("file:///Users/cigdemayyildiz/Desktop/Techtorial/Selenium/Techtorial.html");

        // LinkText, PartialLinkText, TagName

        WebElement java = driver.findElement(By.linkText("Java"));
        java.click();
        System.out.println(driver.getCurrentUrl());

        driver.navigate().back();

        WebElement selenium = driver.findElement(By.linkText("Selenium"));
        selenium.click();

        driver.navigate().back();

        java = driver.findElement(By.linkText("Java"));
        java.click(); // eger yukaridaki java reference icin guncellemeyi yapmazdak
                     // bu mesaji aliriz StaleElementReferenceException

        driver.navigate().back();

        WebElement restApi = driver.findElement(By.partialLinkText("Rest"));
        // kelimelerden herhangi biri olabilir burada aslinda Rest Api idi ama biz sadece Rest i kullandik
        restApi.click();
        System.out.println(driver.getCurrentUrl());

        driver.navigate().back();

        WebElement versionText = driver.findElement(By.tagName("u")); // tagName e gore arama yapiyor eger bu tag den
                                                                     // birden fazla varsa en ilk olanini getiriyor
        System.out.println(versionText.getText()); // tagName e gore arama yapip o tag in icindeki text i yazdirdik


        Thread.sleep(3000); // before close the browser it'll wait for 3sec

        driver.quit(); // it will close the browser

    }
}

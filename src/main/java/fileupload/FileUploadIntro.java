package fileupload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class FileUploadIntro {

    @Test
    public void validateFileUpload(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        //chooseFile.sendKeys("/Users/cigdemayyildiz/Desktop/usa.png");
        chooseFile.sendKeys("/Users/cigdemayyildiz/Desktop/Techtorial/Selenium/usa.png");

        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.submit(); // instead of click() we did submit()
        // submit() methodunu kullanabilmek icin HTML deki <input> taginin <form> tag i altinda olmasi gerekiyor

        WebElement fileUploaded = driver.findElement(By.tagName("h3"));
        String actualText = fileUploaded.getText().trim();
        Assert.assertEquals(actualText, "File Uploaded!");

        WebElement fileName = driver.findElement(By.id("uploaded-files"));
        String actualFileName = BrowserUtils.getText(fileName);
        Assert.assertEquals(actualFileName, "usa.png");

    }

}

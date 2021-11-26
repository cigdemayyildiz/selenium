package seleniumlocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxPractice {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/checkbox");

        WebElement homeCheck = driver.findElement(By.xpath("//span[@class='rct-checkbox']"));
        homeCheck.click();

        WebElement arrowHome = driver.findElement(By.xpath("//button[@class='rct-collapse rct-collapse-btn']"));
        arrowHome.click();

        WebElement arrowDesktop = driver.findElement(By.xpath("//li[.='Desktop']//button"));
        arrowDesktop.click();

//        WebElement desktopCheck = driver.findElement(By.xpath("//label[@for='tree-node-desktop']"));
//        desktopCheck.click();

//        WebElement clickNotes = driver.findElement(By.xpath("//label[@for='tree-node-notes']"));
//        clickNotes.click();
//
//        WebElement clickCommands = driver.findElement(By.xpath("//label[@for='tree-node-commands']"));
//        clickCommands.click();

        WebElement arrowDocuments = driver.findElement(By.xpath("//li[.='Documents']//button"));
        arrowDocuments.click();

        WebElement officeText = driver.findElement(By.xpath("//span[.='Office']"));
        System.out.println(officeText.getText());

//        WebElement documentsCheck = driver.findElement(By.xpath("//label[@for='tree-node-documents']"));
//        documentsCheck.click();

//        WebElement clickWorkSpace = driver.findElement(By.xpath("//label[@for='tree-node-workspace']"));
//        clickWorkSpace.click();
//
//        WebElement clickOffice = driver.findElement(By.xpath("//label[@for='tree-node-office']"));
//        clickOffice.click();

        WebElement arrowDownloads = driver.findElement(By.xpath("//li[.='Downloads']//button"));
        arrowDownloads.click();

//        WebElement downloadsCheck = driver.findElement(By.xpath("//label[@for='tree-node-downloads']"));
//        downloadsCheck.click();

//        WebElement clickWordFile = driver.findElement(By.xpath("//label[@for='tree-node-wordFile']"));
//        clickWordFile.click();
//
//        WebElement clickExcelFile = driver.findElement(By.xpath("//label[@for='tree-node-excelFile']"));
//        clickExcelFile.click();



    }
}

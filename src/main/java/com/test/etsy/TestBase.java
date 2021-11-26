package com.test.etsy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.Driver;

import java.time.Duration;

public class TestBase {

    public WebDriver driver;

    // singleton design pattern olusturduktan sonra bu methodu kullandik
    @BeforeMethod
    public void setUp(){
        driver = Driver.getDriver();
        driver.get(ConfigReader.readProperty("etsyUrl")); // url i configuration.properties e tanimladik
    }
    /*
     Bu methodu singleton design pattern i ogrenmeden once olusturmustuk. Singleton design pattern ile Utils in
     altinda Driver class olusturup orada tanimlamalari yaptik ve yukaridaki gibi tek bir satirla adagidaki 4 satirin
     yapacagi isi bir seferde yaptirdik.
    */
//    @BeforeMethod
//    public void setUp(){
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().deleteAllCookies();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        // implicitly wait will wait all the page element my Driver pointing.
//        // it will wait 5 sec till element load is completed.
//        // After 5 sec if the element is not available it will throw NoSuchElementException
//        driver.get("https://www.etsy.com/");
//    }

    // singleton design pattern dan sonra
    @AfterMethod
    public void tearDown(ITestResult result){
        if (!result.isSuccess()){
            BrowserUtils.getScreenShot(driver, "etsyecreenehots");
        }
        Driver.tearDown();

    }

//    singleton design patterdan once
//    @AfterMethod
//    public void tearDown(){
//        driver.quit();
//    }
}

package com.test.orangehrm;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.Driver;

public class TestBase {

    public WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = Driver.getDriver();
        driver.get(ConfigReader.readProperty("orangehrmUrl"));
    }

    @AfterMethod
    public void tearDown(){
        Driver.tearDown();
    }
}

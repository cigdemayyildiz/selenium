package com.test.automationpractice.tests;

import com.test.automationpractice.TestBase;
import com.test.automationpractice.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class HomePageTests extends TestBase {

    @Test
    public void validateCartTextDisplayed(){
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isCartTextDisplayed());
    }

    @Test
    public void validateAllProductPrices(){
        HomePage homePage = new HomePage(driver);
        homePage.getAllProductPrices(homePage.getListOfPrices());
        List<String> expectedAllProductPrices = Arrays.asList("$16.51","$27.00","$26.00","$50.99","$28.98","$30.50","$16.40");
        Assert.assertEquals(homePage.getAllProductPrices(homePage.getListOfPrices()),expectedAllProductPrices);
    }

    @Test
    public void validateCheapestProductPrice(){
        HomePage homePage = new HomePage(driver);
        homePage.getCheapestProductPrice(homePage.getListOfPrices());
        double expectedCheapestPrice = 16.40;
        Assert.assertEquals(homePage.getCheapestProductPrice(homePage.getListOfPrices()),expectedCheapestPrice);
    }

    @Test
    public void validateAllProductNames(){
        HomePage homePage = new HomePage(driver);
        homePage.getAllProductNames(homePage.getListOfProductNames());
        List<String> expectedProductNames = Arrays.asList("Faded Short Sleeve T-shirts","Blouse","Printed Dress",
                "Printed Dress","Printed Summer Dress","Printed Summer Dress","Printed Chiffon Dress");
        Assert.assertEquals(homePage.getAllProductNames(homePage.getListOfProductNames()), expectedProductNames);
    }

    @Test
    public void validateCheapestProductName(){
        HomePage homePage = new HomePage(driver);
        String actualCheapestProductName = homePage.getCheapestProductName(homePage.getListOfPrices(),homePage.getListOfProductNames(),homePage.getCheapestProductPrice(homePage.getListOfPrices()));
        String expectedCheapestProductName = "Printed Chiffon Dress";
        Assert.assertEquals(actualCheapestProductName, expectedCheapestProductName);
    }

    @Test
    public void validateCheapestProductOldPrice(){
        HomePage homePage = new HomePage(driver);
        double actualCheapestOldPrice = homePage.getCheapestProductOldPrice(homePage.getAllOldPrices());
        double expectedCheapestOldPrice = 20.50;
        Assert.assertEquals(actualCheapestOldPrice, expectedCheapestOldPrice);
    }

    @Test
    public void validateCheapestProductDiscountRate(){
        HomePage homePage = new HomePage(driver);
        String actualCheapestProductDiscountRate = homePage.getCheapestProductDiscountRate(homePage.getAllOldPrices(),
                    homePage.getAllDiscountRates(), homePage.getCheapestProductOldPrice(homePage.getAllOldPrices()));
        String expectedCheapestProductDiscountRate = "-20%";
        Assert.assertEquals(actualCheapestProductDiscountRate, expectedCheapestProductDiscountRate);
    }

    @Test
    public void test(){
        HomePage homePage = new HomePage(driver);
        homePage.getCheapestProductDiscountRate(homePage.getAllOldPrices(),homePage.getAllDiscountRates(),homePage.getCheapestProductOldPrice(homePage.getAllOldPrices()));

    }

}

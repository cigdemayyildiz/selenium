package com.test.etsy.tests;

import com.test.etsy.TestBase;
import com.test.etsy.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    @Parameters("item")
    @Test
    public void etsySearchTest(String item) {
        HomePage homePage = new HomePage(driver);
        homePage.searchItem(item);
        Assert.assertTrue(homePage.validateTitle());
    }

    // homework: change validateTitle() method implementation that will work with all the search values.
    // now it is working only with "java programming mug"

    @Test
    public void test() {
        HomePage homePage = new HomePage(driver);
        homePage.searchItem("winter gloves");
        Assert.assertTrue(homePage.validateTitle());
    }

    @Parameters({"item1","searchText"})
    @Test
    public void test1(String item1, String searchText){
        HomePage homePage = new HomePage(driver);
        homePage.searchItem(item1);
        Assert.assertTrue(homePage.validateTitle1(searchText));

    }
}

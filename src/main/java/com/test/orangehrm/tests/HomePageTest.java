package com.test.orangehrm.tests;

import com.test.orangehrm.TestBase;
import com.test.orangehrm.pages.HomePage;
import com.test.orangehrm.pages.LoginPage;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    @Test
    public void validateClickAdminButton(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin","admin123");
        HomePage homePage = new HomePage(driver);
        homePage.clickAdminButton();
    }

    @Test
    public void validateSelectUserRole(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin","admin123");
        HomePage homePage = new HomePage(driver);
        homePage.clickAdminButton();
        homePage.selectUserRole("1");
        homePage.clickSearchButton();
    }


}

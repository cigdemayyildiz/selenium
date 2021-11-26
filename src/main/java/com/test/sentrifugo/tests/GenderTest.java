package com.test.sentrifugo.tests;

import com.test.sentrifugo.TestBase;
import com.test.sentrifugo.pages.GenderPage;
import com.test.sentrifugo.pages.HomePage;
import com.test.sentrifugo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GenderTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    GenderPage genderPage;

    @BeforeMethod
    public void initializePages(){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        genderPage = new GenderPage(driver);
    }

    @Test
    public void validateGenderError(){
        loginPage.login("EM01","sentrifugo");
        homePage.clickGenderButton();
        genderPage.clickAddButton();
        genderPage.sendGenderInfo("F","Female", "This is new gender.");
        genderPage.clickSaveButton();
        String genderCodeColor = genderPage.getGenderCodeColor();
        String genderNameColor = genderPage.getGenderNameColor();
        Assert.assertEquals(genderCodeColor,"rgba(255, 0, 0, 1)");
        Assert.assertEquals(genderNameColor,"rgba(255, 0, 0, 1)");
    }
}

package com.test.sentrifugo.tests;

import com.test.sentrifugo.TestBase;
import com.test.sentrifugo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void validateSuperAdmin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("EM01", "sentrifugo");
        Assert.assertEquals(driver.getTitle(), "Sentrifugo - Open Source HRMS");
    }

    @Test
    public void validateManagement(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("EM02","sentrifugo");
        Assert.assertEquals(driver.getTitle(), "Sentrifugo - Open Source HRMS");
    }

    @Test
    public void validateManager(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("EM03", "sentrifugo");
        Assert.assertEquals(driver.getTitle(), "Sentrifugo - Open Source HRMS");
    }

      /*
    TEST case 1
    1- go to the sentrifugo page
    2- click login button
    3- validate please enter user and password message are displayed.
    4- validate text of those message
    5- validate color of the texts are red
     */

    @Test
    public void validateMessageDisplayed(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLogin();
        loginPage.messageDisplayed();
    }

    @Test
    public void validateAlertText(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.userNameAlertText(), "Please enter username or email.");
        Assert.assertEquals(loginPage.passwordAlertText(), "Please enter password.");
    }

    @Test
    public void validateColor(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.getColor(), "rgba(255, 0, 0, 1)");

    }
}

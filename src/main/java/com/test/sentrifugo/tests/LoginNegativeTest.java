package com.test.sentrifugo.tests;

import com.test.sentrifugo.TestBase;
import com.test.sentrifugo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginNegativeTest extends TestBase {

    /*
    Test Case 1
    1- go to the page
    2- enter invalid username and validate the message
     */
    @Test
    public void validateInvalidUserName(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("BM01", "sentrifugo");
        Assert.assertEquals(loginPage.getIncorrectText(), "The username or password you entered is incorrect.");
    }

    /*
    Test Case 2
    1- go to the page
    2- enter invalid password and validate the message
     */
    @Test
    public void validateInvalidPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("EM01", "abc");
        Assert.assertEquals(loginPage.getIncorrectText(), "The username or password you entered is incorrect.");
    }

    /*
    Test Case 3
    1- go to the page
    2- enter invalid username and password and validate the message
     */
    @Test
    public void validateInvalidUserNameAndPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("BM02", "abc");
        Assert.assertEquals(loginPage.getIncorrectText(), "The username or password you entered is incorrect.");
    }
}

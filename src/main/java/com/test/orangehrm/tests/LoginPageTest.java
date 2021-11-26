package com.test.orangehrm.tests;

import com.test.orangehrm.TestBase;
import com.test.orangehrm.data.LoginCredentials;
import com.test.orangehrm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    @Test
    public void validatePositiveLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");
    }

    /*
    valid username, invalid password
    invalid username, invalid password
    invalid username, valid password
    valid username, valid password (admin, superAdmin, employee, hr)
     */

    @Test(dataProvider = "credentials", dataProviderClass = LoginCredentials.class)
    public void validateNegativeCredentialLogin(String username, String password, String expected){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        Assert.assertEquals(loginPage.getErrorMessage(), expected);
    }

}

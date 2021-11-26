package com.test.orangehrm.data;

import org.testng.annotations.DataProvider;

public class LoginCredentials {

    /*
    valid username, invalid password
    invalid username, invalid password
    invalid username, valid password
    valid username, valid password (admin, superAdmin, employee, hr)
     */

    @DataProvider(name = "credentials")
    public Object[][] getCredentials(){
        return new Object[][]{
                {"Admin", "test", "Invalid credentials"},
                {"test", "test", "Invalid credentials"},
                {"test", "admin123", "Invalid credentials"}
        };

    }
}

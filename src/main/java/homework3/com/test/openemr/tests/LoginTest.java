package homework3.com.test.openemr.tests;

import homework3.com.test.openemr.TestBase;
import homework3.com.test.openemr.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void loginTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
    }

}

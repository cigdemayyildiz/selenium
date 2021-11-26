package homework3.com.test.openemr.tests;

import homework3.com.test.openemr.TestBase;
import homework3.com.test.openemr.pages.LoginPage;
import homework3.com.test.openemr.pages.MainPage;
import org.testng.annotations.Test;

public class MainTest extends TestBase {

    @Test
    public void mainTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickPatientSearch();


    }

}

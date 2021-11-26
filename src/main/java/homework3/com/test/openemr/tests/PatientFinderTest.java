package homework3.com.test.openemr.tests;

import homework3.com.test.openemr.TestBase;
import homework3.com.test.openemr.pages.LoginPage;
import homework3.com.test.openemr.pages.MainPage;
import homework3.com.test.openemr.pages.PatientFinderPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PatientFinderTest extends TestBase {

    @Test
    public void searchPatientTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickPatientSearch();

        PatientFinderPage patientFinderPage = new PatientFinderPage(driver);
        driver.switchTo().frame(patientFinderPage.finderIframe);
        patientFinderPage.searchPatient("Phil");
    }

    @Test
    public void validateFullName(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickPatientSearch();

        PatientFinderPage patientFinderPage = new PatientFinderPage(driver);
        driver.switchTo().frame(patientFinderPage.finderIframe);
        patientFinderPage.searchPatient("Phil");

        String actualFullName = patientFinderPage.getFullName();
        String expectedFullName = "Belford, Phil";
        Assert.assertEquals(actualFullName, expectedFullName, "Full Name validation");
    }

    @Test
    public void validatePhoneNumber(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickPatientSearch();

        PatientFinderPage patientFinderPage = new PatientFinderPage(driver);
        driver.switchTo().frame(patientFinderPage.finderIframe);
        patientFinderPage.searchPatient("Phil");

        String actualPhoneNumber = patientFinderPage.getPhoneNumber();
        String expectedPhoneNumber = "333-444-2222";
        Assert.assertEquals(actualPhoneNumber,expectedPhoneNumber, "Phone number validation");
    }

    @Test
    public void validateSsnNumber(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickPatientSearch();

        PatientFinderPage patientFinderPage = new PatientFinderPage(driver);
        driver.switchTo().frame(patientFinderPage.finderIframe);
        patientFinderPage.searchPatient("Phil");

        String actualSsnNumber = patientFinderPage.getSsnNumber();
        String expectedSsnNumber = "333222333";
        Assert.assertEquals(actualSsnNumber,expectedSsnNumber, "SSN number validation");
    }
}

package homework3.com.test.openemr.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

    /*
    Search the "Phil Belford" from the search box under the patient finder
    Validate Name
    Validate Phone Number
    Validate SSN number
    Validate external ID are matching in Home page and Patient Dashboard
    Validate DOB is displayed
    Validate age is correct according to the DOB of patient
    */

public class PatientFinderPage {

    public PatientFinderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@placeholder='Search by Name']")
    WebElement search;

    @FindBy(xpath = "//iframe[@name='fin']")
    public WebElement finderIframe;

    @FindBy(xpath = "//td[@class='sorting_1']")
    WebElement fullName;

    @FindBy(xpath = "//tr[@id='pid_1']/td[2]")
    WebElement phoneNumber;

    @FindBy(xpath = "//tr[@id='pid_1']/td[3]")
    WebElement ssnNumber;

    @FindBy(xpath = "//tr[@id='pid_1']/td[4]")
    WebElement dob;

    @FindBy(xpath = "//tr[@id='pid_1']/td[5]")
    WebElement externalID;



    public void searchPatient(String patientName){
        search.sendKeys(patientName);
    }

    public String getFullName(){
        return this.fullName.getText();
    }

    public String getPhoneNumber(){
        return this.phoneNumber.getText();
    }

    public String getSsnNumber(){
        return this.ssnNumber.getText();
    }
}

package homework3.com.test.openemr.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage {

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[contains(text(), 'Patient/Client')]")
    WebElement pageMenus;

    @FindBy(xpath = "//*[@id=\"mainMenu\"]/div/div[5]/div/ul/li[1]/div")
    WebElement findPatient;

    public void clickPatientSearch(){
        pageMenus.click();
        findPatient.click();
    }
}

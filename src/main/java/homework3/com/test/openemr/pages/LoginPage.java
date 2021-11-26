package homework3.com.test.openemr.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

    /*
    Enter username "admin" -- OK
    Enter password "pass" -- OK
    */

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "authUser")
    WebElement userNameField;

    @FindBy(id = "clearPass")
    WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    public void login(){
        this.userNameField.sendKeys("admin");
        this.passwordField.sendKeys("pass");
        loginButton.click();
    }
}

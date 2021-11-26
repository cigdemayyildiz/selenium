package com.test.sentrifugo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        // initElements() method will initialize the elements that we stored inside this class.
    }

    @FindBy(id = "username")
    WebElement userName;

    @FindBy(name= "password")
    WebElement password;

    @FindBy(xpath = "//input[@id='loginsubmit']")
    WebElement loginButton;

    @FindBy(css = "#usernameerror")
    WebElement userNameAlert;

    @FindBy(css = "#pwderror")
    WebElement passwordAlert;

    @FindBy(xpath = "//div[contains(text(), 'entered')]")
    WebElement incorrectText;

    // driver.findElement(By.id("")); --> from now on we will never see that kind of implementation

    public void login(String userName, String password){
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        this.loginButton.click();
    }

    public void clickLogin(){
        this.loginButton.click();
    }

    public void messageDisplayed(){
        Assert.assertTrue(userNameAlert.isDisplayed());
        Assert.assertTrue(passwordAlert.isDisplayed());
    }

    public String userNameAlertText(){
        return userNameAlert.getText().trim();
    }

    public String passwordAlertText(){
        return passwordAlert.getText().trim();
    }

    public String getColor(){
        String color = userNameAlert.getCssValue("color");
        return color;
    }

    public String getIncorrectText(){
        String text = incorrectText.getText().trim();
        return text;
    }
}

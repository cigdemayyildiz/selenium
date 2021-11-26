package com.test.sentrifugo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GenderPage {

    public GenderPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@title='Add']")
    WebElement addButton;

    @FindBy(id = "gendercode")
    WebElement genderCode;

    @FindBy(id = "gendername")
    WebElement genderName;

    @FindBy(id = "description")
    WebElement description;

    @FindBy(id = "submitbutton")
    WebElement saveButton;

    @FindBy(id = "errors-gendercode")
    WebElement genderCodeErrorMessage;

    @FindBy(id = "errors-gendername")
    WebElement genderNameErrorMessage;

    public void clickAddButton(){
        addButton.click();
    }

    public void sendGenderInfo(String genderCode, String genderName, String description){
        this.genderCode.sendKeys(genderCode);
        this.genderName.sendKeys(genderName);
        this.description.sendKeys(description);
    }

    public void clickSaveButton(){
        saveButton.click();
    }

    public String getGenderCodeColor(){
        return genderCodeErrorMessage.getCssValue("color");
    }

    public String getGenderNameColor(){
        return genderNameErrorMessage.getCssValue("color");
    }


}

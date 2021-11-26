package com.test.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class HomePage {

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "menu_admin_viewAdminModule")
    WebElement adminButton;

    @FindBy(id = "searchSystemUser_userType")
    WebElement userRole;

    @FindBy(id = "searchBtn")
    WebElement searchButton;

    @FindBy(xpath = "//table//tbody//tr//td[3]")
    List<WebElement> userRoles;

    public void clickAdminButton(){
        adminButton.click();
    }

    public void selectUserRole(String roleName){
        BrowserUtils.selectBy(userRole, roleName, "text");
    }

    public void clickSearchButton(){
        searchButton.click();
    }

    public boolean validateRoleText(String roleName){
        boolean isRoleTextCorrect = true;
        for (WebElement role : userRoles){
            if (!role.getText().equals(roleName)){
                isRoleTextCorrect = false;
                System.out.println(role.getText());
                return isRoleTextCorrect;
            }
        }
        return isRoleTextCorrect;
    }
}

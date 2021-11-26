package com.test.etsy.pages;

import org.openqa.selenium.Keys;
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

    @FindBy(id = "global-enhancements-search-query")
    WebElement searchBox;

    @FindBy(xpath = "//li//h3")
    List<WebElement> searchTitle;

    public void searchItem(String search){
        this.searchBox.sendKeys(search, Keys.RETURN);
    }

    public boolean validateTitle(){
        boolean hasKey = false;
        for (WebElement title : searchTitle){
            String titleName = BrowserUtils.getText(title).toLowerCase();
            if (titleName.contains("java") || titleName.contains("programming") || titleName.contains("mug")){
                hasKey = true;
                System.out.println(titleName);
            }else{
                System.out.println(titleName);
                return false;
            }
        }
        return hasKey;
    }

    // homework: change validateTitle() method implementation that will work with all the search values.
    // now it is working only with "java programming mug"

    public boolean validateTitle1(String searchText){
        boolean hasKey = false;
        for (WebElement title : searchTitle){
        String titleName = BrowserUtils.getText(title).toLowerCase();
            if (titleName.contains(searchText)){
                hasKey = true;
            }
            else{
                System.out.println(titleName);
                return false;
            }
        }
        return hasKey;
    }
}

package com.test.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

    /*
    Navigate to "http://automationpractice.com/index.php" -- OK(TestBase)
    Validate Cart (empty) text is displayed -- OK
    Get all the product prices -- OK
    Find cheapest product and get the name of product -- OK
    Get the original price of product -- OK
    Get the discount rate of product -- OK
    Validate after discount rate new product price is correct -- OK
    */

public class HomePage {

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "shopping_cart")
    WebElement CartText;

    @FindBy(xpath = "//span[@class='price product-price']")
    List<WebElement> allProductPrices;

    @FindBy(xpath = "//a[@class='product-name']")
    List<WebElement> allProductNames;

    @FindBy(xpath = "//span[@class='old-price product-price']")
    List<WebElement> allOldPrices;

    @FindBy(xpath = "//span[@class='price-percent-reduction']")
    List<WebElement> allDiscountRates;


    public boolean isCartTextDisplayed(){
        return this.CartText.isDisplayed();
    }

    public List<String> getAllProductPrices(List<WebElement> prices){
        List<WebElement> displayedProducts = new LinkedList<>();
        for (int i=0; i<prices.size(); i++){
            if (prices.get(i).isDisplayed()){
                displayedProducts.add(prices.get(i));
            }
        }
        List<String> allProductPrices = new LinkedList<>();
        for (WebElement price : displayedProducts){
            allProductPrices.add(price.getText());
        }
        return allProductPrices;
    }

    public List<WebElement> getListOfPrices(){
        return allProductPrices;
    }

    public double getCheapestProductPrice(List<WebElement> prices){
        List<Double> allProductPrices = new LinkedList<>();
        for (int i=0; i< prices.size(); i++){
            if (prices.get(i).isDisplayed()){
                allProductPrices.add(Double.parseDouble(prices.get(i).getText().trim().substring(1)));
            }
        }
        Collections.sort(allProductPrices);
        return allProductPrices.get(0);
    }

    public List<String> getAllProductNames(List<WebElement> names){
        List<String> allProductNames = new LinkedList<>();
        for (int i=0; i< names.size(); i++){
            if (names.get(i).isDisplayed()){
                allProductNames.add(names.get(i).getText().trim());
            }
        }
        return allProductNames;
    }

    public List<WebElement> getListOfProductNames(){
        return allProductNames;
    }

    public String getCheapestProductName(List<WebElement> prices, List<WebElement> names, double cheapestProductPrice){
        List<Double> allPrices = new LinkedList<>();
        for (int i=0; i<prices.size(); i++){
            if (prices.get(i).isDisplayed()){
                allPrices.add(Double.parseDouble(prices.get(i).getText().trim().substring(1)));
            }
        }
        List<String> allNames = new LinkedList<>();
        for (int i=0; i< names.size(); i++){
            if (names.get(i).isDisplayed()){
                allNames.add(names.get(i).getText().trim());
            }
        }
        Map<Double, String> productMap = new LinkedHashMap<>();
        for (int i=0; i<names.size(); i++){
            if (names.get(i).isDisplayed()){
            productMap.put(allPrices.get(i), allNames.get(i));
            }
        }
        return productMap.get(cheapestProductPrice);
    }

    public List<WebElement> getAllOldPrices(){
        return allOldPrices;
    }

    public double getCheapestProductOldPrice(List<WebElement> oldPrices){
        List<Double> allOldPrices = new LinkedList<>();
        for (int i=0; i<oldPrices.size(); i++){
            if (oldPrices.get(i).isDisplayed()){
                allOldPrices.add(Double.parseDouble(oldPrices.get(i).getText().trim().substring(1)));
            }
        }
        Collections.sort(allOldPrices);
        return allOldPrices.get(0);
    }

    public List<WebElement> getAllDiscountRates(){
        return allDiscountRates;
    }

    public String getCheapestProductDiscountRate(List<WebElement> oldPrices, List<WebElement> discountRates, double cheapestProductOldPrice){
        List<Double> allOldPrices = new LinkedList<>();
        for (int i=0; i<oldPrices.size(); i++){
            if (oldPrices.get(i).isDisplayed()){
                allOldPrices.add(Double.parseDouble(oldPrices.get(i).getText().trim().substring(1)));
            }
        }
        List<String> allDiscountRates = new LinkedList<>();
        for (int i=0; i<discountRates.size(); i++){
            if (discountRates.get(i).isDisplayed()){
                allDiscountRates.add(discountRates.get(i).getText().trim());
            }
        }
        Map<Double,String> discountMap = new LinkedHashMap<>();
        for (int i=0; i<allOldPrices.size(); i++){
            if (oldPrices.get(i).isDisplayed() || discountRates.get(i).isDisplayed()){
                discountMap.put(allOldPrices.get(i), allDiscountRates.get(i));
            }
        }
        return discountMap.get(cheapestProductOldPrice);
    }
}

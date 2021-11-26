package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class BrowserUtils {

    // we will create our reusable methods related with browser inside the BrowserUtils class


    // Method that accepts three param- WebElement, Value and MethodName
    // SelectByVisibleText
    public static void selectBy(WebElement element, String value, String methodName){

        Select select = new Select(element);
        // method name can be text, index or value
        switch (methodName){
            case "text": select.selectByVisibleText(value);
            break;
            case "index": select.selectByIndex(Integer.parseInt(value));
            break;
            case "value": select.selectByValue(value);
            break;
            default:
                System.out.println("Method name is not available. Use text, value or index for method name.");
        }
    }

    // method will get the text from the WebElement and trim it
    public static String getText(WebElement element){
        return element.getText().trim();
    }

    // it will switch window to given target title
    public static void switchByTitle(WebDriver driver, String title){
        Set<String> ids = driver.getWindowHandles();
        for (String id : ids){
            driver.switchTo().window(id);
            if (driver.getTitle().contains(title)){
                break;
            }
        }
    }

    // it will close all the windows if it is not equals to given window title
    public static void closeWindowsByTitle(WebDriver driver, String title){
        Set<String> ids = driver.getWindowHandles();
        for (String id : ids){
            driver.switchTo().window(id);
            if (!driver.getTitle().equals(title)){
                driver.close();
            }
        }
    }

    // implement a method that switch the window by URL
    public static void switchWindowByUrl(WebDriver driver, String url){
        Set<String> ids = driver.getWindowHandles();
        for (String id : ids){
            driver.switchTo().window(id);
            if (driver.getCurrentUrl().equals(url)){
                break;
            }
        }
    }

    public static void scrollToView(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);
    }

    public static void getScreenShot(WebDriver driver, String packageName){
        // getScreenShotAs() method is taking a screen shot and returning the of this screen.
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String location = System.getProperty("user.dir")+"/src/main/java/screenshot/"+packageName+"/";

        try {
            FileUtils.copyFile(file, new File(location+System.currentTimeMillis()+".png"));
        } catch (IOException e) {
            System.out.println("ScreenShot is not stored!");
            e.printStackTrace();
        }
    }

}

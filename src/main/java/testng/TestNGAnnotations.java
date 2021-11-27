package testng;

import org.testng.annotations.*;

public class TestNGAnnotations {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
        System.out.println("You can use to setup your Chrome browser properties(deletecookies, remote driver, screensize");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
        System.out.println("Launch the browser");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
        System.out.println("You can navigate to the browser");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
        System.out.println("You can login to the class");
    }

    @Test
    public void test1(){
        System.out.println("Test - 1");
    }

    @Test
    public void test2(){
        System.out.println("Test - 2");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
        System.out.println("Quit the browser");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }
}

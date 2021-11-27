package testng;

import org.testng.annotations.Test;

public class TestNGIntro {

    @Test(priority = 1)
    public void test1(){
        System.out.println("test1");
    }

    @Test(priority = 2)
    public void test2(){
        System.out.println("test2");
    }

    @Test(priority = 3) // priority belirlemedigimizde method ismine gore ascending order i oluyor
    public void test(){
        System.out.println("test3");
    }
}

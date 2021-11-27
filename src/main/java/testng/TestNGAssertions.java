package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertions {

    // create one method that takes two parameter as an Integer
    // and return the multiplication of these two number

    public int getMultiplication(int num1, int num2){
        return num1 * num2;
    }

    // -2 * 4 = -8
    //  3 * 0 = 0
    //  3 * 2 = 6
    // -2 * -3 = 6
    @Test
    public void validateNegative(){
        int result = getMultiplication(-2,4);
        int expected = -8;
        Assert.assertEquals(result,expected,"it is for -2 * 4");
    }

    @Test
    public void validateZero(){
        int result = getMultiplication(3,0);
        int expected = 0;
        Assert.assertEquals(result,expected,"it is for 3 * 0");
    }

    @Test
    public void validatePositive(){
        int result = getMultiplication(2,3);
        Assert.assertTrue(result==6);
    }

    @Test
    public void validatePositive2(){
        int result = getMultiplication(2,3);
        int expected = 6;
        Assert.assertTrue(result==expected);
        //Assert.assertTrue(result!=expected); --> it is going to be failed
    }

    @Test
    public void validatePositive3(){
        int result = getMultiplication(2,3);
        int expected = 6;
        Assert.assertFalse(result!=expected);
    }

    @Test
    public void validateMinus(){
        int result = getMultiplication(-2,-3);
        int expected = 5;
        Assert.assertEquals(result,expected); // when assertion fails the next won't be executed
                                             // this is called hard assertion
        System.out.println("Negative Test"); // we won't see this message
    }
}

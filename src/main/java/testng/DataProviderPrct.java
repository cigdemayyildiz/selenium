package testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPrct {

    @Test
    public void test1(){
        String firstName = "David";
        String lastName = "Hunt";
        String fullName = firstName+" "+lastName;
        Assert.assertEquals(fullName,"David Hunt");
    }

    @Test
    public void test2(){
        String firstName = "Priyanka";
        String lastName = "Garla";
        String fullName = firstName+" "+lastName;
        Assert.assertEquals(fullName,"Priyanka Garla");
    }

    @Test
    public void test3(){
        String firstName = "John";
        String lastName = "Savedra";
        String fullName = firstName+" "+lastName;
        Assert.assertEquals(fullName,"John Savedra");
    }

//    @DataProvider(name="NameTest")
//    public Object[][] getData(){
//        return new Object[][]{ // it should be String data type, if you want to provide Integer, Double etc you can convert
//                {"David", "Hunt", "David Hunt"},
//                {"Priyanka", "Garla", "Priyanka Garla"},
//                {"John", "Savedra", "John Savedra"},
//                {"Cigdem", "Ayyildiz","Cigdem Ayyildiz"},
//                {"Sameer", "Jain", "Sameer"}, // iclerinden biri hatali olsa bile tamamini test ediyor
//                {"Kushal", "Puri", "Kushal Puri"}
//        };
//    }

    // Object object = new Object[2][3]; --> eger tanimlamayi basta yapsaydik bu seklinde olurdu
    @Test(dataProvider = "NameTest",  dataProviderClass = Data.class)
        public void test(String fName, String lName, String expected){
            String firstName = fName;
            String lastName = lName;
            String fullName = firstName+" "+lastName;
            Assert.assertEquals(fullName,expected);
        }




}

package testng;

import org.testng.annotations.DataProvider;

public class Data {

    @DataProvider(name="NameTest")
    public Object[][] getData(){
        return new Object[][]{
                {"David", "Hunt", "David Hunt"},
                {"Priyanka", "Garla", "Priyanka Garla"},
                {"John", "Savedra", "John Savedra"},
                {"Cigdem", "Ayyildiz","Cigdem Ayyildiz"},
                {"Sameer", "Jain", "Sameer"},
                {"Kushal", "Puri", "Kushal Puri"}
        };
    }

}

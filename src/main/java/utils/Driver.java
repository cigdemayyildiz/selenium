package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    /*
    Singleton Design Pattern
        Singleton design pattern la TestBase icinde olusturdugumuz webDriver cagirmayi, sayfayi maximize yapmayi,
        implicit ya da explicit wait vermeyi ya da cookies leri silmeyi yaptigimiz method yerine getDriver adinda
        bir method olusturduk ve bu method icine TestBase class da yaptigimiz tum islemleri yaptik. Ekstra olarak
        driver i kontrol etmesini eger driver null deger veriyorsa bunlari yapmasi icin de bir condition ekledik.
        Singleton design pattern da variable ve constructor i private olusturuyoruz cunku disardan erisime acik
        olmasini istemiyoruz, disardan herhangi bir degisiklige izin vermiyoruz. getDriver methodunu public
        yaparak Driver sinifinin baska siniflar tarafindan kullanilmasini sagliyoruz.
        Bu yontem ile her TestBase class icin ayri ayri ayni islemleri yapmaktan kurtulmus oluyoruz.
        com.test.etsy.TestBase class a gidersen orada farki daha iyi anlarsin.
     */

    // private variable
    private static WebDriver driver; // static yapma nedeni class icindeki diger methodlar da kullanabilsin diye

    // private constructor
    private Driver(){} // bos bir constructor olusturduk cunku eger hicbir contructor olusturmazsak Java bizim icin
    // her class icin bir constructor olusturdugu icin ve o constructor public oldugu icin disardan erisilebilir olur

    // pbulic method
    public static WebDriver getDriver(){
        String browser = ConfigReader.readProperty("browser");
        // browser name i ConfigReader class indan cagirdik oraya da configuration.properties file indan cagirdik
        // eger browser degistirmek istiyorsak o zaman sadece configuration.properties file a gidip oradaki browser
        // key inin value sunu degistirecegiz. Tek bir degisiklik ile bircok seyi handle etmis olacagiz.
        if (driver == null){ // check your driver is null or not
            switch (browser){ // switch ile birden fazla browser olusturup hangisi ile test yapmak istedigini secebilirsin
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
            }
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }

    public static void tearDown(){
        driver.quit();
        driver = null; // null a cevirmek istiyoruz ki bir sonraki getDriver kullaniminda driver in null oldugundan emin olmak istiyoruz
    }
}

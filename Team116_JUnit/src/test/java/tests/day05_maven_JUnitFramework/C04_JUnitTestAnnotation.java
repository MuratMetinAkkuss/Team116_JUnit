package tests.day05_maven_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_JUnitTestAnnotation {
    //bir class'da 3 farkli test olsa
    //ve ben testleri istersem bagimsiz olarak calistirabilsem
    /*
        JUnit'in bize kazandirdigi en onemli yeniliklerden biri
        @Test annotation'dir.


        annotation kucuk bilgileri barindiran yapilardir
        sadece bir yazi ya da gosterim degillerdir

        @Test annotation siradan bir method'u
        tek basina calistirilabilir bir test
        method'una donusturur.

        JUnit ile test method'lari istersek tek basina,
        istersek de class level'dan calistirilip tum testlerin
        birlikte calisabilecegi bir yapiya donusur.

        JUnit class icerisindeki test method'larini
        belirli belirsiz bir sirada calistirir.
        Test Method'larinin hangi sira ile calisacagini
        ONGOREMEYIZ ve duzenleyemeyiz

     */




    @Test
    public void amazonTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Amazon'a gidelim ve url'in amazon icerdigini test edip
        driver.get("https://www.amazon.com");


        //sayfayi kapatalim

    }

    @Test
    public void wisequarterTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //wise quarter anasayfaya gidin
        driver.get("https://www.wisequarter.com");
        //title'in wise quarter icerdigini test edin
        String expectedTitle = "Wise Quarter";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Title Test PASSEd");
        }else {
            System.out.println("Title TEST FAILED");
        }
        //ve sayfayi kapatin
        driver.close();

    }
}

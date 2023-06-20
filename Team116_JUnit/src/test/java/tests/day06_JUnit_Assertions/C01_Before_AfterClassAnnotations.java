package tests.day06_JUnit_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Before_AfterClassAnnotations {

    /*
        bir class'daki test method'lari birbiri ile baglantili ise
        birinin calisabilmesi icin onceki test method'unun calismasi
        gerekiyorsa

        yani test method'lari bagimsiz olarak calistirilmayacaksa
        @BeforeClass ve @AfterClass annotations'lari kullanilabilir

        Ancak,
        bu annotations'lara sahip method'larin static olmasi gerekir

     */

    //amazon anasyafay gidin
    //3 farkli test method'u olusturup,verilen testleri yapin
    //1-URL'in amazon icerdigini test edin
    //2-Nutella arattirin ve sonuclarin nutella icerdigini test edin
    //3-ilk urune click yapip, urun isminin nutella icerdigini test edin
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void teardown(){
        driver.close();
    }

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        //1-URL'in amazon icerdigini test edin
        String expectedUrl = "amazon";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrl)){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
            throw new RuntimeException();
        }

    }

    @Test
    public void test02(){
        //2-Nutella arattirin ve sonuclarin nutella icerdigini test edin
       WebElement nutella = driver.findElement(By.id("twotabsearchtextbox"));
       nutella.sendKeys("Nutella" + Keys.ENTER);

       WebElement resultWrittenElement = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));

       String expectedContent = "Nutella";
       String actualContent = resultWrittenElement.getText();

       if (actualContent.contains(expectedContent)){
           System.out.println("test passed");
       }else {
           System.out.println("test failed");
           throw new RuntimeException();
       }


    }

    @Test
    public void text03(){
        //3-ilk urune click yapip, urun isminin nutella icerdigini test edin
        WebElement firstProduct = driver.findElement(By.xpath("(//*[@class='s-image'])[1]"));
        firstProduct.click();

        WebElement firstProductTitle = driver.findElement(By.xpath("//span[@id='productTitle']"));

        String expectedTitle = "Nutella";
        String actualTitle = firstProductTitle.getText();

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Test passed");
        }else {
            System.out.println("test failed");
            throw new RuntimeException();
        }
    }

}

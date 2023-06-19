package tests.day05_maven_JUnitFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_MavenFirstTest {
    public static void main(String[] args) {
        /*
            Selenium 4.7.0 ile selenium kendi WebDriver'ini
            olusturma ve kullanabilme imkani verdi

            tum sirketler selenium Webdriver'i
            kullanmayabilir

            boyle bir durumda istenen Webdriver'i da
            pom.xml'e eklememiz gerekir.
            pom.xml'e ekledikten sonra her class'da
            Webdriver onjesi olusturmamiz gerekir


         */
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
}

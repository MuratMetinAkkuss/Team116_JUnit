package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

import java.time.Duration;

public class P01 {
    //assertion islemi

    //http://www.google.com adresine gidip title'in google icerip icermedigini kontrol edelim

    @Test
    public void testTitle(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.google.com/");
        String expectedContent = "Google";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedContent));


    }
}

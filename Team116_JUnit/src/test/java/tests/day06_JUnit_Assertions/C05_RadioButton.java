package tests.day06_JUnit_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_RadioButton {
    //a. Verilen web sayfasına gidin.
    //     https://facebook.com
    // b. Cookies’i kabul edin
    // c. Create an account buton’una basin
    // d. Radio button elementlerini locate edin ve size uygun olani secin
    // e. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://facebook.com");

    }

    @Test
    public void radioButtonTest(){
        // b. Cookies’i kabul edin
        driver.findElement(By.xpath("//button[@data-cookiebanner='accept_button']")).click();
        // c. Create an account buton’una basin
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
        // d. Radio button elementlerini locate edin ve size uygun olani secin
        WebElement womenElement = driver.findElement(By.xpath("//input[@value='1']"));
        WebElement manElement = driver.findElement(By.xpath("//input[@value='2']"));
        WebElement otherSexElement = driver.findElement(By.xpath("//input[@value='-1']"));

        manElement.click();
        // e. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin
        Assert.assertTrue(manElement.isSelected());
        Assert.assertFalse(womenElement.isSelected());
        Assert.assertFalse(otherSexElement.isSelected());
    }

    @After
    public void teardown(){
        driver.close();
    }
}

package tests.day06_JUnit_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_CheckBox {
    //Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    // a. Verilen web sayfasına gidin.
    //     https://the-internet.herokuapp.com/checkboxes
    // b. Checkbox1 ve checkbox2 elementlerini locate edin.
    // c. Checkbox1 seçili değilse onay kutusunu tıklayın
    // d. Checkbox2 seçili değilse onay kutusunu tıklayın
    // e. Checkbox1ve Checkbox2’nin seçili olduğunu test edin

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @Test
    public void chechboxTest(){

        //b. Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement checkBox1Element = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkBox2Element = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        // c. Checkbox1 seçili değilse onay kutusunu tıklayın
        if (!checkBox1Element.isSelected()){
            checkBox1Element.click();
        }
        // d. Checkbox2 seçili değilse onay kutusunu tıklayın
        if (!checkBox2Element.isSelected()){
            checkBox2Element.click();
        }
        // e. Checkbox1ve Checkbox2’nin seçili olduğunu test edin
        Assert.assertTrue(checkBox1Element.isSelected());
        Assert.assertTrue(checkBox2Element.isSelected());

    }

    @AfterClass
    public static void teardown(){
        driver.close();
    }
}

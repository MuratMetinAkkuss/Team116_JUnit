package tests.day07_testBase_dropdown;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseFirstTest extends TestBase {
    //bir class'in test class'i olarak kullanilabilmesi icin
    //oncelikle Webdriver ayarlarinin yapilmasi ve obje olusturulmasi gerekir
    //JAVA OOP consept cercevesinde Webdriver objesinin illa da bu class'da olmasi
    //SART DEGILDIR!
    //Baska class'daki ozellikleri sahiplenmenin en kolay yolu yoluo class'i parent edinmektir

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));

        wait(2);
    }
}

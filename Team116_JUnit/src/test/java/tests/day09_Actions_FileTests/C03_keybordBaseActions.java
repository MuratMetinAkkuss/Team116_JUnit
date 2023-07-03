package tests.day09_Actions_FileTests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.security.Key;

public class C03_keybordBaseActions extends TestBase {
    @Test
    public void test01(){
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        //2- cookies kabul edelim
        driver.findElement(By.xpath("//button[@data-cookiebanner='accept_button']")).click();
        //3- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
        //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        Actions actions = new Actions(driver);
        actions.click(driver.findElement(By.xpath("//input[@name='firstname']")))
                .sendKeys("Murat Metin")
                .sendKeys(Keys.TAB)
                .sendKeys("Akkus")
                .sendKeys(Keys.TAB)
                .sendKeys("muratmetinakus@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("muratmetinakus@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("1234123")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("Jan")
                .sendKeys(Keys.TAB)
                .sendKeys("4")
                .sendKeys(Keys.TAB)
                .sendKeys("1999")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .perform();

        //5- Kaydol tusuna basalim
        driver.findElement(By.xpath("//button[@name='websubmit']")).click();
    }
}

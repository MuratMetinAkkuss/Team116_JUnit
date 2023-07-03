package tests.day09_Actions_FileTests;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Faker extends TestBase {
    @Test
    public void test01(){
        /*
            Faker kutuphanesi testlerimizi yazarken ihtiyac duyabilecegimiz
            isim,soyisim,email, password, username... gibi
            bilgileri fake olarak kullanabilmemizi saglar
         */
        Faker faker = new Faker();
        System.out.println(faker.name().firstName());
        System.out.println(faker.internet().password());
        System.out.println(faker.internet().emailAddress());
        System.out.println(faker.internet().safeEmailAddress("s"));
    }

    @Test
    public void faceBookTest(){
            //1- https://www.facebook.com adresine gidelim
            driver.get("https://www.facebook.com");
            //2- cookies kabul edelim
            driver.findElement(By.xpath("//button[@data-cookiebanner='accept_button']")).click();
            //3- Yeni hesap olustur butonuna basalim
            driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
            //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
            Actions actions = new Actions(driver);
            Faker faker = new Faker();
            String eMailAdress= faker.internet().emailAddress();
            actions.click(driver.findElement(By.xpath("//input[@name='firstname']")))
                    .sendKeys(faker.name().firstName())
                    .sendKeys(Keys.TAB)
                    .sendKeys(faker.name().lastName())
                    .sendKeys(Keys.TAB)
                    .sendKeys(eMailAdress)
                    .sendKeys(Keys.TAB)
                    .sendKeys(eMailAdress)
                    .sendKeys(Keys.TAB)
                    .sendKeys(faker.internet().password())
                    .sendKeys(Keys.TAB)
                    .sendKeys(Keys.TAB)
                    .sendKeys("jan")
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

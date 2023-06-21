package tests.day07_testBase_dropdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C04_JavaScriptAlert extends TestBase {
    /*
        Bir test'i calistirirken
        Web sayfasi bize uyari verebilir buna Alert diyoruz

        EGER bu uyariyi sag click ile inspect yapabiliyorsak
        bu bir HTML ALERT'tir ve diger tum html elementler gibi
        locate edilebilir ve kullanilabilirler.

        ANCAK
        sag click yapip inspect edemiyorsak
        bunlar javascript alert olabilirler

        JS alert'ler locate edilemezler
        sadece driver'imizi o alertlere
        switch yapip

        o alert'lerde istenen islemleri yapabiliriz

     */

    //1. Test
    // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
    // - 1.alert’e tiklayin
    // - Alert’deki yazinin “I am a JS Alert” oldugunu test edin
    // - OK tusuna basip alert’i kapatin
    //2.Test
    // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
    // - 2.alert’e tiklayalim
    // - Cancel’a basip, cikan sonuc yazisinin “You clicked: Cancel” oldugunu test edin
    //3.Test
    // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
    // - 3.alert’e tiklayalim
    // - Cikan prompt ekranina “Abdullah” yazdiralim
    // - OK tusuna basarak alert’i kapatalim
    // - Cikan sonuc yazisinin Abdullah icerdigini test edelim
    @Test
    public void test01(){
        //1. Test
        // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // - 1.alert’e tiklayin
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        // - Alert’deki yazinin “I am a JS Alert” oldugunu test edin
        String actualAlert = driver.switchTo().alert().getText();
        String expectedAlert = "I am a JS Alert";
        Assert.assertEquals(expectedAlert,actualAlert);
        // - OK tusuna basip alert’i kapatin
        driver.switchTo().alert().accept();

    }

    @Test
    public void test02(){
        //2.Test
        // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // - 2.alert’e tiklayalim
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        // - Cancel’a basip, cikan sonuc yazisinin “You clicked: Cancel” oldugunu test edin
        driver.switchTo().alert().dismiss();
        String expectedResult ="You clicked: Cancel";
        String actualResult = driver.findElement(By.xpath("//p[text()='You clicked: Cancel']")).getText();
        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void test03(){
        //3.Test
        // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // - 3.alert’e tiklayalim
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        // - Cikan prompt ekranina “Abdullah” yazdiralim
        driver.switchTo().alert().sendKeys("Abdullah");
        // - OK tusuna basarak alert’i kapatalim
        driver.switchTo().alert().accept();
        // - Cikan sonuc yazisinin Abdullah icerdigini test edelim
        String expectedOutPut = "Abdullah";
        String actualOutPut = driver.findElement(By.xpath("//p[text()='You entered: Abdullah']")).getText();

        Assert.assertTrue(actualOutPut.contains(expectedOutPut));
    }
}

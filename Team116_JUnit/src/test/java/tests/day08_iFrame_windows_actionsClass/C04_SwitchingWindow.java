package tests.day08_iFrame_windows_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseQuit;

import java.util.Set;

public class C04_SwitchingWindow extends TestBaseQuit {
    @Test
    public void test01(){
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String firstwd = driver.getWindowHandle();
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        Assert.assertEquals("Opening a new window", driver.findElement(By.tagName("h3")).getText());
        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertEquals("The Internet", driver.getTitle());
        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        /*
            Kontrolumuz disinda yeni bir tab veya window acilinca
            driver otomatik olarak oraya gecmez

            Yeni sayfaya gecebilmek icin ikinci sayfanin
            Window handle degerini bulmaliyiz
            bunun icin

            1- ilk sayfada iken ilk sayfa window handle degerini kaydedelim
            2-yeni sayfayi acan linki tiklayalim
            3-ilk ve ikinci sayfanin window handle degerlerini bir set olarak kaydedelim
                SEet<String> wHDSet = driver.geetWindowHandles();
            4-Bir foreach loop ile setteki window handle degerlerini ilk sayfanin
              window handle degeri ile karsilastiralim
              ilkSayfaWHD'ne esit OLMAYAN window handle degerini
              ikinciSayfaWHD olarak kaydedelim

            5-buldugumuz ikinciSayfaWHD'ni kullanarak 2.sayfaya gecelim
         */
        Set<String> wHDSet = driver.getWindowHandles();
        String secondPageHandle =" ";

        for (String each:wHDSet
             ) {
            if (!firstwd.equals(each)){
                secondPageHandle=each;
            }
        }
        driver.switchTo().window(secondPageHandle);
        Assert.assertEquals("New Window",driver.getTitle());
        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        Assert.assertEquals("New Window" , driver.findElement(By.tagName("h3")).getText());
        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(firstwd);
        Assert.assertEquals("The Internet",driver.getTitle());
    }
}

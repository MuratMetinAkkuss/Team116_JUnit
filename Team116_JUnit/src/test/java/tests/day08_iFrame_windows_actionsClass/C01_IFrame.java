package tests.day08_iFrame_windows_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_IFrame extends TestBase {
    @Test
    public void test01(){// 2 ) Bir metod olusturun: iframeTest
        //1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");


        // - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
        WebElement anIframeElement = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(anIframeElement.isEnabled());
        System.out.println(anIframeElement.getText());
        // - Text Box’a “Merhaba Dunya!” yazin.
        /*
            TextBox elementi gozumuzun onunde olmasina
            ve rahatca locate edilebilmesine ragmen
            driekt kullanilamiyor

            HTML kodlarini inceleyince
            textBox'in bir IFRAME icerisinde
            oldugunu gorduk textbox'i kullanmadan once
            IFRAME gecis yapmaliyiz

         */
        WebElement iframeElement = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframeElement);
        WebElement textBoxElement = driver.findElement(By.tagName("p"));
        textBoxElement.clear();
        textBoxElement.sendKeys("Merhaba Dunya!");


        // - TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.

        /*
            Bir iframe'e gecis yapildiysa normal sayfa da islem yapilamaz
            Normal sayfa da islem yapmak isterseniz ifram'den cikmaniz gerekir

            DefaultContent() : Anasayfaya cikar
            ParentFrame() : eger ic ice iFrame'ler varsa bir ust iFrame'e cikar
         */

        driver.switchTo().defaultContent();
        WebElement elemntalSeleniumElement = driver.findElement(By.xpath("//*[text() ='Elemental Selenium']"));
        Assert.assertTrue(elemntalSeleniumElement.isDisplayed());
        System.out.println(elemntalSeleniumElement.getText());
        wait(3);
    }
}

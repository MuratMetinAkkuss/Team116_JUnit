package tests.day07_testBase_dropdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C02_DropDownMenu extends TestBase {

    @Test
    public void test01(){
        //Amazon anaysayfaya gidin
        driver.get("https://www.amazon.com");
        //arama kutusunun yanindaki dropdown menude 34 secenek oldugunu test edin
        //dropdown menuden Baby kategorisini secin
        WebElement ddm = driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));

        Select select = new Select(ddm);

        int expectedDdmSize = 28;
        int actualDdmSize = select.getOptions().size();

        Assert.assertEquals(expectedDdmSize,actualDdmSize);


        select.selectByVisibleText("Baby");
        //Arama kutusuna Nutella yazip aratin
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Nutella" + Keys.ENTER);

        //bulunan sonuc sayisinin 10'dan fazla oldugunu test edin
        String actualResultText = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']")).getText();
        String actualResultStr = actualResultText.substring(0,actualResultText.indexOf(" "));

        int actualResultInt = Integer.parseInt(actualResultStr);

        Assert.assertTrue(actualResultInt>10);

        //sectigimiz opsiyonu yazdirin
        /*
            Biz daha once dropdown menuyu locate etmis
            ve bu menuyu kullanarak select objesi olusturmustuk

            ANCAK
            arama yaptirdigimizda HTML KODLAR yenilendigi icin
            eski elementleri BULAMAYABILIR
            bu durumda "stale element" uyarisi verir

            yapmamiz gereken :
            yeniden obje olusturmak degil
            var olan objelere degerleri assignment yapmaktir
         */
         ddm = driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
         select = new Select(ddm);

        System.out.println(select.getFirstSelectedOption().getText());


        //sectigimiz opsiyonun Baby oldugunu test edin
        Assert.assertEquals("Baby",select.getFirstSelectedOption().getText());

    }
}

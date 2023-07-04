package tests.day10_waits_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C03_WebTables extends TestBase {
    @Test
    public void test01(){
        //1.“https://www.amazon.com” adresine gidin
        driver.get("https://www.amazon.com");
        //2.Sayfanin en altina inin
        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(By.xpath("//div[@class='navFooterLine navFooterLinkLine navFooterDescLine']"))).perform();
        wait(2);
        //3.Web table tum body’sini yazdirin
        System.out.println(driver.findElement(By.xpath("//tbody")).getText());
        //4.Web table’daki satir sayisinin 9 oldugunu test edin
        List<WebElement> trList = driver.findElements(By.xpath("//tbody/tr"));
        int expectedNumberOfRow = 9 ;
        int actualNumberOfRow = trList.size();
        Assert.assertEquals(expectedNumberOfRow,actualNumberOfRow);
        //5.Tum satirlari yazdirin
        System.out.println("==============================");
        for (WebElement eachElement:trList
             ) {
            System.out.println(eachElement.getText());
        }
        //6. Web table’daki sutun sayisinin 13 olduğunu test edin
        List<WebElement> listOffifthOfRow = driver.findElements(By.xpath("//tbody/tr[5]/td"));
        int expectedNumberOfColumn = 13 ;
        int actualNumberOfColumn = listOffifthOfRow.size();
        Assert.assertEquals(expectedNumberOfColumn,actualNumberOfColumn);
        //7. 5.sutunu yazdirin
        List<WebElement> besinciSutunElementleriList =
                driver.findElements(By.xpath("//tbody/tr/td[5]"));
        System.out.println("======5.Sutun=======");
        for (WebElement eachData: besinciSutunElementleriList
        ) {
            System.out.println(eachData.getText());
        }
        //8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun
        System.out.println("===========istenen yazi=============");
        System.out.println(ReusableMethods.hucredekiYaziyiGetir(3, 5, driver));
    }
}

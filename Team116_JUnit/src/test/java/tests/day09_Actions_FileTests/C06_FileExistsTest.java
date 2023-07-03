package tests.day09_Actions_FileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C06_FileExistsTest extends TestBase {
    @Test
    public void test01(){
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
            driver.get("https://the-internet.herokuapp.com/download");
        //3. logo.png dosyasını indirelim
            driver.findElement(By.xpath("//a[text()='avatar.png']")).click();
            wait(5);
        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        //once dosyanin indirilecegi dosya yolunu dinamik olarak olusturalim
        String dynamicFilePath = System.getProperty("user.home")+"\\Downloads\\avatar.png";
        System.out.println(dynamicFilePath);
        wait(5);
        //herkesin pc'de farkli kisim + herkes icin ayni olan kisim seklinda dinamik hale getirdik.
        Assert.assertTrue(Files.exists(Path.of(dynamicFilePath)));
    }
    @Test
    public void masaustu(){
        //avatar resmini masaustune kopyalayin
        //masaustune avatar dosyasi oldugunu test edin

        String dynamicFilePath = System.getProperty("user.home") + "\\Desktop\\avatar.png";
        Assert.assertTrue(Files.exists(Path.of(dynamicFilePath)));

    }
}

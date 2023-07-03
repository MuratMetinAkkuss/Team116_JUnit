package tests.day09_Actions_FileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C07_FileUpload extends TestBase {
    @Test
    public void test01(){
        //1.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //2.chooseFile butonuna basalim
        //!!!!!!!burada choose file butonuna basilirsa pc'den fiziki olarak dosya acilir
        //!!!!!!!driver ile mudahale edemeyiz.
        //bunun yerine selenium'un bize sundugu cozumu kullanacagiz
        WebElement chooseFileElement = driver.findElement(By.id("file-upload"));
        //3.Masaustune kopyaladigimiz avat.png dosyayi secelim.
        String dynamicFilePath = System.getProperty("user.home")+"\\Desktop\\avatar.png";
        //4.Upload butonuna basalim.
        chooseFileElement.sendKeys(dynamicFilePath);
        //5.“File Uploaded!” textinin goruntulendigini test edelim.
        driver.findElement(By.id("file-submit")).click();
        WebElement fileUploadElement = driver.findElement(By.xpath("//h3[text()='File Uploaded!']"));
        Assert.assertTrue(fileUploadElement.isDisplayed());
    }

}

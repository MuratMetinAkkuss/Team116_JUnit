package tests.day09_Actions_FileTests;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C05_FileExists{
    @Test
    public void test01(){
        //C:\Users\HUAWEI\Downloads\avatar.png

        /*
            bir dosyanin bilgisayarimizda oldugunu test etmek kolaydir
            ancak testimizin dinamik olmasini saglamak
            yani hangi bigisayarda calistirilirsa calistirilsin
            testin dogru calisabilmesi icin
            dosya yoluna calismamiz gerekir
         */

        //bir dosyanin bilgisayarimizda oldgunu test etmek

        Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\HUAWEI\\Downloads\\avatar.png")));
    }

    @Test
    public void dinamikTest(){
        //dosya yolunu dinamik yapalim

        //C:\Users\HUAWEI           \Downloads\avatar.png

        //Java'da dosya yolunu bize veren iki adet kod var

        //1- calistigimiz klasor'un dosya yolunu almak isterseniz
        System.out.println(System.getProperty("user.dir"));
        //C:\Users\HUAWEI\Documents\GitHub\Team116_JUnit\Team116_JUnit

        //2- bilgisayarimizin ana dosya yolu
        System.out.println(System.getProperty("user.home"));
        //C:\Users\HUAWEI

        //bu bilgileri kullanarak
        //indirdigimiz dosyanin dosya yolunu elde etmek istersek
        //iki parcadan elde edebiliriz
        //System.getProperty("user.home") + herkeste ayni olan kisim

        String dinamikDosyaYolu = System.getProperty("user.home") + "/Downloads/avatar.png";

        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));


    }
}

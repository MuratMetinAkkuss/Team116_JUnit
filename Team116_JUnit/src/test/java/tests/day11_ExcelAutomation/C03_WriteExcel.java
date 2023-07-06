package tests.day11_ExcelAutomation;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C03_WriteExcel {
    @Test
    public void test01() throws IOException {
        String filePath1 = "src/test/java/tests/day11_ExcelAutomation/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(filePath1);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet page1 = workbook.getSheet("Sayfa1");
        //4) 4.hucreye yeni bir cell olusturalim
        //5) Olusturdugumuz hucreye “Nufus” yazdiralim
        //6) 2.satir nufus kolonuna 1500000 yazdiralim
        //7) 10.satir nufus kolonuna 250000 yazdiralim
        //8) 15.satir nufus kolonuna 54000 yazdiralim
        //9) Dosyayi kaydedelim
        //10)Dosyayi kapatalim
    }
}

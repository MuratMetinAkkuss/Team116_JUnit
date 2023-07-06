package tests.day11_ExcelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {
    @Test
    public void test01() throws IOException {
        String filePath1 = "src/test/java/tests/day11_ExcelAutomation/ulkeler.xlsx";
        /*
            eger excel dosyasi proje icerisinde degilse
            masaustu, downloads gibi baski bir klasorun icinde ise
            dosya yolu dinamik hale getirilebilir
         */
        FileInputStream fis = new FileInputStream(filePath1);

        Workbook workbook = WorkbookFactory.create(fis);
        /*
            olusturdugumuz WorkBook biizim excel'imizi canli olarak kullanmaz
            23. satir calistiginda FileInputStream'deki yani verdigimiz dosaya
            yolunda olan excel'deki tum bilgileri alip, bu class'da olusturdugumuz
            WorkBook objesine yukler

            yani WorkBook objesi excel'deki bilgilerin bir kopyasina sahip olur
            Workbook'da bir degisiklik yaparsak ana excel'imiz degismez,
            EGER ana excel'inde degismesini istiyorsak
            islem bittikten sonra
            yani class'in en sonunda
            workbook'daki yeni hali excel'e kaydetmemiz gerekir.
         */

        Sheet sheet = workbook.getSheet("Sayfa1");
        Row row = sheet.getRow(3);
        Cell cell = row.getCell(2);
        System.out.println(cell);

        //excel'de satir ve sutun numaralari index kullanir
        //yani 0'dan baslar

        //12. satirda bulunan Azerbaycan'in ingilizce baskent ismini baku oldugunu test edin


    }
}

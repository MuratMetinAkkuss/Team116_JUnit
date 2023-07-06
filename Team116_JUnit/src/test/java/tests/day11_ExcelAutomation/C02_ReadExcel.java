package tests.day11_ExcelAutomation;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {
    @Test
    public void test01() throws IOException {
        String filePath1 = "src/test/java/tests/day11_ExcelAutomation/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(filePath1);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");

        System.out.println(sayfa1.getRow(0).getCell(1));
    }
}

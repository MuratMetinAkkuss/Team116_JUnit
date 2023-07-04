package tests.day10_waits_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C04_WebTables extends TestBase{
    @Test
    public void test01(){
        //1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        // 2. Headers da bulunan basliklari yazdirin
        List<WebElement> headersListElement = driver.findElements(By.xpath("//div[@role='columnheader']"));
        int counter = 1;
        for (WebElement eachlistElement: headersListElement
             ) {
            System.out.println( counter + ". text of elements : " + eachlistElement.getText());
            counter++;
        }
        // 3. 3.sutunun basligini yazdirin
        System.out.println(3 +". head of titles : "+driver.findElement(By.xpath("(//div[@role='columnheader'])[3]")).getText());
        // 4. Tablodaki tum datalari yazdirin
        // 5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        List<WebElement> dataOfTablesList = driver.findElements(By.xpath("//div[@role='gridcell']"));
        counter = 1;
        for (WebElement each:dataOfTablesList
             ) {
            if (!each.getText().isBlank()) {
                System.out.println(each.getText());
                counter++;
            }
        }
        System.out.println(counter + " of datas is not blank");
        // 6. Tablodaki satir sayisini yazdirin
        List<WebElement> numberOfRowList = driver.findElements(By.xpath("//div[@role='row']"));
        System.out.println("there are " + numberOfRowList.size()+ " row in list");
        // 7. Tablodaki sutun sayisini yazdirin
        List<WebElement> numberOfColumnList = driver.findElements(By.xpath("//div[@role='columnheader']"));
        System.out.println("there are " + numberOfColumnList.size()+ " column in list");
        // 8. Tablodaki 3.kolonu yazdirin
        List<WebElement> tirthColumnList = driver.findElements(By.xpath("//div[@role='row']/div[@class='rt-td'][3]"));
        for (WebElement each:tirthColumnList
        ) {
            if (!each.getText().isBlank()) {
                System.out.println("Column of Age : " + each.getText());
            }
        }
        // 9. Tabloda “First Name” i Kierra olan kisinin Salary’sini yazdirin
        List<WebElement> firstNameElement = driver.findElements(By.xpath("//div[@role='row']/div[@class='rt-td'][1]"));
        counter = 2;
        for (WebElement eachFirstName: firstNameElement
             ) {
            if (eachFirstName.getText().equals("Kierra")){
                String xPath ="((//div[@role='row'])["+counter+"]/div[@class='rt-td'])[5]";
                System.out.println("Kierra's salary = " + driver.findElement(By.xpath(xPath)).getText());
            }
            counter++;
        }

        //10. ReusableMethods sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin
        
    }
}

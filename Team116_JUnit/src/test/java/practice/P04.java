package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class P04 extends TestBase {
    @Test
    public void test01(){
        //usage of dropDownMenu

        //● https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
         //    1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement dropDownelement = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropDownelement);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        //    2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        //    3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        //    4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> dropdownOptionsElement = select.getOptions();
        for (WebElement eachValue: dropdownOptionsElement
             ) {
            System.out.println(eachValue.getText());
        }
         //    5. Dropdown’un boyutunun 3 olduğunu test edin
        Assert.assertEquals(3,dropdownOptionsElement.size());




    }
}

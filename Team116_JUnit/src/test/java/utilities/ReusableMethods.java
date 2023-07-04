package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class ReusableMethods {

    public static String seconPageWindowHandle(String firstPageWindowHandle, WebDriver driver){
        String secondPageWindowHandle = " ";
        Set<String> windowHandlesSet = driver.getWindowHandles();
        for (String each:windowHandlesSet
        ) {
            if (!firstPageWindowHandle.equals(each)){
                secondPageWindowHandle = each;
            }
        }
        return secondPageWindowHandle;
    }
    public static String hucredekiYaziyiGetir(int satirNo , int sutunNo,WebDriver driver){
        //               //tbody/tr[    5    ]/td[   1    ]

        String dinamikXPath = "//tbody/tr["+satirNo+"]/td["+sutunNo+"]";
        WebElement istenenHucredekiElement = driver.findElement(By.xpath(dinamikXPath));

        return istenenHucredekiElement.getText();


    }
}

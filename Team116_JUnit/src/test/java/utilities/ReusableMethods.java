package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    public static void takeSSOnAllPage(WebDriver driver){

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        //dosya yolunu dinamik hale getirmek icin time stamp kullanalim
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMMddhhmm");

        String dynamicFilePath = "target/Screenshot/AllPage"+ldt.format(dtf)+".png";
        File  ssForAllPage = new File(dynamicFilePath);
        File temproaryPage = takesScreenshot.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(temproaryPage,ssForAllPage);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void takeSSOfWebElement(WebDriver driver,WebElement wantedElement) {

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        //dosya yolunu dinamik hale getirmek icin time stamp kullanalim
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMMddhhmm");

        String dynamicFilePath = "target/Screenshot/WebElement" +ldt.format(dtf) + ".png";
        File ssForWebElement = new File(dynamicFilePath);
        File temproaryPage = takesScreenshot.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(temproaryPage, ssForWebElement);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

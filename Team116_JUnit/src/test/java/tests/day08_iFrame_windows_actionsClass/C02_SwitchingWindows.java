package tests.day08_iFrame_windows_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBaseQuit;

public class C02_SwitchingWindows extends TestBaseQuit {
    @Test
    public void test01(){

        //amazon ana sayfaya gidin
        driver.get("https://www.amazon.com");
        //URL'in amazon icerdigini test edin
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));

        wait(3);

        //Yeni bir tab olarak wise quarter anasayfaya gidin
        //Title'in wise icerdigini test edin
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.wisequarter.com");
        String expectedTitle = "Wise";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //yeni bir window acarak youtube sayfasina gidin
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.youtube.com");
        wait(2);

        //URL'i youtube icerdigini test edin
        String expectedUrl = "youtube";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrl));

        //acilan tum sayfalari kapatin

    }
}

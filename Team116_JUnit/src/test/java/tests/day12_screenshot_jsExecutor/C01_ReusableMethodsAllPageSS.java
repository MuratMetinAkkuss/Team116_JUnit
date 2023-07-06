package tests.day12_screenshot_jsExecutor;

import org.junit.Assert;
import org.junit.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C01_ReusableMethodsAllPageSS extends TestBase {
    @Test
    public void test01(){
        //wisequarter ana sayfaya gidin
        driver.get("https:/www.wisequarter.com");

        //url'in wise icerdigini kontrol edin
        Assert.assertTrue(driver.getCurrentUrl().contains("wise"));
        //tum sayfa screenshot alin
        ReusableMethods.takeSSOnAllPage(driver);


    }
}

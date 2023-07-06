package tests.day12_screenshot_jsExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C02_WebElementScreenShot extends TestBase {
    @Test
    public void test01(){
        //google'a gidin
        driver.get("https:/www.google.com");

        //cookies'leri kabul etmek icin
        driver.findElement(By.xpath("(//div[@class='QS5gu sy4vM'])[2]")).click();
        //Nutella aratin
        driver.findElement(By.id("APjFqb")).sendKeys("Nutella");
        driver.findElement(By.xpath("(//input[@class='gNO89b'])[2]")).click();

        //SS
        WebElement searchResult = driver.findElement(By.id("result-stats"));
        ReusableMethods.takeSSOfWebElement(driver,searchResult);


    }
}

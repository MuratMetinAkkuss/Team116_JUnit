package tests.day08_iFrame_windows_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;
import utilities.TestBaseQuit;

import javax.swing.*;
import java.util.Set;

public class C05_Actions extends TestBaseQuit {
    @Test
    public void test01(){
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        String firstWDH = driver.getWindowHandle();
        //3- Cizili alan uzerinde sag click yapin
        Actions actions = new Actions(driver);
        WebElement elementClick = driver.findElement(By.id("hot-spot"));
        actions.contextClick(elementClick).perform();
        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText());
        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        //6- Elemental Selenium linkine tiklayalim
        WebElement elementelSeleniumElement = driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        elementelSeleniumElement.click();
        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        String secondPageWH = ReusableMethods.seconPageWindowHandle(firstWDH,driver);
        driver.switchTo().window(secondPageWH);

        Assert.assertEquals("Make sure your code lands", driver.findElement(By.tagName("h1")).getText());
    }
}

package tests.day09_Actions_FileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class C01_Actions_MoveToElement extends TestBase {
    @Test
    public void test01(){

        //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        WebElement accountListElement = driver.findElement(By.xpath("//span[text()='Account & Lists']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(accountListElement).perform();
        //3- “Create a list” butonuna basin
        actions.click(driver.findElement(By.xpath("//span[text()='Create a List']"))).perform();
        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("//div[@aria-level='1']")).isDisplayed());


    }
}

package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P03 extends TestBase {

    @Test
    public void test01() {

        //https://www.amazon.com/gp/goldbox?ref_=nav_cs_gb adresine gidin
        driver.get("https://www.amazon.com/gp/goldbox?ref_=nav_cs_gb");
        //prime programs kismindaki ilk 3 checkbox locate edin
        WebElement primeCheckElement = driver.findElement(By.xpath("(//input[@data-csa-c-element-type='option'])[1]"));
        WebElement primeEarlyCheckElement = driver.findElement(By.xpath("(//input[@data-csa-c-element-type='option'])[2]"));
        WebElement primeExclusiveCheckElement = driver.findElement(By.xpath("(//input[@data-csa-c-element-type='option'])[3]"));
        // 3 checkbox'a isaretleyin
        if (!primeCheckElement.isSelected()) {
            primeCheckElement.click();
        }
        if (!primeEarlyCheckElement.isSelected()) {
            primeEarlyCheckElement.click();
        }
        if (!primeExclusiveCheckElement.isSelected()) {
            primeExclusiveCheckElement.click();
        }
        //her 3 checkbox'inda isaretli oldugunu dogrulayin
        Assert.assertTrue(primeCheckElement.isSelected());
        Assert.assertTrue(primeEarlyCheckElement.isSelected());
        Assert.assertTrue(primeExclusiveCheckElement.isSelected());


    }
}

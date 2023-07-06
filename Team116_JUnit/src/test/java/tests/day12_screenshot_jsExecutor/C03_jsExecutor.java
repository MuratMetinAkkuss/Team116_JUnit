package tests.day12_screenshot_jsExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

public class C03_jsExecutor extends TestBase {
    @Test
    public void test01(){
        //wise quarter anasayfaya gidelimm
        driver.get("https:/www.wisequarter.com");
        //JavaScript executor kullanarak contact linkine tiklayin
        WebElement contactLinkElement = driver.findElement(By.xpath("//a[text()='Contact']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();",contactLinkElement);

        //asagida bulunan "go to career page" butonuna kadar asagi inin
        //ve bu butona basin


        driver.navigate().back();
        WebElement goToCareerElement = driver.findElement(By.xpath("//*[@class='fas fa-paper-plane']"));

        jse.executeScript("arguments[0].scrollIntoView(true);",goToCareerElement);
        //goToCareerElement.click();

        wait(5);
        jse.executeScript("alert('Naber')");
        wait(5);
    }
}

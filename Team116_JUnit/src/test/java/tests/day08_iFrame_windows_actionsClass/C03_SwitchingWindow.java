package tests.day08_iFrame_windows_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBaseQuit;

public class C03_SwitchingWindow extends TestBaseQuit {
    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        String amazonHandle = driver.getWindowHandle();
        //yeni bir tab olarak wisequarter'a gidelim

        driver.switchTo().newWindow(WindowType.TAB).get("https://www.wisequarter.com");
        String wiseHandle = driver.getWindowHandle();

        //yeni bir sayfa olarak youtube'a gidin

        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.youtube.com");
        String youtubeHandle = driver.getWindowHandle();
        //amazon'un acik oldugu sayfaya donun ve url'in amazon icerdigini test edin
        driver.switchTo().window(amazonHandle);
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));

        //wise quarter'in acik oldugu sayfaya gidin ve Title'in wise icerdigini test edin
        driver.switchTo().window(wiseHandle);
        Assert.assertTrue(driver.getTitle().contains("Wise"));

        //Youtube'un acik oldugu sayfaya gidin ve url'in youtube icerdigini test edin
        driver.switchTo().window(youtubeHandle);
        Assert.assertTrue(driver.getCurrentUrl().contains("youtube"));

        wait(2);

    }
}

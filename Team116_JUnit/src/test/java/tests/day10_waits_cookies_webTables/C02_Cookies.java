package tests.day10_waits_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C02_Cookies extends TestBase {
    @Test
    public void test01(){
        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //2- tum cookie’leri listeleyin
        Set<Cookie> cookiesSet =driver.manage().getCookies();
        int numberOfLine = 1;
        for (Cookie eachCookie: cookiesSet
             ) {
            System.out.println(numberOfLine + "-" + eachCookie);
            numberOfLine++;
        }
        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(cookiesSet.size() > 5);
        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String expectedValue = "USD";
        String actualValue = driver.manage().getCookieNamed("i18n-prefs").getValue();
        Assert.assertEquals(expectedValue,actualValue);
        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        Cookie cookie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);
        System.out.println("=======================");
        cookiesSet =driver.manage().getCookies();
        numberOfLine = 1;
        for (Cookie eachCookie: cookiesSet
        ) {
            System.out.println(numberOfLine + "-" + eachCookie);
            numberOfLine++;
        }
        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        String expectedCookieValue = "cikolatali";
        String actualCookieValue = driver.manage().getCookieNamed("en sevdigim cookie").getValue();
        Assert.assertEquals(expectedValue,actualValue);
        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        //-----Yok oldugunu test etmek icin tum cookie isimlerini kontrol edelim
        //-----ismi skin olan varsa bir flag ile var ise flag'i degistirelim.
        boolean isThereSkin = false;
        cookiesSet =driver.manage().getCookies();
        for (Cookie eachCookie:cookiesSet
             ) {
            if (eachCookie.getName().equals("skin")){
                isThereSkin = true;
                break;
            }
        }
        Assert.assertFalse(isThereSkin);
        //8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookiesSet =driver.manage().getCookies();
        Assert.assertEquals(0, cookiesSet.size());
    }
}

package utilities;

import org.openqa.selenium.WebDriver;

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
}

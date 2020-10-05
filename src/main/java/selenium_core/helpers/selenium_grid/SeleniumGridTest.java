package selenium_core.helpers.selenium_grid;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGridTest
{
    @Test
    public void chromeTest() throws MalformedURLException
    {
        //1. Define desire capabilities:
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName("chrome");
        cap.setPlatform(Platform.MAC);
        // cap.setPlatform(Platform.WIN10);

        //2. Chrome option definition
        ChromeOptions options = new ChromeOptions();
        options.merge(cap); // Just join the options + cap

        //3. HUB address
        String hubUrl = "http://192.168.1.19:4444/wd/hub";
        //4. WebDriver instance
        WebDriver driver = new RemoteWebDriver(new URL(hubUrl),options);
        //------------------------------------------------//test

        driver.get("http://www.facebook.com");
        System.out.println(driver.getTitle());

//        DesiredCapabilities cap = DesiredCapabilities.chrome();
//        ChromeOptions options = new ChromeOptions();
//        cap.setCapability(ChromeOptions.CAPABILITY,options);
//        RemoteWebDriver driver= new RemoteWebDriver(new URL("http://192.168.1.19:4444/wd/hub"), cap);
//        driver.get("http://www.facebook.com");
//        System.out.println(driver.getTitle());


    }
}

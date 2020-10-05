package selenium_core.helpers.browser_configurations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager
{
    //----------------------------------------------------------------------------------------------------------------||
    private WebDriver driver;
    //----------------------------------------------------------------------------------------------------------------||
    public WebDriver chromeDriver()
    {
        try
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return driver;
    }
    //-------------------------------------------------------------------------||firefox
    public WebDriver firefoxDriver()
    {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        //driver.get(address);
        return driver;
    }
    //--------------------------------------------------------------------------||edge
    public WebDriver edgeDriver()
    {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        return driver;
    }
    //--------------------------------------------------------------------------||IE
    public WebDriver internetExplorerDriver()
    {
        WebDriverManager.chromedriver().setup();
        driver = new InternetExplorerDriver();
        return driver;
    }
    //---------------------------------------------------------------------------||opera
    public WebDriver operaDriver()
    {
        WebDriverManager.operadriver().setup();
        driver = new OperaDriver();
        return driver;
    }
     //-------------------------------------------------------------------------||safari
     public WebDriver safariDriver()
     {
          WebDriverManager.chromedriver().setup();
          driver = new SafariDriver();
          return driver;
     }
    //-------------------------------------------------------------------------||tearDown
    public void shutDown()
    {
        if(driver != null)
        {
            driver.quit();
        }
    }
    //----------------------------------------------------------------------------------------------------------------||
}

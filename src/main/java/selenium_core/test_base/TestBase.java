package selenium_core.test_base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.Reporter;
import selenium_core.helpers.browser_configurations.*;
import selenium_core.helpers.browser_configurations.config.ConfigReader;
import selenium_core.helpers.browser_configurations.config.ObjectReader;
import selenium_core.helpers.browser_configurations.config.PropertyReader;
import selenium_core.helpers.excel.ExcelHelper;
import selenium_core.helpers.javascript.JavaScriptHelper;
import selenium_core.helpers.logger.MyLogger;
import selenium_core.helpers.resource.ResourceHelper;
import selenium_core.helpers.wait.WaitHelper;
import selenium_core.utils.ExtentManager;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class TestBase  // TestNg annotation reporting.html
{
    //----------------------------------------------------------------------------------------------------------------||
    public static ExtentReports extentReports;
    public static ExtentTest test;
    private Logger log = MyLogger.getLogger(TestBase.class);
    public WebDriver driver;
    public static File reportDirectory;
    //----------------------------------------------------------------------------------------------------------------||
    //@BeforeTest
    public void beforeTest() throws Exception
    {
        //ConfigReader reader = new PropertyReader();// The same
        ObjectReader.reader = new PropertyReader(); // Initialize data in RUNTIME for reading data from configuration file
        //reportDirectory = new File(ResourceHelper.getRecoursePath("\\src\\main\\java\\core\\screenshots\\"));
        reportDirectory = new File(ResourceHelper.getRecoursePath("/src/main/java/selenium_core/screenshots"));
        setUpDriver(ObjectReader.reader.getBrowserType()); // Launch the browser + and browser type
        test = extentReports.createTest(getClass().getName());
    }
    //----------------------------------------------------------------------------------------------------------------||
    //@BeforeSuite
    public void beforeSuite() // Getting instance of ExtentManager class
    {
        extentReports = ExtentManager.getInstance();
    }
    //----------------------------------------------------------------------------------------------------------------||
    //@BeforeClass
    //public void beforeClass()
    //{
    //
    //}
    //----------------------------------------------------------------------------------------------------------------||
    //@AfterClass
    public void afterClass()
    {
        driverClose();
        driverQuit();
    }
    //----------------------------------------------------------------------------------------------------------------||
    //@BeforeMethod
    public void beforeMethod(Method method)
    {
        test.log(Status.INFO, method.getName() + " test started...(from --> @BeforeMethod)");
    }
    //----------------------------------------------------------------------------------------------------------------||
    //@AfterMethod
    public void afterMethod(ITestResult result) throws IOException
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            test.log(Status.FAIL, result.getThrowable());
            String imagePath = captureScreenShot(result.getName(), driver);
            log.info("<<< Report:  Test failed  ******************************************************* >>>");
            test.addScreenCaptureFromPath(imagePath);
        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
            test.log(Status.PASS, result.getName() + " is pass");
            String imagePath = captureScreenShot(result.getName(), driver);
            log.info("<<< Adding ScreenShot to report file ... >>>");
            test.addScreenCaptureFromPath(imagePath);
        }
        else if(result.getStatus() == ITestResult.SKIP)
        {
            log.info("<<<Skipping test...>>>");
            test.log(Status.SKIP, result.getThrowable());
        }
        extentReports.flush();
    }
    //----------------------------------------------------------------------------------------------------------------||
    public WebDriver getBrowserObject(BrowserType btype) throws Exception
    {
        try
        {
            switch (btype)
            {
                case Chrome:
                    //Get object of ChromeBrowser class
                    ChromeBrowser chrome = ChromeBrowser.class.newInstance(); //Instance of chrome browser class
                    ChromeOptions options_0 = chrome.getChromeOptions();
                    return chrome.getChromeDriver(options_0);

                case Firefox:
                    //Get object of Firefox class
                    FirefoxBrowser firefox = FirefoxBrowser.class.newInstance();
                    FirefoxOptions options_1 = firefox.getFirefoxOptions();
                    return  firefox.getFirefoxDriver(options_1);

                case IExplorer:
                    //Get object of Edge class
                    IExplorerBrowser ie = IExplorerBrowser.class.newInstance();
                    InternetExplorerOptions cap = ie.getIExplorerCapabilities();
                    return ie.getInternetExplorerDriver(cap);

                case Safari:
                    //Get object of Safari class

                case Zalenium_docker:
                    //Get object of Zalenium_docker class
                    Zalenium_docker zalenium = new Zalenium_docker(); //Instance of chrome browser class
                    zalenium.setUp("");
                    //return chrome.getChromeDriver(options_0);

                default:
                        throw new Exception("Driver not found: " + btype.name());
            }
        }
        catch (Exception e)
        {
            log.info(e.getMessage());
            throw e;
        }
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void setUpDriver(BrowserType btype) throws Exception
    {
        driver = getBrowserObject(btype);
        log.info("Initialize Web driver hash-code: " + driver.hashCode());
        WaitHelper wait = new WaitHelper(driver);
        wait.setImplicitWait(ObjectReader.reader.getImplicitWait(), TimeUnit.SECONDS);
        wait.pageLoadTime(ObjectReader.reader.getPageLoadTime(), TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    //----------------------------------------------------------------------------------------------------------------||
    public  String captureScreenShot(String fileName, WebDriver driver)
    {
        if(this.driver == null)
        {
            log.info("Driver is null...");
            return null;
        }
        if (fileName == "")
        {
            fileName = "blank";
        }
        Reporter.log("CaptureScreen method called");
        File destFile = null;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        File screenshotFile = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);
        try
        {
            destFile = new File(reportDirectory +"/"+fileName+"_"+formatter.format(calendar.getTime())+".png");
            //destFile = new File(ResourceHelper.getRecoursePath("/src/main/java/selenium_core/screenshots/") + driver.getTitle() + ".png");
            log.info("Taking a pass...");
            Files.copy(screenshotFile.toPath(), destFile.toPath());
            //FileUtils.copyFile(screenshotFile, destFile);
            Reporter.log("<a href='"+destFile.getAbsolutePath()+"'><img src='"+destFile.getAbsolutePath()+"'height='100' width='100'/></a>");
            //Reporter.log("<br><img src='"+destFile+"' height='400' width='400'/><br>");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return destFile.toString();
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void getNavigationScreen(WebDriver driver)
    {
        log.info("Capturing UI navigation screen..");
        new JavaScriptHelper(driver).zoomInBy60Percentage();
        String screen = captureScreenShot("", driver);
        new JavaScriptHelper(driver).zoomInBy100Percentage();
        try
        {
            test.addScreenCaptureFromPath(screen);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    //----------------------------------------------------------------------------------------------------------------||
    public static void logExtentReport(String log)
    {
        test.log(Status.INFO, log);
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void getApplicationUrl(String url)
    {
        driver.get(url);
        logExtentReport("Navigate to ... " + url);
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void driverQuit()
    {
        if(driver != null)
        {
            driver.quit();
        }
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void driverClose()
    {
        if(driver != null)
        {
            driver.close();
        }
    }
    //----------------------------------------------------------------------------------------------------------------||
    public Object[][] getExcelData(String excelName, String sheetName)
    {
        String excelLocation = ResourceHelper.getRecoursePath("/src/main/java/selenium_core/excel_sheets_data/")+excelName;
        log.info("excel location "+excelLocation);
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getExcelData(excelLocation, sheetName);
        return data;
    }
    //----------------------------------------------------------------------------------------------------------------||

}


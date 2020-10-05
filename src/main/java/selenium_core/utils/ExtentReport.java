package selenium_core.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.Test;

import java.io.IOException;

public class ExtentReport
{
    //------------------------------------------------------------------------------------------------------------||
    @Test
    public void loginTest() throws IOException
    {
        System.out.println("Login to Amazon");

        ExtentHtmlReporter reporter = new ExtentHtmlReporter("test-output/extent_mukesh.html");

        ExtentReports extent = new ExtentReports();

        extent.attachReporter(reporter);

        ExtentTest logger_1 = extent.createTest("Login Test");

        logger_1.log(Status.INFO, "Login to Amazon");

        logger_1.log(Status.PASS, "Title verified");

        extent.flush();
        //------------------------------------------------------------------------------------------------------------||
        ExtentTest logger_2 = extent.createTest("Logoff Test");

        logger_2.log(Status.FAIL, "Title verified");

        logger_2.addScreenCaptureFromPath("/Users/Stan/IdeaProjects/workablereposelenium/src/main/java/core/screenshots/testScreen_15_10_2019_07_47_47.jpg");

        extent.flush();
        //------------------------------------------------------------------------------------------------------------||
    }
}

package selenium_core.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager
{
    private static ExtentReports extent;
    //----------------------------------------------------------------------------------------------------------------||
    public static ExtentReports getInstance()
    {
        if(extent == null)
        {
            return createInstance("test_output/extent.html");
        }
        else
        {
            return extent;
        }
    }
    //----------------------------------------------------------------------------------------------------------------||
    public static ExtentReports createInstance(String fileName)
    {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(fileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("AUTOMATION Report");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        return extent;
    //----------------------------------------------------------------------------------------------------------------||
    }
}

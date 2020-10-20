package selenium_core.test_scripts;

import org.testng.annotations.Test;
import selenium_core.helpers.assertion.AssertionHelper;
import selenium_core.test_base.TestBase;

public class TestReportExample extends TestBase
{
    @Test
    public void testScreen()
    {
        driver.get("https://www.lifehack.org/money");
        //captureScreenShot("Money", driver);
    }
}


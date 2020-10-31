package selenium_core.test_scripts;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenium_core.helpers.assertion.AssertionHelper;
import selenium_core.helpers.browser_configurations.config.ObjectReader;
import selenium_core.helpers.logger.MyLogger;
import selenium_core.page_objects.LoginPage;
import selenium_core.page_objects.NavigationMenu;
import selenium_core.test_base.TestBase;

public class LoginTestDDaproache extends TestBase
{
    private final Logger log = MyLogger.getLogger(LoginTestDDaproache.class);

    LoginPage login;
    NavigationMenu navigationMenu;


    @DataProvider(name="testData")
    public Object[][] testData()
    {
        Object[][] data = getExcelData("testData.xlsx", "loginData");
        return data;
    }
    @BeforeClass
    public void beforeClass()
    {
        getApplicationUrl(ObjectReader.reader.getApplicationUrl());
        login = new LoginPage(driver);
    }
    @Test(dataProvider="testData")
    public void loginTest(String userName, String password, String runMode){

        if(runMode.equalsIgnoreCase("n"))
        {
            throw new SkipException("Run mode for this set of data is marked N");
        }
        login.loginToApplication(userName, password);
        boolean status = login.verifySuccessLoginMsg();
        AssertionHelper.updateTestStatus(status);
        login.logout();
    }
}

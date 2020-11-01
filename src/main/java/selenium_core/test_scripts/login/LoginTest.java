package selenium_core.test_scripts.login;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import selenium_core.helpers.assertion.AssertionHelper;
import selenium_core.helpers.browser_configurations.config.ObjectReader;
import selenium_core.helpers.logger.MyLogger;
import selenium_core.page_objects.LoginPage;
import selenium_core.test_base.TestBase;

public class LoginTest extends TestBase
{
    //----------------------------------------------------------------------------------------------------------------||
    private final Logger log = MyLogger.getLogger(LoginTest.class);
    //----------------------------------------------------------------------------------------------------------------||
    @Test(description="Login test with valid credentials")
    public void testLoginToApplication()
    {
        getApplicationUrl(ObjectReader.reader.getApplicationUrl());
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToApplication(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
        boolean status = loginPage.verifySuccessLoginMsg();
        AssertionHelper.updateTestStatus(status);
    }
    //----------------------------------------------------------------------------------------------------------------||
}

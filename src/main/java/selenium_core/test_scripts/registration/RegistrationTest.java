package selenium_core.test_scripts.registration;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import selenium_core.helpers.assertion.AssertionHelper;
import selenium_core.helpers.browser_configurations.config.ObjectReader;
import selenium_core.helpers.logger.MyLogger;
import selenium_core.page_objects.LoginPage;
import selenium_core.page_objects.MyAccountPage;
import selenium_core.page_objects.RegistrationPage;
import selenium_core.test_base.TestBase;

public class RegistrationTest extends TestBase
{
    //----------------------------------------------------------------------------------------------------------------||
    private final Logger log = MyLogger.getLogger(RegistrationTest.class);
    LoginPage loginPage;
    RegistrationPage register;
    MyAccountPage myAccountPage;
    //----------------------------------------------------------------------------------------------------------------||
    @Test
    public void testRegistration()
    {
        // go to application
        getApplicationUrl(ObjectReader.reader.getApplicationUrl());
        //
        loginPage = new LoginPage(driver);
        loginPage.clickOnSignInLink();
        loginPage.enterRegistrationEmail();
        //
        register = loginPage.clickOnCreateAnAccount();

        // enter registration data
        register.setMrRadioButton();
        register.setFirstName("firstName");
        register.setLastname("lastname");
        register.setPassword("password");
        register.setAddress("address");
        register.setDay("5");
        register.setMonth("June");
        register.setYear("2017");
        register.setYourAddressFirstName("yourAddressFirstName");
        register.setYourAddressLastName("yourAddressLastName");
        register.setYourAddressCompany("yourAddressCompany");
        register.setYourAddressCity("yourAddressCity");
        register.setYourAddressState("Alaska");
        register.setYourAddressPostCode("99501");
        register.setMobilePhone("9999999999");
        register.setAddressAlias("addressAlias");
        register.clickRegistration();
        myAccountPage = new MyAccountPage(driver);
        boolean status = myAccountPage.isYourAccountPageMessage();
        AssertionHelper.updateTestStatus(status);
    }
    //----------------------------------------------------------------------------------------------------------------||
}

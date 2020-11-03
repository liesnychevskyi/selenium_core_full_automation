package selenium_core.page_objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.Status;
import selenium_core.helpers.assertion.VerificationHelper;
import selenium_core.helpers.browser_configurations.config.ObjectReader;
import selenium_core.helpers.javascript.JavaScriptHelper;
import selenium_core.helpers.logger.MyLogger;
import selenium_core.helpers.wait.WaitHelper;
import selenium_core.test_base.TestBase;

public class LoginPage
{
    //----------------------------------------------------------------------------------------------------------------||
    private WebDriver driver;
    private final Logger log = MyLogger.getLogger(LoginPage.class);
    //----------------------------------------------------------------------------------------------------------------||
    WaitHelper waitHelper; // WaiteHelper object reference
    //----------------------------------------------------------------------------------------------------------------|| Locators
    @FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[1]/a")
    WebElement sign_in;

    @FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/span/strong")
    WebElement call_us_now_icon;

    @FindBy(xpath="//img[@id='header_logo']/a/img")
    WebElement logo;

    @FindBy(xpath="//input[@id='search_query_top']")
    WebElement search_field;

    @FindBy(xpath="//input[@id='search_query_top']")
    WebElement search_lens_icon;

    @FindBy(xpath="//div[@id='contact-link']/a")
    WebElement contact_us;

    @FindBy(xpath="//*[@id='email']")
    WebElement emailAddress;

    @FindBy(xpath="//*[@id='passwd']")
    WebElement password;

    @FindBy(xpath="//*[@id='SubmitLogin']")
    WebElement submitLogin;

    @FindBy(xpath="//*[@id='center_column']/p")
    WebElement successMsgObject;

    @FindBy(xpath="//*[@id='email_create']")
    WebElement registrationEmailAddress;

    @FindBy(xpath="//*[@id='SubmitCreate']")
    WebElement createAnAccountButton;

    @FindBy(xpath="//*[@id='columns']/div[1]/a/i")
    WebElement home_icon_button;

    //*[@id="columns"]/div[1]/span[2]
    @FindBy(xpath="//*[@id='center_column']/h1")
    WebElement authenticate;

    @FindBy(xpath="//*[@id='create-account_form']/div/p")
    WebElement CREATE_AN_ACCOUNT_text;

    @FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[2]/a")
    WebElement logout;
    //----------------------------------------------------------------------------------------------------------------|| Constructor
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Elements of page are read
        waitHelper = new WaitHelper(driver); // Waite driver is started
        waitHelper.waitForElementClickable(sign_in, ObjectReader.reader.getExplicitWait()); // Waite page is loaded
        new TestBase().getNavigationScreen(driver); // Capture screenshot every navigated screen
        TestBase.logExtentReport("Login Page Object Created"); // Call this method be sure that LoginPage object is created
    }
    //----------------------------------------------------------------------------------------------------------------|| Methods
    public void enterEmailAddress(String emailAddress)
    {
        log.info("entering email address...."+emailAddress);
        logExtentReport("entering email address...."+emailAddress);
        this.emailAddress.sendKeys(emailAddress);
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void enterPassword(String password)
    {
        log.info("entering password...."+password);
        logExtentReport("entering password...."+password);
        this.password.sendKeys(password);
    }
    //----------------------------------------------------------------------------------------------------------------||
    public NavigationMenu clickOnSubmitButton()
    {
        log.info("clicking on submit button...");
        logExtentReport("clicking on submit button...");
        JavaScriptHelper javaScriptHelper = new JavaScriptHelper(driver);
        javaScriptHelper.scrollDownVertically();
        //new JavaScriptHelper(driver).scrollDownVertically();
        submitLogin.click();
        return new NavigationMenu(driver);
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void clickOnSignInLink()
    {
        log.info("clicked on sign in link...");
        logExtentReport("clicked on sign in link...");
        sign_in.click();
    }
    //----------------------------------------------------------------------------------------------------------------||
    public boolean verifySuccessLoginMsg()
    {
        return new VerificationHelper(driver).isDisplayed(successMsgObject);
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void enterRegistrationEmail()
    {
        String email = System.currentTimeMillis()+"@gmail.com";
        log.info("entering registration email.."+email);
        registrationEmailAddress.sendKeys(email);
    }
    //----------------------------------------------------------------------------------------------------------------||
    public RegistrationPage clickOnCreateAnAccount()
    {
        createAnAccountButton.click();
        return new RegistrationPage(driver);
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void loginToApplication(String emailAddress, String password)
    {
        clickOnSignInLink();
        enterEmailAddress(emailAddress);
        enterPassword(password);
        clickOnSubmitButton();
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void logout()
    {
        logout.click();
        log.info("clicked on logout link");
        waitHelper.waitForElementClickable(sign_in, ObjectReader.reader.getExplicitWait());
    }
    //----------------------------------------------------------------------------------------------------------------||
    // Method for this class exactly
    public void logExtentReport(String s1)
    {
        TestBase.test.log(Status.INFO, s1);
    }
    //----------------------------------------------------------------------------------------------------------------||
}

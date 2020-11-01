package selenium_core.page_objects;

import com.aventstack.extentreports.Status;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium_core.helpers.assertion.VerificationHelper;
import selenium_core.helpers.browser_configurations.config.ObjectReader;
import selenium_core.helpers.logger.MyLogger;
import selenium_core.helpers.wait.WaitHelper;
import selenium_core.test_base.TestBase;

public class MyAccountPage
{
    //----------------------------------------------------------------------------------------------------------------||
    private WebDriver driver;
    private final Logger log = MyLogger.getLogger(MyAccountPage.class);
    WaitHelper waitHelper;
    //----------------------------------------------------------------------------------------------------------------||
    @FindBy(xpath="//*[contains(text(),'Welcome to your account. Here you can manage all of your personal information and orders.')]")
    public static WebElement yourAccountPageMessage;

    @FindBy(xpath="//*[contains(text(),'Order history and details')]")
    public WebElement OrderHistoryAndDetails;

    @FindBy(xpath="//*[contains(text(),'My personal information')]")
    public WebElement MyPersonalInformation;

    @FindBy(xpath="//*[@id='center_column']/div/div[2]/ul/li/a/span")
    public WebElement wishLists;

    @FindBy(xpath="//*[@id='center_column']/h1")
    public WebElement myAccount;
    //----------------------------------------------------------------------------------------------------------------||
    public MyAccountPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(OrderHistoryAndDetails, ObjectReader.reader.getExplicitWait());
        TestBase.test.log(Status.INFO, "MyAccountPage object created");
        new TestBase().getNavigationScreen(driver);
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void clickOnWishLists()
    {
        wishLists.click();
        log.info("clciked on "+wishLists.getText());
        TestBase.test.log(Status.INFO, "clciked on "+wishLists.getText());
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void clickOnOrderHistoryAndDetails()
    {
        OrderHistoryAndDetails.click();
        log.info("clciked on "+OrderHistoryAndDetails.getText());
        TestBase.test.log(Status.INFO, "clciked on "+OrderHistoryAndDetails.getText());
    }
    //----------------------------------------------------------------------------------------------------------------||
    public  boolean isYourAccountPageMessage()
    {
        return new VerificationHelper(driver).isDisplayed(yourAccountPageMessage);
    }
    //----------------------------------------------------------------------------------------------------------------||
}

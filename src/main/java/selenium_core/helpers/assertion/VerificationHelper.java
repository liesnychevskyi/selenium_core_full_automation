package selenium_core.helpers.assertion;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium_core.helpers.logger.MyLogger;

public class VerificationHelper
{
    //----------------------------------------------------------------------------------------------------------------||
    private WebDriver driver;
    private Logger log = MyLogger.getLogger(selenium_core.helpers.assertion.VerificationHelper.class);
    //----------------------------------------------------------------------------------------------------------------||
    public VerificationHelper(WebDriver driver)
    {
        this.driver = driver;
    }
    //----------------------------------------------------------------------------------------------------------------||
    public boolean isDisplayed(WebElement element)
    {
        try
        {
            element.isDisplayed();
            log.info("Element is present >>> " + element.getText());
            return true;
        }
        catch (Exception e)
        {
            log.error("Error, element is not present >>> ", e.getCause());
            return false;
        }
    }
    //----------------------------------------------------------------------------------------------------------------||
    public boolean isNotDisplayed(WebElement element)
    {
        try
        {
            element.isDisplayed();
            log.info("Element is displayed >>> " + element.getText());
            return false;
        }
        catch (Exception e)
        {
            log.error("Element is not displayed >>> ");
            return true;
        }
    }
    //----------------------------------------------------------------------------------------------------------------||
    public String getText(WebElement element)
    {
        if(null == element)
        {
            log.info("WebElement is null.. ");
            return null;
        }
        boolean status = isDisplayed(element);
        if(status)
        {
            log.info("Element text is : " + element.getText());
            return element.getText();
        }
        else
        {
            return null;
        }
    }
    //----------------------------------------------------------------------------------------------------------------||
}

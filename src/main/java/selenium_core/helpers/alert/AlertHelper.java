package selenium_core.helpers.alert;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import selenium_core.helpers.logger.MyLogger;

public class AlertHelper
{
    //----------------------------------------------------------------------------------------------------------------||
    private WebDriver driver;
    private Logger log = MyLogger.getLogger(selenium_core.helpers.alert.AlertHelper.class);
    //----------------------------------------------------------------------------------------------------------------||
    public AlertHelper(WebDriver driver)
    {
        this.driver = driver;
        log.info("AlertHelper object is created..");
    }
    //----------------------------------------------------------------------------------------------------------------||
    public Alert getAlert()
    {
        log.info("Alert test: " + driver.switchTo().alert().getText());
        return driver.switchTo().alert();
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void acceptAlert()
    {
        getAlert().accept();
        log.info("Accept Alert is done..");
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void dismissAlert()
    {
        getAlert().dismiss();
        log.info("Dismiss Alert is done..");
    }
    //----------------------------------------------------------------------------------------------------------------||
    public String getAlertText()
    {
        String text = getAlert().getText();
        log.info("Alert test: " + text);
        return text;
    }
    //----------------------------------------------------------------------------------------------------------------||
    public boolean isAlertPresent()
    {
        try
        {
            driver.switchTo().alert();
            log.info("Alert is present..");
            return true;
        }
        catch (NoAlertPresentException e)
        {
            log.info(e.getCause());
            return false;
        }
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void exceptAlertIfPresent()
    {
        if(isAlertPresent())
        {
            acceptAlert();
        }
        else
        {
            log.info("Alert is not present..");
        }
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void dismissAlertIfPresent()
    {
        if(isAlertPresent())
        {
            dismissAlert();
        }
        else
        {
            log.info("Alert is not present..");
        }
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void exceptProm(String text)
    {
        if(isAlertPresent())
        {
            Alert alert = getAlert();
            alert.sendKeys(text);
            alert.accept();
            log.info("Alert text: " + text);
        }
    }
    //----------------------------------------------------------------------------------------------------------------||
}

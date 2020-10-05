package selenium_core.helpers.wait;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium_core.helpers.logger.MyLogger;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WaitHelper
{
    //----------------------------------------------------------------------------------------------------------------||
    private WebDriver driver;
    private Logger log = MyLogger.getLogger(selenium_core.helpers.wait.WaitHelper.class);
    //----------------------------------------------------------------------------------------------------------------||
    /**
     * constructor will help us to initiate webDriver object
     * @param driver
     */
    public WaitHelper(WebDriver driver)
    {
        this.driver = driver;
    }
    //----------------------------------------------------------------------------------------------------------------||
    /**
     * This is ImplicitlyWait method
     * @param timeout
     * @param unit
     */
    public void setImplicitWait(long timeout, TimeUnit unit)
    {
        log.info("Implicit Wait has been set to: " + timeout);
        driver.manage().timeouts().implicitlyWait(timeout, unit);
    }
    //----------------------------------------------------------------------------------------------------------------||
    /**
     * This is will help us to get WebDriverWait object
     * @param timeOutInSeconds
     * @param pollingEveryInMilliseconds
     * @return
     */
    private WebDriverWait getWait(int timeOutInSeconds, int pollingEveryInMilliseconds )
    {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.pollingEvery(Duration.ofMillis(pollingEveryInMilliseconds));
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(ElementNotVisibleException.class);
        wait.ignoring(StaleElementReferenceException.class);
        wait.ignoring(NoSuchFrameException.class);
        return wait;
    }
    //----------------------------------------------------------------------------------------------------------------||
    /**
     * This method will make sure element is visible
     * @param element
     * @param timeOutInSeconds
     * @param pollingEveryMilliSec
     */
    public void WaitForElementVisibleWithPollingTime(WebElement element, int timeOutInSeconds, int pollingEveryMilliSec)
    {
        log.info("Waiting for : " + element.toString() + " for : " + timeOutInSeconds + " seconds");
        WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryMilliSec);
        wait.until(ExpectedConditions.visibilityOf(element));
        log.info("Element is visible now");
    }
    //----------------------------------------------------------------------------------------------------------------||
    /**
     * This method will make sure element is clickable
     * @param element
     * @param timeOutInSeconds
     */
    public void WaitForElementClickable(WebElement element, int timeOutInSeconds)
    {
        log.info("Waiting for : " + element.toString() + " for : " + timeOutInSeconds + " seconds");
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        log.info("Element is clickable now");
    }
    //----------------------------------------------------------------------------------------------------------------||
    /**
     * This method will make sure element invisibility of element
     * @param element
     * @param timeOutInSeconds
     * @return
     */
    public boolean WaitForElementNotPresent(WebElement element, long timeOutInSeconds)
    {
        log.info("Waiting for : " + element.toString() + " for : " + timeOutInSeconds + " seconds");
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        boolean status = wait.until(ExpectedConditions.invisibilityOf(element));
        log.info("Element is invisible now");
        return status;
    }
    //----------------------------------------------------------------------------------------------------------------||
    /**
     * This method will for frameToBeAvailableAndSwitchToIt
     * @param element
     * @param timeOutInSeconds
     */
    public void WaitForFrameToBeAvailableAndSwitchToIt(WebElement element, long timeOutInSeconds)
    {
        log.info("Waiting for : " + element.toString() + " for : " + timeOutInSeconds + " seconds");
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
        log.info("Frame is available and switched now");
    }
    //----------------------------------------------------------------------------------------------------------------||
    /**
     * This method will give us fluentWait object
     * @param timeOutInSeconds
     * @param polingEveryIntMilliSec
     * @return
     */
    private Wait<WebDriver> getFluentWait(int timeOutInSeconds, int polingEveryIntMilliSec)
    {
        Wait<WebDriver> fWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOutInSeconds))
        .pollingEvery(Duration.ofMillis(polingEveryIntMilliSec)).ignoring(NoSuchElementException.class);
        return fWait;
    }
    //----------------------------------------------------------------------------------------------------------------||
    /**
     *This element will help us to for element appearance
     * @param element
     * @param timeOutInSeconds
     * @param polingEveryInMilliSec
     * @return
     */
    public WebElement waitForElement(WebElement element, int timeOutInSeconds, int polingEveryInMilliSec)
    {
        log.info("");
        getFluentWait(timeOutInSeconds, timeOutInSeconds);
        Wait<WebDriver> fwait = getFluentWait(timeOutInSeconds, polingEveryInMilliSec);
        fwait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }
    //----------------------------------------------------------------------------------------------------------------||
    /**
     * This method will help us to
     * @param timeout
     * @param unit
     */
    public void pageLoadTime(long timeout, TimeUnit unit)
    {
        log.info("Waiting for page to load for : " + timeout + " seconds");
        driver.manage().timeouts().pageLoadTimeout(timeout, unit);
        log.info("Page is loaded");
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void waitForElement(WebElement element, int timeOutInSeconds)
    {
        log.info("Wait for: " + element.toString() + " for: " + timeOutInSeconds + " seconds");
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
        log.info("Element is visible now");
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void waitForElementIsPresentIgnoringException(WebElement element, int timeOutInSeconds)
    {
        log.info("Wait for: " + element.toString() + " for: " + timeOutInSeconds + " seconds");
        WebElement wait = new WebDriverWait(driver, timeOutInSeconds).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(element));
        log.info("Element is visible now");
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void waitForElementToBeClickableIgnoringException(WebElement element, int timeOutInSeconds)
    {
        log.info("Wait for: " + element.toString() + " for: " + timeOutInSeconds + " seconds");
        WebElement wait = new WebDriverWait(driver, timeOutInSeconds).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(element));
        log.info("Element is clickable now");
    }
    //----------------------------------------------------------------------------------------------------------------||
}

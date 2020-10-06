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
        log.info("WaitHelper method is started..");
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
        log.info("SetImplicitWait method is started and has been set to: " + timeout + " seconds");
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
        log.info("GetWait method is started and has been set to: " + timeOutInSeconds + " seconds");
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.pollingEvery(Duration.ofMillis(pollingEveryInMilliseconds));
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(ElementNotVisibleException.class);
        wait.ignoring(StaleElementReferenceException.class);
        wait.ignoring(NoSuchFrameException.class);
        return wait;
    }
    //----------------------------------------------------------------------------------------------------------------||
    /**   log.info("");
     * This method will make sure element is visible
     * @param element
     * @param timeOutInSeconds
     * @param pollingEveryMilliSec
     */
    public void waitForElementVisibleWithPollingTime(WebElement element, int timeOutInSeconds, int pollingEveryMilliSec)
    {
        log.info("WaitForElementVisibleWithPollingTime is started and waiting for : " + element.toString() + " element " + " and set time for : " + timeOutInSeconds + " seconds");
        WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryMilliSec);
        wait.until(ExpectedConditions.visibilityOf(element));
        log.info("Element " + element.toString() + " is visible now");
    }
    //----------------------------------------------------------------------------------------------------------------||
    /**
     * This method will make sure element is clickable
     * @param element
     * @param timeOutInSeconds
     */
    public void waitForElementClickable(WebElement element, int timeOutInSeconds)
    {
        log.info("WaitForElementClickable method is started and waiting for : " + element.toString() + " element and set time for : " + timeOutInSeconds + " seconds");
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        log.info("Element " + element.toString() + " is clickable now");
    }
    //----------------------------------------------------------------------------------------------------------------||
    /**
     * This method will make sure element invisibility of element
     * @param element
     * @param timeOutInSeconds
     * @return
     */
    public boolean waitForElementNotPresent(WebElement element, long timeOutInSeconds)
    {
        log.info("WaitForElementNotPresent is started and waiting for : " + element.toString() + " element and set time for : " + timeOutInSeconds + " seconds");
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        boolean status = wait.until(ExpectedConditions.invisibilityOf(element));
        log.info("Element " + element.toString() + " is not present now");
        return status;
    }
    //----------------------------------------------------------------------------------------------------------------||
    /**
     * This method will for frameToBeAvailableAndSwitchToIt
     * @param element
     * @param timeOutInSeconds
     */
    public void waitForFrameToBeAvailableAndSwitchToIt(WebElement element, long timeOutInSeconds)
    {
        log.info("WaitForFrameToBeAvailableAndSwitchToIt is started and waiting for frame: " + element.toString() + " frame and set time for : " + timeOutInSeconds + " seconds");
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
        log.info("Frame " + element.toString() + " is available and switched now");
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
        log.info("GetFluentWait method is started and set for: " + timeOutInSeconds + " seconds");
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
    public WebElement waitForElementVisibleWithThePolingTime(WebElement element, int timeOutInSeconds, int polingEveryInMilliSec)
    {
        log.info("WaitForElementVisibleWithThePolingTime method is started and waiting for: " + element.toString() + " element and set time for: " + timeOutInSeconds + " seconds");
        getFluentWait(timeOutInSeconds, timeOutInSeconds);
        Wait<WebDriver> fwait = getFluentWait(timeOutInSeconds, polingEveryInMilliSec);
        fwait.until(ExpectedConditions.visibilityOf(element));
        log.info("Element: " + element.toString() + " is visible now");
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
        log.info("PageLoadTime is started and waiting for page to load for : " + timeout + " seconds");
        driver.manage().timeouts().pageLoadTimeout(timeout, unit);
        log.info("Page is loaded by time: " + unit + " second");
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void waitForElementWithTimeout(WebElement element, int timeOutInSeconds)
    {
        log.info("WaitForElementWithTimeout is started and waiting for: " + element.toString() + " element and set time for: " + timeOutInSeconds + " seconds");
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
        log.info("Element " + element.toString() + " is visible now");
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void waitForElementIsPresentIgnoringException(WebElement element, int timeOutInSeconds)
    {
        log.info("WaitForElementIsPresentIgnoringException is started and wait for: " + element.toString() + "element and set time for: " + timeOutInSeconds + " seconds");
        WebElement wait = new WebDriverWait(driver, timeOutInSeconds).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(element));
        log.info("Element " + element.toString() + " is visible now");
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void waitForElementToBeClickableIgnoringException(WebElement element, int timeOutInSeconds)
    {
        log.info("WaitForElementToBeClickableIgnoringException is started and  waiting for: " + element.toString() + " element and set time for: " + timeOutInSeconds + " seconds");
        WebElement wait = new WebDriverWait(driver, timeOutInSeconds).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(element));
        log.info("Element " + element + " is clickable now");
    }
    //----------------------------------------------------------------------------------------------------------------||
}

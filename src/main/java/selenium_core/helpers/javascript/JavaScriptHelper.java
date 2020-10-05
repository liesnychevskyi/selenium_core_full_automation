package selenium_core.helpers.javascript;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium_core.helpers.logger.MyLogger;

public class JavaScriptHelper
{
    //----------------------------------------------------------------------------------------------------------------||
    private WebDriver driver;
    private Logger log = MyLogger.getLogger(selenium_core.helpers.javascript.JavaScriptHelper.class);
    //----------------------------------------------------------------------------------------------------------------||
    public JavaScriptHelper(WebDriver driver)
    {
        this.driver = driver;
        log.info("JavaScriptHelper has been initialized successfully");
    }
    //----------------------------------------------------------------------------------------------------------------||
    public Object executeScript(String script)
    {
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        return exe.executeScript(script);
    }
    //----------------------------------------------------------------------------------------------------------------||
    public Object executeScript(String script, Object...args)
    {
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        return exe.executeScript(script, args);
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void scrollToElement(WebElement element)
    {
        log.info("Scroll to WebElement...");
        executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x,element.getLocation().y);
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void scrollToElementAndClick(WebElement element)
    {
        scrollToElement(element);
        element.click();
        log.info("Element is clicked" + element.toString());
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void scrollIntoView(WebElement element)
    {
        log.info("Scroll till web element");
        executeScript("arguments[0].scrollIntoView()", element);
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void scrollIntoViewAndClick(WebElement element)
    {
        scrollIntoView(element);
        element.click();
        log.info("Element is clicked" + element.toString());
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void scrollDownVertically()
    {
        log.info("Scrolling down vertically");
       executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void scrollUpVertically()
    {
        log.info("Scrolling up vertically");
        executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void scrollDownByPixel(int pixel)
    {
        executeScript("window.scrollBY(0, "+pixel+")");
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void scrollUpnByPixel(int pixel)
    {
        executeScript("window.scrollBY(0,-"+pixel+")");
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void zoomInBy100Percentage()
    {
        executeScript("document.body.style.zoom='100%'");
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void zoomInBy60Percentage()
    {
        executeScript("document.body.style.zoom='60%'");
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void clickElementUsingJavaScript(WebElement element)
    {
        executeScript("arguments[0].click();", element);
    }
    //----------------------------------------------------------------------------------------------------------------||
}

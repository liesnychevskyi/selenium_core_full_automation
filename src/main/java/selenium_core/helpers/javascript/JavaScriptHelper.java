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
        log.info("JavaScriptHelper has been initialized successfully..");
    }
    //----------------------------------------------------------------------------------------------------------------||
    public Object executeScript(String script)
    {
        log.info("ExecuteScript method is started - script is: " + script);
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        return exe.executeScript(script);
    }
    //----------------------------------------------------------------------------------------------------------------||
    public Object executeScriptWithArguments(String script, Object...args)
    {
        log.info("ExecuteScriptWithArguments method is started - script is: " + script + " argument is: " + args);
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        return exe.executeScript(script, args);
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void scrollToElement(WebElement element)
    {
        log.info("Scroll to " + element.toString() + " WebElement");
        executeScriptWithArguments("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x,element.getLocation().y);
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void scrollToElementAndClick(WebElement element)
    {
        log.info("ScrollToElementAndClick method is started..");
        scrollToElement(element);
        element.click();
        log.info("Element: " + element.toString()  + " is scrolled and clicked" );
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void scrollIntoView(WebElement element)
    {
        log.info("ScrollIntoView is started..");
        executeScriptWithArguments("arguments[0].scrollIntoView()", element);
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void scrollIntoViewAndClick(WebElement element)
    {
        log.info("ScrollIntoViewAndClick method is started..");
        scrollIntoView(element);
        element.click();
        log.info("Element: " + element.toString() + " is clicked" );
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void scrollDownVertically()
    {
        log.info("ScrollDownVertically method is started..");
        executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void scrollUpVertically()
    {
        log.info("ScrollUpVertically method is started..");
        executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void scrollDownByPixel(int pixel)
    {
        log.info("ScrollDownByPixel method is started..");
        executeScript("window.scrollBY(0, "+pixel+")");
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void scrollUpnByPixel(int pixel)
    {
        log.info("ScrollUpnByPixel method is started..");
        executeScript("window.scrollBY(0,-"+pixel+")");
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void zoomInBy100Percentage()
    {
        log.info("ZoomInBy100Percentage method is started..");
        executeScript("document.body.style.zoom='100%'");
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void zoomInBy60Percentage()
    {
        log.info("ZoomInBy60Percentage method is started..");
        executeScript("document.body.style.zoom='60%'");
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void clickElementUsingJavaScript(WebElement element)
    {
        log.info("ClickElementUsingJavaScript method is started..");
        executeScriptWithArguments("arguments[0].click();", element);
    }
    //----------------------------------------------------------------------------------------------------------------||
}

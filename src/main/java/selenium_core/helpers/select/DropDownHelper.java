package selenium_core.helpers.select;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import selenium_core.helpers.logger.MyLogger;

import java.util.LinkedList;
import java.util.List;

public class DropDownHelper // Handler of select boxes
{
    //----------------------------------------------------------------------------------------------------------------||
    private WebDriver driver;
    private Logger log = MyLogger.getLogger(selenium_core.helpers.select.DropDownHelper.class);
    //----------------------------------------------------------------------------------------------------------------||
    public DropDownHelper(WebDriver driver)
    {
        this.driver = driver;
        log.info("DropDownHelper object created");
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void selectUsingValue(WebElement element, String value)
    {
        Select select = new Select(element);
        log.info("SelectUsingValue method is started and value is: " + value);
        select.selectByValue(value);
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void selectUsingIndex(WebElement element, int index)
    {
        Select select = new Select(element);
        log.info("SelectUsingIndex is started and index is: " + index);
        select.selectByIndex(index);
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void selectUsingVisibleText(WebElement element, String visibleText)
    {
        Select select = new Select(element);
        log.info("SelectUsingVisibleText method is started and visibleText is: " + visibleText);
        select.selectByValue(visibleText);
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void deSelectUsingValue(WebElement element, String value)
    {
        Select select = new Select(element);
        log.info("DeSelectUsingValue method is started and value is: " + value);
        select.deselectByValue(value);
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void deSelectUsingIndex(WebElement element, int index)
    {
        Select select = new Select(element);
        log.info("DeSelectUsingIndex method is started and index is: " + index);
        select.deselectByIndex(index);
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void deSelectUsingVisibleText(WebElement element, String text)
    {
        Select select = new Select(element);
        log.info("DeSelectUsingVisibleText method is started and text is: " + text);
        select.deselectByVisibleText(text);
    }
    //----------------------------------------------------------------------------------------------------------------||
    public List<String> getAllDropDownData(WebElement element)
    {
        log.info("GetAllDropDownData method is started..");
        Select select = new Select(element);
        List<WebElement> elementList = select.getOptions();
        List<String> valueList = new LinkedList<String>();
        for(WebElement ele: elementList)
        {
            log.info(ele.getText());
            valueList.add(ele.getText());
        }
        return valueList;
    }
    //----------------------------------------------------------------------------------------------------------------||
}

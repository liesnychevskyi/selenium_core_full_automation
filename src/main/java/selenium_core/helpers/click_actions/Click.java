package selenium_core.helpers.click_actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Click
{
    //----------------------------------------------------------------------------------------------------------------||
    public static void clickById(WebDriver driver, String id)
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id(id))).click().build().perform();
    }
    //----------------------------------------------------------------------------------------------------------------||
    public static void clickByXpath(WebDriver driver, String xpath)
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(xpath))).click().build().perform();
    }
    //----------------------------------------------------------------------------------------------------------------||
}

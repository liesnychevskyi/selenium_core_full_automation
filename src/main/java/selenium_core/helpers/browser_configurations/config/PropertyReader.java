package selenium_core.helpers.browser_configurations.config;

import selenium_core.helpers.resource.ResourceHelper;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader implements ConfigReader
{
    //----------------------------------------------------------------------------------------------------------------||
    private static FileInputStream file;
    private static Properties OR;
    //----------------------------------------------------------------------------------------------------------------||
    // Constructor
    public PropertyReader()  // Load the property file to the memory
    {
        //path for windows//String filePath = ResourceHelper.getRecoursePath("\\src\\main\\resources\\config_firefox.properties");
        //String filePath = ResourceHelper.getRecoursePath("/src/main/resources/config_firefox.properties");
        String filePath = ResourceHelper.getRecoursePath("/src/main/resources/config_chrome.properties");
        //String filePath = ResourceHelper.getRecoursePath("/src/main/resources/config_safari.properties");
        try
        {
            file = new FileInputStream(new File(filePath));
            OR = new Properties();
            OR.load(file);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    //----------------------------------------------------------------------------------------------------------------||
    @Override
    public int getImplicitWait()
    {
        return Integer.parseInt(OR.getProperty("implicitWait"));
    }
    //----------------------------------------------------------------------------------------------------------------||
    @Override
    public int getExplicitWait()
    {
        return Integer.parseInt(OR.getProperty("explicitWait"));
    }
    //----------------------------------------------------------------------------------------------------------------||
    @Override
    public int getPageLoadTime()
    {
        return Integer.parseInt(OR.getProperty("pageLoadTime"));
    }
    //----------------------------------------------------------------------------------------------------------------||
    @Override
    public selenium_core.helpers.browser_configurations.BrowserType getBrowserType()
    {
       return selenium_core.helpers.browser_configurations.BrowserType.valueOf(OR.getProperty("browserType"));
    }
    //----------------------------------------------------------------------------------------------------------------||
    @Override
    public String getApplicationUrl()
    {
        System.out.println(OR.getProperty("applicationUrl"));
        return OR.getProperty("applicationUrl");
    }
//    //--------------------------------------------------------------------------------------------------------------||
//    @Override
//    public String getApplicationUrl()
//    {
//        if(System.getProperty("applicationUrl") != null)
//         System.out.println(OR.getProperty("applicationUrl"));
//        return System.getProperty("applicationUrl");
//    }
//  //----------------------------------------------------------------------------------------------------------------||
    @Override
    public String getUserName()
    {
        System.out.println(OR.getProperty("userName"));
        return OR.getProperty("userName");
    }
    //----------------------------------------------------------------------------------------------------------------||
    @Override
    public String getPassword()
    {
        System.out.println(OR.getProperty("password"));
        return OR.getProperty("password");
    }
    //----------------------------------------------------------------------------------------------------------------||
}

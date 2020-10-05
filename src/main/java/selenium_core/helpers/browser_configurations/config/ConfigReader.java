package selenium_core.helpers.browser_configurations.config;

public interface ConfigReader
{
    public int getImplicitWait();
    public int getExplicitWait();
    public int getPageLoadTime();
    public selenium_core.helpers.browser_configurations.BrowserType getBrowserType();
    public String getApplicationUrl();
    public String getUserName();
    public String getPassword();

}

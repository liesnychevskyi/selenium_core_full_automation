package selenium_core.test_scripts.productDetailsPage;

import org.testng.annotations.Test;
import selenium_core.helpers.assertion.AssertionHelper;
import selenium_core.helpers.browser_configurations.config.ObjectReader;
import selenium_core.page_objects.ApplicationText;
import selenium_core.page_objects.LoginPage;
import selenium_core.page_objects.NavigationMenu;
import selenium_core.page_objects.ProductCategoryPage;
import selenium_core.test_base.TestBase;

public class VerifyProductCountsTest extends TestBase
{
    //----------------------------------------------------------------------------------------------------------------||
    LoginPage loginPage;
    NavigationMenu navigationMenu;
    //----------------------------------------------------------------------------------------------------------------||
    @Test
    public void testVerifyProductCounts() throws InterruptedException
    {
        getApplicationUrl(ObjectReader.reader.getApplicationUrl());
        navigationMenu = new NavigationMenu(driver);
        ProductCategoryPage pCate = navigationMenu.clickOnMenu(navigationMenu.womenMenu);

        pCate.selectColor(ApplicationText.Orange);
        int count = pCate.getTotalProducts();
        System.out.println("Count is: " + count);
        Thread.sleep(15000);

        if(count==7)
        {
            AssertionHelper.pass();
        }
        else
        {
            AssertionHelper.fail();
        }
    }
    //----------------------------------------------------------------------------------------------------------------||
}

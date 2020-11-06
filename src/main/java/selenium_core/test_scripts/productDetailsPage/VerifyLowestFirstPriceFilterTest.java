package selenium_core.test_scripts.productDetailsPage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import selenium_core.helpers.assertion.AssertionHelper;
import selenium_core.helpers.browser_configurations.config.ObjectReader;
import selenium_core.helpers.javascript.JavaScriptHelper;
import selenium_core.helpers.logger.MyLogger;
import selenium_core.page_objects.NavigationMenu;
import selenium_core.page_objects.ProductCategoryPage;
import selenium_core.test_base.TestBase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VerifyLowestFirstPriceFilterTest extends TestBase
{
    //----------------------------------------------------------------------------------------------------------------||
    private final Logger log = MyLogger.getLogger(VerifyLowestFirstPriceFilterTest.class);
    //----------------------------------------------------------------------------------------------------------------||
    @Test
    public void verifyLowestFirstPriceListInProduct_detailsPage() throws InterruptedException
    {
        getApplicationUrl(ObjectReader.reader.getApplicationUrl());
        Thread.sleep(3000);
        NavigationMenu navigationMenu = new NavigationMenu(driver);
        Thread.sleep(3000);
        ProductCategoryPage pcategoryPage = navigationMenu.clickOnMenu(navigationMenu.womenMenu);
        JavaScriptHelper javaScriptHelper = new JavaScriptHelper(driver);
        javaScriptHelper.scrollDownByPixel(600);

        // select price filter
        pcategoryPage.selectSortByFilter("Price: Lowest first");
        Thread.sleep(10000);
        // wait for some time to make sure price is sorted.
        List<WebElement> price = pcategoryPage.getAllProductsPrice();
        ArrayList<Integer> array = new ArrayList<Integer>();
        Iterator<WebElement> itr = price.iterator();
        Thread.sleep(10000);

        ArrayList<Integer> data = pcategoryPage.getPriceMassagedData(itr);
        boolean status = pcategoryPage.verifyArrayHasAscendingData(data);
        AssertionHelper.updateTestStatus(status);
        //----------------------------------------------------------------------------------------------------------------||
	/* verifyArrayHasAscendingData method from ProductCategoryPage

		//price comes in "$16.40" format
		// remove $ from beginning and change to int for sorting order verification
		// Store it in array list
		while (itr.hasNext()) {
			String p = itr.next().getText();
			if (p.contains("$")) {
				String actualData = p.substring(1);
				log.info(actualData);
				double p1 = Double.parseDouble(actualData);
				int productPrice = (int) (p1);
				array.add(productPrice);
			}
		}
// getPriceMassagedData method from ProductCategoryPage

        log.info(array);
        //[16, 16, 26, 27, 28, 30, 50]
		for (int i = 0; i < array.size() - 1; i++) {
			// this condition will check all next price should be smaller than previous one.
			// next price can be grater and equal
			if (array.get(i) <= array.get(i + 1)) {
				log.info("obj.get(i):-" + array.get(i));
				log.info("obj.get(i+1):-" + array.get(i + 1));
			} else {
				Assert.assertTrue(false,"price filter is not working");
			}
		}

		*/
    }
    //----------------------------------------------------------------------------------------------------------------||
}

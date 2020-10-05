package selenium_core.helpers.assertion;

import org.apache.log4j.Logger;
import org.testng.Assert;
import selenium_core.helpers.logger.MyLogger;

public class AssertionHelper
{
    //----------------------------------------------------------------------------------------------------------------||
    private static Logger log = MyLogger.getLogger(selenium_core.helpers.assertion.AssertionHelper.class);
    //----------------------------------------------------------------------------------------------------------------||
    public static void verifyText(String actual, String expected)
    {
        log.info("Verify text " + actual + " with " + expected);
        Assert.assertEquals(actual, expected);
    }
    //----------------------------------------------------------------------------------------------------------------||
    public static void makeTrue()
    {
        log.info("Making script PASS..");
        Assert.assertTrue(true);
    }
    //----------------------------------------------------------------------------------------------------------------||
    public static void makeTrue(String massage)
    {
        log.info("Making script PASS with the massage : " + massage);
        Assert.assertTrue(true, massage);
    }
    //----------------------------------------------------------------------------------------------------------------||
    public static void makeFalse()
    {
        log.info("Making script FAIL..");
        Assert.assertTrue(false);
    }
    //----------------------------------------------------------------------------------------------------------------||
    public static void makeFalse(String massage)
    {
        log.info("Making script FAIL with the massage : " + massage);
        Assert.assertTrue(false, massage);
    }
    //----------------------------------------------------------------------------------------------------------------||
    public static void verifyTrue(boolean status)
    {
        log.info("Is true");
        Assert.assertTrue(status);
    }
    //----------------------------------------------------------------------------------------------------------------||
    public static void verifyFalse(boolean status)
    {
        log.info("Is false");
        Assert.assertFalse(status);
    }
    //----------------------------------------------------------------------------------------------------------------||
    public static void verifyNullObject(String s1)
    {
        log.info("Verify object is NULL..");
        Assert.assertNull(s1);
    }
    //----------------------------------------------------------------------------------------------------------------||
    public static void verifyNotNullObject(String s1)
    {
        log.info("Verify object is NOT NULL..");
        Assert.assertNotNull(s1);
    }
    //----------------------------------------------------------------------------------------------------------------||
    public static void fail()
    {
        log.info("Verify is fail..");
        Assert.assertTrue(false);
    }
    //----------------------------------------------------------------------------------------------------------------||
    public static void pass()
    {
        log.info("Verify is pass..");
        Assert.assertTrue(true);
    }
    //----------------------------------------------------------------------------------------------------------------||
    public static void updateTestStatus(boolean status)
    {
        if(status)
        {
            pass();
            log.info("Test status pass" );
        }
        else
        {
            fail();
            log.info("Test status fail" );
        }
    }
    //----------------------------------------------------------------------------------------------------------------||
}

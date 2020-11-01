package selenium_core.test_scripts.example_scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_3
{
    int status = 0;

    @Test
    public void ClickTest()
    {
        if(status == 2)
        {
            Assert.assertTrue(true);
        }
        else
        {
            System.out.println("Test_3 status is: " + status);
            status ++;
            Assert.assertTrue(false);
        }
    }
}

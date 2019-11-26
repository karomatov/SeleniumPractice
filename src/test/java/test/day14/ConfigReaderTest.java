package test.day14;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigurationReader;

public class ConfigReaderTest {
    @Test
    public void test(){
        String expectedBrowser = "chrome";
        String actualBrowser = ConfigurationReader.getProperty("browser");
        Assert.assertEquals(actualBrowser,expectedBrowser);
        System.out.println(ConfigurationReader.getProperty("url"));
    }
}

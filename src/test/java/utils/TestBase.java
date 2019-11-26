package utils;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
public abstract class TestBase {

    @BeforeMethod
    public void setUp(){

        String url = ConfigurationReader.getProperty("url");
        Driver.get().get(url);
    }

    @AfterMethod
    public void teardown(){
        Driver.close();
    }
}



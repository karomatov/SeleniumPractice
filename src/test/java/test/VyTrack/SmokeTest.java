package test.VyTrack;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LogInPage;
import utils.TestBase;

public class SmokeTest extends TestBase {


    @Test(dataProvider = "navigationInfo")
    public void smokeTest(String moduleName, String subModule, String pageSubtitle){

        extentTest = extentReports.createTest("Verify that page subtitle is equals to " + pageSubtitle);
        LogInPage logInPage = new LogInPage();

        logInPage.login("storemanager85", "UserUser123");
        logInPage.navigateTo(moduleName, subModule);

        Assert.assertEquals(logInPage.getPageSubTitle(), pageSubtitle);

    }

    @DataProvider(name = "navigationInfo")
    public Object[][] navigationInfo(){
        return new Object [][]{
                {"Dashboards", "Dashboard","Dashboard" },
                {"Dashboards", "Manage Dashboards","All Manage Dashboards" },
                {"Fleet", "Vehicles","All Cars" },
                {"Customers", "Accounts","All Accounts" },
                {"Activities", "Calls","All Calls" },
                {"Activities", "Calendar Events","All Calendar Events" }
        };
    }

}

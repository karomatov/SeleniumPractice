package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    protected ExtentReports extentReports;
    protected ExtentHtmlReporter extentHtmlReporter;
    protected ExtentTest extentTest;

    @BeforeTest
    public void beforeTest(){
        String filePath = System.getProperty("user.dir") + "/test-output/report.html";
        extentReports = new ExtentReports();
        extentHtmlReporter = new ExtentHtmlReporter(filePath);
        extentReports.attachReporter(extentHtmlReporter);
        extentHtmlReporter.config().setReportName("VyTrack Test result");
        extentReports.setSystemInfo("Environment" , "QA1");
        extentReports.setSystemInfo("Browser", ConfigurationReader.getProperty("browser"));
        extentReports.setSystemInfo("OS", System.getProperty("os.name"));


    }

    @AfterTest
    public void afterTest(){
        extentReports.flush();
    }
    @BeforeMethod
    public void setUp(){

        String url = ConfigurationReader.getProperty("url");
        Driver.get().get(url);
        BrowserUtils.wait(2);

    }

    @AfterMethod
    public void teardown(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE){
            extentTest.fail(result.getName());
            extentTest.fail(result.getThrowable());
            try {
                extentTest.addScreenCaptureFromPath(BrowserUtils.getScreenshot(result.getName()));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else if (result.getStatus() == ITestResult.SKIP){
            extentTest.skip("Test case was skipped: " + result.getName());
        }else if (result.getStatus() == ITestResult.SUCCESS){
                extentTest.pass(result.getName());
                try {
                    extentTest.addScreenCaptureFromPath(BrowserUtils.getScreenshot(result.getName()));
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }
        Driver.close();

    }
}



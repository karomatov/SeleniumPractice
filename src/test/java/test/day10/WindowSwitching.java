package test.day10;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

public class WindowSwitching {
    private WebDriver driver;
    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }
    @Test(description = "Verify that title is still Practice")
    public void test1() {
        driver.findElement(By.linkText("New tab")).click();
        //after 3 seconds, another website will be opened,in the second window
        //selenium doesn't switch automatically to the new window
        BrowserUtils.wait(5);
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Practice", "Title is wrong!");
    }
    @Test(description = "Verify that user is able to see new window")
    public void test2() {
        driver.findElement(By.linkText("New tab")).click();
        //record id of original window, that we opened initially
        String oldWindow = driver.getWindowHandle();
        //after 3 seconds, another website will be opened,in the second window
        //selenium doesn't switch automatically to the new window
        BrowserUtils.wait(5);
        //in the selenium every window has an id. That id calls window handle
        //to read window handle we use a method getWindowHandle()
        //after new window was opened, we can get list of all window id's/window handles
        //list - it's a data structure
        //set it's also a data structure, like list, but it doesn't allow duplicates
        //also, you cannot easily access anything from there
        //there is no .get() method
        //that's why, we need to loop through the set, to read a data from there
        //set can store only unique values
        Set<String> windowHandles = driver.getWindowHandles();
        //loop through the collection of window handles
        for (String windowHandle : windowHandles) {
            //if it's not an old window
            if (!windowHandle.equals(oldWindow)) {
                //switch to that window
                driver.switchTo().window(windowHandle);
            }
        }
        //let's verify that title of new window is a Fresh tab
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Fresh tab", "Title is wrong!");
        //comeback to original page
        //we can build a function, that will jump in between windows
        //based on page title, we can determine where to stop

        String pageTitle = "Practice"; //title of the page that we want

        for (String windowHandle : windowHandles) {
            //keep jumping from window to window
            driver.switchTo().window(windowHandle);
            //once we found a correct page title
            if(driver.getTitle().equals(pageTitle)){
                //just exit
                //stop jumping
                break;
            }
        }
        System.out.println(driver.getTitle());
    }

    @Test
    public void newTab(){
        driver.get("http://google.com");
        BrowserUtils.wait(3);
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
        BrowserUtils.wait(3);
        driver.get("http://practice.cybertekschool.com/");
        BrowserUtils.wait(3);


    }


    @Test
    public void TestJavaS1()
    {

// Take screenshot and store as a file format
        File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            // now copy the  screenshot to desired location using copyFile //method
            FileUtils.copyFile(src, new File("///Users/khurshedkaromatov/Downloads/error.png"));
        }

        catch (IOException e)
        {
            System.out.println(e.getMessage());

        }
    }
    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}

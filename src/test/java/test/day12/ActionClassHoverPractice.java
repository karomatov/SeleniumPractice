package test.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class ActionClassHoverPractice {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/hovers");
    }

    @Test(description = "Verify first image")
    public void test(){
        Actions action = new Actions(driver);
//
//        action.moveToElement(driver.findElement(By.cssSelector(".figure:nth-of-type(1)"))).perform();
//        BrowserUtils.wait(3);
//        String name = driver.findElement(By.cssSelector(".figure:nth-of-type(1) h5")).getText();
//        System.out.println(name);
        for (int i = 1; i <=3; i++){
            action.moveToElement(driver.findElement(By.cssSelector(".figure:nth-of-type("+i+")"))).perform();
            BrowserUtils.wait(3);
            String name = driver.findElement(By.cssSelector(".figure:nth-of-type("+i+") h5")).getText();
            System.out.println(name);
        }

    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}

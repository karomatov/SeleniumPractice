package test.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class MultipleButtonsTests {
    private WebDriver driver;
    private WebDriver safari;
    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        safari = BrowserFactory.getDriver("safari");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
    }

    @Test
    public void verifyButton1(){
        BrowserUtils.wait(5);
        String expectedResult = "Clicked on button one!";
        String expectedResult2 = "Clicked on button one!";
        driver.findElement(By.cssSelector(".container>button")).click();
        safari.findElement(By.cssSelector(".container>button")).click();
        String actualResult = driver.findElement(By.cssSelector("#result")).getText();
        String actualResult2 = safari.findElement(By.cssSelector("#result")).getText();

        Assert.assertEquals(actualResult, expectedResult, "Result is wrong!");
        Assert.assertEquals(actualResult2, expectedResult2, "Result is wrong!");
        System.out.println("Chrome:  " + actualResult);
        System.out.println("Safari:  " + actualResult2);
    }
    @AfterMethod
    public void teardown(){

        driver.quit();
        safari.quit();
    }
}

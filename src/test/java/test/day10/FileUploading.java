package test.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import static org.openqa.selenium.Keys.ENTER;

public class FileUploading {

    private WebDriver driver;


    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }

    @Test
    public void test(){
        driver.findElement(By.linkText("File Upload")).click();
        driver.findElement(By.id("file-upload")).sendKeys("/Users/khurshedkaromatov/Desktop/Screen Shot 2019-11-15 at 12.27.58 PM.png");
        driver.findElement(By.id("file-submit")).submit();
        BrowserUtils.wait(5);
        String expected = "Screen Shot 2019-11-15 at 12.27.58 PM.png";
        String actual = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(actual,expected);
        System.out.println(actual);

    }

    @Test
    public void test1(){
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }

    @Test
    public void test2(){
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
        System.out.println(driver.findElement(By.id("result")).getText());
    }


    @Test
    public void test3(){
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().sendKeys("Selenium is Fun!!!");
        BrowserUtils.wait(3);
        driver.switchTo().alert().accept();
        System.out.println(driver.findElement(By.id("result")).getText());
    }





    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}

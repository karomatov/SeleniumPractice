package test.day09_review;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class task {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");



    }

    @Test
    public void test1(){
        driver.get("https://www.tempmailaddress.com/");
        BrowserUtils.wait(2);
        String email = driver.findElement(By.xpath("(//a[@title='Copy this email address'])[1]")).getText();
        System.out.println(email);
        BrowserUtils.wait(2);
        //driver.findElement(By.cssSelector("Body")).sendKeys(Keys.ALT + "t");


        BrowserUtils.wait(2);
        driver.get("https://practice-cybertekschool.herokuapp.com/sign_up");
        BrowserUtils.wait(5);
        driver.findElement(By.xpath("//*[@id=\"login\"]/div[1]/div/input")).sendKeys("George Bush");
        driver.findElement(By.xpath("//*[@id=\"login\"]/div[2]/div/input")).sendKeys("email");
        String expected = "Thank you for signing up. Click the button below to return to the home page.";
        BrowserUtils.wait(5);
        String actual = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).getText();

        Assert.assertEquals(actual,expected, "They don't match");
        driver.get("https://www.tempmailaddress.com/");

        BrowserUtils.wait(2);
        String senderActual = driver.findElement(By.xpath("(//tr/td[1]/span[2])[1]")).getText();
        String senderEcpected = "do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(senderActual, senderEcpected, "Email is not the same ");
        String subExpected = "Thanks for subscribing to practice.cybertekschool.com!";
        String subActual = driver.findElement(By.xpath("(//tr/td[1]/span[3])[1]")).getText();
        Assert.assertEquals(subActual, subExpected, "Subject is not matching");
        System.out.println("Expected email: " +senderEcpected + " Actual email: " +senderActual );
        System.out.println("Expected subject: " +subExpected +" Actual subject: " + subActual );






    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}

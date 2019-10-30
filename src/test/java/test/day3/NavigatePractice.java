package test.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.awt.*;
import java.util.ArrayList;

public class NavigatePractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("safari");
        driver.manage().window().maximize();
        driver.get("http://google.com");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");


        BrowserUtils.wait(3);
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0)); //switches to new tab
        driver.get("https://www.facebook.com");

        driver.switchTo().window(tabs.get(0)); // switch back to main screen
        driver.get("https://www.news.google.com");
        driver.close();


    }
}

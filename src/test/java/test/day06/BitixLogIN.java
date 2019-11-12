package test.day06;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class BitixLogIN {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://login1.nextbasecrm.com/?login=yes");
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("helpdesk33@cybertekschool.com");
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys("UserUser" + Keys.ENTER);
        BrowserUtils.wait(2);
        //driver.findElement(By.xpath("//input[@type='submit']")).click();

        driver.quit();



    }
}

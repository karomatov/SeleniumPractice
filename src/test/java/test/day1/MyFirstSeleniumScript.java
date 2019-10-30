package test.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class MyFirstSeleniumScript {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://qa2.vytrack.com/user/login");
        driver.manage().window().fullscreen();
        Thread.sleep(3000);
        WebElement username = driver.findElement(By.id("prependedInput"));
        WebElement password = driver.findElement(By.id("prependedInput2"));
        username.sendKeys("storemanager83");
        Thread.sleep(3000);
        password.sendKeys("UserUser123");
        password.submit();
        Thread.sleep(7000);
        //driver.findElement(By.cssSelector("#hdtb-msb-vis > div:nth-child(3) > a")).click();
        //Thread.sleep(4000);
        //driver.findElement(By.cssSelector("#rso > div > div > div:nth-child(2) > div > div > div.r > a > h3")).click();
        //Thread.sleep(4000);
        if (driver.getTitle().equalsIgnoreCase("Dashboard")){
            System.out.println("Passed!");
        } else {
            System.out.println("Failed!");
        }
        System.out.println(driver.getTitle());

        System.out.println(driver.getCurrentUrl());
        driver.quit();
    }

}

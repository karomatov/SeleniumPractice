package test.day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class BrowserNavigation {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("safari");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
        /*
        step 1. Open inspector in chrome and fined locator for the element.
        step 2. Create object of WebElement
        step 3. Use WebElement.
         */
        WebElement button = driver.findElement(By.id("form_submit"));
        button.click();
        BrowserUtils.wait(3);
        driver.close();



    }
}

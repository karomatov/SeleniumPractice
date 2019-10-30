package test.day05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class IdLocatorTest {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        driver.findElement(By.id("disappearing_button")).click();
        WebElement result = driver.findElement(By.id("result"));
        BrowserUtils.wait(3);
        System.out.println(result.getText());
        driver.close();

    }
}

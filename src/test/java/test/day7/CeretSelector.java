package test.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class CeretSelector {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/multiple_buttons");

        WebElement button = driver.findElement(By.cssSelector("[class$='btn']"));
        System.out.println(button.getText());
        driver.quit();
    }
}

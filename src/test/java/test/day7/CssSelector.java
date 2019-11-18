package test.day7;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;
import java.util.Locale;

public class CssSelector {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://practice-cybertekschool.herokuapp.com/multiple_buttons");

        List<WebElement> buttons = driver.findElements(By.cssSelector(".btn"));

        for (WebElement each : buttons) {
            System.out.println(each.getText());
            each.click();
            BrowserUtils.wait(2);
            String result = driver.findElement(By.id("result")).getText();
            System.out.println(result);
        }

        WebElement header = driver.findElement(By.cssSelector("[class='container']>h3"));
        System.out.println(header.getText());

        WebElement p = driver.findElement(By.cssSelector(".container > p"));
        System.out.println(p.getText());

        Faker dummy = new Faker(Locale.forLanguageTag("ru"));

        driver.quit();


    }
}

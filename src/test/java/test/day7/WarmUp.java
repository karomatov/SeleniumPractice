package test.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

import java.util.List;

public class WarmUp {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://cybertekschool.com/");


        List<WebElement>links = driver.findElements(By.xpath("//a"));
        System.out.println("Number of links: " + links.size());

        for(WebElement each : links){
            if (!each.getText().isEmpty()){
                String attr = each.getAttribute("href");
                String text = each.getText();
                System.out.println("Text: " + text + " Links: " + attr);

            }
        }

        driver.quit();

    }
}

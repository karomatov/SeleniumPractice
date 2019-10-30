package test.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.safari.SafariDriver;

public class SafariTest {
    public static void main(String[] args) {
        SafariDriver driver = new SafariDriver();
        driver.get("http://www.google.com");

    }
}

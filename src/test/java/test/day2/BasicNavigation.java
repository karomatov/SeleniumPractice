package test.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        driver.manage().window().fullscreen();
        driver.navigate().to("http://amazon.com");
        Thread.sleep(3000);
        driver.navigate().back();
        driver.close();

    }
}

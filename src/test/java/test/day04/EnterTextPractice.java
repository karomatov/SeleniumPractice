package test.day04;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;
public class EnterTextPractice {
    public static void main(String[] args) {
        //grey text "browser" is not a value
        //it's a placeholder/ or name of the method parameter
        //you dn't enter that
        //it comes up automatically
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement inputBox = driver.findElement(By.name("email"));
        //we enter the text
        inputBox.sendKeys("random@email.com", Keys.ENTER);
        //WebElement button = driver.findElement(By.id("form_submit"));
        //to click on the element
        // button.click();
        BrowserUtils.wait(2);

        String expected = "Your e-mail's been sent!";

        WebElement confirmation = driver.findElement(By.name("confirmation_message"));
        String text = confirmation.getText();
        if (expected.equals(text)){
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
        driver.close();
    }
}


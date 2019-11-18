package test.day08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class DropDowns {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Dropdown")).click();
    }

    @Test(description = "Select option 2 from the dropdown")
    public void test(){
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        //select.selectByVisibleText("Option 2");
        select.selectByIndex(2);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option 2");
        BrowserUtils.wait(2);
        System.out.println("Dropdown option: " + select.getFirstSelectedOption().getText() + " selected");
    }

    @Test(description = "Print list of states")
    public void test2(){
        WebElement state = driver.findElement(By.id("state"));
        Select select = new Select(state);
        List<WebElement> states = select.getOptions();

        for (WebElement each : states) {
            System.out.println("State: " + each.getText() + " - "+ each.getAttribute("value"));
        }
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}

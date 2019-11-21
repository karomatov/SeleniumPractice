package test.day12;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class DragAndDropPractice {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/drag_and_drop");
        driver.manage().window().maximize();
    }

    @Test(description = "Drag and drop")
    public void test(){
        Actions action = new Actions(driver);

        WebElement a = driver.findElement(By.id("column-a"));
        WebElement b = driver.findElement(By.id("column-b"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("for(i=1; i<5;i++) {var name = prompt('Hello'); document.getElementById(\"column-a\").innerHTML =name;}");
        BrowserUtils.wait(10);
        js.executeScript("");
    }
    @Test(description = "Drag and drop example")
    public void test1(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        //click on accept cookies
        BrowserUtils.wait(3);//for demo
        driver.findElement(By.cssSelector("button[title='Accept Cookies']")).click();
        Actions actions = new Actions(driver);
        WebElement moon = driver.findElement(By.id("draggable"));
        WebElement earth = driver.findElement(By.id("droptarget"));
        BrowserUtils.wait(3);//for demo
//      * @param source element to emulate button down at.
//      * @param target element to move to and release the mouse at.
        actions.dragAndDrop(moon, earth).perform();
        BrowserUtils.wait(3);//for demo
        System.out.println(earth.getText());
        driver.quit();
    }




    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}

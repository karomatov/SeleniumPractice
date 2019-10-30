package test.day1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.BrowserFactory;
import utils.BrowserUtils;

import javax.swing.*;

public class fillUpForm {
    static WebDriver driver = BrowserFactory.getDriver("chrome");
    public static void main(String[] args) {
        logIn();
        newCar();
        BrowserUtils.wait(4);
        driver.quit();


    }

    public static void logIn(){

        driver.get("http://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();
        WebElement username = driver.findElement(By.id("prependedInput"));
        WebElement password = driver.findElement(By.id("prependedInput2"));
        username.sendKeys("storemanager83");
        password.sendKeys("UserUser123");
        password.submit();


    }
    public static void newCar(){


        Actions actions = new Actions(driver);
        BrowserUtils.wait(3);
        WebElement fleet = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));
        actions.moveToElement(fleet).perform();
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("(//li[@class='dropdown-menu-single-item last'])[1]")).submit();

        BrowserUtils.wait(2);
        // button for creating a car.
        WebElement createCar = driver.findElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']"));
        actions.click(createCar).perform();
        BrowserUtils.wait(2);

        WebElement modelName = driver.findElement(By.id("custom_entity_type_ModelName-uid-5db8c81a47f8b"));
            modelName.sendKeys("GLE 350");
        WebElement carMake = driver.findElement(By.id("custom_entity_type_Make-uid-5db8c81a480a0"));
            carMake.sendKeys("Mercedes Benz");
        WebElement VAT = driver.findElement(By.id("custom_entity_type_CatalogValue-uid-5db8c81a486ac"));
            VAT.sendKeys("123456");
        WebElement cost = driver.findElement(By.id("custom_entity_type_Cost-uid-5db8c81a48885"));
            cost.sendKeys("2500");
        WebElement totalCost = driver.findElement(By.id("custom_entity_type_TotalCost-uid-5db8c81a48967"));
            totalCost.sendKeys("5000");
        driver.findElement(By.xpath("//*[@id=\"s2id_autogen5\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/ul[2]/li[1]/div")).click();


        // save and close
       driver.findElement(By.xpath("//*[@id=\"custom_entity_type-uid-5db8be87d910b\"]/div[1]/div/div/div[2]/div[1]/div[2]/div/button")).click();
       String info = driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div")).getText();
        System.out.println(info);

    }

}

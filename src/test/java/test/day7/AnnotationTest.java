package test.day7;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnnotationTest {
    @BeforeMethod(description = "Before method")
    public void setup(){
        System.out.println("Before method!!!");
    }

    @AfterMethod
    public void teardown(){
        System.out.println("After method");
    }

    @Test
    public void test1(){
        System.out.println("Test 1");
    }

    @Test
    public void test2(){
        System.out.println("Test 2");
    }
}

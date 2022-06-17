package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 {
    //Driver declaration
    AndroidDriver driver ;


    //Setup method
    @BeforeClass
    public void setUp() throws MalformedURLException {
       UiAutomator2Options options = new UiAutomator2Options();
       options.setPlatformName("android");
       options.setAutomationName("UiAutomator2");
       options.setAppPackage("com.sec.android.app.popupcalculator");
       options.setAppActivity(".Calculator");
       options.noReset();

       //Server Address
       URL serverUrl = new URL("http://localhost:4723/wd/hub");

       //Initializing driver
       driver= new AndroidDriver(serverUrl, options);

    }

    //Test method
    @Test
    public void multiplyTest(){
        driver.findElement(AppiumBy.id("calc_keypad_btn_05")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_mul")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_06")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_equal")).click();

        String value = driver.findElement(AppiumBy.id("calc_edt_formula")).getText();
        int actValue = Integer.parseInt(value);
        Assert.assertEquals(actValue,30);

    }

    //Tear Down method
    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}

package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity3 {
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
    @Test(priority = 1)
    public void additionTest(){
        driver.findElement(AppiumBy.id("calc_keypad_btn_05")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_add")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_09")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_equal")).click();

        String value = driver.findElement(AppiumBy.id("calc_edt_formula")).getText();
        int actValue = Integer.parseInt(value);
        System.out.println("The sum is : "+actValue);
        Assert.assertEquals(actValue,14);

    }

    @Test(priority = 2)
    public void subtractionTest(){
        driver.findElement(AppiumBy.id("calc_keypad_btn_01")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_00")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_sub")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_05")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_equal")).click();

        String value = driver.findElement(AppiumBy.id("calc_edt_formula")).getText();
        int actValue = Integer.parseInt(value);
        System.out.println("The value after subtraction is : "+actValue);
        Assert.assertEquals(actValue,5);

    }

    @Test(priority = 3)
    public void multiplicationTest(){
        driver.findElement(AppiumBy.id("calc_keypad_btn_05")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_mul")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_01")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_00")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_00")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_equal")).click();

        String value = driver.findElement(AppiumBy.id("calc_edt_formula")).getText();
        int actValue = Integer.parseInt(value);
        System.out.println("The value after subtraction is : "+actValue);
        Assert.assertEquals(actValue,500);

    }

    @Test(priority = 4)
    public void divisionTest(){
        driver.findElement(AppiumBy.id("calc_keypad_btn_05")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_00")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_div")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_02")).click();

        driver.findElement(AppiumBy.id("calc_keypad_btn_equal")).click();

        String value = driver.findElement(AppiumBy.id("calc_edt_formula")).getText();
        int actValue = Integer.parseInt(value);
        System.out.println("The value after subtraction is : "+actValue);
        Assert.assertEquals(actValue,25);

    }

    //Tear Down method
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

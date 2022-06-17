package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity4 {
    //Driver declaration
    AndroidDriver driver ;
    WebDriverWait wait;

    //Setup method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.samsung.android.app.contacts");
        options.setAppActivity("com.samsung.android.contacts.contactslist.PeopleActivity");
        options.noReset();

        //Server Address
        URL serverUrl = new URL("http://localhost:4723/wd/hub");

        //Initializing driver & wait
        driver= new AndroidDriver(serverUrl, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    //Test method
    @Test
    public void addContactTest() throws InterruptedException {

       wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("contact_list_floating_action_button")));
       driver.findElement(AppiumBy.id("contact_list_floating_action_button")).click();
       wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("nameEdit")));
       driver.findElement(AppiumBy.id("nameEdit")).sendKeys("Aaditya Varma");

       driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Phone']")).click();

       wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@text='Phone']")));
       driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Phone']")).sendKeys("9991482920");
       driver.findElement(AppiumBy.id("smallLabel")).click();

       wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("header")));
       String name =  driver.findElement(AppiumBy.id("header")).getText();
       String num =driver.findElement(AppiumBy.id("display_number")).getText();

       System.out.println("The name that is added = "+name);
       System.out.println("The number that is added = "+num);
       Assert.assertEquals("Aaditya Varma",name );
       Assert.assertEquals("9991482920",num );

    }

    //Tear Down method
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}

package liveProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity5 {
    //Driver declaration
    AndroidDriver driver ;
    WebDriverWait wait;


    //Setup method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        //Server Address
        URL serverUrl = new URL("http://localhost:4723/wd/hub");

        //Initializing driver
        driver= new AndroidDriver(serverUrl, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));


    }


    //Test method to test valid login
    @Test(priority = 1)
    public void validLoginWeb() throws InterruptedException {
        //Navigating to the url
        driver.get("https://www.training-support.net/selenium");

        //Clicking the "Get started" button, which will scroll to the login form card
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.Button[@text='Get Started!']")));
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Get Started!']")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Login Form']")));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Login Form']")).click();

        /* Once the page loads, find the username and password input fields on the page and enter the following credentials in it:
            Username: admin
            Password: password

        Tried locating the username & password fields using id & accessibilityid but its not working
        so have to use xpath instead
        */
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.EditText[1]")));
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[1]")).sendKeys("admin");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[2]")).sendKeys("password");

        //Click on the Log in button to submit
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Log in']")).click();

        //Asserting the confirmation message
        String confirmText = driver.findElement(AppiumBy.xpath("//android.widget.TextView[4]")).getText();
        System.out.println("The confirmation message after login = "+confirmText);
        Assert.assertEquals("Welcome Back, admin", confirmText);

    }

    //Test method to test invalid login
    @Test(priority = 2)
    public void invalidLoginWeb() throws InterruptedException {
        //Clearing the text fields
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[1]")).clear();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[2]")).clear();

        //Entering incorrect credentials
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[1]")).sendKeys("incorrect");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[2]")).sendKeys("username");

        //Click on the Log in button to submit
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Log in']")).click();

        //Asserting the confirmation message
        String confirmText = driver.findElement(AppiumBy.xpath("//android.widget.TextView[4]")).getText();
        System.out.println("The confirmation message after login = "+confirmText);
        Assert.assertEquals("Invalid Credentials", confirmText);

    }

    //Tear Down method
    @AfterClass
    public void tearDown(){

        driver.quit();
    }
}

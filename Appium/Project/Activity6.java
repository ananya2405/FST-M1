package liveProject;

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

public class Activity6 {
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

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text='Get Started!']")));

        //Scroll to find the Popups card and click it.
        String uiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        driver.findElement(AppiumBy.ByAndroidUIAutomator.androidUIAutomator(uiScrollable +
                ".scrollIntoView(text(\"Popups\"))")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.Button[@text='Sign In']")));

        //Click on the Sign in button
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Sign In']")).click();

        /*
        Find the username and password input fields in the popup and enter the following credentials in it:
        Username: admin
        Password: password

         */
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.EditText[1]")));
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[1]")).sendKeys("admin");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[2]")).sendKeys("password");

        //Click on the Log in button to submit
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Log in']")).click();

        //Asserting the confirmation message
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[4]")));
        String confirmText = driver.findElement(AppiumBy.xpath("//android.widget.TextView[4]")).getText();
        System.out.println("The confirmation message after login = "+confirmText);
        Assert.assertEquals("Welcome Back, admin", confirmText);

    }

    //Test method to test invalid login
    @Test(priority = 2)
    public void invalidLoginWeb() throws InterruptedException {
        //Click on the Sign in button to navigate to the login page again
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Sign In']")).click();

        //Clearing the fields
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[1]")).clear();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[2]")).clear();

        //Entering incorrect credentials
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[1]")).sendKeys("incorrect");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[2]")).sendKeys("username");

        //Click on the Log in button to submit
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Log in']")).click();

        //Asserting the confirmation message
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[4]")));
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

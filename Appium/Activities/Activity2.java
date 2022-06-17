package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
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

public class Activity2 {
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

        //Initializing driver & wait
        driver= new AndroidDriver(serverUrl, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    //Test method
    @Test
    public void testWeb(){
        //Navigating to the url
        driver.get("https://www.training-support.net/");
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("About Us")));
        String heading = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Training Support']")).getText();
        System.out.println("The heading of the page :"+ heading);

        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='About Us']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='About Us']")));
        String heading2 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='About Us']")).getText();
        System.out.println("The heading of the About Us page :"+ heading2);

    }

    //Tear Down method
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

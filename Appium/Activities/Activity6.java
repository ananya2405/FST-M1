package activities;

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
import java.util.List;

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

        //Initializing driver & wait
        driver= new AndroidDriver(serverUrl, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    //Test method
    @Test
    public void testWeb(){
        // Navigate to the page
        driver.get("https://www.training-support.net/selenium/lazy-loading");

        //Wait till the page loads
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.className("android.widget.TextView")));

        // Get the number of images shown in the view
        List<WebElement> num = driver.findElements(AppiumBy.xpath("//android.view.View/android.view.View/android.widget.Image"));
        System.out.println("Number of image shown currently: " + num.size());
        Assert.assertEquals(num.size(), 2);

        // Scroll to the card with Helen's post
        driver.findElement(AppiumBy.androidUIAutomator("UiScrollable(UiSelector()).scrollTextIntoView(\"helen\")"));

        //Get number of images shown on the screen after scrolling.
        num = driver.findElements(AppiumBy.xpath("//android.view.View/android.view.View/android.widget.Image"));
        System.out.println("Number of image shown currently: " + num.size());
        Assert.assertEquals(num.size(), 4);
    }


    //Tear Down method
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

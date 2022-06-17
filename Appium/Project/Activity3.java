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
import java.util.List;

public class Activity3 {
    //Driver declaration
    AndroidDriver driver ;
    WebDriverWait wait;
    String item1 = "Add tasks to list";
    String item2 = "Get number of tasks";
    String item3 = "Clear the list";


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


    //Test method
    @Test
    public void testToDoListWeb() throws InterruptedException {
        //Navigating to the url
        driver.get("https://www.training-support.net/selenium");
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text='Get Started!']")));

        //Scroll to find the To-Do List card and click it.
        String uiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        driver.findElement(AppiumBy.ByAndroidUIAutomator.androidUIAutomator(uiScrollable +
                ".scrollIntoView(text(\"To-Do List\"))")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.EditText")));
        //Clearing the list initially
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=' Clear List']")).click();

        /*
        Once the page loads, find the input field on the page and enter the following three tasks:
        Add tasks to list
        Get number of tasks
        Clear the list
         */
        driver.findElement(AppiumBy.xpath("//android.widget.EditText")).sendKeys(item1);
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();

        driver.findElement(AppiumBy.xpath("//android.widget.EditText")).sendKeys(item2);
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();

        driver.findElement(AppiumBy.xpath("//android.widget.EditText")).sendKeys(item3);
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();

        //Getting the list of tasks added
        List<WebElement> list =  driver.findElements(AppiumBy.xpath("//android.view.View[@resource-id='tasksList']/android.view.View/android.widget.TextView"));
        System.out.println("The count of tasks = " +list.size());

        //Add assertions to verify that the test has passed or failed
        Assert.assertEquals(list.size(), 3);
        Assert.assertEquals(list.get(0).getText(), item1);
        Assert.assertEquals(list.get(1).getText(), item2);
        Assert.assertEquals(list.get(2).getText(), item3);

        //Click on each of the tasks added to strike them out.
        list.get(0).click();
        list.get(1).click();
        list.get(2).click();

        //clear the list and perform assertion
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=' Clear List']")).click();
        list =  driver.findElements(AppiumBy.xpath("//android.view.View[@resource-id='tasksList']/android.view.View/android.widget.TextView"));
        System.out.println("The new count of tasks after clearing the list= " +list.size());
        Assert.assertEquals(list.size(), 0);
    }

    //Tear Down method
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

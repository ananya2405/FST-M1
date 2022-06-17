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

public class Activity2 {
    //Driver declaration
    AndroidDriver driver ;
    WebDriverWait wait;
    String title = "Activity Title";
    String desc = "Activity description";

    //Setup method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();

        //Server Address
        URL serverUrl = new URL("http://localhost:4723/wd/hub");

        //Initializing driver
        driver= new AndroidDriver(serverUrl, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    //Test method
    @Test
    public void googleKeepAppTest()  {
        //Click the Create New Note button to add a new Note.
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("new_note_button")));
        driver.findElement(AppiumBy.id("new_note_button")).click();

        //Add a title for the note and add a small description.
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("editable_title")));
        driver.findElement(AppiumBy.id("editable_title")).sendKeys(title);
        driver.findElement(AppiumBy.id("edit_note_text")).sendKeys(desc);

        //Press the back button
        driver.findElement(AppiumBy.accessibilityId("Open navigation drawer")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("index_note_title")));

        // Assertion to ensure that the note was added.
        String actTitle =  driver.findElement(AppiumBy.id("index_note_title")).getText();
        String actDesc =  driver.findElement(AppiumBy.id("index_note_text_description")).getText();

        System.out.println("The added title is : "+ actTitle);
        System.out.println("The added description is : "+ actDesc);

        Assert.assertEquals(title, actTitle);
        Assert.assertEquals(desc, actDesc);

    }

    //Tear Down method
    @AfterClass
    public void tearDown() throws InterruptedException {
        //clean up
        try {
            driver.findElement(AppiumBy.id("browse_note_interior_content")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("bs_action_button")));
            driver.findElement(AppiumBy.id("bs_action_button")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Delete']")));
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Delete']")).click();
            Thread.sleep(2000);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        driver.quit();
    }

}

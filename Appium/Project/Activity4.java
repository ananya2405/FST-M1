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
        driver.findElement(AppiumBy.id("editable_title")).sendKeys("Activity Title");
        driver.findElement(AppiumBy.id("edit_note_text")).sendKeys("Activity description");

        //Click the reminder icon on the toolbar
        driver.findElement(AppiumBy.id("menu_switch_to_list_view")).click();

        //Picking a date & time
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Pick a date & time']")));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Pick a date & time']")).click();

        //Adding a reminder for tommorrow afternoon
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.keep:id/text")));

        List<WebElement> ele = driver.findElements(AppiumBy.xpath("//android.widget.Spinner"));
        ele.get(0).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Tomorrow']")));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Tomorrow']")).click();
        ele.get(1).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Afternoon']")));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Afternoon']")).click();

        //Clicking save to save the reminder
        driver.findElement(AppiumBy.id("save")).click();

        //Press the back button and switch to the Reminders page.
        driver.findElement(AppiumBy.accessibilityId("Open navigation drawer")).click();

        //Make an assertion to ensure that the note was added with a reminder
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("index_note_title")));
        String reminder = driver.findElement(AppiumBy.id("reminder_chip_text")).getText();
        String title =  driver.findElement(AppiumBy.id("index_note_title")).getText();
        String desc =  driver.findElement(AppiumBy.id("index_note_text_description")).getText();
        System.out.println("The added title is : "+ title);
        System.out.println("The added description is : "+ desc);
        System.out.println("The reminder is : "+ reminder);
        Assert.assertEquals("Activity Title", title);
        Assert.assertEquals("Activity description", desc);
        Assert.assertEquals("Tomorrow, 13:00", reminder);

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

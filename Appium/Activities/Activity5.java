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

public class Activity5 {
    //Driver declaration
    AndroidDriver driver ;
    WebDriverWait wait;
    String expMessage= "Hello from Appium";
    String phnNum = "8777083267";


    //Setup method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.samsung.android.messaging");
        options.setAppActivity("com.android.mms.ui.ConversationComposer");
        options.noReset();

        //Server Address
        URL serverUrl = new URL("http://localhost:4723/wd/hub");

        //Initializing driver
        driver= new AndroidDriver(serverUrl, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    //Test method
    @Test
    public void contactappTest(){
        String uiScrollable = "UiScrollable(UiSelector().scrollable(true)";
        //Clicking the add new message button
        driver.findElement(AppiumBy.id("fab")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("recipients_editor_to")));

        //Locate the contact fields and enter phone number to send a message
        driver.findElement(AppiumBy.id("recipients_editor_to")).sendKeys(phnNum);

        //Locate the message input field and enter the message "Hello from Appium".
        driver.findElement(AppiumBy.id("message_edit_text")).sendKeys(expMessage);

        //Locate the send button and click it.
        driver.findElement(AppiumBy.id("selected_send_button2")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("content_text_view")));
        String actMessage = driver.findElement(AppiumBy.id("content_text_view")).getText();

        //Write an assertion to verify that the message has been sent successfully.
        Assert.assertEquals(expMessage,actMessage);

    }

    //Tear Down method
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}

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

public class Activity1 {
    //Driver declaration
    AndroidDriver driver ;
    WebDriverWait wait;
    String task1 = "Complete Activity with Google Tasks";
    String task2 = "Complete Activity with Google Keep";
    String task3 = "Complete the second Activity Google Keep";
    List<WebElement> list;

    //Setup method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();

        //Server Address
        URL serverUrl = new URL("http://localhost:4723/wd/hub");

        //Initializing driver
        driver= new AndroidDriver(serverUrl, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    //Test method
    @Test
    public void googleTaskTest() throws InterruptedException {
        //Click the button to add a new task.
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("tasks_fab")));
        driver.findElement(AppiumBy.id("tasks_fab")).click();

        //Adding task1
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("add_task_title")));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys(task1);
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("add_task_done")));

        //Clicking save to save the task
        driver.findElement(AppiumBy.id("add_task_done")).click();

        //Adding task2
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("tasks_fab")));
        driver.findElement(AppiumBy.id("tasks_fab")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("add_task_title")));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys(task2);
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("add_task_done")));

        //Clicking save to save the task
        driver.findElement(AppiumBy.id("add_task_done")).click();

        ////Adding task3
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("tasks_fab")));
        driver.findElement(AppiumBy.id("tasks_fab")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("add_task_title")));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys(task3);
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("add_task_done")));

        //Clicking save to save the task
        driver.findElement(AppiumBy.id("add_task_done")).click();

        //Assertion steps
        Thread.sleep(3000);
        list = driver.findElements(AppiumBy.id("task_name"));
        System.out.println("No of lists = "+list.size());
        System.out.println("1st item = "+list.get(0).getText());
        System.out.println("2nd item = "+list.get(1).getText());
        System.out.println("3rd item = "+list.get(2).getText());
        Assert.assertEquals(task3, list.get(0).getText());
        Assert.assertEquals(task2, list.get(1).getText());
        Assert.assertEquals(task1, list.get(2).getText());

     }

    //Tear Down method
    @AfterClass
    public void tearDown() throws InterruptedException {
        //Clean up
        try {
            for (int i = 0; i < 3; i++) {
                list = driver.findElements(AppiumBy.id("task_name"));
                list.get(0).click();
                wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("delete_task_option")));
                driver.findElement(AppiumBy.id("delete_task_option")).click();
                Thread.sleep(2000);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        driver.quit();
    }

}

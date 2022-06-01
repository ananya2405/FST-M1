package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

public class Activity9 {
    WebDriver driver;
    Alert alert;
    @BeforeTest
    public void setUp(){
        //create the driver instance for FirefoxDriver
        driver = new FirefoxDriver();
        Reporter.log("Opening url |");
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
    }

    @BeforeMethod
    public void defaultContent(){
        Reporter.log("Switching to default page |");
        driver.switchTo().defaultContent();
    }


    //Running tests using data from data provider
    @Test
    public void simpleAlertTestCase() {
        Reporter.log("Clicking the Simple alert button |");
        driver.findElement(By.id("simple")).click();
        alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Reporter.log("Alert text = " +alertText+" |");
        Reporter.log("Validating the alert text |");
        Assert.assertEquals(alertText, "This is a JavaScript Alert!");
        Reporter.log("Alert closed |");

    }

    @Test
    public void confirmAlertTestCase(){
        Reporter.log("Clicking the confirm alert button |");
        driver.findElement(By.id("confirm")).click();
        alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Reporter.log("Alert text = " +alertText +" |");
        alert.accept();
        Reporter.log("Validating the alert text |");
        Assert.assertEquals(alertText, "This is a JavaScript Confirmation!");
        Reporter.log("Alert closed |");

    }

    @Test
    public void promptAlertTestCase() {
        Reporter.log("Clicking the prompt alert button |");
        driver.findElement(By.id("prompt")).click();
        alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Reporter.log("Alert text = " +alertText);
        alert.sendKeys("Hello world");
        alert.dismiss();
        Reporter.log("Validating the alert text |");
        Assert.assertEquals(alertText, "This is a JavaScript Prompt!");
        Reporter.log("Alert closed |");
    }


    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}


package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity6 {
    WebDriver driver;
    @BeforeClass(alwaysRun = true)
    public void setUp(){
        //create the driver instance for FirefoxDriver
        driver = new FirefoxDriver();
        //Open url
        driver.get("https://www.training-support.net/selenium/login-form");
    }

    @Test
    @Parameters({"username", "password"})
    public void testTitle(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[(text()='Log in')]")).click();

        //Read the confirmation message and make and assertion to check if the correct message has been printed.
        String text = driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals(text, "Welcome Back, admin");

    }


    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}


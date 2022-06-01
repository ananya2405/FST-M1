package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {

    WebDriver driver;
    @BeforeClass
    public void setUp(){
        //create the a driver instance for FirefoxDriver
        driver = new FirefoxDriver();
        //Open url
        driver.get("https://www.training-support.net/selenium/login-form");
    }

    @Test
    public void testCase1() {
        //Use getTitle() to get and print the title of the page.
        String title = driver.getTitle();
        System.out.println("The page title is = " + title);
        //Make an assertion using assertEquals() to make sure the title of the page is "Training Support".
        Assert.assertEquals(title, "Login Form");

        /*Find the login input fields - username and password
        Enter the credentials - admin and password - and click the "Log in" button.
        */
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[(text()='Log in')]")).click();

        //Read the confirmation message and make and assertion to check if the correct message has been printed.
        String text = driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals(text, "Welcome Back, admin");
    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Activity7 {

    WebDriver driver;
    @BeforeClass(alwaysRun = true)
    public void setUp(){
        //create the driver instance for FirefoxDriver
        driver = new FirefoxDriver();
        //Open url
        driver.get("https://www.training-support.net/selenium/login-form");
    }

    //Creating a data provider
    @DataProvider(name="Authentication")
    public static Object[][] credentials(){
        Object[][] data = { {"admin", "password"} };
        return data;
    }

    //Running tests using data from data provider
    @Test (dataProvider = "Authentication")
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

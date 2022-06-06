package liveSeleniumProjectGroupA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity8 {
    WebDriver driver;
    WebDriverWait wait;
    String jobName;

    @BeforeClass
    public void setUp() {
        //create the driver instance for FirefoxDriver
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //Open application url
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");

    }

    @Test
    @Parameters({"username", "password"} )
    public void loginToWebsiteBackend(String username, String password) {
        //Find the username field of the login form and enter the username into that field.
        driver.findElement(By.id("user_login")).sendKeys(username);

        //Find the password field of the login form and enter the password into that field.
        driver.findElement(By.id("user_pass")).sendKeys(password);

        //Find the login button and click it.
        driver.findElement(By.id("wp-submit")).click();

        //Verify login happened successfully
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='wrap']/h1")));
        String loggedInText = driver.findElement(By.xpath("//*[@class='wrap']/h1")).getText();
        System.out.println("Landing page text after successful login = "+ loggedInText);
        Assert.assertEquals(loggedInText, "Dashboard");

     }

    @AfterClass
    public void tearDown() {
        //Killing the driver instance
        driver.quit();
    }
}

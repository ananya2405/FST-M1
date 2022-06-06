package liveSeleniumProjectGroupA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        //create the driver instance for FirefoxDriver
        driver = new FirefoxDriver();
        //Open application url
        driver.get("https://alchemy.hguy.co/jobs/");
    }

    @Test
    public void getPageHeading() {
        //Get the heading of the website.
        String heading = driver.findElement(By.className("entry-title")).getText();
        System.out.println("The heading of the website is = "+heading);
        //Asserting the title
        Assert.assertEquals(heading, "Welcome to Alchemy Jobs");
    }

    @AfterClass
    public void tearDown() {
        //Killing the driver instance
        driver.quit();
    }

}

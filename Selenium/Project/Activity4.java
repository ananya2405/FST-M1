package liveSeleniumProjectGroupA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity4 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        //create the driver instance for FirefoxDriver
        driver = new FirefoxDriver();
        //Open application url
        driver.get("https://alchemy.hguy.co/jobs/");
    }

    @Test
    public void getSecondHeading() {
        //Get the second heading of the website.
        String heading = driver.findElement(By.xpath("//*[@id='post-16']/div/h2")).getText();
        System.out.println("The second heading of the page is = "+heading);
        Assert.assertEquals(heading, "Quia quis non");

    }

    @AfterClass
    public void tearDown() {
        //Killing the driver instance
        driver.quit();
    }

}

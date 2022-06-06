package liveSeleniumProjectGroupA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        //create the driver instance for FirefoxDriver
        driver = new FirefoxDriver();
        //Open application url
        driver.get("https://alchemy.hguy.co/jobs/");
    }

    @Test
    public void getPageTitle() {
        //Get the title of the website.
        String title = driver.getTitle();
        System.out.println("The page title is = " + title);

        //Asserting the title
        Assert.assertEquals(title, "Alchemy Jobs – Job Board Application");
    }

    @AfterClass
    public void tearDown() {
        //Killing the driver instance
        driver.quit();
    }
}

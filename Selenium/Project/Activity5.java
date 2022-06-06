package liveSeleniumProjectGroupA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        //create the driver instance for FirefoxDriver
        driver = new FirefoxDriver();
        //Open application url
        driver.get("https://alchemy.hguy.co/jobs/");
    }

    @Test
    public void navigateToJobSearchPage() {
        //Click job link from the site
        driver.findElement(By.xpath("//a[text()='Jobs']")).click();

        //Get page title
        String title = driver.getTitle();
        System.out.println("The second heading of the page is = "+title);
        Assert.assertEquals(title, "Jobs – Alchemy Jobs");

    }

    @AfterClass
    public void tearDown() {
        //Killing the driver instance
        driver.quit();
    }

}

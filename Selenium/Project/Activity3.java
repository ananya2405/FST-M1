package liveSeleniumProjectGroupA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        //create the driver instance for FirefoxDriver
        driver = new FirefoxDriver();
        //Open application url
        driver.get("https://alchemy.hguy.co/jobs/");
    }

    @Test
    public void getImageUrl() {
        //Get the image url of the website.
        String imageUrl = driver.findElement(By.cssSelector("img[class*='attachment']")).getAttribute("src");
        System.out.println("The url of the image is = "+imageUrl);

    }

    @AfterClass
    public void tearDown() {
        //Killing the driver instance
        driver.quit();
    }

}

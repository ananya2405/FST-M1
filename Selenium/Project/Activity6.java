package liveSeleniumProjectGroupA;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity6 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        //create the driver instance for FirefoxDriver
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //Open application url
        driver.get("https://alchemy.hguy.co/jobs/");
    }

    @Test
    public void searchJobs() {
        //Click job link from the site
        driver.findElement(By.xpath("//a[text()='Jobs']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search_keywords")));

        //Search for a particular job and wait for listings to show.
        driver.findElement(By.id("search_keywords")).sendKeys("Banking");
        driver.findElement(By.cssSelector("input[value='Search Jobs']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("position")));


        //Click on the first job search result
        driver.findElement(By.className("position")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[class*='button']")));

        //Click the "Apply for job" button
        driver.findElement(By.cssSelector("input[class*='button']")).click();

        //print the email id to the console.
        String email = driver.findElement(By.className("job_application_email")).getText();
        System.out.println("The email id for job application is = "+email);


    }

    @AfterClass
    public void tearDown() {
        //Killing the driver instance
        driver.quit();
    }

}

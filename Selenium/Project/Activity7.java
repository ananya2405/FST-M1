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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity7 {
    WebDriver driver;
    WebDriverWait wait;
    String jobName;

    @BeforeClass
    public void setUp() {
        //create the driver instance for FirefoxDriver
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //Open application url
        driver.get("https://alchemy.hguy.co/jobs/");
        jobName = "TestJob_" + Math.random();
    }

    @Test
    @Parameters({"username", "password"} )
    public void postJobs(String username, String password) {
        //Click "Post a job" link from the site
        System.out.println("The new job will be posted is = "+ jobName);
        driver.findElement(By.xpath("//a[text()='Post a Job']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[class='button']")));

        //Sign in to the site with the given credential
        driver.findElement(By.cssSelector("a[class='button']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user_login")));
        driver.findElement(By.id("user_login")).sendKeys(username);
        driver.findElement(By.id("user_pass")).sendKeys(password);
        driver.findElement(By.id("wp-submit")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("job_title")));


        //Fill in the necessary details in the form
        driver.findElement(By.id("job_title")).sendKeys(jobName);
        driver.switchTo().frame("job_description_ifr");
        driver.findElement(By.xpath("//*[@id='tinymce']")).sendKeys(jobName);
        driver.switchTo().defaultContent();
        //Clicking the Preview button
        driver.findElement(By.name("submit_job")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("job_preview_submit_button")));

        //Clicking on "Submit Listing" button
        driver.findElement(By.id("job_preview_submit_button")).click();

        //Click job link from the site
        driver.findElement(By.xpath("//a[text()='Jobs']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search_keywords")));

        //Search for the new job created and wait for listings to show.
        driver.findElement(By.id("search_keywords")).sendKeys(jobName);
        driver.findElement(By.cssSelector("input[value='Search Jobs']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("position")));
        String actualJobName = driver.findElement(By.xpath("//*[@class='position']/h3")).getText();
        System.out.println("The new job posted is = "+ actualJobName);

        //Verify the job is correctly posted
        Assert.assertEquals(actualJobName, jobName);

    }

    @AfterClass
    public void tearDown() {
        //Killing the driver instance
        driver.quit();
    }
}

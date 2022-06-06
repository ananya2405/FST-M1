package liveSeleniumProjectGroupA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Activity9 {
    WebDriver driver;
    WebDriverWait wait;
    String position;
    Actions act ;


    @BeforeClass
    public void setUp() {
        //create the driver instance for FirefoxDriver
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //Open application url
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");

        position = "TestPosition_" + Math.random();
        act =  new Actions(driver);

    }

    @Test
    @Parameters({"username", "password"} )
    public void addJobPosition(String username, String password) throws InterruptedException {
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

        //Click on menu item that says “Job Listings”.
        driver.findElement(By.xpath("//div[contains(text(),'Job Listings')]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[class='page-title-action']")));

        //Click on "Add New” button
        driver.findElement(By.cssSelector("a[class='page-title-action']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("post-title-0")));

        //Closing the popup windows
        driver.findElement(By.cssSelector(".components-modal__header > button:nth-child(2) > svg:nth-child(1)")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("post-title-0")));

        //Filling up required details
        driver.findElement(By.xpath("//*[@id='post-title-0']")).sendKeys(position);
        driver.findElement(By.name("_company_name")).sendKeys(position);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Publish…')]")));
        driver.findElement(By.xpath("//button[contains(text(),'Publish…')]")).click();

        //Clicking on the 2nd Publish button
        act.moveToElement(driver.findElement(By.xpath("//button[contains(text(),'Publish…')]"))).click().perform();

        //Verify that the job listing was created.
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".post-publish-panel__postpublish-header")));
        String message = driver.findElement(By.cssSelector(".post-publish-panel__postpublish-header")).getText();
        System.out.println("The success message after job posting : "+message);
        Assert.assertEquals(message, position+" is now live.");

    }

    @AfterClass
    public void tearDown() {
        //Killing the driver instance
        driver.quit();
    }
}

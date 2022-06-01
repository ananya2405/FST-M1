package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;

public class Activity2 {

    WebDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp(){
        //create the a driver instance for FirefoxDriver
        driver = new FirefoxDriver();
        //Open url
        driver.get("https://www.training-support.net/selenium/target-practice");
    }

    @Test
    public void testCase1() {
        //Use getTitle() to get and print the title of the page.
        String title = driver.getTitle();
        System.out.println("The page title is = " + title);
        //Make an assertion using assertEquals() to make sure the title of the page is correct.
        Assert.assertEquals(title, "Target Practice");
    }

     @Test
     public void testCase2(){
        //Getting the button text
        String buttonText = driver.findElement(By.cssSelector("button.black")).getText();
        // Adding an incorrect assertion
        Assert.assertEquals(buttonText, "grey");

    }

    //skipping the test by setting it's enabled parameter to false.
    @Test(enabled = false)
    public void testCase3(){
         Assert.assertEquals(1, 1);

    }

    //skipping the test by throwing a SkipException inside the method.
    @Test
    public void testCase4(){
        throw new SkipException("Skipping the test case");

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}


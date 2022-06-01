package activities;

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
    @BeforeClass(alwaysRun = true)
    public void setUp(){
        //create the a driver instance for FirefoxDriver
        driver = new FirefoxDriver();
        //Open url
        driver.get("https://www.training-support.net/selenium/target-practice");
    }

    @Test
    public void testTitle() {
        //Use getTitle() to get and print the title of the page.
        String title = driver.getTitle();
        System.out.println("The page title is = " + title);
        //Make an assertion using assertEquals() to make sure the title of the page is "Training Support".
        Assert.assertEquals(title, "Target Practice");

     }

    @Test(groups = {"HeaderTests"})
    public void testHeader1() {
        //Find the third header and assert the text in the h3 tag
        String headerText= driver.findElement(By.id("third-header")).getText();
        Assert.assertEquals(headerText, "Third header");
    }

    @Test(groups = {"HeaderTests"})
    public void testHeader2() {
        //Find and assert the colour of the fifth header tag element.
        String headerTextColor= driver.findElement(By.cssSelector("h5.green")).getCssValue("color");
        Assert.assertEquals(headerTextColor, "rgb(33, 186, 69)");
    }

    @Test(groups = {"ButtonTests"})
    public void testButton1() {
        //Find the button with the class olive and assert it text.
        String buttonText= driver.findElement(By.cssSelector("button.olive")).getText();
        Assert.assertEquals(buttonText, "Olive");
    }


    @Test(groups = {"ButtonTests"})
    public void testButton2() {
        //Find and assert the colour of the first button in the third row.
        String buttonColor= driver.findElement(By.cssSelector("button.brown")).getCssValue("color");
        Assert.assertEquals(buttonColor, "rgb(255, 255, 255)");

    }


    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}


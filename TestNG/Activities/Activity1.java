package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class Activity1 {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp(){
        //create the a driver instance for FirefoxDriver
        driver = new FirefoxDriver();
        //Open url
        driver.get("https://www.training-support.net");
     }

     @Test
     public void homePage(){
         //Use getTitle() to get and print the title of the page.
         String title = driver.getTitle();
         System.out.println("The page title is = "+ title);
         //Make an assertion using assertEquals() to make sure the title of the page is "Training Support".
         Assert.assertEquals(title, "Training Support");

         //Use findElement() to find the "About Us" Button on the page and click it.
         driver.findElement(By.id("about-link")).click();

         //Get and print the title of the new page.
         String pageTitle = driver.getTitle();
         System.out.println("The page title is = "+ pageTitle);

         //Assert the title of the new page.
         Assert.assertEquals(pageTitle, "About Training Support");
     }

     @AfterClass
    public void tearDown(){
        driver.quit();
     }
}

package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
    public static void main(String[] args)  {
        //Create a WebDriver instance, named driver, with the FirefoxDriver().
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/simple-form");

        //Get the title of the page using driver.getTitle() and print out the title.
        System.out.println("The title of the page = " + driver.getTitle());

        /*Use findElement() with id to find the text fields - firstname and lastname.
        Use WebElement.sendKeys() to type in those text fields. */
        driver.findElement(By.id("firstName")).sendKeys("Test");
        driver.findElement(By.id("lastName")).sendKeys("userpassword");
        driver.findElement(By.id("email")).sendKeys("test@gmail.com");
        driver.findElement(By.id("number")).sendKeys("1321312321");

        //Finally, submit the form by clicking the Submit button.
        driver.findElement(By.cssSelector("input[class='ui green button']")).click();
        driver.quit();

    }
}

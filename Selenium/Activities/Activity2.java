package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
    public static void main(String[] args){
        //Create a WebDriver instance, named driver, with the FirefoxDriver().
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net");

        //Get the title of the page using driver.getTitle() and print out the title
        System.out.println("The title of the page = "+ driver.getTitle());

        /*
        Use findElement() with the following locators to find the "About Us" link:
        id()
        className()
        linkText()
        cssSelector()
        Print the text in the WebElement using the getText() method.
         */
        System.out.println("The desired text using id locator: " +driver.findElement(By.id("about-link")).getText());
        System.out.println("The desired text using className locator: " +driver.findElement(By.className("inverted")).getText());
        System.out.println("The desired text using linkText locator: " +driver.findElement(By.linkText("About Us")).getText());
        System.out.println("The desired text using cssSelector locator: " +driver.findElement(By.cssSelector(".inverted")).getText());

        driver.quit();

    }
}

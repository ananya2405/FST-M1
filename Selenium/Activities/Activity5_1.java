package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_1 {
    public static void main(String[] args) {

        // Create a WebDriver instance, named driver, with the FirefoxDriver().
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/dynamic-controls");

        //Get the page title and print it to the console.
        System.out.println("The title of the page = " + driver.getTitle());

        /* Use findElement() to find the checkbox input element.
        Use the isDisplayed() method to check if it is visible on the page.
        */
        boolean isDisplayed = driver.findElement(By.cssSelector("input[class='willDisappear']")).isDisplayed();
        System.out.println("Is the checkbox visible ? "+ isDisplayed);

        //Click the "Remove Checkbox".
        driver.findElement(By.cssSelector("button[id='toggleCheckbox']")).click();

        // Print the result of the isDisplayed() method again.
        isDisplayed = driver.findElement(By.cssSelector("input[class='willDisappear']")).isDisplayed();
        System.out.println("Is the checkbox visible ? "+ isDisplayed);

        driver.quit();

    }
    }

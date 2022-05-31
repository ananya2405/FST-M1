package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_3 {

    public static void main(String[] args) {

        // Create a WebDriver instance, named driver, with the FirefoxDriver().
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/dynamic-controls");

        //Get the page title and print it to the console.
        System.out.println("The title of the page = " + driver.getTitle());

        //Use findElement() to find the text field.
        boolean isEnabled = driver.findElement(By.id("input-text")).isEnabled();

        //Use the isEnabled() method to check if the text field is enabled.
        System.out.println("Is the textbox enabled ? "+ isEnabled);

        //Click the "Enable Input" button to enable the input field.
        driver.findElement(By.id("toggleInput")).click();

        //Use the isEnabled() method again and print the result.
        isEnabled = driver.findElement(By.id("dynamicText")).isEnabled();
        System.out.println("Is the textbox enabled ? "+ isEnabled);

        driver.quit();


    }
}

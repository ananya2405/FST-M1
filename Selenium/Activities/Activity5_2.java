package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_2 {
    public static void main(String[] args) {

        // Create a WebDriver instance, named driver, with the FirefoxDriver().
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/dynamic-controls");

        //Get the page title and print it to the console.
        System.out.println("The title of the page = " + driver.getTitle());

        /*
        Use findElement() to find the checkbox input element.
        Use the isSelected() method to check if the checkbox is selected.
         */
        boolean isSelected = driver.findElement(By.cssSelector("input[class='willDisappear']")).isSelected();
        System.out.println("Is the checkbox visible ? "+ isSelected);

        //Click the checkbox to select it.
        driver.findElement(By.cssSelector("input[class='willDisappear']")).click();

        // Use the isSelected() method again and print the result.
        isSelected = driver.findElement(By.cssSelector("input[class='willDisappear']")).isSelected();
        System.out.println("Is the checkbox visible ? "+ isSelected);

        driver.quit();

    }
}

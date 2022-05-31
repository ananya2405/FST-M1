package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity11_3 {
    public static void main(String[] args) throws InterruptedException {
        //Create a WebDriver instance, named driver, with the FirefoxDriver()
        WebDriver driver = new FirefoxDriver();

        //Open the url
        driver.get("https://www.training-support.net/selenium/javascript-alerts");

        //Get the title of the page using driver.getTitle() and print out the title.
        System.out.println("The title of the page = " + driver.getTitle());

        //lso use findElement() to find the button to open a PROMPT alert and click it.
        driver.findElement(By.id("prompt")).click();

        //Switch the focus from the main window to the Alert box.
        Alert alert = driver.switchTo().alert();
        System.out.println("The text in the a;ert is = "+ alert.getText());

        //Use sendKeys() to type in "Yes, you are!".
        alert.sendKeys("Yes, you are!");

        //Close the alert with alert.accept().
        alert.accept();

        driver.quit();

    }
}

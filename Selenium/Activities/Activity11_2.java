package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity11_2 {
    public static void main(String[] args) throws InterruptedException {
        //Create a WebDriver instance, named driver, with the FirefoxDriver()
        WebDriver driver = new FirefoxDriver();

        //Open the url
        driver.get("https://www.training-support.net/selenium/javascript-alerts");

        //Get the title of the page using driver.getTitle() and print out the title.
        System.out.println("The title of the page = " + driver.getTitle());

        //Use findElement() to find the button to open a SIMPLE alert and click it.
        driver.findElement(By.id("confirm")).click();

        Alert alert = driver.switchTo().alert();
        System.out.println("The text in the a;ert is = "+ alert.getText());
        alert.accept();
        driver.findElement(By.id("confirm")).click();
        alert.dismiss();

        driver.quit();


    }
}

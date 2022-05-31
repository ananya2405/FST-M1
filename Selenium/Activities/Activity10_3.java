package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity10_3 {
    public static void main(String[] args) {
        //Create a WebDriver instance, named driver, with the FirefoxDriver()
        WebDriver driver = new FirefoxDriver();

        //Open the url
        driver.get("https://training-support.net/selenium/drag-drop");

        //Get the title of the page using driver.getTitle() and print out the title.
        System.out.println("The title of the page = "+driver.getTitle());

        //Find the ball and simulate a click and drag to move it into "Dropzone 1".
        WebElement ball = driver.findElement(By.id("draggable"));
        WebElement dropzone1 = driver.findElement(By.id("droppable"));
        WebElement dropzone2 = driver.findElement(By.id("dropzone2"));
        Actions builder = new Actions(driver);

        //Verify that the ball has entered Dropzone 1.
        builder.dragAndDrop(ball,dropzone1).build().perform();
        System.out.println("Ball entered: "+ dropzone1.getText());

        //Once verified, move the ball into "Dropzone 2".
        builder.dragAndDrop(ball,dropzone2).build().perform();

        //Verify that the ball has entered Dropzone 2.
        System.out.println("Ball entered: "+ dropzone2.getText());

        driver.quit();

    }
}

package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10_1 {
    public static void main(String[] args) throws InterruptedException {
        //Create a WebDriver instance, named driver, with the FirefoxDriver()
        WebDriver driver = new FirefoxDriver();

        //Open the url
        driver.get("https://www.training-support.net/selenium/input-events");

        //Get the title of the page using driver.getTitle() and print out the title.
        System.out.println("The title of the page = " + driver.getTitle());

        Actions action = new Actions(driver);
        WebElement dice = driver.findElement(By.id("wrapD3Cube"));
        String diceVal;

        //Left click and print the value of the side in the front.
        action.click(dice).perform();
        diceVal = driver.findElement(By.className("active")).getText();
        System.out.println("The dice value after left click is ="+ diceVal);

        //Double click to show a random side and print the number.
        action.doubleClick(dice).perform();
        diceVal = driver.findElement(By.className("active")).getText();
        System.out.println("The dice value after double click is ="+ diceVal);

        //Right click and print the value shown on the front of the cube.
        action.contextClick(dice).perform();
        diceVal = driver.findElement(By.className("active")).getText();
        System.out.println("The dice value after right click is ="+ diceVal);

        driver.quit();


    }
}

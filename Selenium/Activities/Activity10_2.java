package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10_2 {
    public static void main(String[] args) throws InterruptedException {
        //Create a WebDriver instance, named driver, with the FirefoxDriver()
        WebDriver driver = new FirefoxDriver();

        //Open the url
        driver.get("https://www.training-support.net/selenium/input-events");

        //Get the title of the page using driver.getTitle() and print out the title.
        System.out.println("The title of the page = " + driver.getTitle());

        //Creating an action class object
        Actions action = new Actions(driver);
        WebElement pressedKey = driver.findElement(By.id("keyPressed"));

        //Press the key of your first name in caps
        action.sendKeys("A").build().perform();
        System.out.println("The pressed key is = "+pressedKey.getText());

        //Press CTRL+a and the CTRL+c to copy all the text on the page.
        action.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).build().perform();
        System.out.println("The pressed key is = "+pressedKey.getText());

        driver.quit();
    }
}

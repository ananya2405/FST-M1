package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity6_2 {
    public static void main(String[] args) {
        //Create a WebDriver instance, named driver, with the FirefoxDriver().
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Navigate to the url
        driver.get("https://training-support.net/selenium/ajax");
        //Get the title of the page using driver.getTitle() and print out the title.
        System.out.println("The page title is = " + driver.getTitle());

        //Find and click the "Change content" button on the page.
        WebElement toggleButton = driver.findElement(By.xpath("//button[contains(@class,'violet ')]"));
        toggleButton.click();

        //Wait for the text to say "HELLO!". Print the message that appears on the page.
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ajax-content"),"HELLO!"));
        String message = driver.findElement(By.id("ajax-content")).getText();
        System.out.println(("The message displayed is = "+ message));

        //Wait for the text to change to contain "I'm late!". Print the new message on the page.
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ajax-content"),"I'm late!"));
        message = driver.findElement(By.id("ajax-content")).getText();
        System.out.println(("New message displayed is = "+ message));

        driver.quit();
    }
}

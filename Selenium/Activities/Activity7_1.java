package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity7_1 {

    public static void main(String[] args) {
        //Create a WebDriver instance, named driver, with the FirefoxDriver().
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Navigate to the url
        driver.get("https://training-support.net/selenium/dynamic-attributes");
        //Get the title of the page using driver.getTitle() and print out the title.
        System.out.println("The page title is = " + driver.getTitle());

        /*
        Find the username and password input fields. Type in the credentials:
        username: admin
        password: password
         */
        WebElement username = driver.findElement(By.xpath("//input[starts-with(@class,'username-')]"));
        WebElement password = driver.findElement(By.xpath("//input[starts-with(@class,'password-')]"));
        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        username.sendKeys("admin");
        password.sendKeys("password");
        loginButton.click();

        //Wait for login message to appear and print the login message to the console.
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("action-confirmation")));
        String message = driver.findElement(By.id("action-confirmation")).getText();

        System.out.println("The login message displaying is : "+message);

        driver.quit();
    }
}

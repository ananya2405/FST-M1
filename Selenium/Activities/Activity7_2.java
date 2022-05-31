package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity7_2 {
    public static void main(String[] args) {
        //Create a WebDriver instance, named driver, with the FirefoxDriver().
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Navigate to the url
        driver.get("https://training-support.net/selenium/dynamic-attributes");
        //Get the title of the page using driver.getTitle() and print out the title.
        System.out.println("The page title is = " + driver.getTitle());

        //Find the input fields of the Sign Up form. Fill in the details in the fields with your own data.
        WebElement username = driver.findElement(By.xpath("//input[contains(@class, '-username')]"));
        WebElement password = driver.findElement(By.xpath("//input[contains(@class, '-password')]"));
        WebElement confirmPassword = driver.findElement(By.xpath("//label[text() = 'Confirm Password']/following::input"));
        WebElement email = driver.findElement(By.xpath("//label[contains(text(), 'mail')]/following-sibling::input"));
        WebElement signupButton = driver.findElement(By.xpath("//button[contains(text(), 'Sign Up')]"));

        username.sendKeys("admin");
        password.sendKeys("password");
        confirmPassword.sendKeys("password");
        email.sendKeys("admin@gmail.com");
        signupButton.click();

        //Wait for success message to appear and print it to the console.
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("action-confirmation")));
        String message = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("The sign up message is : "+ message);

        driver.quit();
    }
}


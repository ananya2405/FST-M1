package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity6_1 {
    public static void main(String[] args){
        //Create a WebDriver instance, named driver, with the FirefoxDriver().
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));

        //Navigate to the url
        driver.get("https://training-support.net/selenium/dynamic-controls");
        //Get the title of the page using driver.getTitle() and print out the title.
        System.out.println("The page title is = "+driver.getTitle());

        //Find the checkbox toggle button and click it.
        WebElement toggleButton = driver.findElement(By.id("toggleCheckbox"));
        WebElement checkBox = driver.findElement(By.xpath("//div[@id='dynamicCheckbox']/input"));
        toggleButton.click();

        //Wait till the checkbox disappears.
        wait.until(ExpectedConditions.invisibilityOf(checkBox));

        //Click the button again. Wait till it appears
        toggleButton.click();
        wait.until(ExpectedConditions.visibilityOf(checkBox));
        //check the checkbox
        checkBox.click();

        driver.quit();

    }
}

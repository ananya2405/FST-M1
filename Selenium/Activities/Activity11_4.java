package activities;

import org.apache.commons.math3.analysis.function.Exp;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class Activity11_4 {
    public static void main(String[] args) throws InterruptedException {
        //Create a WebDriver instance, named driver, with the FirefoxDriver()
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Open the url
        driver.get("https://www.training-support.net/selenium/tab-opener");

        //Print the Page Title and Handle of that tab.
        System.out.println("The title of the page = " + driver.getTitle());
        String parentWindow = driver.getWindowHandle();
        System.out.println("The parent window handle is = "+parentWindow);

        //Find the button to open a new tab and click it.
        driver.findElement(By.id("launcher")).click();
        //Wait for the new tab to open.
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        //Print all the handles.
        Set<String> windows= driver.getWindowHandles();
        System.out.println("Printing all the window handles = "+windows);
        //Switch to the newly opened tab
        for(String window: windows){
            driver.switchTo().window(window);
        }

        //print it's title and heading.
        System.out.println("The window handle = "+ driver.getWindowHandle());
        wait.until(ExpectedConditions.titleIs("Newtab"));
        System.out.println("The page title of the new window = "+ driver.getTitle());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='content']")));
        System.out.println("The page header is = "+ driver.findElement(By.cssSelector("div[class='content']")).getText());

        //Find the button to open another tab and click it.
        driver.findElement(By.id("actionButton")).click();

        ////Wait for the new tab to open.
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));

        // //Print all the handles.
        windows= driver.getWindowHandles();
        System.out.println("Printing all the window handles = "+windows);

        //Switch to the newly opened tab
        for(String window: windows){
            driver.switchTo().window(window);
        }
        //print it's title and heading.
        System.out.println("The window handle = "+ driver.getWindowHandle());
        wait.until(ExpectedConditions.titleIs("Newtab2"));
        System.out.println("The page title of the new window = "+ driver.getTitle());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='content']")));
        System.out.println("The page header is = "+ driver.findElement(By.cssSelector("div[class='content']")).getText());

        driver.quit();
    }
}

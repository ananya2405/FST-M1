package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_1 {
    public static void main(String[] args) {
        //Create a WebDriver instance, named driver, with the FirefoxDriver().
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net");

        //Get the title of the page using driver.getTitle() and print out the title.
        System.out.println("The title of the page = " + driver.getTitle());

        //Use findElement() with xpath() to find and click the "About Us" link on the page.
        driver.findElement(By.xpath("//a[@id='about-link']")).click();

        //Print the title of the new page that open when the link is clicked.
        System.out.println("The title of the new page is = " + driver.getTitle());

        driver.quit();
    }
}

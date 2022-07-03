package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_3 {
    public static void main(String[] args) {

        // Create a WebDriver instance, named driver, with the FirefoxDriver().
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");
        System.out.println("The title of the page = " + driver.getTitle());

        /*
        Use findElement() with xpath() to
        Find the third header on the page.
        Find the fifth header on the page and get it's 'colour' CSS Property.
        Find the violet button on the page and print all the class attribute values.
        Find the grey button on the page with Absolute XPath.
         */
        System.out.println("The third header is = " + driver.findElement(By.xpath("//h3[@id='third-header']")).getText());
        System.out.println("The color of fifth header is = " + driver.findElement(By.xpath("//h5")).getCssValue("color"));
        System.out.println("The class attribute values of the violet button is = " + driver.findElement(By.xpath("//button[contains(text(), 'Violet')]")).getAttribute("class"));
        System.out.println("The grey button text is = " + driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[2]")).getText());

        driver.quit();
    }
}

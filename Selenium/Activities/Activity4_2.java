package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_2 {
    public static void main(String[] args) {
        // Create a WebDriver instance, named driver, with the FirefoxDriver().
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/simple-form");
        System.out.println("The title of the page = " + driver.getTitle());

        //Use findElement() with xpath() to find all the input fields on the page.
        driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("Test");
        driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("userpassword");
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("test@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"number\"]")).sendKeys("1321312321");

        //Click the submit button at the end of the form to submit the form.
        driver.findElement(By.xpath("//*[@id=\"simpleForm\"]/div/div[6]/div[1]/input")).click();
        driver.quit();


    }
}

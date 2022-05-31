package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity8_1 {
    public static void main(String[] args){
        //Create a WebDriver instance, named driver, with the FirefoxDriver()
        WebDriver driver = new FirefoxDriver();

        //Open the url
        driver.get("https://training-support.net/selenium/tables");

        //Use findElements() in combination with xpath() to find the number of columns and rows (not counting the table header) and print them.
        int noOfColumns = driver.findElements(By.xpath("//table[contains(@class,'striped')]/tbody/tr[1]/td")).size();
        int noOfRows = driver.findElements(By.xpath("//table[contains(@class,'striped')]/tbody/tr")).size();
        System.out.println("No of columns in the table = "+ noOfColumns);
        System.out.println("No of rows in the table = "+ noOfRows);

        //Find and print the all the cell values of the third row of the table.
        List<WebElement> list = driver.findElements(By.xpath("//table[contains(@class,'striped')]/tbody/tr[3]/td"));
        System.out.println("Elements of 3rd row are : ");
        for(WebElement ele : list){
            System.out.println(ele.getText());
        }
        // Find and print the cell value at the second row and second column.
        String value = driver.findElement(By.xpath("//table[contains(@class,'striped')]/tbody/tr[2]/td[2]")).getText();
        System.out.println("The cell value in the 2nd row of 2nd column is =  "+ value);

        driver.quit();
    }
}

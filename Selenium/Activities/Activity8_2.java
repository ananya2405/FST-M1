package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity8_2 {
    public static void main(String[] args) {
        //Create a WebDriver instance, named driver, with the FirefoxDriver()
        WebDriver driver = new FirefoxDriver();

        //Open the url
        driver.get("https://training-support.net/selenium/tables");

        //Use findElements() in combination with xpath() to find the number of columns and rows (not counting the table header) and print them.
        int noOfColumns = driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr[1]/td")).size();
        int noOfRows = driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr")).size();
        System.out.println("No of columns in the table = " + noOfColumns);
        System.out.println("No of rows in the table = " + noOfRows);

        // Find and print the cell value at the second row and second column.
        WebElement ele = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        String value = ele.getText();
        System.out.println("The cell value in the 2nd row of 2nd column is =  "+ value);

        //Click the header of the first column to sort by name.
        driver.findElement(By.xpath("//table[@id='sortableTable']/thead/tr/th[1]")).click();

        //Find and print the cell value at the second row and second column again.
        ele = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        value = ele.getText();
        System.out.println("The cell value in the 2nd row of 2nd column after sorting =  "+ value);

        //Print the cell values of the table footer.
        List<WebElement> list = driver.findElements(By.xpath("//table[@id='sortableTable']/tfoot/tr/th"));
        System.out.println("Elements of footer are : ");
        for(WebElement item : list){
            System.out.println(item.getText());
        }
        driver.quit();

    }
}

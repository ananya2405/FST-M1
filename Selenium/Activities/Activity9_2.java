package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity9_2 {
    public static void main(String[] args) {
        //Create a WebDriver instance, named driver, with the FirefoxDriver()
        WebDriver driver = new FirefoxDriver();

        //Open the url
        driver.get("https://training-support.net/selenium/selects");

        //Create a new Select class object with the WebElement.
        WebElement chosen = driver.findElement(By.id("multi-value"));
        Select multiList = new Select(driver.findElement(By.id("multi-select")));
        List<WebElement> optionsSelected;

        if(multiList.isMultiple()){
            multiList.selectByVisibleText("Javascript");
            System.out.println(chosen.getText());

            multiList.selectByValue("node");
            System.out.println(chosen.getText());

            for(int i=4; i<=6; i++) {
                multiList.selectByIndex(i);
            }
            System.out.println(chosen.getText());

            multiList.deselectByValue("node");
            System.out.println(chosen.getText());

            multiList.deselectByIndex(7);
            System.out.println(chosen.getText());

            optionsSelected = multiList.getAllSelectedOptions();
            for (WebElement item : optionsSelected) {
                System.out.println("Selected option = " + item.getText());
            }
            multiList.deselectAll();
            System.out.println(chosen.getText());
        }
        driver.quit();
    }
}

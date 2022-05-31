package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity9_1 {
    public static void main(String[] args) {
        //Create a WebDriver instance, named driver, with the FirefoxDriver()
        WebDriver driver = new FirefoxDriver();

        //Open the url
        driver.get("https://training-support.net/selenium/selects");

        //Create a new Select class object with the WebElement.
        Select sel = new Select(driver.findElement(By.id("single-select")));
        WebElement optionSelected ;

        //Select the second option using selectByVisibleText()
        sel.selectByVisibleText("Option 2");
        optionSelected = sel.getFirstSelectedOption();
        System.out.println("The chosen option is = "+optionSelected.getText());

        //Select the third option using selectByIndex()
        sel.selectByIndex(3);
        optionSelected = sel.getFirstSelectedOption();
        System.out.println("The chosen option is = "+optionSelected.getText());

        //Select the fourth option using selectByValue()
        sel.selectByValue("4");
        optionSelected = sel.getFirstSelectedOption();
        System.out.println("The chosen option is = "+optionSelected.getText());

        //Get all the options in the dropdown and print them one by one.
        List<WebElement> options = sel.getOptions();
        System.out.println("The list of all options from the dropdown : ");
        for(WebElement ele: options){
            System.out.println(ele.getText());

        }
        driver.quit();
    }
}

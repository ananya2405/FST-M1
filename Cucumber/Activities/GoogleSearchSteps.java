package stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleSearchSteps extends BaseClass{

    @Given("^User is on Google Home Page$")
    public void homePage(){
        driver.get("https://www.google.com/");

    }

    @When("^User types in Cheese and hits ENTER$")
    public void enterSearchText(){
        WebElement ele = driver.findElement(By.cssSelector("input[name='q']"));
        ele.sendKeys("Cheese");
        ele.sendKeys(Keys.ENTER);

    }

    @Then("^Show how many search results were shown$")
    public void result(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("result-stats")));
        String result = driver.findElement(By.id("result-stats")).getText();
        System.out.println("The result is = "+result);

    }

}

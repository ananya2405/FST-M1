package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertTests extends BaseClass{

    @Given("^User is on the page$")
    public void loginPage(){
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        String pageTile = driver.getTitle();
        System.out.println("The page title is : "+pageTile);
        Assert.assertEquals("Javascript Alerts",pageTile);

    }

    @When("^User clicks the Simple Alert button$")
    public void clickSimpleAlertButton(){
        driver.findElement(By.id("simple")).click();
    }

    @When("^User clicks the Confirm Alert button$")
    public void clickConfirmAlertButton(){
        driver.findElement(By.id("confirm")).click();
    }

    @When("^User clicks the Prompt Alert button$")
    public void clickPromptAlertButton(){
        driver.findElement(By.id("prompt")).click();

    }

    @Then("^Alert opens$")
    public void switchToAlert(){
       alert = driver.switchTo().alert();

    }

    @And("^Read the text from it and print it$")
    public void validateAlertMessage(){
        String alertText = alert.getText();
        System.out.println("The alert message is = "+ alertText);

   }

    @And("^Write a custom message in it$")
    public void writeToAlert(){
        alert.sendKeys("New alert message!");
    }

    @And("^Close the alert$")
    public void closeAlert(){
        alert.accept();
    }

    @And("^Close the alert with Cancel$")
    public void closeAlertWithCancel(){
        alert.dismiss();
    }
}

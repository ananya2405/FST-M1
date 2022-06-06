package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginTestSteps extends BaseClass{

    @Given("^User is on Login page$")
    public void loginPage(){
        driver.get("https://www.training-support.net/selenium/login-form");
        String pageTile = driver.getTitle();
        System.out.println("The page title is : "+pageTile);
        Assert.assertEquals("Login Form",pageTile);

    }

    @When("^User enters username and password$")
    public void enterLoginInfo(){
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
    }

   /* @When("^User enters \"(.*)\" and \"(.*)\"$")
    public void enterLoginInfo(String username, String password){
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
    }*/


    @When("^User enters \"(.*)\" and \"(.*)\"$")
    public void user_enters_and(String username, String password) throws Throwable {
        //Enter username from Feature file
        driver.findElement(By.id("username")).sendKeys(username);
        //Enter password from Feature file
        driver.findElement(By.id("password")).sendKeys(password);
        //Click Login
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("^Read the page title and confirmation \"(.*)\"$")
    public void validateMessage(String confirmMessage){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("action-confirmation")));
        String title = driver.getTitle();
        Assert.assertEquals("Login Form", title);
        System.out.println("The page title is : "+ title);

        String message = driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals(confirmMessage, message);
        System.out.println("The welcome message is : "+ message);


    }



}

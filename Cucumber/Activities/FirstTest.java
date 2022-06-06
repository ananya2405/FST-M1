package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class FirstTest extends BaseClass {
    @Given("^user is on TS homepage$")
    public void openingTSPage() {
        //Open the page
        driver.get("https://training-support.net");

        //Get page title
        String pageTitle = driver.getTitle();
        Assert.assertEquals("Training Support", pageTitle);

    }

    @When("^user clicks the About Us button$")
    public void clickAboutUs() {
        //Clicking the About Us link
        driver.findElement(By.id("about-link")).click();
    }

    @Then("^user is redirected to the About Us page$")
    public void navToAboutUsPage() {
        String title = driver.getTitle();
        Assert.assertEquals("About Training Support", title);
    }

  /*  @Then("^close the browser$")
    public void closeBrowser(){
        driver.quit();

    }*/


}

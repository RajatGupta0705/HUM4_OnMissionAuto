package glueCode;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef1
{
    @Given("open login page")
    public void open_login_page() {
        System.out.println("open login page");
    }
    @When("enter the credentials")
    public void enter_the_credentials() {
        System.out.println("enter the creds");
    }
    @When("hit login button")
    public void hit_login_button() {
        System.out.println("hit login button");
    }
    @Then("product page should be displayed")
    public void product_page_should_be_displayed() {
        System.out.println("product page should be displayed");
    }
}

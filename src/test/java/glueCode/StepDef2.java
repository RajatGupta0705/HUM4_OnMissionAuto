package glueCode;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageClasses.*;
import utilities.BrowserUtilities;

import java.util.Random;

public class StepDef2
{
    public Shared sh;
    public StepDef2(Shared shobj)
    {
        this.sh= shobj;
    }


     @When("User clicks on Checkout button")
    public void clickCheckoutButton() throws Exception
     {
         this.sh.cartdataobj.validateCheckoutButton();
    }
    @Then("User should get redirected to Checkout page")
    public void checkOutPageRedirection() throws Exception
    {
        this.sh.checkoutpv=new CheckoutPageValidation(this.sh.driver);
        this.sh.checkoutpv.verifyCheckoutPage();
    }
    @When("User should enter all the user details")
    public void userFillDetails() throws Exception
    {
        this.sh.checkoutpv.fillUserDetails();
    }
    @When("User clicks on Continue button")
    public void userClickonContinueButton() throws Exception {
        this.sh.checkoutpv.clickContinueButton();
    }
    @Then("User should get redirected to Checkout Overview page")
    public void userRedirectToOverviewPage() throws Exception {
   this.sh.checkoutOverviewV=new CheckoutOverviewValidation(this.sh.driver);
   Assert.assertTrue(this.sh.checkoutOverviewV.overViewPage.isDisplayed());
    }
}

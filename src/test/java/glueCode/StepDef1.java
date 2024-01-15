package glueCode;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.remote.RemoteWebDriver;
import pageClasses.AddToCart;
import pageClasses.CartDataVerification;
import pageClasses.LoginLogout;
import utilities.BrowserUtilities;

import java.util.Random;

public class StepDef1
{
    public Shared sh;
    public StepDef1 (Shared shobj)
    {
        this.sh= shobj;
    }
    @Given("Open the {string} site in QA environment in {string} browser")
    public void launchSite(String siteName, String browser) throws Exception
    {
        this.sh.bobj= new BrowserUtilities();
        this.sh.driver= this.sh.bobj.getDriver(browser);
        this.sh.bobj.launchSite(this.sh.driver,siteName);
    }
    @Given("Provide username and password with {string} criteria in {string} browser and login to the site")
    public void doLogin(String cr, String browser) throws Exception
    {
      this.sh.lobj= new LoginLogout(this.sh.driver);
      this.sh.lobj.loginIntoSite(cr, browser);
    }
    @Then("Product page should be displayed")
    public void productPageVisibility() throws Exception
    {
        this.sh.aobj= new AddToCart(this.sh.driver);
        Assert.assertTrue(this.sh.aobj.productPageVisibility());
    }
//    @Given("User should be on product selection page")
//    public void productSelectionPage() throws Exception
//    {
//        Assert.assertTrue(this.sh.aobj.productPageVisibility());
//    }
    @Given("Product list should be displayed")
    public void itemListVisibility()
    {
        Assert.assertTrue(this.sh.aobj.itemListVisibility());
    }
    @When("User adds the products into Cart")
    public void addProductstoCart()throws Exception
    {
        this.sh.r = new Random();
        this.sh.countBeforeProductSeletion=this.sh.aobj.getCartCount();
        this.sh.aobj.addToCart(this.sh.r.nextInt(this.sh.largestNumber-this.sh.smallestNumber+1)+this.sh.smallestNumber);
    }
    @Then("Cart count should get increase")
    public void getCartCount()
    {
        this.sh.countAfterProductSeletion = this.sh.aobj.getCartCount();
        Assert.assertTrue(this.sh.countAfterProductSeletion > this.sh.countBeforeProductSeletion);
    }
    @When("User clicks on cart icon")
    public void clickCartIcon()throws Exception
    {
        this.sh.cartdataobj= new CartDataVerification(this.sh.driver);
        this.sh.cartdataobj.clickOnCartButton();
    }
    @When("User is redirected to cart page")
    public void userShouldBeOnCartPage()
    {
        Assert.assertTrue(this.sh.cartdataobj.cartPage.isDisplayed());
    }
    @Then("count of cart items should be same as items added to the cart")
    public void cartListVisibility()
    {
        this.sh.cartdataobj.validateCartCount();
    }
    @Then("Each item should be a clickable link")
    public void clickableItem()
    {
        this.sh.cartdataobj.validateItemsAreClickable();
    }
    @Then("Product price against each items should be displayed")
    public void productPriceVisibility()
    {
        this.sh.cartdataobj.validatePriceVisibility();
    }
    @Then("Remove button against each items should be displayed")
    public void removeButtonVisibility()
    {
        this.sh.cartdataobj.validateRomvebuttonVisibility();
    }
}

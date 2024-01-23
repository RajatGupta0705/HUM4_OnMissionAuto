package glueCode;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pageClasses.*;

public class StepDef3
{
    public Shared sh;
    public StepDef3(Shared shobj)
    {
        this.sh= shobj;
    }
    @When("Items list is visible")
    public void itemsListVisibility()
    {
       this.sh.checkoutOverviewV.overviewPageValidation();
    }
    @Then("Cart count should be same as list item count")
    public void cartCountValidation() throws Exception
    {
        this.sh.checkoutOverviewV.checkoutItemsCount();
    }
    @Then("Payment information should be displayed")
    public void paymentInformationVisibility()
    {
        this.sh.checkoutOverviewV.validatePaymentInformation();
    }
    @Then("Shipping information should be displayed")
    public void shippingInformationValidation()
    {
        this.sh.checkoutOverviewV.validateShippingInformation();
    }
    @When("Price total should be displayed")
    public void priceTotalVisibility()
    {
       this.sh.checkoutOverviewV.validatePriceTotal();
    }
    @Then("validate total amount is calculated is correctly with tax")
    public void validateTotalAmount()
    {
        this.sh.checkoutOverviewV.validateTotalAmount();
    }
}

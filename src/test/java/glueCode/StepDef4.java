package glueCode;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageClasses.OrderSuccess;

public class StepDef4
{
    public Shared sh;
    public StepDef4(Shared shobj)
    {
        this.sh= shobj;
    }
    @When("clicking on finish button")
    public void validateFinishButton() throws Exception
    {
        this.sh.checkoutOverviewV.validateFinishButton();
    }
    @Then("order complete page should be displayed")
    public void validateOrderCompletePage()
    {
        this.sh.os = new OrderSuccess(this.sh.driver);
        this.sh.os.validateThankYouPage();
    }
    @Then("Thank you message should be displayed")
    public void validateThankYouMessage()
    {
        this.sh.os.validateThankYouMessage();
    }
}

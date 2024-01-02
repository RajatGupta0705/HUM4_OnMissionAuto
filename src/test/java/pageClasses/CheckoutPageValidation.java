package pageClasses;

import io.cucumber.java.de.Wenn;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PropertiesUtility;

public class CheckoutPageValidation
{
    private RemoteWebDriver driver;
    @FindBy(xpath = "//*[contains(text(), 'Checkout')]")
    public WebElement checkoutPage;

    @FindBy(id = "first-name")
    private WebElement fname;
    @FindBy(id="last-name")
    private WebElement lname;
    @FindBy(id= "postal-code")
    private WebElement zcode;
    @FindBy(id="cancel")
    private WebElement cancelButton;
    @FindBy(id="continue")
    private WebElement contineuButton;
    @FindBy(xpath = "//*[@data-test='error']")
    private WebElement errors;
    @FindBy(xpath = "//*[text()='Your Cart']")
    public WebElement cartPage;
    private CheckoutOverviewValidation checkoutOverview;

    public CheckoutPageValidation(RemoteWebDriver driver)
    {
        this.driver=driver;
        checkoutOverview = new CheckoutOverviewValidation(driver);
        PageFactory.initElements(driver, this);
    }
    public void checkoutPageValidation()
    {
        if (this.checkoutPage.isDisplayed())
        {
            System.out.println("user is successfully landed to the checkout page");
        }
        else System.out.println("user is not able to land on checkout page");
    }
    public void fillUserDetails() throws Exception
    {
        String fname =  PropertiesUtility.getPropertyValue("src\\test\\java\\resourceFiles\\userDetails.properties" , "FirstName");
        String lname =  PropertiesUtility.getPropertyValue("src\\test\\java\\resourceFiles\\userDetails.properties" , "LastName");
        String zip =  PropertiesUtility.getPropertyValue("src\\test\\java\\resourceFiles\\userDetails.properties" , "ZipCode");
        try {
            this.fname.sendKeys(fname);
            this.lname.sendKeys(lname);
            this.zcode.sendKeys(zip);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    public void clickContinueButton() throws Exception
    {
        contineuButton.click();
        if(checkoutOverview.overViewPage.isDisplayed())
        {
            this.driver.executeScript("arguments[0].scrollIntoView();",checkoutOverview.overViewPage);
            Thread.sleep(1000);
            System.out.println("continue button is working fine. User is on overviewe page");
        }
        else if (this.errors.isDisplayed()) System.out.println("fill all the mandetory user details");
        else System.out.println("continue button is not working as expected");
    }

    public void validateCancelButton() throws Exception
    {
        this.cancelButton.click();
        Thread.sleep(1000);
        if(this.cartPage.isDisplayed())
        {
            this.driver.executeScript("arguments[0].scrollIntoView();",this.cartPage);
            Thread.sleep(1000);
            System.out.println("cancel button is working fine");
        }
        else System.out.println("cancel button is not working as expected");
    }
}

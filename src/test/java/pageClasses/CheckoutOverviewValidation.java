package pageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.image.renderable.RenderableImage;

public class CheckoutOverviewValidation
{
    private RemoteWebDriver driver;
    @FindBy(xpath = "//*[text()='Checkout: Overview']")
    public WebElement overViewPage;

    public CheckoutOverviewValidation(RemoteWebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }
    public void overviewPageValidation()
    {
        if (this.overViewPage.isDisplayed())
        {
            System.out.println("user is successfully landed to the checkout over view page");
        }
        else System.out.println("user is not able to land on checkout overview page");
    }
}

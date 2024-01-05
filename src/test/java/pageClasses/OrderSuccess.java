package pageClasses;

import io.cucumber.java.bs.A;
import io.netty.util.ThreadDeathWatcher;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSuccess
{
    RemoteWebDriver driver;
    @FindBy (xpath = "//span[contains(text(), 'Complete!')]")
    public WebElement orderComplete;
    @FindBy (xpath = "//*[contains(text(), 'Thank you')]")
    private WebElement thanksPage;
    @FindBy(xpath = "//*[text()='Back Home']")
    private WebElement backButton;
    private AddToCart addToCart;
    public OrderSuccess(RemoteWebDriver driver)
    {
        this.driver= driver;
        this.addToCart = new AddToCart(this.driver);
        PageFactory.initElements(driver,this);
    }
    public void validateThankYouPage()
    {
        if(this.orderComplete.isDisplayed()) System.out.println("user is successfully landed on the thank you page");
        else System.out.println("User is unable to land on the complete page");
    }
    public void validateThankYouMessage()
    {
        if(this.thanksPage.isDisplayed()) System.out.println("Order is placed successfully");
        else System.out.println("Order is not placed successfully");
    }
    public void validateBackHomeButton()throws Exception
    {
        if(this.backButton.isDisplayed())
        {
            this.driver.executeScript("arguments[0].scrollIntoView();",this.backButton);
            this.backButton.click();
            Thread.sleep(1000);
            if(this.addToCart.product.isDisplayed()) System.out.println("Back Home button is working as expected");
            else System.out.println("Back Home button is not working as expected");
        }
    }
}

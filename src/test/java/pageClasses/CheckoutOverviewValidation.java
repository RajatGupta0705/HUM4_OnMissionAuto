package pageClasses;

import io.cucumber.java.bs.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.awt.image.renderable.RenderableImage;
import java.util.List;

public class CheckoutOverviewValidation
{
    private RemoteWebDriver driver;
    @FindBy(xpath = "//*[text()='Checkout: Overview']")
    public WebElement overViewPage;

    @FindBys({@FindBy(xpath="//*[@class='cart_item']")})
    private List<WebElement> overViewItems;

    @FindBy(xpath="//*[@class='summary_info']")
    private WebElement summary;

    @FindBy(xpath = "//*[@class= 'shopping_cart_badge']")
    private WebElement cart_count;

    private AddToCart addToCart;
    private OrderSuccess orderSuccess;

    public CheckoutOverviewValidation(RemoteWebDriver driver)
    {
        this.driver= driver;
        this.addToCart = new AddToCart(this.driver);
        this.orderSuccess = new OrderSuccess(this.driver);
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
    public void checkoutItemsCount()
    {
        int itemsCount = Integer.parseInt(cart_count.getText());
        if (overViewItems.size()==itemsCount)
            System.out.println("Items available in overview are same as in cart");
        else
            System.out.println("Items available in overview are not same as in cart");
    }
    public void validatePaymentInformation()
    {
        if (summary.findElement(By.xpath("div[1]")).isDisplayed())
        {
            if (summary.findElement(By.xpath("div[2]")).isDisplayed() && summary.findElement(By.xpath("div[2]")).getText() != null)
                System.out.println("Payment information is displayed");
            else
                System.out.println("Payment information label is  displayed but value is not displayed");
        }
        else
            System.out.println("Payment information label is not displayed");
    }
    public void validateShippingInformation()
    {
        if (summary.findElement(By.xpath("div[3]")).isDisplayed())
        {
            if (summary.findElement(By.xpath("div[4]")).isDisplayed() && summary.findElement(By.xpath("div[4]")).getText() != null)
                System.out.println("Shipping information is displayed");
            else
                System.out.println("Shipping information label is  displayed but value is not displayed");
        }
        else
            System.out.println("Shipping information label is not displayed");
    }
    public void validatePriceTotal()
    {
        if (summary.findElement(By.xpath("div[5]")).isDisplayed())
        {
            if (summary.findElement(By.xpath("div[6]")).isDisplayed() && summary.findElement(By.xpath("div[6]")).getText() != null
                    && summary.findElement(By.xpath("div[7]")).getText() != null)
                System.out.println("Price total information is displayed");
            else
                System.out.println("Price total information label is  displayed but value is not displayed");
        }
        else
            System.out.println("Price total information label is not displayed");
    }
    public void validateTotalAmount()
    {
        float itemTotalAmt = 0;
        float totalAmt = 0;
        for (WebElement t : overViewItems)
        {
            String price = t.findElement(By.xpath("div[2]/div[2]/div")).getText().trim();
            price = price.replace("$","");
            float f = Float.parseFloat(price);
            itemTotalAmt = itemTotalAmt + f;
        }
        System.out.println("total amount excluding tax = "+itemTotalAmt);
      String [] tax = summary.findElement(By.xpath("div[7]")).getText().trim().split(" ");
        float f = Float.parseFloat(tax[1].replace("$",""));
        totalAmt = itemTotalAmt + f;

        String [] total = summary.findElement(By.xpath("div[8]")).getText().trim().split(" ");
        float t = Float.parseFloat(total[1].replace("$",""));
        System.out.println("total amount including tax = "+totalAmt);
        if (t == totalAmt)
            System.out.println("Total amount calculated correctly");
        else
            System.out.println("Total amount is not calculated correctly");
    }
    public void validateCancelButtonOnOvervView() throws Exception
    {
        WebElement e= this.summary.findElement(By.xpath("div[9]/button[1]"));
        if(e.isDisplayed())
        {
            this.driver.executeScript("arguments[0].scrollIntoView();",e);
            Thread.sleep(1000);
            e.click();
            Thread.sleep(1000);
            if(this.addToCart.product.isDisplayed())
            {
                this.driver.executeScript("arguments[0].scrollIntoView();",this.addToCart.product);
                Thread.sleep(1000);
                System.out.println("Cancel button is redirected to the product page. Working fine");
            }
            else System.out.println("Cancel button on the overview page is not working as expected");
        }
    }
    public void validateFinishButton() throws Exception
    {
        WebElement e= this.summary.findElement(By.xpath("div[9]/button[2]"));
        if(e.isDisplayed())
        {
            this.driver.executeScript("arguments[0].scrollIntoView();",e);
            Thread.sleep(1000);
            e.click();
            Thread.sleep(1000);
            if(this.orderSuccess.orderComplete.isDisplayed())
            {
                this.driver.executeScript("arguments[0].scrollIntoView();",this.orderSuccess.orderComplete);
                Thread.sleep(1000);
                System.out.println("Finish button is redirected to the complete page. Working fine");
            }
            else System.out.println("Finish button on the overview page is not working as expected");
        }
    }
}

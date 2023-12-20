package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class AddToCart
{
    private RemoteWebDriver driver;
    @FindBy(xpath = "//span[text()='Products']")
    private WebElement product;
    @FindBy(xpath = "//*[@class='inventory_list']")
    private WebElement inventory_list;
    @FindBys({@FindBy (xpath = "//*[@class='inventory_item']")})
    private List<WebElement> itmesList;
    public AddToCart (RemoteWebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public void productPageVisibility()
    {
        try
        {
            this.product.isDisplayed();
            System.out.println("User is on product selection page");
        }
        catch (Exception ex)
        {
            System.out.println("User is not on product selection page");
            System.out.println(ex.getMessage());
        }
    }
    public void itemListVisibility()
    {
        try
        {
            this.inventory_list.isDisplayed();
            System.out.println("User is able to see the items");
            for (WebElement e : itmesList)
            {
                System.out.println(e.findElement(By.xpath("div[2]/div/a/div")).getText());
            }

        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    public void addToCart() //div[2]/div[2]/button
    {
        String text= itmesList.get(0).findElement(By.xpath("div[2]/div[2]/button")).getText();
        if(text.equals("Add to cart"))
        {
            try {
                itmesList.get(0).findElement(By.xpath("div[2]/div[2]/button")).click();
            } catch (Exception ex) {
                System.out.println();
            }
        }
        else System.out.println("item already added into the cart");
    }
}

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
    public WebElement product;
    @FindBy(xpath = "//*[@class='inventory_list']")
    private WebElement inventory_list;
    @FindBys({@FindBy (xpath = "//*[@class='inventory_item']")})
    private List<WebElement> itmesList;
    @FindBy(xpath = "//*[@class= 'shopping_cart_badge']")
    private WebElement cart_count;



    public AddToCart (RemoteWebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public boolean productPageVisibility()
    {
        try
        {
            this.product.isDisplayed();
            System.out.println("User is on product selection page");
            return true;
        }
        catch (Exception ex)
        {
            System.out.println("User is not on product selection page");
            return false;
        }
    }
    public boolean itemListVisibility()
    {
        try
        {
            this.inventory_list.isDisplayed();
            System.out.println("User is able to see the items");
            return true;
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            System.out.println("User is on product page but item list is not visible");
            return false;
        }
    }
    public int availableItems()
    {
        return itmesList.size();
    }
    public void displayItemList()
    {
        System.out.println("Item list contains below items");
        for (WebElement e : itmesList)
        {
            System.out.printf(e.findElement(By.xpath("div[2]/div/a/div")).getText()+"\n");
        }
    }
    public void addToCart(int itemsToBeAdded) throws Exception
    {
        int count=0;
        for(int i=0; i<itemsToBeAdded; i++)
        {
            String text= itmesList.get(i).findElement(By.xpath("div[2]/div[2]/button")).getText();
            if(text.equals("Add to cart"))
            {
                try
                {
                    this.driver.executeScript("arguments[0].scrollIntoView();",itmesList.get(i));
                    Thread.sleep(500);
                    itmesList.get(i).findElement(By.xpath("div[2]/div[2]/button")).click();
                    count++;
                }
                catch (Exception ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            else System.out.println(text+" already added into the cart");
            Thread.sleep(2000);
        }
        System.out.println(count+" items are added into the cart");

    }
    public int getCartCount()
    {
        try
        {
            int count = Integer.parseInt(this.cart_count.getText());
            return count;
        }
        catch (Exception ex)
        {
            return 0;
        }

    }
}

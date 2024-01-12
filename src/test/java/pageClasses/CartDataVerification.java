package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utilities.PropertiesUtility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CartDataVerification {
    private RemoteWebDriver driver;

    @FindBy(xpath = "//*[@class ='shopping_cart_link']")
    private WebElement cartIcon;

    @FindBy(xpath = "//*[text()='Your Cart']")
    public WebElement cartPage;

    @FindBys({@FindBy(xpath = "//*[@class = 'cart_item']")})
    public List<WebElement> cartItemList;

    @FindBy(id="continue-shopping")
    private  WebElement continueShoppingButton;

    @FindBy(id="checkout")
    private WebElement checkoutButton;
    private CheckoutPageValidation checkout;
    private AddToCart addCart;
    List<String> products;
    public CartDataVerification(RemoteWebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
        addCart = new AddToCart(driver);
        checkout = new CheckoutPageValidation(driver);
        products = new ArrayList<String>();
    }
    public void validateCartCount()
    {
        int itemCount = addCart.getCartCount();
        System.out.println(itemCount+" items are added into the cart");
        if(itemCount==cartItemList.size())
        {
            System.out.println("Number of items added are available in the cart");
        }
        else System.out.println("Number of items added are not available in the cart");
    }
    public void clickOnCartButton() throws Exception
    {
        this.driver.executeScript("arguments[0].scrollIntoView();",cartIcon);
        Thread.sleep(2000);
        this.cartIcon.click();
        if(cartPage.isDisplayed()) System.out.println("user is successfully landed on cart page");
        else System.out.println("user is not able to navigate to cart page");
    }
    public void validateItemsAreClickable()
    {
        int flag=0;
        for (WebElement e : cartItemList)
        {
            this.driver.executeScript("arguments[0].scrollIntoView();",e);
            if(e.findElement(By.xpath("div[2]/a")).getAttribute("href").equalsIgnoreCase(null))
            {
                System.out.println(e.findElement(By.xpath("div[2]/div/a/div")).getText()+" is not clickable");
                flag=1;
            }
        }
        if (flag==0) System.out.println("All items added in the cart are clickable");
        else System.out.println("All items added in the cart are not clickable");
    }
    public void validatePriceVisibility()
    {
        int flag=0;
        for (WebElement e : cartItemList)
        {
            this.driver.executeScript("arguments[0].scrollIntoView();",e);
            if(e.findElement(By.xpath("div[2]/div[2]/div")).getText().equalsIgnoreCase(null))
            {
                System.out.println("price for the item"+ "\""+e.findElement(By.xpath("div[2]/div[2]/div")).getText()+"\" is not visible");
                flag=1;
            }
        }
        if (flag==0) System.out.println("Price for all items added in the cart is visible");
        else System.out.println("Price for all items added in the cart is not visible");
    }
    public void validateRomvebuttonVisibility()
    {
        int flag=0;
        for (WebElement e : cartItemList)
        {
            this.driver.executeScript("arguments[0].scrollIntoView();",e);
            boolean x= e.findElement(By.xpath("div[2]/div[2]/button")).isDisplayed();
            if(x=false)
            {
                System.out.println("Remove button for the item"+ "\""+e.findElement(By.xpath("div[2]/div[2]/button"))+"\" is not visible");
                flag=1;
            }
        }
        if (flag==0) System.out.println("Remove button for all items added in the cart is visible");
        else System.out.println("Remove button for all items added in the cart is not visible");
    }

    public void validateContinueShoppingButton()
    {
        if(continueShoppingButton.isDisplayed())
        {
            this.driver.executeScript("arguments[0].scrollIntoView();",continueShoppingButton);
            if(continueShoppingButton.isEnabled())
            {
                continueShoppingButton.click();
                if(addCart.productPageVisibility())
                {
                    this.driver.executeScript("arguments[0].scrollIntoView();",cartIcon);
                    System.out.println("\"continue shopping\" button is working fine");
                }
                else System.out.println("\"continue shopping\" is not working as expected");
            }
            else System.out.println("continue shopping button is not enabled");
        }
        else System.out.println("continue shopping button is not visible");
    }

    public void removeCartItems(int itemsTobeDeleted) throws Exception
    {
        int cartItems=0;
        int x= addCart.getCartCount();
        if (itemsTobeDeleted<=x)
        {
            for(int i= 1;i<=itemsTobeDeleted;i++)
            {
                products.add(PropertiesUtility.getPropertyValue("src\\test\\java\\resourceFiles\\productItemsToBeRemoved.properties" , "product"+i));
            }
            for(int i=0;i<products.size();i++)
            {
                int flag=0;
                for(WebElement a: cartItemList)
                {
                    String p1=a.findElement(By.xpath("div[2]/a/div")).getText();
                    if(p1.equalsIgnoreCase(products.get(i)))
                    {
                        Thread.sleep(2000);
                        a.findElement(By.xpath("div[2]/div[2]/button")).click();
                        cartItems++;
                        boolean var1=cartItemList.contains(a);
                        if(!var1)
                        {
                            System.out.println(p1+" is successfully removed");
                        }
                        else System.out.println(p1+" is not removed");
                        flag=1;
                        break;
                    }
                }
                if (flag==0) System.out.println(products.get(i)+" is not available in the cart");
            }
            if (itemsTobeDeleted<x)
            {
                int y= addCart.getCartCount();
                int z=x-y;
                if(z==cartItems) System.out.println("Given no. of Cart items are removed successfully");
                else System.out.println("Given no. of Cart items are not removed");
            }
            else
            {
                int z=x-0;
                if(z==cartItems) System.out.println("Given no. of Cart items are removed successfully");
                else System.out.println("Given no. of Cart items are not removed");
            }

        }
        else System.out.println("no of items to be removed are more than number of items available in the card. Please enter correct no of items");

    }
    public void validateCheckoutButton() throws Exception
    {
        if(checkoutButton.isDisplayed())
        {
            this.driver.executeScript("arguments[0].scrollIntoView();",checkoutButton);
            if(checkoutButton.isEnabled())
            {
                checkoutButton.click();
            }
            else System.out.println("checkout button is not enabled");
        }
        else System.out.println("checkout button is not visible");
    }
}

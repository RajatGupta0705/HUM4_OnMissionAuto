package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartDataVerification {
    private RemoteWebDriver driver;

    @FindBy(xpath = "//*[@class ='shopping_cart_link']")
    private WebElement cartIcon;

    @FindBy(xpath = "//*[text()='Your Cart']")
    private WebElement cartPage;

    @FindBys({@FindBy(xpath = "//*[@class = 'cart_item']")})
    private List<WebElement> cartItemList;
    private AddToCart cartCount;

    public CartDataVerification(RemoteWebDriver driver) {

        this.driver = driver;
        cartCount = new AddToCart(driver);
        PageFactory.initElements(driver, this);
    }

//    public List<WebElement> displayNewlyAddedItems() {
//        System.out.println("Displaying newly added cart items");
//        try {
//            cartIcon.click();
//            Thread.sleep(3000);
//            for (WebElement cl : cartItemList) {
//                System.out.println(cl.findElement(By.xpath("div[2]/a/div")).getText() + "\n");
//            }
//
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
//        return cartItemList;
//    }
    public void validateCartCount()
    {
        int itemCount = cartCount.getCartCount();
        if(itemCount==cartItemList.size())
        {
            System.out.println("Number of items added are available in the cart");
        }
        else System.out.println("Number of items added are not available in the cart");
    }
    public void clickOnCartButton() throws Exception
    {
        this.cartIcon.click();
        Thread.sleep(2000);
        if(cartPage.isDisplayed()) System.out.println("user is successfully landed on cart page");
        else System.out.println("user is not able to navigate to cart page");
    }
    public void validateItemsAreClickable()
    {
        int flag=0;
        for (WebElement e : cartItemList)
        {
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
}

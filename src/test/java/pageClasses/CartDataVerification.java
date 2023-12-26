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

    @FindBy(id = "shopping_cart_container")
    private WebElement cartIcon;

    @FindBys({@FindBy(xpath = "//*[@class = 'cart_item']")})
    private List<WebElement> cartItemList;

    public CartDataVerification(RemoteWebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> displayNewlyAddedItems() {
        System.out.println("Displaying newly added cart items");
        try {
            cartIcon.click();
            Thread.sleep(3000);
            for (WebElement cl : cartItemList) {
                System.out.println(cl.findElement(By.xpath("div[2]/a/div")).getText() + "\n");
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return cartItemList;
    }
}

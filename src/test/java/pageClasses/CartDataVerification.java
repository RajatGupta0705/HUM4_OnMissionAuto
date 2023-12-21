package pageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class CartDataVerification {
    private RemoteWebDriver driver;


    @FindBy(id = "shopping_cart_container")
    private WebElement cartIcon;

    @FindBys({@FindBy(xpath = "//*[@class = 'cart_item']")})
    private List<WebElement> cartItemList;


    public CartDataVerification(RemoteWebDriver driver){

    }
}

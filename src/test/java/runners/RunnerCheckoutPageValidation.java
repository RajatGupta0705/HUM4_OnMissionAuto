package runners;

import org.openqa.selenium.remote.RemoteWebDriver;
import pageClasses.AddToCart;
import pageClasses.CartDataVerification;
import pageClasses.CheckoutPageValidation;
import pageClasses.LoginLogout;
import utilities.BrowserUtilities;

import java.util.Scanner;

public class RunnerCheckoutPageValidation
{
    public static void main(String []args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter No. of items tobe added in cart");
        int noOfItems = Integer.parseInt(sc.nextLine());
        String[] criterias = {"valid"};
        String[] browsers = {"chrome"};

        for (String cr : criterias)
        {
            System.out.println("Running for " + cr + " criteria.");
            for (int i = 0; i < browsers.length; i++)
            {
                System.out.println("Running on " + browsers[i] + " browser");
                BrowserUtilities bobj = new BrowserUtilities();
                RemoteWebDriver driver = bobj.getDriver(browsers[i]);
                bobj.launchSite(driver, "https://www.saucedemo.com/");
                Thread.sleep(2000);
                LoginLogout lobj = new LoginLogout(driver);
                lobj.loginIntoSite(cr, browsers[i]);
                AddToCart aobj = new AddToCart(driver);
                if(aobj.productPageVisibility())
                {
                    if(aobj.itemListVisibility())
                    {
                        Thread.sleep(2000);
                        if(noOfItems<=aobj.availableItems())
                        {
                            aobj.addToCart(noOfItems);
                            Thread.sleep(2000);
                            if(aobj.getCartCount()== noOfItems)
                            {
                                System.out.println("Required no of items added in cart");
                                CartDataVerification cdv = new CartDataVerification(driver);
                                CheckoutPageValidation checkout = new CheckoutPageValidation(driver);
                                cdv.clickOnCartButton();
                                Thread.sleep(1000);
                                cdv.validateCartCount();
                                Thread.sleep(1000);
                                cdv.validateItemsAreClickable();
                                Thread.sleep(1000);
                                cdv.validatePriceVisibility();
                                Thread.sleep(1000);
                                cdv.validateRomvebuttonVisibility();
                                Thread.sleep(1000);
                                cdv.validateContinueShoppingButton();
                                Thread.sleep(1000);
                                cdv.clickOnCartButton();
                                Thread.sleep(4000);
                                cdv.removeCartItems();
                                Thread.sleep(1000);
                                cdv.validateCheckoutButton();
                                checkout.checkoutPageValidation();
                                Thread.sleep(500);
                                checkout.fillUserDetails();
                                Thread.sleep(2000);
                                checkout.validateCancelButton();
                                Thread.sleep(1000);
                                cdv.validateCheckoutButton();
                                Thread.sleep(1000);
                                checkout.fillUserDetails();
                                Thread.sleep(1000);
                                checkout.clickContinueButton();
                                Thread.sleep(2000);

                            }
                        }
                        else
                        {
                            System.out.println("No. of items are more than displayed items list");
                        }
                        lobj.logoutSite();
                        Thread.sleep(3000);
                        bobj.closeSite(driver);
                    }
                } else {
                    bobj.closeSite(driver);
                }
            }
        }
    }
}

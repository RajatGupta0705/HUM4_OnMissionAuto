package runners;

import org.openqa.selenium.remote.RemoteWebDriver;
import pageClasses.AddToCart;
import pageClasses.CartDataVerification;
import pageClasses.CheckoutPageValidation;
import pageClasses.LoginLogout;
import utilities.BrowserUtilities;

import java.util.Scanner;

public class RunnerPositveScnarioFlow
{
    public static void main(String []args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter No. of items tobe added in cart");
        int noOfItems = Integer.parseInt(sc.nextLine());
        System.out.println("Enter no of items to be removed");
        int noOfItemsTobeRvd= Integer.parseInt(sc.nextLine());
        sc.close();
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
                LoginLogout lobj = new LoginLogout(driver);
                AddToCart aobj = new AddToCart(driver);
                CartDataVerification cdv = new CartDataVerification(driver);
                CheckoutPageValidation checkout = new CheckoutPageValidation(driver);
                bobj.launchSite(driver, "SauceLabDemo");
                Thread.sleep(2000);
                lobj.loginIntoSite(cr, browsers[i]);
                Thread.sleep(2000);
                if(noOfItems<=aobj.availableItems())
                {
                    aobj.addToCart(noOfItems);
                    Thread.sleep(2000);
                    cdv.clickOnCartButton();
                    Thread.sleep(1000);
                    cdv.removeCartItems(noOfItemsTobeRvd);
                    Thread.sleep(1000);
                    cdv.validateCheckoutButton();
                    Thread.sleep(1000);
                    lobj.logoutSite();
                    Thread.sleep(3000);
                    bobj.closeSite(driver);
                }
                else
                {
                    System.out.println("Required number of items to be added are more than items displayed items list");
                }
            }
        }
    }
}

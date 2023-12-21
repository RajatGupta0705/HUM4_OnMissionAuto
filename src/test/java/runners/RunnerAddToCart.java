package runners;

import org.openqa.selenium.remote.RemoteWebDriver;
import pageClasses.AddToCart;
import pageClasses.LoginLogout;
import utilities.BrowserUtilities;

public class RunnerAddToCart
{
    public static void main(String []args) throws Exception {

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
                        aobj.displayItemList();
                        Thread.sleep(6000);
                        aobj.addToCart();
                        Thread.sleep(5000);
                        lobj.logoutSite();
                        Thread.sleep(3000);
                        bobj.closeSite(driver);
                    }
                }
            }
        }
    }
}

package runners;

import org.openqa.selenium.remote.RemoteWebDriver;
import pageClasses.LoginLogout;
import utilities.BrowserUtilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunnerClassUtility
{
    public static void main(String [] args) throws  Exception
    {
        Scanner sc = new Scanner(System.in);
        // Saurabh changes
        System.out.println("Enter criteria");
        String cr= sc.nextLine();
        sc.close();
        String [] browsers = {"chrome","firefox","edge"};
        for(int i=0;i<browsers.length;i++)
        {
            System.out.println("Running on "+browsers[i]+" browser");
            BrowserUtilities bobj = new BrowserUtilities();
            RemoteWebDriver driver = bobj.getDriver(browsers[i]);
            bobj.launchSite(driver,"https://www.saucedemo.com/");
            Thread.sleep(2000);
            LoginLogout lobj= new LoginLogout(driver);
            if(lobj.loginIntoSite(cr, browsers[i]))
            {
                System.out.println("user logged in sucessfully");
                Thread.sleep(1000);
                if(lobj.logoutSite()) {
                    System.out.println("user logged out successfully");
                    System.out.println("Test case passed for valid user in "+browsers[i]+" browser");
                }
                else System.out.println("user logged in but unable to log out. Login test case failed for valid user in "+browsers[i]+" browser");
            }
            Thread.sleep(2000);
            bobj.closeSite(driver);
        }

    }
}

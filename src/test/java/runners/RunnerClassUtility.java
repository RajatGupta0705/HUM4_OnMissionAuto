package runners;

import org.openqa.selenium.remote.RemoteWebDriver;
import pageClasses.LoginLogout;
import utilities.BrowserUtilities;

import java.util.Scanner;

public class RunnerClassUtility
{
    public static void main(String [] args) throws  Exception
    {
        Scanner sc = new Scanner(System.in);
        // Saurabh changes
        System.out.println("Enter browser name");
        String browserName= sc.nextLine();
        System.out.println("Enter criteria");
        String cr= sc.nextLine();
        sc.close();
        BrowserUtilities bobj = new BrowserUtilities();
        RemoteWebDriver driver = bobj.getDriver(browserName);
        bobj.launchSite(driver,"https://www.saucedemo.com/");
        Thread.sleep(2000);
        System.out.println(bobj.getTitle(driver));
        Thread.sleep(2000);
        LoginLogout lobj= new LoginLogout(driver);
        boolean loginresult= lobj.loginIntoSite("locked_out_user", "secret_sauce", cr );
        if(loginresult) System.out.println("user not able to logs in successfully for "+cr);
        Thread.sleep(5000);
        /*boolean logoutresult= lobj.logoutSite();
        if (logoutresult) System.out.println("user logs out successfully");
        Thread.sleep(2000);*/
        bobj.closeSite(driver);
    }
}

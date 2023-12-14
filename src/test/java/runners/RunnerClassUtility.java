package runners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
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
        sc.close();
        BrowserUtilities bobj = new BrowserUtilities();
        RemoteWebDriver driver = bobj.getDriver(browserName);
        bobj.launchSite(driver,"https://www.saucedemo.com/");
        Thread.sleep(2000);
        System.out.println(bobj.getTitle(driver));
        Thread.sleep(2000);
        LoginLogout lobj= new LoginLogout(driver);
        boolean loginresult= lobj.loginIntoSite("standard_user", "secret_sauce");
        if(loginresult) System.out.println("user logs in successfully");
        Thread.sleep(5000);
        boolean logoutresult= lobj.logoutSite();
        if (logoutresult) System.out.println("user logs out successfully");
        Thread.sleep(2000);
        bobj.closeSite(driver);
    }
}

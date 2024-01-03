package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserUtilities
{
    private RemoteWebDriver driver;
    public BrowserUtilities()
    {
        this.driver=null;
    }
    public RemoteWebDriver getDriver (String browserName)
    {
        if(browserName.equalsIgnoreCase("chrome"))
        {
            this.driver= new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("firefox"))
        {
            this.driver=new FirefoxDriver();
        }
        else
        {
            this.driver= new EdgeDriver();
        }
        return this.driver;
    }
    public  void launchSite(RemoteWebDriver driver, String urlName) throws Exception
    {
        this.driver= driver;
        this.driver.manage().window().maximize();
        Thread.sleep(2000);
        String url = PropertiesUtility.getPropertyValue("src\\test\\java\\resourceFiles\\urls.properties" , urlName);
        this.driver.get(url);
    }
    public String getTitle(RemoteWebDriver driver)
    {
        this.driver=driver;
        String x= this.driver.getTitle();
        return x;
    }
    public void closeSite(RemoteWebDriver driver)
    {
        this.driver= driver;
        this.driver.close();
    }
}

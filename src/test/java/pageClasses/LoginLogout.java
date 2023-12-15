package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import utilities.PropertiesUtility;

public class LoginLogout
{
    private RemoteWebDriver driver;
    private By username;
    private By password;
    private By login;
    private By menu;
    private By logout;
    private By locked_error;

    public LoginLogout(RemoteWebDriver driver)
    {
        this.driver= driver;
        username = By.id("user-name");
        password= By.id("password");
        login = By.id("login-button");
        menu = By.xpath("//*[text()='Open Menu']");
        logout=By.xpath("//*[text()='Logout']");
        locked_error=By.xpath("//*[contains(text(),'Epic sadface')]");
    }
    public boolean loginIntoSite(String criteria, String browser) throws Exception
    {
        boolean success = false;
        if (criteria.equalsIgnoreCase("valid"))
        {
            String valid_user1 =  PropertiesUtility.getPropertyValue("C:\\Git_AUTO\\HUM4_OnMissionAuto\\src\\test\\java\\resourceFiles\\users.properties" , "valid_user");
            String password1 =  PropertiesUtility.getPropertyValue("C:\\Git_AUTO\\HUM4_OnMissionAuto\\src\\test\\java\\resourceFiles\\users.properties" , "password");
            this.driver.findElement(username).sendKeys(valid_user1);
            Thread.sleep(1000);
            this.driver.findElement(password).sendKeys(password1);
            Thread.sleep(1000);
            this.driver.findElement(login).click();
            boolean valid_user_success = this.driver.findElement(menu).isDisplayed();
            if(valid_user_success){
                success=true;
            }
            else
            {
                System.out.println("TC failed for valid user in "+browser+" browser");
            }
        }
        else if(criteria.equalsIgnoreCase("locked user"))
        {
            String valid_user2 =  PropertiesUtility.getPropertyValue("C:\\Git_AUTO\\HUM4_OnMissionAuto\\src\\test\\java\\resourceFiles\\users.properties" , "locked_user");
            String password2 =  PropertiesUtility.getPropertyValue("C:\\Git_AUTO\\HUM4_OnMissionAuto\\src\\test\\java\\resourceFiles\\users.properties" , "password");
            this.driver.findElement(username).sendKeys(valid_user2);
            Thread.sleep(1000);
            this.driver.findElement(password).sendKeys(password2);
            Thread.sleep(1000);
            this.driver.findElement(login).click();
            try
            {
                this.driver.findElement(locked_error).isDisplayed();
                System.out.println("TC passed for locked user in "+browser+" browser");
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                System.out.println("TC failed for locked user in "+browser+" browser");
            }
        }
        else {
            System.out.println("Invalid Criteria......Please enter valid criteria");
            this.driver.close();
            System.exit(0);
        }
        return success;
    }
    public boolean logoutSite() throws Exception
    {
        this.driver.findElement(menu).click();
        Thread.sleep(2000);
        this.driver.findElement(logout).click();
        try
        {
            this.driver.findElement(login).isDisplayed();
            return true;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }
}


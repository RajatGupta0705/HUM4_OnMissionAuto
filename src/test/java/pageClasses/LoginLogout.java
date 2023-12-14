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
    public void loginIntoSite(String criteria) throws Exception
    {
        boolean success = false;
        if (criteria.equalsIgnoreCase("valid"))
        {
            String valid_user1 =  PropertiesUtility.getPropertyValue("C:\\projectAuto\\HUM4_OnMissionAuto\\src\\test\\java\\resourceFiles\\users.properties" , "valid_user");
            String password1 =  PropertiesUtility.getPropertyValue("C:\\projectAuto\\HUM4_OnMissionAuto\\src\\test\\java\\resourceFiles\\users.properties" , "password");
            this.driver.findElement(username).sendKeys(valid_user1);
            Thread.sleep(1000);
            this.driver.findElement(password).sendKeys(password1);
            Thread.sleep(1000);
            this.driver.findElement(login).click();
            success = this.driver.findElement(menu).isDisplayed();
            if(success){
                System.out.println("TC passed for valid user.");
            }else{
                System.out.println("TC failed for valid user.");
            }
        }
//        else if(criteria.equalsIgnoreCase("locked user"))
//        {
//            this.driver.findElement(username).sendKeys(user);
//            Thread.sleep(1000);
//            this.driver.findElement(password).sendKeys(pwd);
//            Thread.sleep(1000);
//            this.driver.findElement(login).click();
//            success = this.driver.findElement(locked_error).isDisplayed();
//        }
        else {
            System.out.println("Invalid Criteria......");
            success = false;
        }
    }

    public boolean logoutSite() throws Exception
    {
        this.driver.findElement(menu).click();
        Thread.sleep(2000);
        this.driver.findElement(logout).click();
        return this.driver.findElement(login).isDisplayed();
    }
}


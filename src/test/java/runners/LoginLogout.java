package runners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginLogout
{
    private RemoteWebDriver driver;
    private By username;
    private By password;
    private By login;
    private By menu;
    private By logout;

    public LoginLogout(RemoteWebDriver driver)
    {
        this.driver= driver;
        username = By.id("user-name");
        password= By.id("password");
        login = By.id("login-button");
        menu = By.xpath("//*[text()='Open Menu']");
        logout=By.xpath("//*[text()='Logout']");
    }
    public boolean loginIntoSite(String user, String pwd) throws Exception
    {
        this.driver.findElement(username).sendKeys(user);
        Thread.sleep(1000);
        this.driver.findElement(password).sendKeys(pwd);
        Thread.sleep(1000);
        this.driver.findElement(login).click();
        return this.driver.findElement(menu).isDisplayed();
    }

    public boolean logoutSite() throws Exception
    {
        this.driver.findElement(menu).click();
        Thread.sleep(2000);
        this.driver.findElement(logout).click();
        return this.driver.findElement(login).isDisplayed();
    }

}


package runners;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;

public class Dummy
{
    public static void main(String [] args) throws Exception
    {
        RemoteWebDriver driver = new ChromeDriver();
        WebDriverWait wait=  new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.withTimeout(Duration.ofSeconds(1));
        wait.pollingEvery(Duration.ofMillis(100));
        driver.get("https://www.saucedemo.com/"); //automissionmissionauto@gmail.com
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(2000);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("(//*[@class='inventory_item'])[1]/div[2]/div/a/div")).getText());

//        System.out.println(System.currentTimeMillis());
//
//        try
//        {
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Open Menu']")));
//        }
//        catch (Exception ex){
//        System.out.println(ex.getMessage());}
//        System.out.println(System.currentTimeMillis());
       /* driver.findElent(By.name("q")).sendKeys("amadeus", Keys.ENTER);em
        Thread.sleep(5000);
        driver.navigate().back();
        driver.findElement(By.name("q")).sendKeys("cybage", Keys.ENTER);
        /*Thread.sleep(2000);*/
//        driver.findElement(By.id("user-name")).sendKeys("performance_glitch_user");
//        Thread.sleep(2000);
//        driver.findElement(By.id("password")).sendKeys("secret_sauce");
//        driver.findElement(By.id("login-button")).click();
        //long x= System.currentTimeMillis();
        //Thread.sleep(2000);
        //WebElement e= driver.findElement(By.xpath("//*[text()='Open Menu']"));
        // FluentWait<RemoteWebDriver> wait=  new FluentWait<RemoteWebDriver>(driver);
//        FluentWait<RemoteWebDriver> wait=  new FluentWait<RemoteWebDriver>(driver);
//        wait.withTimeout(Duration.ofSeconds(10));
//        wait.pollingEvery(Duration.ofMillis(100));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Open Menu']")));
        //Thread.sleep(1000);
//        if(driver.findElement(By.xpath("//*[text()='Open Menu']")).isDisplayed())
//            driver.findElement(By.xpath("//*[text()='Open Menu']")).click();
//        //long y= System.currentTimeMillis();
//        //System.out.println(y-x);
//        driver.close();
        /*Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='Logout']")).click();
       // driver.findElement(By.name("password")).sendKeys("Rajat0705@", Keys.ENTER);
        driver.findElement(By.id("login-button")).click();

        FluentWait<RemoteWebDriver> wait=  new FluentWait<RemoteWebDriver>(driver);
        wait.withTimeout(Duration.ofSeconds(1));
        wait.pollingEvery(Duration.ofMillis(100));
        wait.until(ExpectedConditions.visibilityOf(e));*/

        ////*[@placeholder='Search Facebook']
//        FluentWait<RemoteWebDriver> wait=  new FluentWait<RemoteWebDriver>(driver);
//        wait.withTimeout(Duration.ofSeconds(2));
//        wait.pollingEvery(Duration.ofMillis(100));
//        driver.get("https://www.facebook.com");
//        driver.findElement(By.id("email")).sendKeys("9098938935");
//        driver.findElement(By.id("pass")).sendKeys("Rajat0705@", Keys.ENTER);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Search Facebook']"))).;
//        driver.close();
//        driver.get("https://www.amazon.com/");
//        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("cricket kit", Keys.ENTER);
//        if(driver.findElement(By.xpath("//span[text()='Featured']")).isDisplayed()) System.out.println("true");

    }
}

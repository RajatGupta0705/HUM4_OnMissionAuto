import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SwagLabsTest {
    public static void main(String args[]) throws InterruptedException {
    String[] usernames = {
            "standard_user",
            "locked_out_user",
            "problem_user",
            "performance_glitch_user",
            "error_user",
            "visual_user"
    };
    String password = "secret_sauce";
  // With actual user
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(1000);
        driver.findElement(By.id("user-name")).sendKeys(usernames[0]);
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(1000);
        driver.findElement(By.id("login-button")).click();
        driver.manage().window().maximize();
        Thread.sleep(2000);
        if(driver.findElement(By.xpath("//*[text()='Products']")).isDisplayed()) System.out.println("User logs in successfully");
        else System.out.println("log in failed");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Open Menu']")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Logout")).click();
        Thread.sleep(3000);
        if(driver.findElement(By.id("login-button")).isDisplayed()) System.out.println("user logs out successfully");
        else System.out.println("user failed to sign out");
// driver.close();
//With locked user
/*ChromeDriver driver = new ChromeDriver();
driver.get("https://www.saucedemo.com/");*/
        Thread.sleep(1000);
        driver.findElement(By.id("user-name")).sendKeys(usernames[1]);
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(1000);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);
        if(driver.findElement(By.xpath("//*[contains(text(),'Epic sadface')] ")).isDisplayed()) System.out.println("Locked user TC passed");
        else System.out.println("Locked out TC failed");
        driver.close();
}
}

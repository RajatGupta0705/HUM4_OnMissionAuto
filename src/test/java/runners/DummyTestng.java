package runners;

import io.cucumber.java.Before;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DummyTestng
{
    @Test(description = "tests")
    void tests()
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        System.out.println("tests method");
        driver.close();
    }
    @BeforeMethod
    void before()
    {
        System.out.println("before method");
    }
}

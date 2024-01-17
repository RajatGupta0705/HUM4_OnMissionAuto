package glueCode;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.asserts.SoftAssert;
import pageClasses.*;
import utilities.BrowserUtilities;

import java.util.Random;

public class Shared
{
    public RemoteWebDriver driver;
    public Random r;
    public Scenario s;
    public BrowserUtilities bobj;
    public LoginLogout lobj;
    public AddToCart aobj;
    public CartDataVerification cartdataobj;
    public CheckoutPageValidation checkoutpv;
    public CheckoutOverviewValidation checkoutOverviewV;
    public OrderSuccess os;
    public int countBeforeProductSeletion;
    public int countAfterProductSeletion;
    public int largestNumber=6;
    public int smallestNumber=1;
    @Before
    public void method1(Scenario sobj)
    {
        this.s= sobj;
        s.log(s.getName()+" is going started");
    }
    @After
    public void method2(Scenario sobj) throws Exception
    {
        this.s =sobj;
        s.log(s.getName()+" is "+s.getStatus().name());
        this.lobj.logoutSite();
        this.driver.close();
    }
}

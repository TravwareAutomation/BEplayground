package pages.BEpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.FileNotFoundException;
import java.time.Duration;

public class BEpagesTests {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    //    @AfterMethod
//    public void tearDown() {driver.quit();}
    /* @Testagencies
     public void regressionflight(){
             mainPage = new MainPageBE(driver);
             driver.get(mainPage.site);
             mainPage.flightType(driver);
             mainPage.flightDistinations(driver);
             //mainPage.flighDates();
     }*/
    @Test(priority = 1)
    public void regressiondash() throws FileNotFoundException, AWTException {
        DashboardPage dash1=new DashboardPage(driver);
        dash1.logIn(driver);
        dash1.investCheckboxBookingDetails(driver);
        dash1.gettingElementsTest(driver);
    }

}

//
package pages.RequestPackages;

import Utilities.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.FileNotFoundException;
import java.time.Duration;

public class PackagesRequestTest {
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

    @Test(priority = 1)
    public void packagesTest() throws FileNotFoundException, AWTException {
        ReusableMethods reusables = new ReusableMethods(driver);
        CreateNewRequestPackage newPack=new CreateNewRequestPackage(driver);
        reusables.logIn(driver);
        newPack.navigateToCreateNewPackageRequest(driver);
        newPack.basicInfoTab(driver);


    }

}

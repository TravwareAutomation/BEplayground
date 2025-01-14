package pages.Agencies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Agencies.Agencies;
import pages.BEpages.DartsTravellersPage;
import pages.BEpages.DashboardPage;
import pages.Roles.AllRolesPage;
import pages.Roles.NewRolePage;
import pages.Users.AllUsersPage;
import pages.Users.NewUserPage;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class AgenciesTests {
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
    public void agenciesCreatePage() throws AWTException, IOException {
        Agencies createAgency = new Agencies(driver);
        createAgency.loginNewAgency(driver);
        createAgency.setCredentials(driver);
        createAgency.setAgencyStatus();
        createAgency.setAgencyCountryCode(driver);
        createAgency.setAgencyType();
        createAgency.addAgency(driver);
    }
}

//
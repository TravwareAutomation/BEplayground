package pages.Agencies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
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
        CreateNewAgencies createAgency = new CreateNewAgencies(driver);
        createAgency.loginNewAgency(driver);
        createAgency.setCredentials(driver);
        createAgency.setAgencyStatus();
        createAgency.setAgencyCountryCode(driver);
        createAgency.setAgencyType(driver);
        createAgency.addAgency(driver);
    }
    @Test(priority = 2)
    public void allAgenciesPage() throws IOException, AWTException {
        AllAgenciesPage agencies=new AllAgenciesPage(driver);
        agencies.logIn(driver);
//        agencies.openActionsMenu();
//        agencies.openEditPage(driver);
//        agencies.openShowPage(driver);
//        agencies.openAgencyCreditsPage(driver);
//        agencies.openEditPage(driver);
        agencies.openUsersPage(driver);
    }
}

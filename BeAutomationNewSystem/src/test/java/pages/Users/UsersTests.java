package pages.Users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.time.Duration;

public class UsersTests {
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

    @Test( priority = 1)
    public void creatingNewUser() throws IOException, AWTException{
        NewUserPage newUser = new NewUserPage(driver);
        newUser.loginNewUsers(driver);
        newUser.newUserCredentials(driver);
        newUser.choosingAgency(driver);
        newUser.settingStatus();
        newUser.settingCountry(driver);
        newUser.settingPhoneNumber(driver);
        newUser.submittingForm(driver);
    }
    @Test(priority = 2)
    public void allUsresSearch() throws IOException, AWTException {
        AllUsersPage allusers = new AllUsersPage(driver);
        allusers.loginNewUsers(driver);
        //allusers.searchBarAllRoles(driver);
        allusers.choosingAgency(driver);
        allusers.getListOfUsers();
        allusers.clearFilters();
    }
}

//
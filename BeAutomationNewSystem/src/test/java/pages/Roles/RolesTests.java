package pages.Roles;

import com.opencsv.exceptions.CsvValidationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.time.Duration;

public class RolesTests {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

//        @AfterMethod
//    public void tearDown() {driver.quit();}


    @Test(priority = 1)
    public void regressionrole() throws IOException, AWTException {
        NewRolePage role = new NewRolePage(driver);
        role.logIn(driver);
        role.roleCreation(driver);
    }
    @Test(priority = 2)
    public void regressionAllRoles() throws IOException, AWTException, CsvValidationException {
        AllRolesPage allRoles = new AllRolesPage(driver);
        allRoles.openAllRolesPage(driver);
        allRoles.searchBarAllRoles(driver);
    }
    @Test(priority = 3)
    public void regressionDeleteUser() throws IOException, AWTException, CsvValidationException {
        AllRolesPage allRoles = new AllRolesPage(driver);
        allRoles.openAllRolesPage(driver);
        allRoles.DeleteUserAllRoles(driver);
    }

}

//
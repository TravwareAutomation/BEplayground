package com.example.beaportal;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.Agencies.CreateNewAgencies;
import pages.Roles.AllRolesPage;
import pages.BEpages.DashboardPage;
import pages.BEpages.DartsTravellersPage;
import pages.Roles.NewRolePage;
import pages.Users.AllUsersPage;
import pages.Users.NewUserPage;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class MainPageTest {
    private WebDriver driver;
    private DartsTravellersPage mainPage;

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

    @Test(priority = 2)
    public void regressionrole() throws IOException, AWTException {
        NewRolePage role = new NewRolePage(driver);
        role.logIn(driver);
        role.roleCreation(driver);
    }
    @Test(priority = 3)
    public void regressionAllRoles() throws IOException, AWTException, CsvValidationException {
        AllRolesPage allRoles = new AllRolesPage(driver);
        allRoles.openAllRolesPage(driver);
        allRoles.searchBarAllRoles(driver);
    }
    @Test(priority = 4)
    public void regressionDeleteUser() throws IOException, AWTException, CsvValidationException {
        AllRolesPage allRoles = new AllRolesPage(driver);
        allRoles.openAllRolesPage(driver);
        allRoles.DeleteUserAllRoles(driver);
    }
    @Test( priority = 5)
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
    @Test(priority = 6)
    public void allUsresSearch() throws IOException, AWTException {
        AllUsersPage allusers=new AllUsersPage(driver);
        allusers.loginNewUsers(driver);
        //allusers.searchBarAllRoles(driver);
        allusers.choosingAgency(driver);
        allusers.getListOfUsers();
        allusers.clearFilters();
    }
    @Test(priority = 7)
    public void agenciesCreatePage() throws AWTException, IOException {
        CreateNewAgencies createAgency = new CreateNewAgencies(driver);
        createAgency.loginNewAgency(driver);
        createAgency.setCredentials(driver);
        createAgency.setAgencyStatus();
        createAgency.setAgencyCountryCode(driver);
        createAgency.setAgencyType(driver);
        createAgency.addAgency(driver);
    }
}

//
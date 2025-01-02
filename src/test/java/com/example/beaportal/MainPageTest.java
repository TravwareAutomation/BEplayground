package com.example.beaportal;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.AllRolesPage;
import pages.Dashboard;
import pages.MainPageBE;
import pages.NewRolePage;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;

public class MainPageTest {
    private WebDriver driver;
    private MainPageBE mainPage;
    private Dashboard dash1;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    /*
        @AfterMethod
        public void tearDown() {driver.quit();}
        @Test
        public void regressionflight(){
                mainPage = new MainPageBE(driver);
                driver.get(mainPage.site);
                mainPage.flightType(driver);
                mainPage.flightDistinations(driver);
                //mainPage.flighDates();
        }
    @Test
        public void regressiondash(){
            dash1 = new Dashboard(driver);
            driver.get(dash1.site);
            dash1.logIn(driver);
            dash1.investCheckboxBookingDetails(driver);
            dash1.gettingElementsTest(driver);
        }
    */
    @Test(priority = 1)
    public void regressionrole() throws IOException {
        NewRolePage role = new NewRolePage(driver);
        role.logIn(driver);
        role.roleCreation(driver);
    }
    @Test(priority = 2)
    public void regressionAllRoles() throws IOException {
        AllRolesPage allRoles = new AllRolesPage(driver);
        allRoles.openAllRolesPage(driver);
        allRoles.searchBarAllRoles(driver);
    }
    @Test(priority = 3)
    public void deleteUser() throws IOException {
        AllRolesPage allRoles = new AllRolesPage(driver);
        allRoles.openAllRolesPage(driver);
        allRoles.DeleteUserAllRoles(driver);
    }

}

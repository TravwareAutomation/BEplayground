package pages;

import Utilities.ReusableMethods;
import com.opencsv.CSVReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertTrue;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Scanner;

public class AllRolesPage {
    @FindBy(xpath = "/html/body/div/div/div[2]/div[2]/div/div[2]/div[1]/div[1]/div/div/input")
    public WebElement searchBarAllRolesPage;
    @FindBy(xpath = "/html/body/div/div/div[2]/div[1]/div/div/div/div/div/div[1]/ul/li/div/div[2]/div/ul/li[1]/a")
    public WebElement allRoles;
    @FindBy(xpath = "/html/body/div/div/div[2]/div[2]/div/div[2]/div[2]/div/table/tbody/tr/td[6]/button/svg/path")
    public WebElement optionsMenu;
    @FindBy(xpath = "/html/body/div[2]/div/div[3]/button/span/span")
    public WebElement deleteButton;
    @FindBy(xpath = "/html/body/div[2]/div/div[1]/span")
    public WebElement actionsVisibility;

    public void searchBarAllRoles(WebDriver driver) throws IOException {
        ReusableMethods searchReused=new ReusableMethods(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        searchBarAllRolesPage.sendKeys(searchReused.searchViaName(driver));
    }
    public void DeleteUserAllRoles(WebDriver driver) throws IOException {
        ReusableMethods deletReused=new ReusableMethods(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        searchBarAllRolesPage.sendKeys(deletReused.searchViaName(driver));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        optionsMenu.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        assertTrue(actionsVisibility.isDisplayed());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        deleteButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    public void openAllRolesPage(WebDriver driver) throws IOException {

        ReusableMethods logInReused=new ReusableMethods(driver);
        logInReused.logIn(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logInReused.roleTabDropdown.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        allRoles.click();

    }
    public AllRolesPage(WebDriver driver) throws FileNotFoundException {
        PageFactory.initElements(driver, this);
    }
}

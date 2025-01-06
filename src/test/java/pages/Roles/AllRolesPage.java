package pages.Roles;

import Utilities.ReusableMethods;
import com.opencsv.CSVReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertTrue;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.*;

public class AllRolesPage {
    @FindBy(xpath = "/html/body/div/div/div[2]/div[2]/div/div[2]/div[1]/div[1]/div/div/input")
    public WebElement searchBarAllRolesPage;
    @FindBy(xpath = "/html/body/div/div/div[2]/div[1]/div/div/div/div/div/div[1]/ul/li/div/div[2]/div/ul/li[1]/a")
    public WebElement allRoles;
    @FindBy(id = "radix-:r1:")
    public WebElement optionsMenu;
    @FindBy(xpath = "/html/body/div[3]/div/div[3]/button")
    public WebElement deleteButton;
    @FindBy(id = "radix-:r2:")
    public WebElement actionsMenu;
    @FindBy( xpath= "/html/body/div[5]")
    public  WebElement deleteDialogue;
    @FindBy(xpath = "/html/body/div[3]")
    public WebElement overlayingPage;
    @FindBy(xpath = "/html/body/div[5]/div[3]")
    public WebElement deleteDialogueAgreeButton;
    public void searchBarAllRoles(WebDriver driver) throws IOException {
        ReusableMethods searchReused=new ReusableMethods(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        searchBarAllRolesPage.sendKeys(searchReused.searchViaName(driver));
    }
    public void DeleteUserAllRoles(WebDriver driver) throws IOException, InterruptedException {

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        //using ReusableMethods to search in all roles page
        ReusableMethods deleteReused=new ReusableMethods(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        searchBarAllRolesPage.sendKeys(deleteReused.searchViaName(driver));

        //clicking options menu
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        optionsMenu.click();

        //clicking the delete button in action menu
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        assertTrue(actionsMenu.isDisplayed());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<WebElement> menuElements=actionsMenu.findElements(By.tagName("div"));
        menuElements.get(3).click();

        //agreeing to delete role
        Actions action = new Actions(driver);
        List<WebElement> menuDiv1=driver.findElements(By.tagName("div"));
        menuDiv1.get(162).findElement(By.tagName("button")).click();
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("dialog-description")));

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

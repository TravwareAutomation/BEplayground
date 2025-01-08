package pages.Roles;

import Utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertTrue;
import java.io.FileNotFoundException;
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
    public WebElement deleteButton;
    public WebElement editButton;
    @FindBy(id = "radix-:r2:")
    public WebElement actionsMenu;
    public List<WebElement> deleteDialogue;
    public List<WebElement> editDialogue;
    public WebElement deleteDialogueAgreeButton;

    public void openAllRolesPage(WebDriver driver) throws IOException {

        ReusableMethods logInReused=new ReusableMethods(driver);
        logInReused.logIn(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logInReused.roleTabDropdown.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        allRoles.click();
    }
    public void searchBarAllRoles(WebDriver driver) throws IOException {
        ReusableMethods searchReused=new ReusableMethods(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        searchBarAllRolesPage.sendKeys(searchReused.searchViaName(driver));
    }

    public void editOption(WebDriver driver) throws IOException {
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        EditPage editPage = new EditPage(driver);
        openAllRolesPage(driver);
        //Opening Edit page
        ReusableMethods deleteReused=new ReusableMethods(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        searchBarAllRolesPage.sendKeys(deleteReused.searchViaName(driver));

        optionsMenu.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        editDialogue=actionsMenu.findElements(By.tagName("div"));
        editButton=editDialogue.get(2);
        editButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[1]/a[3]")));
        editPage.getAllPermissions(driver);

    }
    public void DeleteUserAllRoles(WebDriver driver) throws IOException, InterruptedException {

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("dialog-description")));
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
        deleteDialogue=actionsMenu.findElements(By.tagName("div"));
        deleteButton=deleteDialogue.get(3);
        deleteButton.click();

        //agreeing to delete role
        Actions action = new Actions(driver);
        List<WebElement> menuDiv1=driver.findElements(By.tagName("div"));
        deleteDialogueAgreeButton = menuDiv1.get(162).findElement(By.tagName("button"));
        deleteDialogueAgreeButton.click();
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("dialog-description")));
    }

    public AllRolesPage(WebDriver driver) throws FileNotFoundException {
        PageFactory.initElements(driver, this);
    }
}

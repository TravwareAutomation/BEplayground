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
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[1]/div/div/input")
    public WebElement searchBarAllRolesPage;
    @FindBy(xpath = "/html/body/div/div/div[2]/div[1]/div/div/div/div/div/div[1]/ul/li/div/div[2]/div/ul/li[1]/a")
    public WebElement allRoles;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div[2]/div[2]/div/table/tbody")
    public WebElement tableBody;
    public WebElement deleteButton;
    public WebElement editButton;
    @FindBy(id = "radix-:ru7:")
    public WebElement actionsMenu;
    public List<WebElement> deleteDialogue;
    public List<WebElement> editDialogue;
    public WebElement deleteDialogueAgreeButton;

    public void openAllRolesPage(WebDriver driver) throws IOException {

        ReusableMethods reusables=new ReusableMethods(driver);
        reusables.logIn(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        reusables.roleTabDropdown.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        allRoles.click();
    }
    public void searchBarAllRoles(WebDriver driver) throws IOException {
        ReusableMethods reusables=new ReusableMethods(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        searchBarAllRolesPage.sendKeys(reusables.searchViaName(driver));
    }

    public void editOption(WebDriver driver) throws IOException {
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        EditPage editPage = new EditPage(driver);
        openAllRolesPage(driver);
        //Opening Edit page
        ReusableMethods reusables=new ReusableMethods(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        searchBarAllRolesPage.sendKeys(reusables.searchViaName(driver));

        tableBody.findElements(By.tagName("tr")).get(0).findElements(By.tagName("td")).
                get(5).findElement(By.tagName("button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        actionsMenu.findElements(By.tagName("div")).get(2).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[1]/a[3]")));
        editPage.getAllPermissions(driver);

    }
    public void DeleteUserAllRoles(WebDriver driver) throws IOException {
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("dialog-description")));
        //using ReusableMethods to search in all roles page
        ReusableMethods deleteReused=new ReusableMethods(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        searchBarAllRolesPage.sendKeys(deleteReused.searchViaName(driver));

        //clicking options menu
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        tableBody.findElements(By.tagName("tr")).get(0).findElements(By.tagName("td")).
                get(5).findElement(By.tagName("button")).click();

        //clicking the delete button in action menu
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        actionsMenu.findElements(By.tagName("div")).get(3).click();


        //agreeing to delete role
        Actions action = new Actions(driver);
        List<WebElement> menuDiv1=driver.findElements(By.tagName("div"));
        deleteDialogueAgreeButton = menuDiv1.get(150).findElement(By.partialLinkText("agree"));
        System.out.println(deleteDialogueAgreeButton.getText());
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("dialog-description")));
    }

    public AllRolesPage(WebDriver driver) throws FileNotFoundException {
        PageFactory.initElements(driver, this);
    }
}

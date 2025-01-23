package pages.Roles;

import Utilities.ReusableMethods;
import com.opencsv.exceptions.CsvValidationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class AllRolesPage {
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[1]/div/div/input")
    public WebElement searchBarAllRolesPage;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[1]/div/div/div/div/div/div[1]/ul/li/div/div[1]/div/div[2]/h2")
    public WebElement roleTabDropdown;
    @FindBy(xpath = "/html/body/div/div/div[2]/div[1]/div/div/div/div/div/div[1]/ul/li/div/div[2]/div/ul/li[1]/a")
    public WebElement allRoles;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div[2]/div[2]/div/table/tbody")
    public WebElement tableBody;
    public WebElement editButton;
    @FindBy(css = ".text-red-600:nth-child(1)")
    public WebElement actionsMenu;
    @FindBy(css = ".bg-red-600")
    public WebElement deleteDialogueAgreeButton;

    public void openAllRolesPage(WebDriver driver) throws IOException, AWTException {

        ReusableMethods reusables=new ReusableMethods(driver);
        reusables.logIn(driver);
        navigateToTab(driver);
    }
    public void navigateToTab(WebDriver driver) throws FileNotFoundException, AWTException {
        ReusableMethods reusables =new ReusableMethods(driver);
        WebElement[] tabs={roleTabDropdown,allRoles};
        reusables.navigateToTab(tabs);
    }
    public void searchBarAllRoles(WebDriver driver) throws IOException, CsvValidationException {
        ReusableMethods reusables=new ReusableMethods(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        searchBarAllRolesPage.sendKeys(reusables.searchViaName(driver));
    }

    public void editOption(WebDriver driver) throws IOException, AWTException, CsvValidationException {
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

        actionsMenu.findElements(By.tagName("div")).get(1).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[1]/a[3]")));
        editPage.getAllPermissions(driver);
    }
    public void DeleteUserAllRoles(WebDriver driver) throws IOException, CsvValidationException {
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
        actionsMenu.click();

        //agreeing to delete role
        System.out .println(deleteDialogueAgreeButton.getText());
        deleteDialogueAgreeButton.click();
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("dialog-description")));
    }
    public AllRolesPage(WebDriver driver) throws FileNotFoundException {
        PageFactory.initElements(driver, this);
    }
}
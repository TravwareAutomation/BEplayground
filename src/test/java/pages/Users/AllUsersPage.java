package pages.Users;

import Utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertTrue;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class AllUsersPage {
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[1]/div/div/div/div/div/div[2]/ul/li/div/div[1]")
    public WebElement usersTap;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[1]/div/div/div/div/div/div[2]/ul/li/div/div[2]/div/ul/li[1]/a")
    public WebElement allUsersTab;
    @FindBy(xpath ="/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div[1]/div/input" )
    public WebElement searchBarAllUsers;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div[1]/div/button")

    public WebElement allUsersAgency;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div[1]/div/div[2]/button")
    public WebElement searchButtonAllUsers;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div[2]/div/table/tbody")
    public WebElement tableBody;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div[1]/div/div[2]/button[1]")
    public WebElement clearButton;

    public void loginNewUsers(WebDriver driver) throws IOException, AWTException {
        ReusableMethods reusables=new ReusableMethods(driver);
        reusables.logIn(driver);
        navigateToTab(driver);
    }
    public void navigateToTab(WebDriver driver) throws FileNotFoundException, AWTException {
        ReusableMethods reusables =new ReusableMethods(driver);
        WebElement[] tabs={usersTap,allUsersTab};
        reusables.navigateToTab(tabs);
    }
    public void searchBarAllRoles(WebDriver driver) throws IOException {
        ReusableMethods reusables=new ReusableMethods(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        searchBarAllUsers.sendKeys(reusables.searchViaName(driver));
    }
    public void choosingAgency(WebDriver driver) throws AWTException, FileNotFoundException {
        Robot newRobot=new Robot();
        ReusableMethods reusables= new ReusableMethods(driver);
        try {
            assertTrue(allUsersAgency.isDisplayed());
            allUsersAgency.click();
            char[] arr={'G','Y','G','Y','Y'};
            reusables.keyStrokes(arr);
            newRobot.delay(1000);
            searchButtonAllUsers();
            newRobot.delay(500);
        } catch (NoAlertPresentException e) {
            System.out.println("all us button is not displayed to be clicked");
        }
    }
    public void searchButtonAllUsers(){
        try {
            assertTrue(searchButtonAllUsers.isDisplayed());
            searchButtonAllUsers.click();
        } catch (NoAlertPresentException e) {
            System.out.println("Search button is not displayed to be clicked");
        }
    }
    public void getListOfUsers() throws AWTException {
        Robot newRobot=new Robot();
        newRobot.delay(500);
        List<WebElement> tableContents=tableBody.findElements(By.tagName("tr"));
        newRobot.delay(500);
        for (WebElement tableContent : tableContents) {
            System.out.println(" ");
            for (int j = 0; j < 7; j++)
            {System.out.print(tableContent.findElements(By.tagName("td")).get(j).getText()+ " (-*-) ");}
            System.out.println(" ");
            System.out.println("--------------------------");
        }
    }
    public void clearFilters(){
        try {
            assertTrue(clearButton.isDisplayed());
            clearButton.click();

        } catch (NoAlertPresentException e) {
            System.out.println("clear button is not displayed to be clicked");
        }
    }
    public AllUsersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}

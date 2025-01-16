package pages.Agencies;

import Utilities.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import static org.testng.Assert.assertTrue;
public class AllAgenciesPage {
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[1]/div/div/div/div/div/div[3]/ul/li/div/div[1]/div/div[2]/h2")
    public WebElement agenciesTab;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[1]/div/div/div/div/div/div[3]/ul/li/div/div[2]/div/ul/li[1]/a")
    public WebElement allAgenciesTab;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[1]/div/div/input")
    public WebElement searchBarAllAgencies;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div[2]/div[2]/div/table/tbody/tr[1]/td[8]/button")
    public WebElement openActionsMenu;
    @FindBy(css = "a:nth-child(3) > .relative")
    public WebElement editAgencyButton;
    @FindBy(css = "a:nth-child(4) > .relative")
    public WebElement showAgencyButton;
    @FindBy(css = ".text-red-600:nth-child(1)")
    public WebElement deleteAgencyButton;
    @FindBy(css = "a:nth-child(6) > .relative")
    public WebElement agencyUsersButton;
    @FindBy(css = "a:nth-child(7) > .relative")
    public WebElement agencyCreditButton;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div[2]/h2")
    public WebElement basicInfo;
    Robot newRobot = new Robot();
    public void logIn(WebDriver driver) throws FileNotFoundException, AWTException {
        ReusableMethods reusables =new ReusableMethods(driver);
        reusables.logIn(driver);
        navigateToAllAgenciesTab(driver);
    }
    public void navigateToAllAgenciesTab(WebDriver driver) throws FileNotFoundException, AWTException {
        ReusableMethods reusables =new ReusableMethods(driver);
        WebElement[] tabs={agenciesTab,allAgenciesTab};
        reusables.navigateToTab(tabs);
    }
    public void searchBarAllRoles(WebDriver driver) throws IOException {
        ReusableMethods reusables=new ReusableMethods(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        searchBarAllAgencies.sendKeys(reusables.searchViaName(driver));
    }
    public void newAgencyButton(WebDriver driver) throws IOException, AWTException {
        CreateNewAgencies newAgency=new CreateNewAgencies(driver);
        newAgency.navigateToTab(driver);
        newAgency.setCredentials(driver);
        newAgency.setAgencyStatus();
        newAgency.setAgencyCountryCode(driver);
        newAgency.setAgencyType(driver);
        newAgency.addAgency(driver);
    }
    public void openActionsMenu(){
        openActionsMenu.click();
        newRobot.delay(700);
    }
    public void openEditPage(WebDriver driver) throws FileNotFoundException, AWTException {
        newRobot.delay(1000);
        openActionsMenu();
        editAgencyButton.click();

        newRobot.delay(1000);
        CreateNewAgencies editAgency =new CreateNewAgencies(driver);
        String[] data={"hassan","hassan.balaha@travware.com","1258,nasr Rd , c2","01288718221","223344332","5","Active","Corporate"};
        editAgency.setAgencyCountryCode(driver);
        editAgency.editAgency(driver,data);
    }
    public void openShowPage(WebDriver driver) {
//        this invoke is to search for a certain agency name
//        searchBarAllRoles(driver);

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(7));
        AllAgenciesShowPage showInfo=new AllAgenciesShowPage(driver);
        newRobot.delay(1000);
        openActionsMenu();
        showAgencyButton.click();
        newRobot.delay(500);
        wait.until(ExpectedConditions.visibilityOf(basicInfo));
        showInfo.readingDataInShowPage();
    }
    public void openDeleteAgencyPage(){
        newRobot.delay(1000);
        openActionsMenu();
        deleteAgencyButton.click();
    }
    public void openUsersPage(){
        newRobot.delay(1000);
        openActionsMenu();
        agencyUsersButton.click();
    }
    public void openAgencyCreditsPage(){
        newRobot.delay(1000);
        openActionsMenu();
        agencyCreditButton.click();
    }
    public AllAgenciesPage(WebDriver driver) throws AWTException {
        PageFactory.initElements(driver,this);
    }
}

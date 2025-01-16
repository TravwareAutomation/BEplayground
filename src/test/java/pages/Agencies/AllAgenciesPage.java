package pages.Agencies;

import Utilities.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    WebElement searchBarAllAgencies;

    public void logIn(WebDriver driver) throws FileNotFoundException, AWTException {
        ReusableMethods reusables =new ReusableMethods(driver);
        reusables.logIn(driver);
        navigateToTab(driver);
    }
    public void navigateToTab(WebDriver driver) throws FileNotFoundException, AWTException {
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
        newAgency.setAgencyType();
        newAgency.addAgency(driver);
    }
    public AllAgenciesPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
}

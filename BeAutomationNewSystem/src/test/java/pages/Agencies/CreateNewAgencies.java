package pages.Agencies;

import Utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.testng.Assert.assertTrue;


public class CreateNewAgencies {
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[1]/div/div/div/div/div/div[3]/ul/li/div/div[1]/div/div[2]/h2")
    public WebElement agenciesTab;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[1]/div/div/div/div/div/div[3]/ul/li/div/div[2]/div/ul/li[2]/a")
    public WebElement createAgencyTab;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div[2]/form/div[2]/div[1]/input")
    public WebElement agencyName;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div[2]/form/div[2]/div[2]/input")
    public WebElement agencyEmail;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div[2]/form/div[2]/div[3]/input")
    public WebElement agencyAddress;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div[2]/form/div[2]/div[4]/select")
    public WebElement agencyStatus;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div[2]/form/div[2]/div[5]/select")
    public WebElement countryCode;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div[2]/form/div[2]/div[6]/input")
    public WebElement agencyPhoneNumber;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div[2]/form/div[2]/div[7]/input")
    public WebElement agencyTaxNumber;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div[2]/form/div[2]/div[8]/input")
    public WebElement agencyNumberOfUsers;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div[2]/form/div[2]/div[9]/button")
    public WebElement agencyType;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div[2]/form/div[4]/button")
    public WebElement addAgencyButton;
    public String[] data={"test_mmm","hassan.balaha@travware.com","1258,nasr Rd , c2","01288718221","223344332","5","Active","Corporate"};
    //---------------name( 0 ),--------------email( 1 )-------address( 2 )-------- phone number( 3 )---tax number( 4 )--number of employees( 5 )
    // --status (inActive)( 6 )--agencyType(  7  )
    char[] countryCodeInit ={'E','G'};



    // logging in and opening agencies tap and accessing creating new agency option
    public void loginNewAgency(WebDriver driver) throws IOException, AWTException {
        ReusableMethods reusables=new ReusableMethods(driver);
        reusables.logIn(driver);
        navigateToTab(driver);
    }
    public void setCredentials(WebDriver driver) throws FileNotFoundException, AWTException {
        WebElement[] locators={agencyName,agencyEmail,agencyAddress,agencyPhoneNumber,agencyTaxNumber,agencyNumberOfUsers};
        //------------------------name( 0 )---------email( 1 )-----address( 2 )------phone number( 3 )-------tax number( 4 )
        // ----number of employees( 5 )
        ReusableMethods reusables=new ReusableMethods(driver);
        reusables.settingCredintials(locators,data);
    }
    public void navigateToTab(WebDriver driver) throws FileNotFoundException, AWTException {
        ReusableMethods reusables =new ReusableMethods(driver);
        WebElement[] tabs={agenciesTab,createAgencyTab};
        reusables.navigateToTab(tabs);
    }
    public void setAgencyStatus(){
        Select statusListOptions=new Select(agencyStatus);
        statusListOptions.selectByIndex(Integer.parseInt(data[6]));
    }
    public void setAgencyType(WebDriver driver) throws AWTException, FileNotFoundException {
        ReusableMethods reusables = new ReusableMethods(driver);
        agencyType.click();
        reusables.setType(data[7]);
    }
    public void setAgencyCountryCode(WebDriver driver) throws AWTException {
        Select selectTypeOptions = new Select(countryCode);
        Robot newRobot=new Robot();
        newRobot.delay(300);
        selectTypeOptions.selectByValue("EG");
    }
    public void addAgency(WebDriver driver){
        try {
            addAgencyButton.click();
        } catch (NoAlertPresentException e) {
            List<WebElement> alerrtDetect=driver.findElements(By.tagName("ol"));
            String local=alerrtDetect.get(0).findElement(By.tagName("li")).getText();
        }
    }
    public void editAgency() throws FileNotFoundException, AWTException {
        WebElement[] locators={agencyName,agencyEmail,agencyAddress,agencyPhoneNumber,agencyTaxNumber,agencyNumberOfUsers,agencyStatus};
        //------------------------name( 0 )---------email( 1 )-----address( 2 )------phone number( 3 )-------tax number( 4 )
        // ----number of employees( 5 )
        String[] data1 ={"","","","","","",""};
        for(int i=0;i<data1.length;i++){
            data1[i]=locators[i].getAttribute("value");
            System.out.println(data1[i]);
            locators[i].clear();
            assert data1[i] != null;
            locators[i].sendKeys(data1[i]);
        }
        for (String datum : data1) {
            System.out.println(datum);
        }
    }
    public  CreateNewAgencies(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}

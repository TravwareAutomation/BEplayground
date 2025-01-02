package Utilities;

import com.opencsv.CSVReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;

public class ReusableMethods {
    public String site1="https://b2e.dartstravelers.com/dashboard/roles/create";
    public String site="https://b2e.dartstravelers.com";
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[2]/form/div[1]/input")
    public WebElement DashboardUsername;
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[2]/form/div[2]/div[1]/input")
    public WebElement DashboardPassword;
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[2]/form/div[3]/button")
    public WebElement DashboardLogInButton;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[1]/div/div/div/div/div/div[1]/ul/li/div/div[1]/div/div[2]/h2")
    public WebElement roleTabDropdown;
    public String user="b2e.dartstravelers@travware.com";
    public String pass="password";
    public File file = new File("/home/developer/master/BEAPortal/src/test/java/pages/username.csv");
    public FileReader filereader = new FileReader("/home/developer/master/BEAPortal/src/test/java/pages/username.csv");



    public void logIn(WebDriver driver){
        driver.get(site1);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        DashboardUsername.sendKeys(user);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        DashboardPassword.sendKeys(pass);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        DashboardLogInButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public String searchViaName(WebDriver driver) throws IOException {
        ReusableMethods fileReused=new ReusableMethods(driver);
        String scannedUser;
        CSVReader csvReader = new CSVReader(fileReused.filereader);
        scannedUser= Arrays.toString(csvReader.readNext());
        System.out.println(scannedUser.substring(1,(scannedUser.length()-4)));
        return scannedUser.substring(1,(scannedUser.length()-4));
    }
    public ReusableMethods(WebDriver driver) throws FileNotFoundException {
        PageFactory.initElements(driver, this);
    }
}

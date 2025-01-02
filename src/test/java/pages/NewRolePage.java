package pages;

import Utilities.ReusableMethods;
import com.opencsv.CSVWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.NoAlertPresentException;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

public class NewRolePage {
    //creating new role
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
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[1]/div/div/div/div/div/div[1]/ul/li/div/div[2]/div/ul/li[2]/a")
    public WebElement createRoleOptionDropdown;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div[2]/form/div[1]/div[1]/input")
    public WebElement roleName;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div[2]/form/div[1]/div[2]/input")
    public WebElement roleLevel;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div[2]/form/div[2]/button")
    public WebElement newRoleButton;

    // LOCATIONS OF CHECKBOXEX IN NEW ROLE PAGE
    //div containing all the checkboxs
    @FindBy(xpath = "/html/body/div/div/div[2]/div[2]/div/div[3]/button")
    public WebElement updateButton;
    @FindBy(xpath = "/html/body/div/div/div[2]/div[2]/div/div[2]/div[2]/div[1]/div/div[2]/div")
    public WebElement confirmBooking;
    public String user="b2e.dartstravelers@travware.com";
    public String pass="password";
    String[] rolenameString= {" "," "};


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

    public void roleCreation(WebDriver driver) throws IOException {
        Random rand = new Random();
        int rand_int1 = rand.nextInt((5-1)+1)+1;
        rolenameCreation("Hassan Testing User No.",driver);

        roleTabDropdown.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        createRoleOptionDropdown.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        assertTrue(roleName.isDisplayed());
        roleName.sendKeys(rolenameString);

        assertTrue(roleLevel.isDisplayed());
        roleLevel.sendKeys(String.valueOf(rand_int1));
        newRoleButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        confirmBooking.findElement(By.id("category-1")).click();
        rolenameString[1]=confirmBooking.findElement(By.tagName("h3")).getText();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        updateButton.click();



//        System.out.println(list1.get(0).findElements(By.tagName("div")).get(0).
//                findElements(By.tagName("div")).get(0).findElements(By.tagName("div")).get(1).findElement(By.tagName("div")).getText());

    }
    public void rolenameCreation(String name,WebDriver driver) throws IOException {
        ReusableMethods file=new ReusableMethods(driver);
        FileWriter outputFile = new FileWriter(file.file );
        CSVWriter writer = new CSVWriter(outputFile);
        Random rand = new Random();
        int rand_int1 = rand.nextInt(1000);
        rolenameString[0] = name + String.valueOf(rand_int1);
        writer.writeNext(rolenameString);
        writer.close();
    }
    public static boolean isAlertPresent(WebDriver driver) {
        try {
            driver.switchTo().alert();
            driver.switchTo().alert().dismiss();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
    public NewRolePage(WebDriver driver) throws IOException {
        PageFactory.initElements(driver, this);
    }

}

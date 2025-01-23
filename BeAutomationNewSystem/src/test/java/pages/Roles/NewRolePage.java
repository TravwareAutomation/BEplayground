package pages.Roles;

import Utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.NoAlertPresentException;
import static org.testng.Assert.assertTrue;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

public class NewRolePage {
    //creating new role
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[1]/div/div/div/div/div/div[1]/ul/li/div/div[1]/div/div[2]/h2")
    public WebElement roleTabDropdown;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[1]/div/div/div/div/div/div[1]/ul/li/div/div[2]/div/ul/li[2]/a")
    public WebElement createRoleOptionDropdown;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div[2]/form/div[1]/div[1]/input")
    public WebElement roleName;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div[2]/form/div[1]/div[2]/input")
    public WebElement roleLevel;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div[2]/form/div[2]/button")
    public WebElement newRoleButton;

    // LOCATIONS OF CHECKBOXEX IN NEW ROLE PAGE
    //div containing all the checkboxs
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div[3]/button")
    public WebElement updateButton;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[1]/div/div[2]/div")
    public WebElement confirmBooking;



    public void logIn(WebDriver driver) throws FileNotFoundException {
        ReusableMethods reusables = new ReusableMethods(driver);
        reusables.logIn(driver);
    }
    public void navigateToTab(WebDriver driver) throws FileNotFoundException, AWTException {
        ReusableMethods reusables =new ReusableMethods(driver);
        WebElement[] tabs={roleTabDropdown,createRoleOptionDropdown};
        reusables.navigateToTab(tabs);
    }
    public void roleCreation(WebDriver driver) throws IOException, AWTException {
        Random rand = new Random();
        int rand_int1 = rand.nextInt((5-1)+1)+1;
        String localName="";
        localName=rolenameCreation("Hassan No.",driver);

        navigateToTab(driver);

        assertTrue(roleName.isDisplayed());
        roleName.sendKeys(localName);

        assertTrue(roleLevel.isDisplayed());
        roleLevel.sendKeys(String.valueOf(rand_int1));
        newRoleButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        confirmBooking.findElement(By.id("category-1")).click();
        localName=confirmBooking.findElement(By.tagName("h3")).getText();
        System.out.println(localName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        updateButton.click();



    }
    public String rolenameCreation(String name,WebDriver driver) throws IOException {
        ReusableMethods reusables=new ReusableMethods(driver);
        return reusables.nameCreation(name,driver);
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

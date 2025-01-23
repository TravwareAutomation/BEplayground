package pages.Agencies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Users.NewUserPage;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class AllAgenciesUsersPage {



@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div[2]/div[1]/div/a/button")
public WebElement newAgencyUserButton;
public void clickOnNewAgencyUserButton(WebDriver driver) throws IOException, AWTException {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    NewUserPage newUserpage=new NewUserPage(driver);

    wait.until(ExpectedConditions.visibilityOf(newUserpage.newUserTravelAgency));
    newUserpage.loginNewUsers(driver);
    newUserpage.newUserCredentials(driver);
    newUserpage.choosingAgency(driver);
    newUserpage.settingStatus();
    newUserpage.settingCountry(driver);
    newUserpage.settingPhoneNumber(driver);
    newUserpage.submittingForm(driver);

}












    public AllAgenciesUsersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}

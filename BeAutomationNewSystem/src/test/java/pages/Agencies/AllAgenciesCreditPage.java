package pages.Agencies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;

public class AllAgenciesCreditPage {

    public String creditsPageURL="https://b2e.dartstravelers.com/dashboard/agencies/29/credits";
    @FindBy(xpath ="/html/body/div[1]/div/div[2]/div[2]/div[2]/div[1]/button")
    public WebElement addNewAgencyCreditButton;
    @FindBy(xpath = "/html/body/div[4]")
    public WebElement addAgencyCreditFrame;
    @FindBy(xpath = "/html/body/div[4]/div[2]/form/div[1]/input")
    public WebElement addAgencyCreditLimit;
    @FindBy(xpath = "/html/body/div[4]/div[2]/form/div[2]/div[1]/input")
    public WebElement addAgencyCreditFlightLimit;
    @FindBy(xpath = "/html/body/div[4]/div[2]/form/div[2]/div[2]/input")
    public WebElement addAgencyCreditHotelLimit;
    @FindBy(xpath = "/html/body/div[4]/div[2]/form/div[3]/input")
    public WebElement addAgencyCreditDepositLimit;
//    @FindBy(xpath = "/html/body/div[4]/div[2]/form/div[4]/button")
//    public  WebElement addAgencyCreditCurrency;
    @FindBy(xpath = "/html/body/div[4]/div[2]/form/div[4]/select")
    public WebElement addAgencyCreditCurrencySelector;
    @FindBy(xpath = "/html/body/div[4]/div[1]/h2")
    public WebElement addAgencyCreditLabel;
    @FindBy(xpath = "/html/body/div[4]/div[2]/form/div[5]/button")
    public WebElement addAgencyCreditButton;

    public void getagency(WebDriver driver){
        driver.get(creditsPageURL);
    }
    String[] dataCreditPage={"100000","50000","25000","25000","EGP"};
    public void newAgencyCredit(WebDriver driver) throws AWTException {
        Robot newRobot=new Robot();
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(addNewAgencyCreditButton));

        addNewAgencyCreditButton.click();
        newRobot.delay(500);
        addAgencyCreditLimit.sendKeys(dataCreditPage[0]);
        addAgencyCreditFlightLimit.sendKeys(dataCreditPage[1]);
        addAgencyCreditHotelLimit.sendKeys(dataCreditPage[2]);
        addAgencyCreditDepositLimit.sendKeys(dataCreditPage[3]);
        Select currencySelector = new Select(addAgencyCreditCurrencySelector);
        switch (dataCreditPage[4]) {
            case "EGP":
                currencySelector.selectByValue("3");
                break;
            case "Euro":
                // Block of code to be executed if expression == value2
                currencySelector.selectByValue("2");
                break;
            case "Dollar":
                // Block of code to be executed if expression == value3
                currencySelector.selectByValue("1");
                break;
            default:
                // Block of code to be executed if none of the above values match
                currencySelector.selectByValue("3");
                break;
        }
        addAgencyCreditButton.click();


    }

    public AllAgenciesCreditPage(WebDriver driver) {PageFactory.initElements(driver, this);}
}

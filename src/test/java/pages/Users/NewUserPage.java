package pages.Users;

import Utilities.ReusableMethods;
import com.opencsv.CSVWriter;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.tracing.opentelemetry.SeleniumSpanExporter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class NewUserPage {
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[1]/div/div/div/div/div/div[2]/ul/li/div/div[1]")
    public WebElement usersTap;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[1]/div/div/div/div/div/div[2]/ul/li/div/div[2]/div/ul/li[2]/a")
    public WebElement createNewUser;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div[2]/form/div[1]/div[2]/div[1]/input")
    public WebElement newUserName;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div[2]/form/div[1]/div[2]/div[2]/input")
    public WebElement newUserEmail;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div[2]/form/div[1]/div[3]/div[1]/input")
    public WebElement newUserPassWord;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div[2]/form/div[1]/div[3]/div[2]/button")
    public WebElement newUserTravelAgency;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div[2]/form/div[1]/div[4]/div[1]/button")
    public WebElement newUserRole ;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div[2]/form/div[1]/div[4]/div[2]/button")
    public WebElement newUserPaymentMethod;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div[2]/form/div[1]/div[5]/div[1]/button")
    public WebElement newUsersStatus;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div[2]/form/div[1]/div[5]/div[2]/button")
    public WebElement newUserCountryCode;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div[2]/form/div[1]/div[5]/div[3]/input")
    public WebElement newUserPhone;
    @FindBy( xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[2]/button[1]")
    public WebElement submitButton;
    String[] data={" ","Hassan.balaha1@travware.com","P@ssw0rd","test_mmm","01288718221"};


    String[] rolenameString= {" "," "};
    public void newUserCredentials(WebDriver driver) throws IOException {
        createNewUserName(driver);
        System.out.println(data[0]);
        newUserName.sendKeys(data[0]);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        newUserEmail.sendKeys(data[1]);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        newUserPassWord.sendKeys(data[2]);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    public void loginNewUsers(WebDriver driver) throws IOException {
        ReusableMethods loginReused=new ReusableMethods(driver);
        loginReused.logIn(driver);
    }
    //setting the name of the new user....
    public void createNewUserName(WebDriver driver) throws IOException {
        ReusableMethods nameReused=new ReusableMethods(driver);
        FileWriter outputFile = new FileWriter(nameReused.file );
        CSVWriter writer = new CSVWriter(outputFile);
        Random rand = new Random();

       //creating new user having new name , pass,email ,....etc
        int rand_int1 = rand.nextInt(1000);
        String localName=nameReused.nameCreation("Hassan No. ",driver);
        System.out.println(localName);
        rolenameString[0] = localName + rand_int1;
        data[0]=rolenameString[0];
        System.out.println(Arrays.toString(data));
        writer.writeNext(rolenameString);
        writer.close();
    }
    public void choosingAgency(WebDriver driver) throws FileNotFoundException, AWTException {
        ReusableMethods reusables = new ReusableMethods(driver);
        newUserTravelAgency.click();
        char[] arr={'G','Y','G','Y','Y'};
        reusables.keyStrokes(arr);

    }
    public void settingStatus() throws AWTException {
        Robot newRobot=new Robot();
        newUsersStatus.click();
        newRobot.keyPress(KeyEvent.VK_ENTER);
        newRobot.keyRelease(KeyEvent.VK_ENTER);
    }
    public void settingCountry(WebDriver driver) throws AWTException{
        Robot newRobot=new Robot();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        newUserCountryCode.click();
        newRobot.keyPress(KeyEvent.VK_E);
        newRobot.keyRelease(KeyEvent.VK_E);
        newRobot.keyPress(KeyEvent.VK_G);
        newRobot.keyRelease(KeyEvent.VK_G);
        newRobot.delay(500);
        newRobot.keyPress(KeyEvent.VK_ENTER);
        newRobot.keyRelease(KeyEvent.VK_ENTER);
    }
    public void settingPhoneNumber(WebDriver driver){
        newUserPhone.sendKeys(data[4]);
    }
    public void submittingForm(WebDriver driver){
        submitButton.click();
        //getting the alert test to compare it in a try-catch statement
        List<WebElement> alerrtDetect=driver.findElements(By.tagName("ol"));

        System.out.println(alerrtDetect.get(0).findElement(By.tagName("li")).getText());
        String local=alerrtDetect.get(0).findElement(By.tagName("li")).getText();
        try {
            if (local.equals("The email must be a valid email address.")){
                System.out.println(alerrtDetect.get(0).findElement(By.tagName("li")).getText());
                alerrtDetect.get(0).findElement(By.tagName("button")).click();
            }
        } catch (NoAlertPresentException e) {
            System.out.println("every thing went successfully");

        }
    }

    public void creatingNewUser(WebDriver driver) throws IOException {
        //navigating the
        usersTap.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        createNewUser.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        newUserCredentials(driver);
    }
    public NewUserPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}

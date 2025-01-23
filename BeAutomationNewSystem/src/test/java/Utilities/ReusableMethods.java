package Utilities;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertTrue;

public class ReusableMethods {
    //
    //
    public String site="https://b2e.dartstravelers.com/";
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[2]/form/div[1]/input")
    public WebElement DashboardUsername;
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[2]/form/div[2]/div[1]/input")
    public WebElement DashboardPassword;
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[2]/form/div[3]/button")
    public WebElement DashboardLogInButton;
    @FindBy(xpath = "/html/body/div[1]/header/div/div/div/div[3]/a[2]")
    public WebElement signInButton;
    public String user="b2e.dartstravelers@travware.com";
    public String pass="password";
    public File file = new File("C:/Users/hassan.balaha/IdeaProjects/BeAutomationNewSystem/src/test/java/pages/username.csv");
    public FileReader filereader = new FileReader("C:/Users/hassan.balaha/IdeaProjects/BeAutomationNewSystem/src/test/java/pages/username.csv");
    String[] rolenameString= {" "," "};

    public void logIn(WebDriver driver){
        driver.get(site);
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(signInButton));
        signInButton.click();
        wait.until(ExpectedConditions.visibilityOf(DashboardUsername));
        DashboardUsername.sendKeys(user);
        wait.until(ExpectedConditions.visibilityOf(DashboardPassword));
        DashboardPassword.sendKeys(pass);
        wait.until(ExpectedConditions.visibilityOf(DashboardLogInButton));
        DashboardLogInButton.click();

    }
    public String searchViaName(WebDriver driver) throws IOException, CsvValidationException {
        String scannedUser;
        ReusableMethods fileReused=new ReusableMethods(driver);
        CSVReader csvReader = new CSVReader(fileReused.filereader);
        scannedUser= Arrays.toString(csvReader.readNext());
        System.out.println(scannedUser.substring(1,(scannedUser.length()-4)));
        return scannedUser.substring(1,(scannedUser.length()-4));
    }
    public String nameCreation(String name,WebDriver driver) throws IOException {
        ReusableMethods file=new ReusableMethods(driver);
        FileWriter outputFile = new FileWriter(file.file );
        CSVWriter writer = new CSVWriter(outputFile);
        Random rand = new Random();
        int rand_int1 = rand.nextInt(2000);
        String localName=name + String.valueOf(rand_int1);
        rolenameString[0] = localName;
        writer.writeNext(rolenameString);
        writer.close();
        return localName;
    }
    public void settingCredintials(WebElement[] locators,String[] data) throws AWTException {
        Robot newRobot = new Robot();
        newRobot.delay(800);
        for(WebElement element: locators){

            if (locators[Arrays.asList(locators).indexOf(element)]!=null){
                System.out.println(locators[Arrays.asList(locators).indexOf(element)].getText());
                locators[Arrays.asList(locators).indexOf(element)].clear();
                locators[Arrays.asList(locators).indexOf(element)].
                        sendKeys(data[Arrays.asList(locators).indexOf(element)]);
                newRobot.delay(300);
            }
            else {
                System.out.println("else entered --> "+Arrays.asList(locators).indexOf(element));
                continue;
            }
        }
    }
    public void keyStrokes(char[] keys) throws AWTException {
        Robot newRobot=new Robot();
        for (char key : keys) {
            //char[] arr={'E','G',};
            newRobot.keyPress(KeyEvent.getExtendedKeyCodeForChar(key));
            newRobot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(key));
            newRobot.delay(500);
        }
        newRobot.delay(1000);
        newRobot.keyPress(KeyEvent.VK_ENTER);
        newRobot.keyRelease(KeyEvent.VK_ENTER);
        newRobot.delay(500);
    }
    // Method to calculate the arrival date based on departure date and number of days to stay
    public static String[] calculateFlightDates(String departureDate, int numberOfDaysToStay) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate departure = LocalDate.parse(departureDate, formatter);
        LocalDate arrival = departure.plusDays(numberOfDaysToStay);
        String formattedDepartureDate = departure.format(formatter);
        String formattedArrivalDate = arrival.format(formatter);

        // Return both dates as a string array
        return new String[] {formattedDepartureDate, formattedArrivalDate};
    }
    public void navigateToTab(WebElement[] tabs) throws AWTException {
        Robot newRobot=new Robot();
        newRobot.delay(500);
        tabs[0].click();
        newRobot.delay(500);
        tabs[1].click();
    }
    public void setStatus(String status) throws AWTException {
        Robot newRobot = new Robot();
        if (status.equals("active")) {
            newRobot.keyPress(KeyEvent.VK_ENTER);
            newRobot.keyRelease(KeyEvent.VK_ENTER);
        } else if (status.equals("inactive")) {
            newRobot.keyPress(KeyEvent.VK_DOWN);
            newRobot.keyRelease(KeyEvent.VK_DOWN);
            newRobot.keyPress(KeyEvent.VK_ENTER);
            newRobot.keyRelease(KeyEvent.VK_ENTER);
        } else {
            newRobot.keyPress(KeyEvent.VK_ENTER);
            newRobot.keyRelease(KeyEvent.VK_ENTER);
        }
    }

    public void setType(String Type) throws AWTException {
        Robot newRobot = new Robot();
        if (Type.equals("Travel Agency")) {
            newRobot.keyPress(KeyEvent.VK_ENTER);
            newRobot.keyRelease(KeyEvent.VK_ENTER);
        } else if (Type.equals("Corporate")) {
            newRobot.keyPress(KeyEvent.VK_DOWN);
            newRobot.keyRelease(KeyEvent.VK_DOWN);
            newRobot.keyPress(KeyEvent.VK_ENTER);
            newRobot.keyRelease(KeyEvent.VK_ENTER);
        } else {
            newRobot.keyPress(KeyEvent.VK_ENTER);
            newRobot.keyRelease(KeyEvent.VK_ENTER);
        }
    }

    public void gettingElementsTest(WebDriver driver,WebElement elementBase) throws AWTException {
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));

        List<WebElement> list1=elementBase.findElements(By.tagName("tr"));
        System.out.println("------------------------------------------------------------------------------------");
        for (int i=1;i<=list1.size()-1;i++) {
            for (int j=0;j<=6;j++){
                System.out.print("[ "+list1.get(i).findElements(By.tagName("td")).get(j).getText()+"] |" );}
            System.out.println();
        }
    }
    public ReusableMethods(WebDriver driver) throws FileNotFoundException {
        PageFactory.initElements(driver, this);
    }
}

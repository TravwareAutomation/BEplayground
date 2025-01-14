package pages.BEpages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

// page_url = https://www.jetbrains.com/
public class DartsTravellersPage {
    public String site="https://b2c.dartstravelers.com/";
// flight passenger and class details

    @FindBy(xpath = "/html/body/div[1]/main/div/div[1]/div/div/div[2]/div/div[1]/details[1]/summary")
    public WebElement flightTypeSelector;
        @FindBy(xpath = "/html/body/div[1]/main/div/div[1]/div/div/div[2]/div/div[1]/details[1]/ul/li[3]")
        public WebElement FlightType;
    @FindBy(xpath = "/html/body/div[1]/main/div/div[1]/div/div/div[2]/div/div[1]/details[2]/summary")
    public WebElement NumberOfPassengersSelector;
        @FindBy(xpath = "/html/body/div[1]/main/div/div[1]/div/div/div[2]/div/div[1]/details[2]/div/div[1]/div/button[1]")
        public WebElement NumberOfPassengers;

    @FindBy(xpath = "/html/body/div[1]/main/div/div[1]/div/div/div[2]/div/div[1]/details[3]/summary")
    public WebElement ClassSelector;
        @FindBy(xpath = "/html/body/div[1]/main/div/div[1]/div/div/div[2]/div/div[1]/details[3]/ul/li[1]/a")
        public WebElement classType;
    //asserting a roundtrip is in order by checking the "Returning date is available"

    @FindBy(xpath = "/html/body/div[1]/main/div/div[1]/div/div/div[2]/div/form/span/div[3]/label/span")
    public WebElement returnDate;
// flight city and date details
    @FindBy(xpath = "/html/body/div[1]/main/div/div[1]/div/div/div[2]/div/form/span/div[1]/div[1]/input")
    public WebElement departingCity;
        @FindBy(xpath = "/html/body/div[1]/main/div/div[1]/div/div/div[2]/div/form/span/div[1]/div[1]/ul")
        public  WebElement departingCityCairo;
    @FindBy(xpath = "/html/body/div[1]/main/div/div[1]/div/div/div[2]/div/form/span/div[1]/div[2]/input")
    public WebElement arrivalCity;
        @FindBy(xpath = "/html/body/div[1]/main/div/div[1]/div/div/div[2]/div/form/span/div[1]/div[2]/ul/li/ul/li/a/div/div/h3")
        public  WebElement arrivalCityDubai;
    @FindBy(xpath = "/html/body/div[1]/main/div/div[1]/div/div/div[2]/div/form/span/button")
    public WebElement SearchButton;

    //xpath to the departingdate field
    @FindBy(xpath = "/html/body/div[1]/main/div/div[1]/div/div/div[2]/div/form/span/div[2]/input")
    public WebElement DepartingDateField;
    @FindBy(xpath = "/html/body/div[1]/main/div/div[1]/div/div/div[2]/div/form/span/div[2]")
    public  WebElement departingDateFrame;

    //selecting flight type (oneway , round trip , multi cities)
    public void flightType(WebDriver driver) {
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        flightTypeSelector.click();
//        FlightType.click();
        assertEquals(returnDate.getText(), "Returning");

        //selecting passenger number
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        NumberOfPassengersSelector.click();
        NumberOfPassengers.click();
        NumberOfPassengersSelector.click();

        //selecting class type (economy , first , business)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        ClassSelector.click();
        classType.click();
    }
    //setting distinations
    public void flightDistinations(WebDriver driver) {

        // entring flight details (cities )
        //choosing depart city
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        departingCity.sendKeys("Cairo");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<WebElement> DepartCityList=driver.findElements(By.xpath("/html/body/div[1]/main/div/div[1]/div/div/div[2]/div/form/span/div[1]/div[1]/ul"));
        DepartCityList.get(0).findElement(By.partialLinkText("Cairo")).click();

        //choosing arrival city
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        arrivalCity.sendKeys("dxb");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        assertTrue(arrivalCityDubai.isDisplayed());
        arrivalCityDubai.click();
        SearchButton.click();

    }
    public void flighDates(){
        DepartingDateField.sendKeys("06/15");
    }
    //constructor for this Class to enable using it in other classes
        public DartsTravellersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}

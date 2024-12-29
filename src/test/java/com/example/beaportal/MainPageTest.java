package com.example.beaportal;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
public class MainPageTest {
    private WebDriver driver;

    private MainPage mainPage;

        @BeforeMethod    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(mainPage.site);

    }

//        @AfterMethod    public void tearDown() {driver.quit();}

    @Test
    public void testingFlightCaiDxb() throws InterruptedException {
        Wait<WebDriver>wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //selecting flight type (oneway , round trip , multi cities)
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        mainPage.flightTypeSelector.click();
//        mainPage.FlightType.click();
        Select dropdown;
        //selecting passenger number
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        mainPage.NumberOfPassengersSelector.click();
        mainPage.NumberOfPassengers.click();
        mainPage.NumberOfPassengersSelector.click();

        //selecting class type (economy , first , business)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        mainPage.ClassSelector.click();
        mainPage.classType.click();

        assertTrue(mainPage.returnDate.isDisplayed());
        // entring flight details (cities )
        //choosing depart city
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        mainPage.departingCit.sendKeys("Cairo");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<WebElement> DepartCityList=driver.findElements(By.xpath("/html/body/div[1]/main/div/div[1]/div/div/div[2]/div/form/span/div[1]/div[1]/ul"));
        DepartCityList.get(0).findElement(By.partialLinkText("Cairo")).click();
        //choosing arrival city
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        mainPage.arrivalCity.sendKeys("dxb");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        assertTrue(mainPage.arrivalCityDubai.isDisplayed());
        mainPage.arrivalCityDubai.click();
        mainPage.SearchButton.click();



    }
//
//        WebElement searchPageField = driver.findElement(By.cssSelector("input[data-test='search-input']"));
//                assertEquals(searchPageField.getAttribute("value"), "Selenium");    }

//    @Test
//    public void toolsMenu() {
//        mainPage.toolsMenu.click();
//
//        WebElement menuPopup = driver.findElement(By.cssSelector("div[data-test='main-submenu']"));
//        assertTrue(menuPopup.isDisplayed());
//    }
//
//    @Test
//    public void navigationToAllTools() {
//        mainPage.seeDeveloperToolsButton.click();
//        mainPage.findYourToolsButton.click();
//
//        WebElement productsList = driver.findElement(By.id("products-page"));
//        assertTrue(productsList.isDisplayed());
//                assertEquals(driver.getTitle(), "All Developer Tools and Products by JetBrains");    }
}

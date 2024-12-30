package com.example.beaportal;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class MainPageTest {
    private WebDriver driver;

    private MainPage mainPage;
        @BeforeMethod
        public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(mainPage.site);
    }
//    @AfterMethod    public void tearDown() {driver.quit();}
    @Test
    public void regressionflight(){
            mainPage.flightType(driver);
            mainPage.flightDistinations(driver);
            mainPage.flighDates();
    }

}

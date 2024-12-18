package com.example.flairstechassistment0;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

import java.lang.String;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class MainPageTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private  WebDriverWait wait ;


    @BeforeMethod
    public void setUp() {
        long noOfSeconds = 5;
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginPage = new LoginPage(driver);

    }

//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }

    @Test(priority = 1)
    public void logIn() {
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://devs.travware.info/login");
        loginPage.loginAgent.sendKeys("devs");
//        if (loginPage.userName.isEnabled()) {loginPage.userName.sendKeys("demo");}
//        else {
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("arguments[0].removeAttribute('disabled');", loginPage.userName);
//            loginPage.userName.sendKeys("demo");
//        }
//        wait.until(ExpectedConditions.invisibilityOf(loginPage.loginForm));

        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].value='demo'", loginPage.userName);
            js.executeScript("arguments[0].value='demo'", loginPage.passWord);
            js.executeScript("arguments[0].click()", loginPage.submitButton);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("successful run baby ");
        }
        loginPage.submitButton.click();
        loginPage.submitButton.click();

//        loginPage.userName.sendKeys("demo");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

    }

}

package com.example.beautomations;

import org.testng.Assert;
import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class MainPageTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.google.com/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void titleAssert() {
        for (int i=0;i<=6;i++) {
            WebElement title = driver.findElement(By.xpath("/html/head/title"));
            Assert.assertEquals(driver.getTitle(), "Google", "title should be a match");
            System.out.println(i);
        }
    }

}

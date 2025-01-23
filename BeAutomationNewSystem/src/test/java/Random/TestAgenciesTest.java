package Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;
public class TestAgenciesTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @BeforeMethod
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @AfterMethod
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void testAgencies() {
    driver.get("https://b2e.dartstravelers.com/signin");
    driver.manage().window().setSize(new Dimension(1920, 1080));
    driver.findElement(By.name("email")).sendKeys("b2e.dartstravelers@travware.com");
    driver.findElement(By.name("password")).sendKeys("password");
    driver.findElement(By.cssSelector(".btn")).click();
    driver.findElement(By.cssSelector("div:nth-child(3) .flex .text-xs")).click();
    {
      WebElement element = driver.findElement(By.linkText("Create Agency"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    driver.findElement(By.linkText("All Agencies")).click();
    {
      WebElement element = driver.findElement(By.cssSelector("#radix-\\3Ar1\\3A > .text-primary"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.cssSelector("html")).click();
    driver.findElement(By.cssSelector(".text-red-600:nth-child(1)")).click();
    driver.findElement(By.cssSelector(".h-4")).click();
  }
}
///
//
//
//
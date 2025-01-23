package pages.BEpages;

import Utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertTrue;

import java.awt.*;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;

public class DashboardPage {
        @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div[4]/div[2]/div/table")
        public WebElement elementListDashboard;
        @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div[4]/div[1]/div[2]")
        public WebElement bookinDetailsCheckbox;
        public void logIn(WebDriver driver) throws FileNotFoundException {
                ReusableMethods reusables=new ReusableMethods(driver);
                driver.get(reusables.site);
                reusables.logIn(driver);
        }
        public void gettingElementsTest(WebDriver driver) throws FileNotFoundException, AWTException {
                ReusableMethods reusables=new ReusableMethods(driver);
                WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(4));
                wait.until(ExpectedConditions.visibilityOf(elementListDashboard));
                reusables.gettingElementsTest(driver,elementListDashboard);

        }
        public void investCheckboxBookingDetails(WebDriver driver) {

                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                assertTrue(bookinDetailsCheckbox.isDisplayed());
                List<WebElement>list1=bookinDetailsCheckbox.findElements(By.tagName("div"));
                System.out.println(list1.get(0).getText()+" "+ list1.size());

                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                assertTrue(list1.get(0).isDisplayed());
                list1.get(0).click();


                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                boolean x =list1.get(0).isSelected();
                System.out.println(x);
        }
        public DashboardPage(WebDriver driver) {
                PageFactory.initElements(driver, this);
        }
}

package pages.BEpages;

import Utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;

public class DashboardPage {
        @FindBy(xpath = "/html/body/div/div/div[2]/div[2]/div/div/div[4]/div[2]/div/table")
        public WebElement elementListDashboard;
        @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div/div[4]/div[1]/div[2]/div")
        public WebElement bookinDetailsCheckbox;


        public void logIn(WebDriver driver) throws FileNotFoundException {
                ReusableMethods reusedMethods=new ReusableMethods(driver);
                driver.get(reusedMethods.site);
                reusedMethods.logIn(driver);
        }
        public void gettingElementsTest(WebDriver driver) {

                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                assertTrue(elementListDashboard.isDisplayed());
                List<WebElement>list1=elementListDashboard.findElements(By.tagName("tr"));
                System.out.println("[ID ]"+ "[ Reference ]       "+"[ Booked By ]"+
                        "[ Total Amount ]"+"[ Phone ]"+"[ Created At ]"+"[Status ]" );
                System.out.println("------------------------------------------------------------------------------------");
                for (int i=1;i<=list1.size()-1;i++) {
                         for (int j=0;j<=6;j++){
                                System.out.print("[ "+list1.get(i).findElements(By.tagName("td")).get(j).getText()+"] |" );}
                System.out.println();
                }

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

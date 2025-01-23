package pages.RequestPackages;

import Utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;

public class CreateNewRequestPackage {
    @FindBy(css = ".bg-primary")
    public WebElement ActionsMenu;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[1]/div/div/div/div/div/div[4]/ul/li/div/div[1]/div/div[2]/h2")
    public WebElement requestPackages;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[1]/div/div/div/div/div/div[4]/ul/li/div/div[2]/div/ul/li[1]/a")
    public WebElement allPackageRequests;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[1]/div/div/div/div/div/div[4]/ul/li/div/div[2]/div/ul/li[2]/a")
    public WebElement createNewPackageRequest;
    //Basic info tab in Create new
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/div[1]/form/div[1]/div[2]/div")
    public WebElement basicInformationTabGrid;
    String[] data={"hassan","active","EGP","2000","","","","","","","","",};
    public void navigateToCreateNewPackageRequest(WebDriver driver) throws FileNotFoundException, AWTException {
        ReusableMethods reusables = new ReusableMethods(driver);
        WebElement[] navigationTabs={requestPackages,createNewPackageRequest};
        reusables.navigateToTab(navigationTabs);
    }
    public void basicInfoTab(WebDriver driver) throws FileNotFoundException, AWTException {
        Select newSelector;
        List<WebElement> temp =basicInformationTabGrid.findElements(By.tagName("div"));
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        for(int i=0;i< temp.size();i++){
            WebElement element = temp.get(i).findElement(By.tagName("label"));
            if(element.getText().equals("Name")){
                temp.get(i).findElement(By.tagName("input")).sendKeys("hassan");}

            else if(element.getText().equals("Status")){
                WebElement x =driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/div[1]/form/div[1]/div[2]/div/div[2]/select"));
                Select select=new Select(x);
                select.selectByValue("active");
            }
//            else if(temp.get(i).getText().equals("Currency")){
//                newSelector = new Select(temp.get(i).findElement(By.xpath("following-sibling::*[3]")));
//                newSelector.selectByValue("3");
//            }
//            else if(temp.get(i).getText().equals("Number of Nights")){temp.get(i).
//                    findElement(By.xpath("following-sibling::*[1]")).sendKeys("5");}
//            else if(temp.get(i).getText().equals("Number of Nights")){temp.get(i).
//                    findElement(By.xpath("following-sibling::*[1]")).sendKeys("5");}
//            else if(temp.get(i).getText().equals("Number of Nights")){temp.get(i).
//                    findElement(By.xpath("following-sibling::*[1]")).sendKeys("5");}
//            else if(temp.get(i).getText().equals("Number of Nights")){temp.get(i).
//                    findElement(By.xpath("following-sibling::*[1]")).sendKeys("5");}
//            else if(temp.get(i).getText().equals("Number of Nights")){temp.get(i).
//                    findElement(By.xpath("following-sibling::*[1]")).sendKeys("5");}
//            else if(temp.get(i).getText().equals("Number of Nights")){temp.get(i).
//                    findElement(By.xpath("following-sibling::*[1]")).sendKeys("5");}
//            else if(temp.get(i).getText().equals("Number of Nights")){temp.get(i).
//                    findElement(By.xpath("following-sibling::*[1]")).sendKeys("5");}
        }
}
    public CreateNewRequestPackage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}

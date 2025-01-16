package pages.Agencies;

import Utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.List;

public class AllAgenciesShowPage {

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div[2]/div[1]/div")
    WebElement agencyInformation;
   String[] data={"name -> ","Created by -> ","Status -> ","Created at -> ","Type -> ","E-mail -> ","Tax number -> ","Address -> "};
    public void logIn(WebDriver driver) throws FileNotFoundException, AWTException {
        AllAgenciesPage showAgency=new AllAgenciesPage(driver);
        ReusableMethods reusables =new ReusableMethods(driver);
        reusables.logIn(driver);
        showAgency.navigateToAllAgenciesTab(driver);
    }
    public void readingDataInShowPage( ){

        List<WebElement> information = agencyInformation.findElements(By.tagName("p"));
        System.out.println("the data viewed in basic information page is : \n");
        for (int i =0;i<data.length;i++){
            data[i]+=information.get(i).findElement(By.tagName("span")).getText();
            System.out.println(data[i]);
        }

    }
    public AllAgenciesShowPage(WebDriver driver) {PageFactory.initElements(driver,this);}

}

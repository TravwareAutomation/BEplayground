package com.example.beaportal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = https://www.jetbrains.com/
public class MainPage {

    public String site="https://b2c.travware.com/"

    @FindBy(xpath = "/html/body/div[1]/main/div/div[1]/div/div/div[2]/div/div[1]/details[1]/summary']")
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
        public WebElement NumberOfPassengers;

        public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}

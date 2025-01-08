package pages.Users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewUserPage {
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div[2]/form/div[1]/div[2]/div[1]/input")
    public WebElement newUserName;






    public NewUserPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}

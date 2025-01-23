package pages.Roles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class EditPage {

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div[2]")
    public WebElement permissionOptions;
    public List<WebElement> permissionList;
    public void getAllPermissions(WebDriver driver){
        permissionOptions.click();
        permissionList=permissionOptions.findElements(By.tagName("div"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println(permissionList.size());

    }

    public EditPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}

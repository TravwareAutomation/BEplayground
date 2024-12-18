package com.example.flairstechassistment0;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = https://www.jetbrains.com/
public class LoginPage {
    @FindBy(id = "Forms_Login_Agent")
    public WebElement loginAgent;
    //Username
    @FindBy(id = "user_name")
    public WebElement userName;
    @FindBy(id = "user_password")
    public WebElement passWord;
    @FindBy(id = "user_login_submit")
    public WebElement submitButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}

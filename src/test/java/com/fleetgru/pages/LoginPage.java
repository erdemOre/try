package com.fleetgru.pages;

import com.fleetgru.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "prependedInput")
    public WebElement usernameInputBox;

    @FindBy(id = "prependedInput2")
    public WebElement passwordInputBox;

    @FindBy(id = "_submit")
    public WebElement loginBtn;

    @FindBy(id = "remember_me")
    public WebElement rememberMeBtn;

    @FindBy(linkText = "Forgot your password?")
    public WebElement forgotPasswordLink;

    public void login(String username, String password){
        usernameInputBox.sendKeys(username);
        passwordInputBox.sendKeys(password);
        loginBtn.click();
    }

    @FindBy(css = ".alert.alert-error")
    public WebElement invalidCredentialErrorMsg;



}

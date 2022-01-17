package com.heartbingo.pages;

import com.aventstack.extentreports.Status;
import com.heartbingo.customelisteners.CustomListeners;
import com.heartbingo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Vimal Vithalpura
 * @project HeartBingo-Technical-Test-PageFactory
 * @created 17/01/2022
 */
public class LoginPage extends Utility {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy (xpath = "//iframe[@class='oneauth-iframe']")
    WebElement iFrame;

    @CacheLookup
    @FindBy (id = "username")
    WebElement usernameField;

    @CacheLookup
    @FindBy (id = "password")
    WebElement passwordField;

    @CacheLookup
    @FindBy (xpath = "//button[contains(text(),'Log In')]")
    WebElement loginButton;

    @CacheLookup
    @FindBy (className = "login_errorMessageWrapper__2ZcGx")
    WebElement errorMessge;

    @CacheLookup
    @FindBy (className = "login_toCenter__1zNiC")
    WebElement forgottenPassword;


    public void swithToFrame(){
        driver.switchTo().frame(iFrame);
        CustomListeners.test.log(Status.PASS,"Switch to iFrame ");
    }

    public void enterUsername(String username){
        swithToFrame();
        doSendTextToElement(usernameField, username);
        CustomListeners.test.log(Status.PASS,"Enter Username ");
    }

    public void enterPassword(String password){
        doSendTextToElement(passwordField, password);
        CustomListeners.test.log(Status.PASS,"Enter Password ");
    }

    public void clickOnLoginButton(){
        doClickOnElement(loginButton);
        CustomListeners.test.log(Status.PASS,"Click on Login button ");
    }

    public String getErrorMessageText(){
        CustomListeners.test.log(Status.PASS,"Get Error Message Text ");
        return doGetTextFromElement(errorMessge);
    }

    public String forgottenYourPasswordLink(){
        CustomListeners.test.log(Status.PASS,"Get Forgotten Password Link Text ");
        return doGetTextFromElement(forgottenPassword);
    }
}

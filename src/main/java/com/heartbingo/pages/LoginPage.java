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
    WebElement txtUsernameField;

    @CacheLookup
    @FindBy (id = "password")
    WebElement txtPasswordField;

    @CacheLookup
    @FindBy (xpath = "//button[contains(text(),'Log In')]")
    WebElement btnLoginButton;

    @CacheLookup
    @FindBy (className = "login_errorMessageWrapper__2ZcGx")
    WebElement msgErrorMessge;

    @CacheLookup
    @FindBy (className = "login_toCenter__1zNiC")
    WebElement lnkForgottenPassword;

    @CacheLookup
    @FindBy (xpath = "//button[contains(text(),'Log Out')]")
    WebElement btnLogout;

    public void swithToFrame(){
        driver.switchTo().frame(iFrame);
        CustomListeners.test.log(Status.PASS,"Switch to iFrame ");
    }

    public void enterUsername(String username){
        swithToFrame();
        doSendTextToElement(txtUsernameField, username);
        CustomListeners.test.log(Status.PASS,"Enter Username ");
    }

    public void enterPassword(String password){
        doSendTextToElement(txtPasswordField, password);
        CustomListeners.test.log(Status.PASS,"Enter Password ");
    }

    public void clickOnLoginButton(){
        doClickOnElement(btnLoginButton);
        CustomListeners.test.log(Status.PASS,"Click on Login button ");
    }

    public String getErrorMessageText(){
        CustomListeners.test.log(Status.PASS,"Get Error Message Text ");
        return doGetTextFromElement(msgErrorMessge);
    }

    public String forgottenYourPasswordLink(){
        CustomListeners.test.log(Status.PASS,"Get Forgotten Password Link Text ");
        return doGetTextFromElement(lnkForgottenPassword);
    }

    public void clickOnLogoutButton(){
        doClickOnElement(btnLogout);
        CustomListeners.test.log(Status.PASS,"Click on Logout button ");
    }
}

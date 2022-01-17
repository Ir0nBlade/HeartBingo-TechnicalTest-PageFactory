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
 * @created 16/01/2022
 */
public class HomePage extends Utility {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy (xpath = "//div[@class='bvs-site-logo']")
    WebElement heartBingoLogo;

    @CacheLookup
    @FindBy (xpath = "//a[contains(text(),'Log In')]")
    WebElement loginButton;

    @CacheLookup
    @FindBy (linkText = "Sign Up")
    WebElement signUpButton;

    @CacheLookup
    @FindBy (xpath = "//div[contains(text(),'Daily Jackpots')]")
    WebElement dailyJackpots;

    @CacheLookup
    @FindBy (xpath = "//div[contains(text(),'Hot Picks')]")
    WebElement hotPicksText;

    @CacheLookup
    @FindBy (xpath = "//span[@class='bvs-icon is-menu is-big floating-nav__header-item is-inverted']")
    WebElement menuButton;

    @CacheLookup
    @FindBy (xpath = "//button[@type='cookies-policy-button']")
    WebElement acceptCookies;

    @CacheLookup
    @FindBy (linkText = "Modern Slavery Statement")
    WebElement modernSlaveryText;

    @CacheLookup
    @FindBy (linkText = "Terms & Conditions")
    WebElement termsAndConditionsLink;


    public void verifyThatLoginButtonIsVisible(){
        verifyThatElementIsDisplayed(loginButton);
        CustomListeners.test.log(Status.PASS,"Verify login button is visible on Homepage ");
    }

    public void verifyThatSignUpButtonIsVisible(){
        verifyThatElementIsDisplayed(signUpButton);
        CustomListeners.test.log(Status.PASS,"Verify Sign-In button is visible on Homepage ");
    }

    public void clickOnLoginbutton(){
//        CustomListeners.test.log(Status.PASS,"Click on Login Button ");
        doClickOnElement(loginButton);
    }

    public void clickOnSignUpButton(){
        doClickOnElement(signUpButton);
        CustomListeners.test.log(Status.PASS,"Click on SignUp button ");
    }

    public String getdailyJackpotsText(){
        CustomListeners.test.log(Status.PASS,"Get Daily JackPot Text ");
        return doGetTextFromElement(dailyJackpots);
    }

    public String getHotPicksText(){
        CustomListeners.test.log(Status.PASS,"Get Hot Picks text ");
        return doGetTextFromElement(hotPicksText);
    }

    public void clickOnMenuButton(){
        doClickOnElement(menuButton);
        CustomListeners.test.log(Status.PASS,"Click on Menu Button ");
    }

    public void acceptCookies(){
        CustomListeners.test.log(Status.PASS,"Click Ok to accept cookies ");
        doClickOnElement(acceptCookies);
    }

    public String getMordenSlaveryStatementText(){
        CustomListeners.test.log(Status.PASS,"Get Mordern Slavery Statement Text ");
        return doGetTextFromElement(modernSlaveryText);
    }

    public void clickOnTermsAndConditonsLink(){
        doClickOnElement(termsAndConditionsLink);
        CustomListeners.test.log(Status.PASS,"Click on Terms & Conditons Link ");
    }


}

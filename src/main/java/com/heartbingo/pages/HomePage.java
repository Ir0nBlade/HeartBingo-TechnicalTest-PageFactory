package com.heartbingo.pages;

import com.aventstack.extentreports.Status;
import com.heartbingo.customelisteners.CustomListeners;
import com.heartbingo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

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
    @FindBy (xpath = "//a[contains(text(),'Log In')]")
    WebElement btnLoginButton;

    @CacheLookup
    @FindBy (xpath = "//a[contains(text(),'Sign Up')]")
    WebElement btnSignUpButton;

    @CacheLookup
    @FindBy (xpath = "//div[contains(text(),'Daily Jackpots')]")
    WebElement msgDailyJackpots;

    @CacheLookup
    @FindBy (xpath = "//div[contains(text(),'Hot Picks')]")
    WebElement msgHotPicksText;

    @CacheLookup
    @FindBy (xpath = "//span[@class='bvs-icon is-menu is-big floating-nav__header-item is-inverted']")
    WebElement btnMenuButton;

    @CacheLookup
    @FindBy (xpath = "//button[@type='cookies-policy-button']")
    WebElement btnAcceptCookies;

    @CacheLookup
    @FindBy (linkText = "Modern Slavery Statement")
    WebElement msgModernSlaveryText;

    @CacheLookup
    @FindBy (linkText = "Terms & Conditions")
    WebElement lnkTermsAndConditionsLink;

    @CacheLookup
    @FindBy (xpath = "//span[normalize-space()='Information Required - Click Here']")
    WebElement msgInformationRequired;

    public void verifyThatLoginButtonIsVisible(){
        verifyThatElementIsDisplayed(btnLoginButton);
        CustomListeners.test.log(Status.PASS,"Verify login button is visible on Homepage ");
    }

    public void verifyThatSignUpButtonIsVisible(){
        verifyThatElementIsDisplayed(btnSignUpButton);
        CustomListeners.test.log(Status.PASS,"Verify Sign-In button is visible on Homepage ");
    }

    public void clickOnLoginbutton(){
        doClickOnElement(btnLoginButton);
        CustomListeners.test.log(Status.PASS,"Click on Login Button ");
    }

    public void clickOnSignUpButton(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        doClickOnElement(btnSignUpButton);
        CustomListeners.test.log(Status.PASS,"Click on SignUp button ");
    }

    public String getdailyJackpotsText(){
        CustomListeners.test.log(Status.PASS,"Get Daily JackPot Text ");
        return doGetTextFromElement(msgDailyJackpots);
    }

    public String getHotPicksText(){
        CustomListeners.test.log(Status.PASS,"Get Hot Picks text ");
        return doGetTextFromElement(msgHotPicksText);
    }

    public void clickOnMenuButton(){
        doClickOnElement(btnMenuButton);
        CustomListeners.test.log(Status.PASS,"Click on Menu Button ");
    }

    public void acceptCookies(){
        CustomListeners.test.log(Status.PASS,"Click Ok to accept cookies ");
        doClickOnElement(btnAcceptCookies);
    }

    public String getMordenSlaveryStatementText(){
        CustomListeners.test.log(Status.PASS,"Get Mordern Slavery Statement Text ");
        return doGetTextFromElement(msgModernSlaveryText);
    }

    public void clickOnTermsAndConditonsLink() throws InterruptedException {
        Thread.sleep(1000);
        doClickOnElement(lnkTermsAndConditionsLink);
        CustomListeners.test.log(Status.PASS,"Click on Terms & Conditons Link ");
    }

    public String getInformationRequiredText() throws InterruptedException {
        Thread.sleep(1000);
        return doGetTextFromElement(msgInformationRequired);
    }
}

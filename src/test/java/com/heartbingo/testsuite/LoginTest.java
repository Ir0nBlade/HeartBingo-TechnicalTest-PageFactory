package com.heartbingo.testsuite;

import com.heartbingo.customelisteners.CustomListeners;
import com.heartbingo.pages.HomePage;
import com.heartbingo.pages.LoginPage;
import com.heartbingo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * @author Vimal Vithalpura
 * @project HeartBingo-Technical-Test-PageFactory
 * @created 17/01/2022
 */
@Listeners(CustomListeners.class)
public class LoginTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod (groups = {"sanity", "smoke", "regression"})
    public void initialize(){
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    /**
     * This Test will verify user should not login with invalid credentials
     * Verification is done by validating Error message
     *
     */
    @Test (groups = {"regression"})
    public void verifyUserShouldNotAbleToLoginWithInvalidUserName(){
        homePage.clickOnLoginbutton();
        loginPage.enterUsername(doGetRandomEmail());
        loginPage.enterPassword(doGetRandomString(9));
        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getErrorMessageText(),"The username or password you entered is incorrect. Please try again.");
        Assert.assertEquals(loginPage.forgottenYourPasswordLink(),"Forgotten your Password!");
    }

}

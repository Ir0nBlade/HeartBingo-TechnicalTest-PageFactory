package com.heartbingo.testsuite;

import com.heartbingo.customelisteners.CustomListeners;
import com.heartbingo.pages.HomePage;
import com.heartbingo.pages.LoginPage;
import com.heartbingo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import resources.testdata.TestData;

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
     * DataProvider used to get multiple sets of data
     * Verification is done by validating Error message
     *
     */
    @Test (priority = 0, groups = {"smoke"}, dataProvider = "Credentials", dataProviderClass = TestData.class)
    public void verifyUserShouldNotAbleToLoginWithInvalidUserName(String username, String password){
        homePage.clickOnLoginbutton();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getErrorMessageText(),"The username or password you entered is incorrect. Please try again.");
        Assert.assertEquals(loginPage.forgottenYourPasswordLink(),"Forgotten your Password?");
    }

    /**
     * This Test will verify user should login with valid credential
     * Parameters for email and password is passed into LoginTest.xml file
     *
     */
    @Test (priority = 1, groups = {"regression"})
    @Parameters({"email", "password"})
    public void verifyUserShouldLoginWithValidCredentials(String email, String password) throws InterruptedException {
        homePage.clickOnLoginbutton();
        loginPage.enterUsername(email);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
        Assert.assertEquals(homePage.getInformationRequiredText(),"Information Required - Click Here");
    }

}

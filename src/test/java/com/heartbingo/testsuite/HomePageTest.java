package com.heartbingo.testsuite;

import com.heartbingo.customelisteners.CustomListeners;
import com.heartbingo.pages.HomePage;
import com.heartbingo.pages.TermsAndconditonsPage;
import com.heartbingo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * @author Vimal Vithalpura
 * @project HeartBingo-Technical-Test-PageFactory
 * @created 16/01/2022
 */
@Listeners(CustomListeners.class)
public class HomePageTest extends TestBase {

    HomePage homePage;
    TermsAndconditonsPage termsAndconditonsPage;

    @BeforeMethod (groups = {"sanity", "smoke", "regression"})
    public void initialize(){
        homePage = new HomePage();
        termsAndconditonsPage = new TermsAndconditonsPage();
    }

    /**
     * This Test will verify that user should navigate to homepage successfully
     *  Verification is done by validating if elements are dislplayed on homepage
     *
     */
    @Test (priority=0, groups={"sanity", "regression"})
    public void verifyUserShouldNavigateToHomePageSuccessfully(){
        homePage.acceptCookies();
        homePage.verifyThatLoginButtonIsVisible();
        homePage.verifyThatSignUpButtonIsVisible();
        Assert.assertEquals(homePage.getHotPicksText(),"Hot Picks");
        Assert.assertEquals(homePage.getdailyJackpotsText(),"Daily Jackpots");
    }

    /**
     * This Test will verify that user should navigate to menu and click on The Terms & Conditons link
     * And verify Terms & condition visible on Terms and condition page
     */
    @Test (priority=1, groups={"smoke", "regression"})
    public void verifyUsershouldNavigateToTermsAndConditons(){
        homePage.acceptCookies();
        homePage.clickOnMenuButton();
        Assert.assertEquals(homePage.getMordenSlaveryStatementText(),"Modern Slavery Statement");
        homePage.clickOnTermsAndConditonsLink();
        Assert.assertEquals(termsAndconditonsPage.getCustomerTermsAndConditionText(),"Heart Bingo CUSTOMERS - TERMS AND CONDITIONS");


    }
}

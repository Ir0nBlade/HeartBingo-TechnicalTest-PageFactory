package com.heartbingo.testsuite;

import com.heartbingo.customelisteners.CustomListeners;
import com.heartbingo.pages.HomePage;
import com.heartbingo.pages.LoginPage;
import com.heartbingo.pages.SignUpPage;
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
public class SignUpTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;
    SignUpPage signUpPage;

    @BeforeMethod (groups = {"sanity", "smoke", "regression"})
    public void initialize(){
        homePage = new HomePage();
        loginPage = new LoginPage();
        signUpPage = new SignUpPage();
    }


    /**
     *  This test will verify User should navigate to Sign Up page successfully
     *  Verification is done by validating "Enter your full name to join Heart Bingo" on Sign Up page
     *
     */
    @Test (priority=0, groups={"smoke", "regression"})
    public void verifyUserNavigateToSignUpPageSuccessfully(){
        homePage.clickOnSignUpButton();
        Assert.assertEquals(signUpPage.getJoinHeartBingoText(),"Enter your full name to join Heart Bingo");
    }


    /**
     *  This test will verify First Name and Last Name field should not be null on Sign Up page
     *  Verification is done by validating Error message
     *
     */
    @Test (priority=1, groups={"sanity", "regression"})
    public void verifyFirstNameAndLastNameFieldShouldNotBeNull(){
        homePage.clickOnSignUpButton();
        signUpPage.clickOnContinueButton();
        Assert.assertEquals(signUpPage.getFirstNameNullErrorMessage(),"You must provide your first name");
        Assert.assertEquals(signUpPage.getSurnameNullErrorMessage(),"You must provide your surname");
    }

    /**
     *  This test verify User should able to Sign Up by entering mandatory details
     *
     */
    @Test (priority=2, groups={"regression"})
    public void verifyUserShouldAbleToSignUpByEnteringMandatoryDetails(){
        homePage.clickOnSignUpButton();
        signUpPage.enterFirstName("Alan");
        signUpPage.enterLastName("Johnson");
        signUpPage.clickOnContinueButton();
        signUpPage.selectGender("Male");
        signUpPage.enterEmailAddress(doGetRandomEmail());
        signUpPage.enterPassword(getRandomString(15));
        signUpPage.enterMobileNumber("7912457832");
        Assert.assertEquals(signUpPage.getAgeWarningText(),"You must be over the age of 18 to proceed");
        signUpPage.selectDayMonthYearForDateOfBirth("1","November", "1982");
        signUpPage.enterAddressDetails("10 Downland Drive", "London", "SE10 0NY");
        signUpPage.doClickOnContinueButton();
        signUpPage.selectCurrency("GBP");
        signUpPage.selectExclusiveOffers("No");
        signUpPage.clickTermsAndConditionCheckbox();
        signUpPage.clickOnCreateAccountButton();
        signUpPage.clickOncloseButton();
    }
}

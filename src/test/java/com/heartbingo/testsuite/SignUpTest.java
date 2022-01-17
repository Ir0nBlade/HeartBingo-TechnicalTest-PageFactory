package com.heartbingo.testsuite;

import com.heartbingo.pages.HomePage;
import com.heartbingo.pages.LoginPage;
import com.heartbingo.pages.SignUpPage;
import com.heartbingo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Vimal Vithalpura
 * @project HeartBingo-Technical-Test-PageFactory
 * @created 17/01/2022
 */
public class SignUpTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;
    SignUpPage signUpPage;

    @BeforeMethod
    public void initialize(){
        homePage = new HomePage();
        loginPage = new LoginPage();
        signUpPage = new SignUpPage();
    }

    @Test
    public void verifyUserNavigateToSignUpPageSuccessfully(){
        homePage.clickOnSignUpButton();
        Assert.assertEquals(signUpPage.getJoinHeartBingoText(),"Enter your full name to join Heart Bingo");
    }

    @Test
    public void verifyFirstNameAndLastNameFieldShouldNotBeNull(){
        homePage.clickOnSignUpButton();
        signUpPage.clickOnContinueButton();
        Assert.assertEquals(signUpPage.getFirstNameNullErrorMessage(),"You must provide your first name");
        Assert.assertEquals(signUpPage.getSurnameNullErrorMessage(),"You must provide your surname");
    }

    @Test
    public void verifyUserShouldAbleToSignUpByEnteringMandatoryDetails(){
        homePage.clickOnSignUpButton();
        signUpPage.enterFirstName("Alan");
        signUpPage.enterLastName("Johnson");
        signUpPage.clickOnContinueButton();
        signUpPage.selectGender("Male");
        signUpPage.enterEmailAddress(doGetRandomEmail());
        signUpPage.enterPassword(getRandomString(10));
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

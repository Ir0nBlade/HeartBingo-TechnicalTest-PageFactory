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
 * @created 17/01/2022
 */
public class SignUpPage extends Utility {

    public SignUpPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy (id = "first_name")
    WebElement firstNameField;

    @CacheLookup
    @FindBy (id = "last_name")
    WebElement lastNameField;

    @CacheLookup
    @FindBy (xpath = "//span[contains(text(),'You must provide your first name')]")
    WebElement firstNameErrorMessage;

    @CacheLookup
    @FindBy (xpath = "//span[contains(text(),'You must provide your surname')]")
    WebElement surnameErrorMessage;

    @CacheLookup
    @FindBy (css = ".regpath__button-next-text")
    WebElement continueButton;

    @CacheLookup
    @FindBy (xpath = "//p[contains(text(),'Enter your full name to join Heart Bingo')]")
    WebElement joinHeartBingoText;

    @CacheLookup
    @FindBy (css = "label[for='account_gender_male']")
    WebElement genderMale;

    @CacheLookup
    @FindBy (className = "bvs-button-card-alternative")
    WebElement gender;

    @CacheLookup
    @FindBy (id = "regpath_form_email_input")
    WebElement emailField;

    @CacheLookup
    @FindBy (id = "password")
    WebElement passwordField;

    @CacheLookup
    @FindBy (name = "phone_number")
    WebElement mobileNumberField;

    @CacheLookup
    @FindBy (xpath = "//p[contains(text(),'You must be over the age of 18 to proceed')]")
    WebElement ageWarningText;

    @CacheLookup
    @FindBy (xpath = "//select[@name='day']")
    WebElement dobDay;

    @CacheLookup
    @FindBy (xpath = "//select[@name='month']")
    WebElement dobMonth;

    @CacheLookup
    @FindBy (xpath = "//select[@name='year']")
    WebElement dobYear;

    @CacheLookup
    @FindBy (id = "address1")
    WebElement address1Field;

    @CacheLookup
    @FindBy (id = "city")
    WebElement cityField;

    @CacheLookup
    @FindBy (id = "postcode")
    WebElement postcodeField;

    @CacheLookup
    @FindBy (xpath = "//span[contains(text(),'Continue')]")
    WebElement getContinueButton;

    @CacheLookup
    @FindBy (xpath = "//div[@class='account-form__circle-selector']")
    WebElement selectCurrency;

    @CacheLookup
    @FindBy (xpath = "//button[@class='bvs-button-alternative is-round is-secondary account-box']")
    WebElement selectExclusiveOffers;

    @CacheLookup
    @FindBy (xpath = "//div[@class='bvs-checkbox-card__checkbox']")
    WebElement checkbox;

    @CacheLookup
    @FindBy (xpath = "//button[@type='submit']")
    WebElement createAccountButton;

    @CacheLookup
    @FindBy (xpath = "//span[@class='bvs-icon is-big is-cross is-inverted']")
    WebElement closeButton;

    @CacheLookup
    @FindBy (partialLinkText = "Welcome")
    WebElement welcomemessage;

    public String getJoinHeartBingoText(){
        CustomListeners.test.log(Status.PASS,"Get text from Join Heart Bingo ");
        return doGetTextFromElement(joinHeartBingoText);
    }

    public void enterFirstName(String firstName){
        doSendTextToElement(firstNameField, firstName);
        CustomListeners.test.log(Status.PASS,"Enter First Name ");
    }

    public void enterLastName(String lastName){
        doSendTextToElement(lastNameField, lastName);
        CustomListeners.test.log(Status.PASS,"Enter Last Name ");
    }

    public String getFirstNameNullErrorMessage(){
        CustomListeners.test.log(Status.PASS,"Get Error message for Null first name ");
        return doGetTextFromElement(firstNameErrorMessage);
    }

    public String getSurnameNullErrorMessage(){
        CustomListeners.test.log(Status.PASS,"Get Error message for Null Last Name ");
        return doGetTextFromElement(surnameErrorMessage);
    }

    public void clickOnContinueButton(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        doClickOnElement(continueButton);
        CustomListeners.test.log(Status.PASS,"Click on Continue button ");
    }

    public void selectGender(String gen){
        doclickOnElement(gender, gen);
    }

    public void enterEmailAddress(String email){
        doSendTextToElement(emailField, email);
    }

    public void enterPassword(String password){
        doSendTextToElement(passwordField, password);
    }

    public void enterMobileNumber(String mobile){
        doSendTextToElement(mobileNumberField, mobile);
    }

    public String getAgeWarningText(){
        return doGetTextFromElement(ageWarningText);
    }

    public void selectDayMonthYearForDateOfBirth(String day, String month, String year){
        doSelectByVisibleTextFromDropDown(dobDay, day);
        doSelectByVisibleTextFromDropDown(dobMonth, month);
        doSelectByVisibleTextFromDropDown(dobYear, year);
    }

    public void enterAddressDetails(String address1, String city, String postcode){
        doSendTextToElement(address1Field, address1);
        doSendTextToElement(cityField, city);
        doSendTextToElement(postcodeField, postcode);
    }

    public void doClickOnContinueButton(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        doClickOnElement(getContinueButton);
    }

    public void selectCurrency(String currency){
        doclickOnElement(selectCurrency, currency);
    }

    public void selectExclusiveOffers(String yesOrNo){
        doclickOnElement(selectExclusiveOffers, yesOrNo);
    }

    public void clickTermsAndConditionCheckbox(){
        doClickOnElement(checkbox);
    }

    public void clickOnCreateAccountButton(){
        doClickOnElement(createAccountButton);
    }
    public void clickOncloseButton(){
        doClickOnElement(closeButton);
    }

    public String getWelcomeMessage(){
        return doGetTextFromElement(welcomemessage);
    }
}
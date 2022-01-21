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
public class SignUpPage extends Utility {

    public SignUpPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy (id = "first_name")
    WebElement txtFirstNameField;

    @CacheLookup
    @FindBy (id = "last_name")
    WebElement txtLastNameField;

    @CacheLookup
    @FindBy (xpath = "//span[contains(text(),'You must provide your first name')]")
    WebElement msgFirstNameErrorMessage;

    @CacheLookup
    @FindBy (xpath = "//span[contains(text(),'You must provide your surname')]")
    WebElement msgSurnameErrorMessage;

    @CacheLookup
    @FindBy (css = ".regpath__button-next-text")
    WebElement btnContinueButton;

    @CacheLookup
    @FindBy (xpath = "//p[contains(text(),'Enter your full name to join Heart Bingo')]")
    WebElement msgJoinHeartBingoText;

    @CacheLookup
    @FindBy (className = "bvs-button-card-alternative")
    WebElement btnGender;

    @CacheLookup
    @FindBy (id = "regpath_form_email_input")
    WebElement txtEmailField;

    @CacheLookup
    @FindBy (id = "password")
    WebElement txtPasswordField;

    @CacheLookup
    @FindBy (name = "phone_number")
    WebElement txtMobileNumberField;

    @CacheLookup
    @FindBy (xpath = "//p[contains(text(),'You must be over the age of 18 to proceed')]")
    WebElement txtAgeWarningText;

    @CacheLookup
    @FindBy (xpath = "//select[@name='day']")
    WebElement drpDobDay;

    @CacheLookup
    @FindBy (xpath = "//select[@name='month']")
    WebElement drpDobMonth;

    @CacheLookup
    @FindBy (xpath = "//select[@name='year']")
    WebElement drpDobYear;

    @CacheLookup
    @FindBy (id = "address1")
    WebElement txtAddress1Field;

    @CacheLookup
    @FindBy (id = "city")
    WebElement txtCityField;

    @CacheLookup
    @FindBy (id = "postcode")
    WebElement txtPostcodeField;

    @CacheLookup
    @FindBy (xpath = "//span[contains(text(),'Continue')]")
    WebElement btnGetContinueButton;

    @CacheLookup
    @FindBy (xpath = "//div[@class='account-form__circle-selector']")
    WebElement btnCurrency;

    @CacheLookup
    @FindBy (xpath = "//button[@class='bvs-button-alternative is-round is-secondary account-box']")
    WebElement chkSelectExclusiveOffers;

    @CacheLookup
    @FindBy (xpath = "//div[@class='bvs-checkbox-card__checkbox']")
    WebElement chkCheckbox;

    @CacheLookup
    @FindBy (xpath = "//button[@type='submit']")
    WebElement btnCreateAccountButton;

    @CacheLookup
    @FindBy (xpath = "//span[@class='bvs-icon is-big is-cross is-inverted']")
    WebElement btnCloseButton;


    public String getJoinHeartBingoText(){
        CustomListeners.test.log(Status.PASS,"Get text from Join Heart Bingo ");
        return doGetTextFromElement(msgJoinHeartBingoText);
    }

    public void enterFirstName(String firstName){
        doSendTextToElement(txtFirstNameField, firstName);
        CustomListeners.test.log(Status.PASS,"Enter First Name ");
    }

    public void enterLastName(String lastName){
        doSendTextToElement(txtLastNameField, lastName);
        CustomListeners.test.log(Status.PASS,"Enter Last Name ");
    }

    public String getFirstNameNullErrorMessage(){
        CustomListeners.test.log(Status.PASS,"Get Error message for Null first name ");
        return doGetTextFromElement(msgFirstNameErrorMessage);
    }

    public String getSurnameNullErrorMessage(){
        CustomListeners.test.log(Status.PASS,"Get Error message for Null Last Name ");
        return doGetTextFromElement(msgSurnameErrorMessage);
    }

    public void clickOnContinueButton(){
        doClickOnElement(btnContinueButton);
        CustomListeners.test.log(Status.PASS,"Click on Continue button ");
    }

    public void selectGender(String gen){
        doclickOnElement(btnGender, gen);
        CustomListeners.test.log(Status.PASS,"Click on Gender Male or Female ");
    }

    public void enterEmailAddress(String email){
        doSendTextToElement(txtEmailField, email);
        CustomListeners.test.log(Status.PASS,"Enter email address into email field ");
    }

    public void enterPassword(String password){
        doSendTextToElement(txtPasswordField, password);
        CustomListeners.test.log(Status.PASS,"Enter password into password field ");
    }

    public void enterMobileNumber(String mobile){
        doSendTextToElement(txtMobileNumberField, mobile);
        CustomListeners.test.log(Status.PASS,"Enter Mobile number ");
    }

    public String getAgeWarningText(){
        CustomListeners.test.log(Status.PASS,"Get text for Age warning message ");
        return doGetTextFromElement(txtAgeWarningText);
    }

    public void selectDayMonthYearForDateOfBirth(String day, String month, String year){
        doSelectByVisibleTextFromDropDown(drpDobDay, day);
        CustomListeners.test.log(Status.PASS,"Select Day from dropdown for Date of Birth ");
        doSelectByVisibleTextFromDropDown(drpDobMonth, month);
        CustomListeners.test.log(Status.PASS,"Select Month from dropdown for Date of Birth ");
        doSelectByVisibleTextFromDropDown(drpDobYear, year);
        CustomListeners.test.log(Status.PASS,"Select Year from dropdown for Date of Birth ");
    }

    public void enterAddressDetails(String address1, String city, String postcode){
        doSendTextToElement(txtAddress1Field, address1);
        CustomListeners.test.log(Status.PASS,"Enter address line 1 in address field ");
        doSendTextToElement(txtCityField, city);
        CustomListeners.test.log(Status.PASS,"Enter City into City field ");
        doSendTextToElement(txtPostcodeField, postcode);
        CustomListeners.test.log(Status.PASS,"Enter postcode into Postcode field ");
    }

    public void doClickOnContinueButton()  {
        doClickOnElement(btnGetContinueButton);
        CustomListeners.test.log(Status.PASS,"Click on Continue button ");
    }

    public void selectCurrency(String currency){
        doclickOnElement(btnCurrency, currency);
        CustomListeners.test.log(Status.PASS,"Select Currency GBP or EUR ");
    }

    public void selectExclusiveOffers(String yesOrNo){
        doclickOnElement(chkSelectExclusiveOffers, yesOrNo);
        CustomListeners.test.log(Status.PASS,"Select Yes or No option for Exclusive offers ");
    }

    public void clickTermsAndConditionCheckbox(){
        doClickOnElement(chkCheckbox);
        CustomListeners.test.log(Status.PASS,"Click on checkbox for accepting Terms and Conditions ");
    }

    public void clickOnCreateAccountButton(){
        doClickOnElement(btnCreateAccountButton);
        CustomListeners.test.log(Status.PASS,"Click on Create Account button ");
    }
    public void clickOncloseButton(){
        doClickOnElement(btnCloseButton);
        CustomListeners.test.log(Status.PASS,"Click on Close Icon ");
    }
}

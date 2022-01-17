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
public class TermsAndconditonsPage extends Utility {

    public TermsAndconditonsPage() {
        PageFactory.initElements(driver, this);
    }


    @CacheLookup
    @FindBy(tagName = "strong")
    WebElement termsAndConditionsText;


    public String getCustomerTermsAndConditionText(){
        CustomListeners.test.log(Status.PASS,"Get Terms & Conditons Text ");
        return doGetTextFromElement(termsAndConditionsText);
    }
}

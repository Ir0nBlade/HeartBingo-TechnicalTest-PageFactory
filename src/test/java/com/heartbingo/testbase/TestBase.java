package com.heartbingo.testbase;

import com.heartbingo.propertyreader.PropertyReader;
import com.heartbingo.utility.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * @author Vimal Vithalpura
 * @project HeartBingo-Technical-Test-PageFactory
 * @created 16/01/2022
 */
public class TestBase extends Utility {

    String browser = PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod(groups = {"sanity", "smoke", "regression"})
    public void setUp(){
        selectBrowser(browser);
    }

    @AfterMethod(groups = {"sanity", "smoke", "regression"})
    public void tearDown(){
        closeBrowser();
    }
}

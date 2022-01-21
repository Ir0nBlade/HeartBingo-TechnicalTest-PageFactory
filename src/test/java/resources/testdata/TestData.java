package resources.testdata;

import com.heartbingo.utility.Utility;
import org.testng.annotations.DataProvider;

/**
 * @author Vimal Vithalpura
 * @project HeartBingo-Technical-Test-PageFactory
 * @created 16/01/2022
 */
public class TestData extends Utility {

    @DataProvider(name= "Credentials")
    public Object[] getData(){
        String[][] data = new String[][]{
                {"abc.123@gmail.com", "getRagi321741"},
                {"abcd@gmail.com", "lkjuio3258"},
                {"adfdfgfg", "12345678"}
        };
        return data;
    }
}

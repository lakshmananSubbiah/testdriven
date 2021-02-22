package lakshman.testdriven;


import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import lakshman.testdriven.App;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void firstCaseEmptyString(){
    	assertThat(App.processNumber(""),equalTo(0));
    }
    
    @Test
    public void secondCaseNullString() {
    	assertThat(App.processNumber(null),equalTo(0));
    }
}

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
    
    @Test
    public void testWithNumber1() {
    	assertThat(App.processNumber("1"),equalTo(1));
    }
    
    @Test
    public void testWithNumber2() {
    	assertThat(App.processNumber("100"),equalTo(100));
    }
    
    @Test
    public void thirdCaseTwoNumbersSeparatedByComma() {
    	assertThat(App.processNumber("1,2"),equalTo(3));
    }
    
    @Test
    public void fourthCaseUnknownAmountOfNumbers() {
    	assertThat(App.processNumber("1,2,3,4"),equalTo(10));
    }
    
    @Test
    public void fourthCaseUnknownAmountOfNumbers2() {
    	assertThat(App.processNumber("1,2,3,4,5"),equalTo(15));
    }
    
    @Test
    public void fourthCaseUnknownAmountOfNumbers3() {
    	assertThat(App.processNumber("30,50,59"),equalTo(139));
    }
    
    
}

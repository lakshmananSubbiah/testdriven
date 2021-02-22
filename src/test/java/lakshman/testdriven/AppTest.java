package lakshman.testdriven;


import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

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
    
    @Test
    public void fifthCaseNewLineBetweenNumbers() {
    	assertThat(App.processNumber("1\n2,3"),equalTo(6));
    }
    
    @Test
    public void sixthCaseChangeDelimiter() {
    	assertThat(App.processNumber("//;\n1;2"),equalTo(3));
    }
    
    
    @Test
    public void sixthCaseChangeDelimiter2() {
    	assertThat(App.processNumber("//-15-34-50"),equalTo(99));
    }
    
    @Test
    public void seventhCaseNegativeNumbers() {
    	try {
    		App.processNumber("1,2,-3");
    		fail("it should not be passed");
    	}
    	catch(NumberFormatException e) {
    		assertThat(e.getMessage(),equalTo("negatives not allowed [-3]"));
    	}
    }
    
    @Test
    public void eigthCaseMultipleNegativeNumbers() {
    	try {
    		App.processNumber("1,2,-3,-5");
    		fail("it should not be passed");
    	}
    	catch(NumberFormatException e) {
    		assertThat(e.getMessage(),equalTo("negatives not allowed [-3, -5]"));
    	}
    }
    
    @Test
    public void ninthCaseGetAddCount() {
    	App.processNumber("1,2,3");
    	assertThat(App.getCount(),equalTo(3));
    }
    
    @Test
    public void ninthCaseGetAddCount2() {
    	App.processNumber("//;\n1;2");
    	assertThat(App.getCount(),equalTo(2));
    }
    
    @Test
    public void ignoreNumbersGreaterThanThousand() {
    	assertThat(App.processNumber("1,1001"),equalTo(1));
    }
    
    @Test
    public void tenthCasemultipleDelimiter() {
    	assertThat(App.processNumber("//[***]\n1***2***3"),equalTo(6));
    }
    
    @Test
    public void multipleDelimitersCase() {
    	assertThat(App.processNumber("//[***][%%]\n1***2***3%%4"),equalTo(10));
    }
}

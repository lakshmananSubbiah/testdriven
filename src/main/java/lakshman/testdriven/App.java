package lakshman.testdriven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       System.out.println("Enter the number string");
       try {
    	   String numberString = br.readLine();
    	   System.out.println(processNumber(numberString));
       }
       catch(IOException ioe) {
    	   ioe.printStackTrace();
       }
    }

	static char[] processNumber(String numberString) {
		// TODO Auto-generated method stub
		return null;
	}
}

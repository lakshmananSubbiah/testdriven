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

	static Integer processNumber(String numberString) {
		if(numberString==null || numberString.equals("")) {
			return 0;
		}
		else {
			
			if(numberString.contains(",")) {
				int sum = 0;
				String[] split = numberString.split(",");
				sum = Integer.parseInt(split[0])+Integer.parseInt(split[1]);
				return sum;
			}
			else {
				return Integer.parseInt(numberString);
			}
		}
	}
}

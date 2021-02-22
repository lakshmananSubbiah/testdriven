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
			char splitter = ',';
			if(numberString.startsWith("//")) {
				splitter = numberString.charAt(2);
				numberString = numberString.substring(3);
			}
			int sum = 0;
			String[] split = numberString.split(splitter+"|\n");
			for(String sp: split) {
				if(!sp.isEmpty()) {
					Integer num = Integer.parseInt(sp);
					if(num<0) {
						throw new NumberFormatException("negatives not allowed "+num);
					}
					sum+=num;
				}
			}
			return sum;
		}
	}
}

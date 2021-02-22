package lakshman.testdriven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
	
	private static int count = 0;
	
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
		count = 0;
		if(numberString==null || numberString.equals("")) {
			return 0;
		}
		else {
			String splitter = ",";
			if(numberString.startsWith("//")) {
				if(numberString.contains("[")) {
					splitter = numberString.substring(3,numberString.indexOf("]"));
					numberString = numberString.substring(numberString.indexOf("]")+1);
					StringBuilder sb = new StringBuilder();
					for(char c: splitter.toCharArray()) {
						if(c == '*') {
							sb.append('\\');
							sb.append('*');
						}
						else {
							sb.append(c);
						}
					}
					splitter = sb.toString();
				}
				else {
					splitter = numberString.substring(2, 3);
					numberString = numberString.substring(3);
				}
			}
			boolean flag = false;
			List<Integer> negativeNums = new ArrayList<Integer>();
			int sum = 0;
			String[] split = numberString.split(splitter+"|\n");
			for(String sp: split) {
				if(!sp.isEmpty()) {
					Integer num = Integer.parseInt(sp);
					if(num<0) {
						flag = true;
						negativeNums.add(num);
					}
					else if(num>1000) {
						continue;
					}
					sum+=num;
					count++;
				}
			}
			if(flag) {
				throw new NumberFormatException("negatives not allowed "+negativeNums);
			}
			return sum;
		}
	}
	
	public static int getCount() {
		return count;
	}
	
}

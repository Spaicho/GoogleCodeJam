package gcj2017.round_0.b_tidy_numbers.submissions;
import java.util.*;
import java.io.*;

public class TidyNumbers_0 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		try {
////			System.setIn(new FileInputStream("TidyNumbers\\input.txt"));
//			System.setIn(new FileInputStream("TidyNumbers\\B-small-attempt1.in"));
//			//System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("output.txt"))));
//	
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int ind = 1; ind <= t; ++ind) {
		  long n = in.nextLong();
		  char[] arr = ("" + n).toCharArray();
		  int len = arr.length;
		  
		  if(len==1){
			  System.out.println("Case #" + ind + ": " + new String(arr));
			  continue;
		  }
		  
		  for(int i = len -1; i>0; i--){
			  if(arr[i]<arr[i-1] || arr[i]=='0'){
				  for(int j=i;j<len;j++){
					  arr[j] = '9';
				  }
				  
				  minusOne(arr,i-1);
			  }
		  }
		  if (arr[0]=='0'){
			  arr[0]=' ';
		  }
		  System.out.println("Case #" + ind + ": " + new String(arr).trim());
		}
	      
	}

	private static void minusOne(char[] arr, int i) {

		if(arr[i]=='0' && i>0){
			arr[i] ='9';
			minusOne(arr,i-1);
		} else {
			int c = Character.getNumericValue(arr[i]) -1;
			arr[i] = (""+c).charAt(0);
		}
	}

}

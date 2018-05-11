package round_1b.a_steed_2_cruise_control.submissions;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ProblemOne {

	  public static void main(String[] args) {
		  
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		    
		for (int i = 0; i < t; ++i) {
		    int d = in.nextInt();
		    int n = in.nextInt();
		    
		    double max=0;
			for (int j = 0; j < n; ++j) {
				int k = in.nextInt();
			    double s = in.nextInt();
			    max = Math.max(max,(d- k)/s);
			}
			double r = d/max;
  
			System.out.println("Case #" + (i+1) + ": " + r);

	    }
		      
	  }

}

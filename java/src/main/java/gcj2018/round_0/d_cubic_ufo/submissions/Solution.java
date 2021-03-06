package round_0.d_cubic_ufo.submissions;

import java.util.*;
import java.io.*;

public class Solution {
	
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      double a = in.nextDouble();
      
      double hi = 1.414213d;
      double lo = 1.000000d;
      
      double lv = 0.5d;
      double hv= 0.3535533905932738d;
    
	  if(Math.abs(a-lo)<=0.00001){
	      System.out.println("Case #" + i + ": ");
	      System.out.println(lv +" " + 0 + " "+ 0);
	      System.out.println(0 +" " + lv + " "+ 0);
	      System.out.println(0 +" " + 0 + " "+ lv);
	      break;
	  }
	  if(Math.abs(a-hi)<=0.00001){
	      System.out.println("Case #" + i + ": ");
	      System.out.println(hv +" " + hv + " "+ 0);
	      System.out.println((-hv) +" " + hv + " "+ 0);
	      System.out.println(0 +" " + 0 + " "+ lv);
	      break;
	  }
      
	  double x;
	  double v;
	  double y;
      while(true){
    	   x = hi+lo;
    	   x = x/2;
    	   v = lv+hv;
    	   v = v/2;
    	    y = a - x;
    	  if(Math.abs(y)<=0.00001){
    	      System.out.println("Case #" + i + ": ");
    	      System.out.println(v +" " + v + " "+ 0);
    	      System.out.println((-v) +" " + v + " "+ 0);
    	      System.out.println(0 +" " + 0 + " "+ lv);
    	      break;
    	  } else if(y < 0){
    		  hi = x;
    		  hv = v;
    	  } else {
    	
    		  lo = x; 
    		  lv = v;
    	  }
      }

    }
  }
}

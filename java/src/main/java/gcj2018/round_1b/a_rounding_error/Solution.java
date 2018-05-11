package round_1b.a_rounding_error;

import java.util.*;
import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution {
	
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int tt = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    
    int scale = 20;
    for (int t = 1; t <= tt; ++t) {
      int n = in.nextInt();
      int l = in.nextInt();
      
	  //System.err.println();
	  //System.err.println(1+"/"+n);

      // Get 1 part decimal
      BigDecimal r1 = new BigDecimal(100).divide(new BigDecimal(n),scale,RoundingMode.HALF_UP);
	  //System.err.println(r1);

	  //may be use big integer
      long r1i = r1.longValue();

      BigDecimal r1f = r1.subtract(new BigDecimal(r1i));

	  //System.err.println(r1f);
	  
	  BigDecimal rr1f = new BigDecimal(r1f.toString());
	  
	  int ii = 1;
	  while(rr1f.compareTo(new BigDecimal(0.5d))<0 
			  && rr1f.compareTo(BigDecimal.ZERO) !=0){
		  rr1f = rr1f.add(r1f);
	      long rr1i = rr1f.longValue();
	      rr1f = rr1f.subtract(new BigDecimal(rr1i));
	      ii++;
	  }
	  //System.err.println(ii + " to get to :" +rr1f);


	  int currMax = 0;
	  int sumC = 0;
	  ArrayList<Integer> list = new ArrayList<Integer>();
	  
      for (int i = 0; i < l; ++i) {
          long c = in.nextInt();
          sumC+=c;
          long roundc = 0;
          BigDecimal r2 = new BigDecimal(c*100).divide(new BigDecimal(n),scale,RoundingMode.HALF_UP);

          long r2i = r2.longValue();
          BigDecimal r2f = r2.subtract(new BigDecimal(r2i));
          if(r2f.compareTo(new BigDecimal(0.5d))>=0)
        	  roundc = r2i +1;
          else{
        	  roundc = r2i;
        	  if(r2f.compareTo(BigDecimal.ZERO)!=0d){
	        	  int hm = 0;
	        	  BigDecimal rr2f = new BigDecimal(r2f.toString());
	        	  while(rr2f.compareTo(new BigDecimal(0.5d))<0){
	        		  rr2f =rr2f.add(r1f);
	        	      long rr2i = rr2f.longValue();
	        	      rr2f = rr2f.subtract(new BigDecimal(rr2i));
	        	      hm++;
	        	  }
	        	  if(hm<=ii){
	        		  list.add(hm);
	        		  //System.err.println("list item :"+list.size() + ":"+hm);

	        	  }
        	  }
          }

          currMax += roundc;
      }
      
      if(r1f.compareTo(BigDecimal.ZERO)==0){
    	  System.out.println("Case #" + t + ": "+100);
    	  continue;
      } else if(r1f.compareTo(new BigDecimal(0.5d))>=0){
    	  long max = currMax + (n - sumC)*(r1i+1);
    	  System.out.println("Case #" + t + ": "+max);
    	  continue;
      }

      int rem = n - sumC;
	  //System.err.println("currentMax :"+currMax + " rem before:"+rem);

      Collections.sort(list);
      for(int j : list){
    	  
    	  if(rem>=j){
    		  rem -= j;
    		  currMax += (r1i*j)+1;
    	  } else
    		  break;
    	  
      }
	  //System.err.println("currentMax after list:"+currMax);// + " rem :"+rem);

	  int nb = rem/ii;
	  
	  //System.err.println("rem :"+rem);
	  //System.err.println("nb  :"+nb);
	  rem = rem%ii;

	  //System.err.println("rem :"+rem);


      //currMax+=(rem/ii)*(r1i+1);
      //currMax+=nb*(r1i+1)*ii;
      currMax+=nb*((r1i*ii)+1);


      //rem = rem%ii;
	  //System.err.println("currentMax after nb  :"+currMax + " rem :"+rem);

      //currMax += (rem - (rem/ii))* (r1i);
      currMax += rem* (r1i);
	  //System.out.println("currentMax after rem  :"+currMax + " rem :"+rem);

      
	  System.out.println("Case #" + t + ": "+currMax);

    }
  }
}

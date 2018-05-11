package round_1a.a_whaffle_choppers;

import java.util.*;
import java.io.*;

public class Solution {
	
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int tt = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    
    for (int t = 1; t <= tt; ++t) {
      int r = in.nextInt();
      int c = in.nextInt();
      int h = in.nextInt();
      int v = in.nextInt();
      
      int[] rr = new int[r];
      int[] cc = new int[c];
      int tr = 0;
      int tc = 0;
      for (int i = 0; i < r; ++i) {
    	  String l = in.next();
          for (int j = 0; j < c; ++j) {
        	  if(l.charAt(j)=='@'){
        		  cc[j]= cc[j]+1;
        		  rr[i]= rr[i]+1;
        	  }
          }
      }
      
      for (int i = 0; i < r; ++i) {
    	  tr+=rr[i];
      }
      for (int i = 0; i < c; ++i) {
    	  tc+=cc[i];
      }
     boolean pp = true;

    int ttr = rr[0];
    for (int i = 0; i < r; ++i) {
//	  System.out.println("rr("+i+"):"+rr[i]);
	  if(ttr!=rr[i])
		  pp = false;
    }
    int ttc = cc[0];

    for (int i = 0; i < c; ++i) {
//	  System.out.println("cc("+i+"):"+cc[i]);
	  if(ttc!=cc[i])
		  pp = false;
    }
    
    if(pp && rr[0] != 0 && cc[0] != 0 && !(tr == tc && tr == r*c)){
  	  System.out.println("Case #" + t + ": IMPOSSIBLE");
  	  continue;
    }
      




      
//	  System.out.println("tc:"+tr);
//	  System.out.println("tr:"+tc);
      
	     boolean p = true;

      
      if(tc%(v+1)==0){
    	  int s = tc/(v+1);
//    	  System.out.println("share c:"+s);

    	  int ss=0;
    	  for(int i=0;i<c;i++){
    		  
    		  if(ss==s){
    			  ss=0;
    		  } else if(ss>s){
    			  p = false;
    			  break;
    		  } else {// ss<s
    			  ss+=cc[i];
    		  }
    	  }
      } else {
    	  p= false;
    	  continue;
      }
      
      
      
      if(!p){
    	  System.out.println("Case #" + t + ": IMPOSSIBLE");
    	  continue;
      }
      
      if(tr%(h+1)==0){
    	  int s = tr/(h+1);
//    	  System.out.println("share r:"+s);

    	  int ss=0;
    	  for(int i=0;i<r;i++){
    		  
    		  if(ss==s){
    			  ss=0;
    		  } else if(ss>s){
    			  p = false;
    			  break;
    		  } else {// ss<s
    			  ss+=rr[i];
    		  }
    	  }
      } else {
    	  p= false;
    	  continue;
      }
      
      if(!p)
    	  System.out.println("Case #" + t + ": IMPOSSIBLE");
      else 
    	  System.out.println("Case #" + t + ": POSSIBLE");
      



      
//    	  System.out.println("Case #" + i + ": IMPOSSIBLE");
//    	  System.out.println("Case #" + i + ": "+ 0);

//    	  System.out.println("Case #" + i + ": "+ swapCount);

      
    }
  }
}
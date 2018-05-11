package round_0.a_saving_the_universe_again.submissions;

import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int d = in.nextInt();
      String p = in.next();
      
      char[] str = p.toCharArray();
      int totalC = 1;
      int totalD = 0;
      ArrayList<Integer> sc = new ArrayList<Integer>();
      
      for(int j=0;j<p.length();j++){
    	  if(str[j]=='C'){
    		  totalC*=2;
    	  } else {
    		  sc.add(totalC);
    		  totalD+=totalC;
    	  }
      }
      
      if(sc.size()>d)
    	  System.out.println("Case #" + i + ": IMPOSSIBLE");
      else if(totalD<=d)
    	  System.out.println("Case #" + i + ": "+ 0);
      else {
    	  int swapCount = 0;
    	  while(totalD>d){
    		  swapCount++;
    		  
        	  Collections.sort(sc);

    		  int x = sc.get(sc.size()-1);
    		  sc.remove(sc.size()-1);
    		  sc.add(x/2);
    		  
    		  totalD = totalD - x/2;
    		  
    	  }
    	  System.out.println("Case #" + i + ": "+ swapCount);

      }
    }
  }
}
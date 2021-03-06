package round_0.b_trouble_sort.submissions;
import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      
      ArrayList<Integer> va = new ArrayList<Integer>();
      ArrayList<Integer> vb = new ArrayList<Integer>();

      for (int j = 0; j <n; ++j) {
    	  int v = in.nextInt();
    	  if(j%2==0)
    		  va.add(v);
    	  else
    		  vb.add(v);
      }
      Collections.sort(va);
      Collections.sort(vb);
      
      int x =-1;
      for (int j = 0; j <n-1; ++j) {
    	  
    	  
    	  if(j%2==0){
    		  if(va.get(j/2)>vb.get(j/2)){
    			  x=j;
    			  break;
    		  }
    	  } else {
    		  if(vb.get(j/2)>va.get(j/2 +1)){
    			  x=j;
    			  break;

    		  }

    	  }
      }
      if(x==-1)
    	  System.out.println("Case #" + i + ": OK");
      else
    	  System.out.println("Case #" + i + ": "+ x);

    }
  }
}
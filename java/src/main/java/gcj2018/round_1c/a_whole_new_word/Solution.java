package round_1c.a_whole_new_word;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution{
	
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int tt = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    
    for (int t = 1; t <= tt; ++t) {
      int n = in.nextInt();
      int l = in.nextInt();
      
	  List<String> w = new ArrayList<String>();
	  List<Set<Character>> lsc = new ArrayList<Set<Character>>();

	  //a Set per column
	  for(int i = 0;i<l;i++){
		  Set<Character> sc = new HashSet<Character>();
		  lsc.add(sc);
	  }
	
	  //fill Sets
      for (int i = 0; i < n; ++i) {
          String ww = in.next();
          w.add(ww);
          char[] wa = ww.toCharArray();
          for(int j = 0; j<ww.length(); j++){
        	  lsc.get(j).add(wa[j]);
          }
      }
      
      //break if we already have all combination in input : 
      //(count of possible letter per column) power (column count)
      long difComb = 1;
      for(int i = 0; i<lsc.size();i++)
    	  difComb *= lsc.get(i).size();
      
      if(difComb<=n){
    	  System.out.println("Case #" + t + ": -");
    	  continue;
      }
      
      try {
    	  //get all possible combinations, compare with input words 
          recurse(lsc,w, l);
          
      } catch (IllegalStateException e) {
    	  //we use an exception to break of recursive calls
    	  System.out.println("Case #" + t + ": "+e.getMessage());
    	  continue;
      }

     System.out.println("Case #" + t + ": -");

    }
    
  }

	private static void recurse(List<Set<Character>> lsc, List<String> w, int l) {
	
		StringBuilder sb = new StringBuilder();
		recurse(lsc,w, sb,l);
	
	}


	private static void recurse(List<Set<Character>> aa, List<String> w, StringBuilder sb1, int i) {
		
		if(i>0){
			List<Set<Character>> bb= new ArrayList<Set<Character>>();
			bb = aa.subList(1, i);
			
    	  Set<Character> sc = aa.get(0);
    	  Iterator<Character> it = sc.iterator();
          while(it.hasNext()){
        	  StringBuilder sb2 = new StringBuilder(sb1);
        	  sb2.append(it.next());
        	  recurse(bb,w,sb2,i-1);
          }
	          
		} else {
			String res = sb1.toString();
	        if(!w.contains(res)){
	        	throw new IllegalStateException(res);
	        } else {
	        	//System.err.println(res);
	        }
		}
		
	}

}

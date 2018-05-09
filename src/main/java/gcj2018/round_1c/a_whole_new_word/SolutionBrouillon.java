package gcj2018.round_1c.a_whole_new_word;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.io.*;
public class SolutionBrouillon{
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int tt = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    
    for (int t = 1; t <= tt; ++t) {
      int n = in.nextInt();
      int l = in.nextInt();
      
	  List<String> w = new ArrayList<String>();
	  List<Set<Character>> lsc = new ArrayList<Set<Character>>();

	  for(int i = 0;i<l;i++){
		  Set<Character> sc = new HashSet<Character>();
		  lsc.add(sc);
	  }
	
//	  char[][] aaa =  new char[n][l];
//	  int iii = 0;
      for (int i = 0; i < n; ++i) {
          String ww = in.next();
          w.add(ww);
          char[] wa = ww.toCharArray();
          for(int j = 0; j<ww.length(); j++){
        	  
        	  lsc.get(j).add(wa[j]);
//        	  aaa[j][i]=wa[j];
        		  
          }
          
      }
      String res = "-";
      long difComb = 1;
      for(int i = 0; i<lsc.size();i++)
    	  difComb *= lsc.get(i).size();
      
      if(difComb<=n){
    	  System.out.println("Case #" + t + ": "+res);
    	  continue;
      }
      
//	  char[][] aa =  new char[lsc.size()][lsc.get(0).size()];
//      for(int i = 0; i<lsc.size();i++){
//    	  Set<Character> sc = lsc.get(i);
//    	  Iterator<Character> it = sc.iterator();
//          for(int j = 0; it.hasNext();j++){
//    		  aa[i][j] = it.next();
//          }
//      }
//      lsc = null;
      boolean found = false;
      StringBuilder res2 = new StringBuilder();
      
      //recurse(aa,res2, aa.length, aa[0].length);
      
      recurse(lsc,w, l);

//      for(int x = 0;x<aa.length*aa[0].length;x++){
//           res2 =new StringBuilder();
//          int j = aa[0].length;
//          //int y = Math.random()
//
//          for(int i = 0; i<aa.length;i++){
//              int randomNum = ThreadLocalRandom.current().nextInt(0, j);
//
//              //for(int j = 0; j<aa[i].length;j++){
//            	  res2.append(aa[i][randomNum]);
//              //}
//          }
//    	  //System.out.println(res2.toString());
//
//          if(!w.contains(res2.toString())){
//        	  found = true;
//        	  break;
//          }
//      }

      if (found)
    	  System.out.println("Case #" + t + ": "+res2.toString());
      else
    	  System.out.println("Case #" + t + ": "+res);

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
          for(int j = 0; it.hasNext();j++){
        	  StringBuilder sb2 = new StringBuilder(sb1);
        	  sb2.append(it.next());
        	  recurse(bb,w,sb2,i-1);
          }
	          
		} else {
			String res = sb1.toString();
//	        if(!w.contains(res)){
//	        	throw new IllegalStateException(res);
//	        }
			System.out.println(res);
		}
		
	}

	public static void recurse(char[][] aa, StringBuilder sb1, int i, int j) {
		
		
		if(i>0){
			char[][] bb= new char[i-1][j];
			
			for(int ii=1; ii<i ;ii++){
				bb[ii-1]=aa[ii];
			}
			
			for(int jj = 0 ; jj<j; jj++){
				StringBuilder sb2 = new StringBuilder(sb1);

				sb2.append(aa[0][jj]);
//				sb2.append(recurse(bb,sb2,i-1,j));
				recurse(bb,sb2,i-1,j);
			}
		} else {
			System.out.println(sb1.toString());
		}
		

	}
}

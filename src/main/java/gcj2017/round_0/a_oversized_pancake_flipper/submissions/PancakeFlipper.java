package round_0.a_oversized_pancake_flipper.submissions;
import java.util.*;
import java.io.*;

public class PancakeFlipper {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
//			System.setIn(new FileInputStream("input.txt"));
			System.setIn(new FileInputStream("A-small-attempt7.in"));
//			System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("output.txt"))));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
	    for (int ind = 1; ind <= t; ++ind) {
	      String s = in.next();
	      int k = in.nextInt();
	      
	      int nb = 0;
	      boolean ko=false; 
	      String res = "";
	      String ss="";
	      char[] arr = s.toCharArray();
	      
//	      for(char c : s.toCharArray()){
	      for(int i = 0; i< arr.length;i++){
	    	  char c = arr[i];
	    	  
	    	  if(ss.length()==0){
	    		  ss = ss + c;
	    	  } else if(ss.charAt(0)==c){
	    		  ss = ss + c;
	    	  } else {
	    		  //handle ss
	    		  if (ss.charAt(0)=='-'){
	    			  int mod = ss.length()%k;
	    			  int rem = k - mod;
	    			  
	    			  if(mod==0){
	    				  nb +=ss.length()/k;
	    			  } else {
	    				  ko = true;
	    				  
	    				  if(i+rem<=arr.length){
	    					  int j;
		    				  for(j = 0;j <rem ;j++){
		    					  char cc = arr[j+i];
		    					  if(!(cc=='+')){
		    						  if(j+i+k<=arr.length){
//		    							  boolean isAdjDiff =false;
//		    							  for(int l = 0;l<k-rem;l++){
//		    								  arr[i+j+l]
//		    								  
//		    							  }
		    							  nb++;
		    							  for(int l = 0;l<k;l++)
				    						  arr[i+j+l] = arr[i+j+l]=='-' ? '+':'-';
		    							  		    							 
		    						  } else {
		    							  break;
		    						  }
		    					  } 
		    				  }
		    				  if(j==rem){
		    					  ko = false;
		    					  nb++;
		    					  for(int l = 0;l<rem;l++)
		    						  arr[l+i] = '-';
		    					  //i+=k;
		    					  //c = s.charAt(i);
		    				  }
	    				  } 			  
	    			  }
	    		  } else if (ss.charAt(0)=='+'){}
	    		  ss = ""+arr[i]; //ss = i< arr.length ? "" + arr[i] : "";
	    	  }
	    	  
	    	  if(ko){
	    		  break;
	    	  }
	    	  	    		  
	      }
	      //handle last
	      if(!ko && ss.length() > 0){
	    	  
	    	  if (ss.charAt(0)=='-'){
    			  int mod = ss.length()%k;
    			  int rem =mod -k;
    			  
    			  if(mod==0){
    				  nb +=ss.length()/k;
    			  } else {
    				  ko = true;
    				  
//    				  if(i+rem<=arr.length){
//    					  int j;
//	    				  for(j = 0;j <rem ;j++){
//	    					  char cc = s.charAt(j+i);
//	    					  if(!(cc=='+')){
//	    						break;
//	    					  }
//	    				  }
//	    				  if(j==rem){
//	    					  ko = false;
//	    					  nb++;
//	    					  for(int l = i;l<rem;l++)
//	    						  arr[l] = '-';
//	    					  //i+=k;
//	    					  //c = s.charAt(i);
//	    				  }
//    				  } 			  
    			  }
    		  } else if (ss.charAt(0)=='+'){}
	    	  
//    		  if (ss.charAt(0)=='-'){
//    			  if(ss.length()%k==0){
//    				  nb +=ss.length()/k;
//    			  } else {
//    				  ko = true;
//    			  }
//    				  
//    		  } else if (ss.charAt(0)=='+'){
//    			  //nothing to do
//    		  } else {
//    			  ko = true;
//    		  }
	      }
	      
	      if(ko){
	    	  res ="IMPOSSIBLE";
	      } else {
	    	  res = ""+nb;
	      }
	      System.out.println("Case #" + ind + ": " + res);
	    }
		
	}

}

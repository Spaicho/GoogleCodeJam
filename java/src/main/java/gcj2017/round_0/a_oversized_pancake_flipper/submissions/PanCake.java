package round_0.a_oversized_pancake_flipper.submissions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class PanCake {


		  public static void main(String[] args) {
			    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
			    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
			    for (int i = 1; i <= t; ++i) {
			      String s = in.next();
			      int k = in.nextInt();
			      String happy="";
			      String allHappy="";
			      String allBlank="";
			      String blank="";
			      int numberHappy=0;
			      int numberBlank=0;

			      for(int w=0;w<k;w++){
			    	  happy+="+";
			    	  blank+="-";

			      }
			      for(int w=0;w<s.length();w++){
			    	  allHappy+="+";
			    	  allBlank+="-";
			    	  if("+".equals(s.substring(w,w))){
			    	   numberHappy++;
			    	   }else{
					   numberBlank++;}
			      }
			      System.out.println("Case #" + i + ": " + s + " " + k);
			      int result=0;
		    	  String sToSwitch=s;
			      if(numberHappy!=s.length() && s.length()%k==0){
			      for(int j=0;j<s.length();j=j+k){
			    	  String sub=sToSwitch.substring(j, j+k);
			    	  if(sub.equals(happy)){
			    		  continue;
			    	  }else if(sub.equals(blank)){
			    		  sToSwitch=sToSwitch.substring(0, j).concat(happy).concat(sToSwitch.substring(j+k));
			    	  result++;
			    	  }else{
			    		  
			    	  } 
			      }
			      }else if(numberHappy!=sToSwitch.length()){
			    	  int firstBlank=sToSwitch.indexOf("-");
			    	  int secondBlank=sToSwitch.indexOf("-", firstBlank);
			    	  String betweenBlanks=sToSwitch.substring(firstBlank, secondBlank);
			    	  String firstBlankSeq=sToSwitch.substring(firstBlank, firstBlank+k);
			    	  if(firstBlankSeq.equals(blank)){
			    		  sToSwitch=sToSwitch.substring(0, firstBlank).concat(happy).concat(sToSwitch.substring(firstBlank+k));
				    	  result++;
			    	  }else if(betweenBlanks.length()%k==0){
			    		  
			    	  }
			      }
			       if(!sToSwitch.equals(allHappy)) result=-1;

			      System.out.println("==> Case #"+i+": "+result);

			    }
			  }
		  
		  
}


		  

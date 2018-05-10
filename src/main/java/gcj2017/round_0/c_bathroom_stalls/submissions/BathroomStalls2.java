package round_0.c_bathroom_stalls.submissions;
import java.util.*;
import java.io.*;

public class BathroomStalls2 {

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("BathroomStalls\\C-small-practice-2.in"));
//			System.setIn(new FileInputStream("BathroomStalls\\input.txt"));
			//System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("output.txt"))));
		} catch (FileNotFoundException e) {	e.printStackTrace();}
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int ind = 1; ind <= t; ++ind) {
		  int n = in.nextInt();
		  int k = in.nextInt();

		  int max=-1;
		  int min=-1;
		  int ls=-1;
		  int rs=-1;
		  
		  ArrayList<Integer> fulls = new ArrayList<>();
		  fulls.add(-1);
		  fulls.add(n);
		  
		  for(int i = 0;i<k;i++){
			  
			  int lo = 0;
			  int hi = n;
			  			  
			  //Collections.sort(fulls);
			  int lf = fulls.get(0);
			  //int rf = fulls.get(fulls.size()-1);
			  int range = -1;
			  
			  for(int j = 1; j<fulls.size()-1;j++){
				  int f = fulls.get(j);
				  if(f-lf>range){
					  range = f - lf;
					  lo = lf+1;
					  hi = f;
				  }
				  lf=f;
				  f = fulls.get(j+1);
				  if(f-lf>range){
					  range = f - lf;
					  lo = lf+1;
					  hi = f;
				  }				  
			  }
			  
			  int s = (hi-lo)/2 + (hi-lo)%2;
			  ls = s - lo -1;
			  rs = hi - s;
			  
			  fulls.add(s);
		  }
		  
		  max =Math.max(ls, rs);
		  min =Math.min(ls, rs);
		  
		  System.out.println("Case #" + ind + ": " + max + " " + min);
		}
	}
}
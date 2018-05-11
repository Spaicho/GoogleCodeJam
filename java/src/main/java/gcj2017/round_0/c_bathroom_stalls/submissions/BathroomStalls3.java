package round_0.c_bathroom_stalls.submissions;
import java.util.*;
import java.io.*;

public class BathroomStalls3 {

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("BathroomStalls\\C-small-practice-1.in"));
//			System.setIn(new FileInputStream("BathroomStalls\\input.txt"));
			//System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("output.txt"))));
		} catch (FileNotFoundException e) {	e.printStackTrace();}
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int ind = 1; ind <= t; ++ind) {
		  int n = in.nextInt();
		  int k = in.nextInt();

		  TreeSet<Integer> s = new TreeSet<>();
		  int x1=-1;
		  int x2=-1;
		  int x = n;  
		  int rep = 1;
		  for(int i = 0;i<k;i++){
			  
			  //System.out.println("     n:"+n+" k:"+k +" pollFirst :" + x);

			  x-=1;
			  x = x>0 ? x : 0;
			  x1 = x/2;
			  x2 = x/2 + x%2;
			  
			  for (int j=rep;j>0;j--){
				  System.out.println("Case #" + ind + ": " + x2 + " " + x1 + "     n:"+n+" k:"+k);
				  i++;
			  }
			  
			  if(x1 > 0)
				  s.add(x1);
			  if(x2 > 0)
				  s.add(x2);
			  
			  if(x%2==0){
				  rep=1;
			  }
			  
			  x = s.pollLast();
			  
		  }
		  
		  System.out.println("Case #" + ind + ": " + x2 + " " + x1 + "     n:"+n+" k:"+k);
		}
	}
}
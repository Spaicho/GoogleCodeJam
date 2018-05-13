package round1.c;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;

import com.google.common.collect.*;

public class A {

	public static String imp = "IMPOSSIBLE";
	
	  public static void main(String[] args) {
		
		try {
			//System.setIn(new FileInputStream("A-large.in"));
			
			//System.setIn(new FileInputStream("A-small-attempt0.in"));
			System.setIn(new FileInputStream("A-small-practice.in"));
			
//			System.setIn(new FileInputStream("input.txt"));
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		    
		for (int i = 1; i < t+1; i++) {
		    int n = in.nextInt();
		    int k = in.nextInt();

		    Multiset<Cake> set = TreeMultiset.create();
		    		//new TreeMultimap<Integer,Multiset<Integer>>(null, null);
		    
			for (int j = 0; j < n; ++j) {
				int r = in.nextInt();
			    int h = in.nextInt();
			    
			    set.add(new Cake(r,h));
			}
			
			double res = 0;
			int count = 0;
			
//			int ind = 0;
//			int lastKey = Integer.MAX_VALUE;
			
			for (Cake c : set) {
								
				if(count>=k)
					break;
				
//				if(key==lastKey){
//					lastKey = key;
//					ind++;
//				} else {
//					 ind = 0;
//					 lastKey = Integer.MAX_VALUE;
//				}
				
				int r = c.r;
				int h = c.h;
				
//				Collection<Integer> values = map.get(key);
//				int count2 = 0;
//		        for(Integer value : values){
//		            h = value * -1;
//		        	if(count2>=ind)
//						break;
//		        	count2++;
//		        }
				
				
				
				if(res==0){
					res = res + 2*r*h*Math.PI + r*r*Math.PI;
				} else {
					res = res + 2*r*h*Math.PI;
				}
				count++;

			}

			System.out.println("Case #" + i + ": " + res);
	    }
		
	}

}
 class Cake implements Comparable<Cake>{
	int r;
	int h;
	double diff;
	double s1;
	double s2;
	double s;
	@Override
	public int compareTo(Cake o) {
		// TODO Auto-generated method stub
//		if(diff>o.diff)
//			return -1;
//		else if(diff<o.diff)
//			return 1;
//		else if(r>o.r)
//			return -1;
//		else if(r==o.r)
//			return h>o.h ? -1 : 1;
//		else return 1;
		// TODO Auto-generated method stub
		if(s>o.s)
			return -1;
		else if(s<o.s)
			return 1;
		else if(r>o.r)
			return -1;
		else if(r==o.r)
			return h>o.h ? -1 : 1;
			else return 1;
		
	}
	
	Cake(int r, int h){
		this.r = r;
		this.h = h;
		double h2 = h/2;
		this.diff = r-h2;
		s1 = r*r*Math.PI;
		s2 = 2*r*h*Math.PI;
		s = s1+s2;
	}
	
}

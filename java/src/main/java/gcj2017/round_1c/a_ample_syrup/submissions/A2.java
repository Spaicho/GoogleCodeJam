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

public class A2 {

	public static String imp = "IMPOSSIBLE";
	
	  public static void main(String[] args) {
		
		try {
			//System.setIn(new FileInputStream("A-large.in"));
			
			//System.setIn(new FileInputStream("A-small-attempt0.in"));
			//System.setIn(new FileInputStream("A-small-practice.in"));
			
			System.setIn(new FileInputStream("input.txt"));
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		    
		for (int i = 1; i < t+1; i++) {
		    int n = in.nextInt();
		    int k = in.nextInt();

		    Multiset<Cake2> set = TreeMultiset.create();
		    
			for (int j = 0; j < n; ++j) {
				int r = in.nextInt();
			    int h = in.nextInt();
			    
			    set.add(new Cake2(r,h));
			}
			
			for(Cake2 c: set){
				System.out.println(c);
			}
			System.out.println();
			
			double res = 0;
			Object[] arr = set.toArray();
			
			int ind = 0;
			int prevR = Integer.MAX_VALUE;
			
			for(int j = 0;j<k;j++,ind++){
				
				while(ind <=n-1 && ! containsEnoughCakeWithLessRad(arr,k-j,ind,prevR)){
					ind++;
				}
				
				if(ind==n)
					System.out.println("Case #" + i + ": " + imp);
				
				Cake2 c = (Cake2) arr[ind];
				int r = c.r;
				int h = c.h;
				prevR = r;
				
				System.out.println(c);
				
				if(res==0){
					res = res + 2*r*h*Math.PI + r*r*Math.PI;
				} else {
					res = res + 2*r*h*Math.PI;
				}
				
			}

			System.out.println("Case #" + i + ": " + res);
	    }
		
	}


	private static boolean containsEnoughCakeWithLessRad(Object[] arr, int need, int start,int prevR) {
		
		int len = arr.length;
		int found =0;
		Cake2 cur = (Cake2) arr[start];
		
		if(cur.r>prevR)
			return false;
		
		for(int i = start+1;i<len;i++){
			Cake2 c = (Cake2) arr[i];
			if(cur.r>=c.r)
				found++;
			if(found==need-1)
				break;
		}
		return found>=need-1;
	}

}
 class Cake2 implements Comparable<Cake2>{
	int r;
	int h;
	double s1;
	double s2;
	double s;
	@Override
	public int compareTo(Cake2 o) {
		
		if(s>o.s)
			return -1;
		else if(s<o.s)
			return 1;
		else if(r>o.r)
			return -1;
		else if(r==o.r)
			return h>o.h ? -1 : 1;
		else 
			return 1;
	}
	
	Cake2(int r, int h){
		this.r = r;
		this.h = h;

		s1 = r*r*Math.PI;
		s2 = 2*r*h*Math.PI;
		s = s1+s2;
	}

	@Override
	public String toString() {
		return "r:"+r +
				" h:"+h +
				" s:"+s 
				//" s1 : "+s1 +
				//" s2 : "+s2
				;
	}
	
}

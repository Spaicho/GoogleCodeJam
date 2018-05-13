package round1.c;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;

import com.google.common.collect.*;

public class A3 {

	public static String imp = "IMPOSSIBLE";
	
	  public static void main(String[] args) {
		
		try {
			//System.setIn(new FileInputStream("A-large.in"));
			
			//System.setIn(new FileInputStream("A-small-attempt0.in"));
			System.setIn(new FileInputStream("A-small-practice.in"));
			
			//System.setIn(new FileInputStream("input.txt"));
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
	    int tcase = -1;
	    
		for (int i = 1; i < t+1; i++) {
			
			if(i<tcase) continue;
				
		    int n = in.nextInt();
		    int k = in.nextInt();

		    Multiset<Cake3> set = TreeMultiset.create();
		    
			for (int j = 0; j < n; ++j) {
				int r = in.nextInt();
			    int h = in.nextInt();
			    
			    set.add(new Cake3(r,h));
			}
			
//			for(Cake3 c: set){
//				System.out.println(c);
//			}
//			System.out.println();
			
//			BigDecimal res = BigDecimal.ZERO;
			double res = 0;
			
			Object[] arr = set.toArray();
						
			int maxR = 0;
			Cake3 cMax = null;
			
			for(int j = 0;j<k;j++){
				
				Cake3 c = (Cake3) arr[j];
				
				if(maxR<c.r){
					maxR = c.r;
					cMax = c;
				}
				
				//System.out.println(c);
				
				//res = res.add(c.s2);
				res +=c.s2;
				
			}
			//res =res.add(cMax.s1);
			res +=cMax.s1;
			
			System.out.println("Case #" + i + ": " + res);
			
			if(i==tcase) break;
				
	    }
		
	}

}
 class Cake3 implements Comparable<Cake3>{
	int r;
	int h;
	double s1;
	double s2;
	double s;
	
	@Override
	public int compareTo(Cake3 o) {
		
//		if(s.compareTo(o.s)>0)
		if(s>o.s)
			return -1;
//		else if(s.compareTo(o.s)<0)
		else if(s2<o.s2)
			return 1;
		else if(r>o.r)
			return -1;
		else if(r==o.r)
			return h>o.h ? -1 : 1;
		else 
			return 1;
	}
	
	Cake3(int r, int h){
		this.r = r;
		this.h = h;

		//s1 = new BigDecimal(BigInteger.valueOf(r)
		//		.multiply(BigInteger.valueOf(r)))
		//		.multiply(new BigDecimal(Math.PI));
		
		s1 = (BigInteger.valueOf(r).
				multiply(BigInteger.valueOf(r)).
				doubleValue()) * Math.PI;
		
//		s2 = new BigDecimal(BigInteger.valueOf(r)
//				.multiply(BigInteger.valueOf(h))
//				.multiply(BigInteger.valueOf(2)))
//				.multiply(new BigDecimal(Math.PI));
		s2 = (BigInteger.valueOf(r)
				.multiply(BigInteger.valueOf(h))
				.multiply(BigInteger.valueOf(2))).doubleValue() * Math.PI;
		
		s = s1+s2;
	}

	@Override
	public String toString() {
		return "r:"+r +
				" h:"+h +
				" s:"+s +
				" s1 : "+s1 +
				" s2 : "+s2
				;
	}
	
}

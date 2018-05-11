package round_0.c_bathroom_stalls.submissions;
import java.util.*;
import java.io.*;


public class BathroomStalls {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("BathroomStalls\\C-small-practice-1.in"));
//			System.setIn(new FileInputStream("BathroomStalls\\input.txt"));
			//System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("output.txt"))));
	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int ind = 1; ind <= t; ++ind) {
		  int n = in.nextInt();
		  int k = in.nextInt();
		  
		  ArrayList<Stall> list = new ArrayList<>();
		  list.add(new Stall(0,-1,-1));
		  list.add(new Stall(n+1,-1,-1));
		  
		  for(int s=1;s<n+1;s++){	
			  list.add(new Stall(s,s-1,n-s));
		  }
		  
		  Collections.sort(list,new StallComparator());

		  int max=-1;
		  int min=-1;
		  
		  for(int i = 0;i<k;i++){
			  ArrayList<Stall> ol = new ArrayList<>(list);
			  Collections.sort(ol);
			  
			  Stall stall = ol.get(ol.size()-1);
			  max = Math.max(stall.ls, stall.rs);
			  min = Math.min(stall.ls, stall.rs);
			  
			  updateList(list,stall);
		  }
		  
		  System.out.println("Case #" + ind + ": " + max + " " + min);
		}
	}

	private static void updateList(ArrayList<Stall> list,Stall stall) {
		int lo=0;
		int hi=list.size() -1;
				
		for(int i =0;i <stall.s;i++){
			if(list.get(i).ls==-1){
				lo = i;
			}
		}
		
		for(int i = stall.s+1; i <list.size();i++){
			if(list.get(i).ls==-1){
				hi = i;
				break;
			}
		}
		
		for(int i =lo+1;i <stall.s;i++){
			list.get(i).ls = i- lo -1;
			list.get(i).rs = stall.s - i -1;
		}
		
		for(int i = stall.s+1;i <hi;i++){
			list.get(i).ls = i-stall.s -1;
			list.get(i).rs = hi - i -1;
		}
		
		list.get(stall.s).ls=-1;
		list.get(stall.s).rs=-1;
		
	}

}

class Stall implements Comparable<Stall>{
	public int s;
    public int ls;
    public int rs;
    public Stall(int s,int ls, int rs){
    	this.s=s;
    	this.ls=ls;
    	this.rs=rs;
    }
	@Override
	public int compareTo(Stall o) {
		
		if(Math.min(this.ls, this.rs) > Math.min(o.ls, o.rs)){
			return 1;
		} else if(Math.min(this.ls, this.rs) < Math.min(o.ls, o.rs)){
			return -1;
		} else {
			if(Math.max(this.ls, this.rs) > Math.max(o.ls, o.rs)){
				return 1;
			} else if(Math.max(this.ls, this.rs) < Math.max(o.ls, o.rs)){
				return -1;
			} else {
				if(this.s > o.s){
					return -1;
				} else {
					return 1;
				}
			}
		}
		
	}
}

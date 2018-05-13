package round_1b.b_stable_neigh_bors.submissions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	  public static void main(String[] args) {
		
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		    
		for (int i = 1; i < t+1; i++) {
		    int n = in.nextInt();
		    		    
		    int r = in.nextInt();
		    int o = in.nextInt();
		    int y = in.nextInt();
		    int g = in.nextInt();
		    int b = in.nextInt();
		    int v = in.nextInt();
		    
		    int[] all = {r,o,y,g,b,v};
		    String res = "";
		    //print(all);
		    
			for (int j = 0; j < n; ++j) {
				//print(all);
			    res = popColor(res, all,n);
				//System.out.println(res);

			    if (res.contains("IMPOSSIBLE"))
			    	break;
			}
			int mid = Math.max(r, b);
			int max = Math.max(mid,y);
			int min;
			if(max==y){
				min = Math.min(r, b);
			} else {
				mid = Math.max(y, Math.min(r, b));
				min = Math.min(r, Math.min(r, y));
			}
			
//			if(max>mid+min){
//				System.out.print("IMPOSSIBLE3 : " + "max mid min : "+max+ " "+mid +" "+min+" ");
//			}
			
			System.out.println("Case #" + i + ": " + res);
	    }
		
	  }

	private static String popColor(String res,int[] all, int n) {
		
		String prim="";
		String second="";
		char lastRes = res.length()==0 ? ' ' : res.charAt(res.length()-1);
		
		int[] indices = getIndicesByMax(all,res);
		
		for(int i=0;i<6;i++){
			int j = indices[i];
			
			if(all[j]!=0){
				String f = forbiddenLetter(j);
				if(! f.contains(lastRes+"")){
					char cc = popLetter(j);
					if(cc=='B' || cc=='R'  || cc=='Y'){
						prim = prim + cc;
					} else {
						second = second + cc;
					}
				}
			}
		}
		
		//System.out.println("result:"+res +" : "+prim +" : "+ second);
		
		char cc = ' ';
		String fus = second + prim;

		if(res.length()==n-2 && fus.length()==2){
			String f1 = forbiddenLetter(popIndex(fus.charAt(1)));
			if(!f1.contains(res.charAt(0)+"")){
				cc = fus.charAt(0);
			} else {
				cc = fus.charAt(1);
			}
			
		} else if(res.length()==n-1 && fus.length()>0){
			String f1 = forbiddenLetter(popIndex(fus.charAt(0)));
			if(f1.contains(res.charAt(0)+"")){
				return "IMPOSSIBLE";//+" "+res +" : "+prim +" : "+ second;
			} else {
				cc = fus.charAt(0);
			}
		} else {
			if(res.length()==0){
				cc = prim.length() > 0 ? prim.charAt(0) : second.length() > 0 ? second.charAt(0) : ' ';
			}else {
				cc = second.length() > 0 ? second.charAt(0) : prim.length() > 0 ? prim.charAt(0) : ' ';
			}
		}

		if(cc==' '){
			return "IMPOSSIBLE";//+" "+res +" : "+prim +" : "+ second;
			
		}
		
		int x = popIndex(cc);
			
		all[x] = all[x]-1;
		
		return res+cc;
	}

	private static int[] getIndicesByMax(int[] all,String res) {
		int[] indices = new int[6];
		int[] tmp = Arrays.copyOf(all,6);
		//System.out.print("all   : ");
		//print(tmp);
		
		for(int j=0;j<6;j++){
			int max = tmp[0];
			int ind = 0;
			for(int i=1;i<6;i++){
				if(max < tmp[i]){
					ind = i;
					max = tmp[i];
				} else if (max == tmp[i]){
					char c = res.length() > 0 ? res.charAt(0) : ' ';
					if(c !=' ' && forbiddenLetter(popIndex(c)).contains(popLetter(i)+"")){
						ind = i;
						max = tmp[i];
					}
				}
				//ind = max < tmp[i] ? ind = i : ind;
				//max = max < tmp[i] ? max = tmp[i] : max;
			}
			indices[j] = ind;
			tmp[ind] = -1;
		}
		//System.out.print("order : ");
		//print(indices);
		return indices;
	}

	private static char popLetter(int i) {
		char c = ' ';
		switch (i) {
			case 0 :
				c = 'R';
				break;
			case 1 :
				c = 'O';
				break;
			case 2 :
				c = 'Y';
				break;
			case 3 :
				c = 'G';
				break;
			case 4 :
				c = 'B';
				break;
			case 5 :
				c = 'V';
				break;
			default :
				break;
		}
		return c;
	}
	
	private static int popIndex(char c) {
		int i = -1;
		switch (c) {
		case 'R' :
			i = 0;
			break;
		case 'O' :
			i = 1;
			break;
		case 'Y' :
			i = 2;
			break;
		case 'G' :
			i = 3;
			break;
		case 'B' :
			i = 4;
			break;
		case 'V' :
			i = 5;
			break;
		default :
			break;
		}
		return i;
	}
	
	private static String forbiddenLetter(int i) {
		String res = "";
		
		res = res + popLetter(i);
		res = res + popLetter((i+1)%6);
		res = res + popLetter(i-1 < 0 ? 5 : i-1);
		
		if(i%2==1){
			res = res + popLetter((i+2)%6);
			res = res + popLetter(i-2 < 0 ? i - 2 + 6 : i-2);	
		}
		
		return res;
	}
	

  private static void print(int[] all){
	  for(int i = 0;i<6;i++){
		  System.out.print(all[i]+",");
	  }
	  //System.out.println();

  }
}

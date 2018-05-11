package round_0.c_go_gopher.submissions;

import java.util.*;
import java.io.*;

public class Solution {
	
  public static void main(String[] args) {
	//System.out.println("hello solution for go gopher");
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
   
    boolean stopAll = false;
    
    for (int ii = 1; ii <= t; ++ii) {
    	if(stopAll)
    		break;
      int a = in.nextInt();
      
      int[][] grid;
      
      if(a==20)
    	  grid = new int[3][7];
      else if(a==10)
    	  grid = new int[3][4];
      else // if(a==200)
    	  grid = new int[3][67];

      int col = 0;
      int i0=3;
      int j0=3;
      int jj;
      
      for(jj=0; jj<1000;jj++){
    	 
     	 //System.err.println("send :"+i0  + " " + (j0+col)); 

    	 System.out.println(i0  + " " + (j0+col)); 
    	 int i = in.nextInt();
    	 int j = in.nextInt();
     	 //System.err.println("recieved :"+i  + " " + j); 

    	 if(i==0 && j ==0)
    		 break;
    	 if(i==-1 && j ==-1){
    		 stopAll=true;
    		 break;
    	 }
    	 
    	 grid[i-2][j-2]=1;
    	 
    	 if(grid[0][col]==1 && grid[1][col]==1 && grid[2][col]==1){
         	 //System.err.println("col :"+col  + " done."); 
    		 if(grid[0].length -3 > col)
    			 col++;
    	 }
      }
      if(jj==1000)
    	  stopAll=true;
    }
  }
}

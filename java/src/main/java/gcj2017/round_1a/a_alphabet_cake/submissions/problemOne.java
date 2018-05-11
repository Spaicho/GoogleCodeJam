package round_1a.a_alphabet_cake.submissions;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class problemOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("A-small-attempt2.in"));
//			System.setIn(new FileInputStream("input.txt"));
////			System.setIn(new FileInputStream("TidyNumbers\\B-small-attempt1.in"));
//			System.setIn(new FileInputStream("TidyNumbers\\B-large.in"));
//			System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("output.txt"))));
//	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int ind = 1; ind <= t; ++ind) {
		  int r = in.nextInt();
		  int c = in.nextInt();
		  
		  char[][] grid = new char[r][c];
		  char[][] grid2 = new char[r][c];
		  char[][] grid3 = new char[r][c];
		  grid2=grid;
		  for(int i = 0; i<r;i++){
			  String row = in.next();
			  for(int j = 0; j<c;j++){
				  grid[i][j]= row.charAt(j);
				  grid3[i][j]= row.charAt(j);
			  }
		  }
		  for(int i = 0; i<r;i++){
			  for(int j = 0; j<c;j++){
				  if(grid3[i][j]!='?'){
					  int d1 = 1;
					  while(i+d1<r && j+d1 <c && (grid[i+d1][j+d1]=='?' || grid[i+d1][j+d1]==grid[i][j])){
						  d1++;
					  }
					  int d2 = -1;
					  while(i+d2>=0 && j+d2 >=0 && (grid[i+d2][j+d2]=='?' || grid[i+d2][j+d2]==grid[i][j])){
						  d2--;
					  }
					  int l = 1;
					  while(i+l<r && (grid[i+l][j]=='?' || grid[i+l][j]==grid[i][j])){
						  l++;
					  }
					  int l2 = -1;
					  while(i+l2>=0 && (grid[i+l2][j]=='?'|| grid[i+l2][j]==grid[i][j])){
						  l2--;
					  }
					  int b = 1;
					  while(j+b<c && (grid[i][j+b]=='?' || grid[i][j+b]==grid[i][j])){
						  b++;
					  }
					  int b2 = -1;
					  while(j+b2>=0 && (grid[i][j+b2]=='?' || grid[i][j+b2]==grid[i][j])){
						  b2--;
					  }
					  
					  d1--;
					  l--;
					  b--;
					  d2++;
					  l2++;
					  b2++;
					  
					  if(d1 +d2>0){
						  for(int x=0;d1>0 && x<=d1 && x<=l && x<=b;x++){
							  grid2[i+x][j]=grid[i][j];
							  grid2[i][j+x]=grid[i][j];
							  grid2[i+x][j+x]=grid[i][j];
						  }
						  for(int x=l2;l-l2>b-b2  && l-l2>0 && x<=l ;x++){
							  grid2[i+x][j]=grid[i][j];
						  }
						  for(int x=b2;b-b2>=l-l2 && b-b2>0 && x<=b ;x++){
							  grid2[i][j+x]=grid[i][j];
						  }
					  }
					  if(d1 +d2<0){
						  for(int x=0;d2<0 && x>=d2 && x>=l2 && x>=b2;x--){
							  grid2[i+x][j]=grid[i][j];
							  grid2[i][j+x]=grid[i][j];
							  grid2[i+x][j+x]=grid[i][j];
						  }
						  for(int x=l2;l-l2>b-b2  && l-l2>0 && x<=l ;x++){
							  grid2[i+x][j]=grid[i][j];
						  }
						  for(int x=b2;b-b2>=l-l2 && b-b2>0 && x<=b ;x++){
							  grid2[i][j+x]=grid[i][j];
						  }
					  }
					  if(d1 +d2==0){
						  for(int x=d2;d1-d2>0 && x<=d1 && x<=l && x>=l2 && x<=b && x>=b2 ;x++){
							  for(int z = d2;z<d1+i;z++){
								  grid2[x+i][z+i]=grid[i][j];
							  }
						  }
						  for(int x=l2;l-l2>b-b2  && l-l2>0 && x<=l ;x++){
							  grid2[i+x][j]=grid[i][j];
						  }
						  for(int x=b2;b-b2>=l-l2 && b-b2>0 && x<=b ;x++){
							  grid2[i][j+x]=grid[i][j];
						  }

					  }

				  }
			  }
		  }
		  
		  System.out.println("Case #" + ind +": "); 
		  for(int i = 0; i<r;i++){
			  for(int j = 0; j<c;j++){
				  System.out.print(grid2[i][j]); 
			  }
			  System.out.println();
		}
	      
	}


}
}
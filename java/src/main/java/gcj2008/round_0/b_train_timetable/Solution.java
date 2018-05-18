package round_0.b_train_timetable;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		TestSetEnum.redirectIO(TestSetEnum.LARGE_PRACTICE);
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
	    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
	    for (int ind = 1; ind <= t; ++ind) {
	    	int turn = in.nextInt();
	    	int na = in.nextInt();
	    	int nb = in.nextInt();

	    	
	    	List<Integer> depA = new ArrayList<>(na);
	    	List<Integer> arrA = new ArrayList<>(na);
	    	List<Integer> depB = new ArrayList<>(nb);
	    	List<Integer> arrB = new ArrayList<>(nb);
	    	
	    	//fill lists from train table, convert all to int, and sort
		    for (int ii = 0; ii < na; ++ii) {
		    	String[] dep = in.next().split(":");
		    	depA.add(Integer.parseInt(dep[0])*60 + Integer.parseInt(dep[1]));
		    	String[] arr = in.next().split(":");
		    	arrA.add(Integer.parseInt(arr[0])*60 + Integer.parseInt(arr[1]));

		    }
		    Collections.sort(depA);
		    Collections.sort(arrA);
		    
		    for (int ii = 0; ii < nb; ++ii) {
		    	String[] dep = in.next().split(":");
		    	depB.add(Integer.parseInt(dep[0])*60 + Integer.parseInt(dep[1]));
		    	String[] arr = in.next().split(":");
		    	arrB.add(Integer.parseInt(arr[0])*60 + Integer.parseInt(arr[1]));
		    }
		    Collections.sort(depB);
		    Collections.sort(arrB);
		    
		    int i =0;
		    int j =0;
		    int naa = na;
		    
		    //match A departure with B arrival + turn
		    while(i<na && j<nb){
		    	if(depA.get(i)>=(arrB.get(j)+turn)){
		    		naa--;
		    		j++;
		    	}
	    		i++;
		    }
		    
		    i =0;
		    j =0;
		    int nbb = nb;

		    //match B departure with A arrival + turn
		    while(i<na && j<nb){
		    	if(depB.get(j)>=(arrA.get(i)+turn)){
		    		nbb--;
		    		i++;
		    	}
		    	j++;
		    }


	    	System.out.println("Case #" + ind + ": "+naa+ " "+nbb);
	   
	    }
		
	}



	
	/**
	 * 
	 * @author ut296p
	 *
	 */
	enum TestSetEnum {
		
		SMALL_PRACTICE  ("-small-practice"), 
		SMALL_PRACTICE_1("-small-practice-1"), 
		SMALL_PRACTICE_2("-small-practice-2"), 
		LARGE_PRACTICE("-large-practice");
		
		/***/
		private final static String CLASS_FILE_NAME = "Solution.class";
		private final static String BIN_FOLDER 		= "/bin/";
		private final static String INOUT_FOLDER 	= "/inout/";
		
		private String inputfileName;
		private String outputfileName;
		
		private final static List<String> PREFIXES =  Arrays.asList("A", "B", "C", "D", "E");
		
		private final static String IN_SUFFIXE = ".in";
		private final static String OUT_SUFFIXE = ".out";

		
		private TestSetEnum(String fileName){
			
			this.inputfileName  = fileName + IN_SUFFIXE;
			this.outputfileName = fileName + OUT_SUFFIXE;
		}

		/**
		 * @param input
		 * @param output
		 */
		private static void redirectIO(TestSetEnum testSetEnum) {
			
			try {
				String inoutFolder = Solution.class.getResource(CLASS_FILE_NAME).getPath().substring(1).replace(BIN_FOLDER, INOUT_FOLDER).replace(CLASS_FILE_NAME, "");
				String prefix = getProblemPrefix(inoutFolder);
						
				String inPath  = inoutFolder + prefix +  testSetEnum.inputfileName;
				String outPath = inoutFolder + prefix + testSetEnum.getOutputfileName();
				
				System.setIn(new FileInputStream(inPath));
				System.setOut(new PrintStream(new FileOutputStream(outPath)));

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		private static String getProblemPrefix(String inoutFolder) {
			
			String[] folders = inoutFolder.split("/");
			return folders[folders.length-1].split("_")[0].toUpperCase();
		}

		/**
		 * @return the prefixes
		 */
		public static List<String> getPrefixes() {
			return PREFIXES;
		}


		/**
		 * @return the inputfileName
		 */
		public String getInputfileName() {
			return inputfileName;
		}


		/**
		 * @return the outputfileName
		 */
		public String getOutputfileName() {
			return outputfileName;
		}

	}

}

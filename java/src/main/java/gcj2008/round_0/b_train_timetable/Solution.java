package round_0.b_train_timetable;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		TestSetEnum.redirectIO(TestSetEnum.SMALL_PRACTICE_2);
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
	    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
	    for (int i = 1; i <= t; ++i) {
	    	int s = in.nextInt();

	    	System.out.println("Case #" + i + ": ");
	   
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
		LARGE_PRACTICE_1("-large-practice");
		
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

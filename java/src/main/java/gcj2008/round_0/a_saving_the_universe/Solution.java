package round_0.a_saving_the_universe;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	/**
	 * @param args
	 */
	private final static String  A_SMALL_PRACTICE_IN = "A-small-practice.in";
	private final static String  A_SMALL_PRACTICE_OUT = "A-small-practice.out";

	private final static String  A_LARGE_PRACTICE_IN = "A-large-practice.in";	
	private final static String  A_LARGE_PRACTICE_OUT = "A-large-practice.out";
	
	private final static String CLASS_FILE_NAME = "Solution.class";
	private final static String BIN_FOLDER = "/bin/";
	private final static String INOUT_FOLDER = "/inout/";

	
	public static void main(String[] args) {
		
		String input  = A_SMALL_PRACTICE_IN;
		String output = A_SMALL_PRACTICE_OUT;
		
		try {
			String inoutFolder = Solution.class.getResource(CLASS_FILE_NAME).getPath().substring(1).replace(BIN_FOLDER, INOUT_FOLDER).replace(CLASS_FILE_NAME, "");

			String inPath = inoutFolder + input;
			String outPath = inoutFolder + output;
			
			System.setIn(new FileInputStream(inPath));
			System.setOut(new PrintStream(new FileOutputStream(outPath)));

		} catch (FileNotFoundException e) { // | URISyntaxException e) {
			e.printStackTrace();
		}
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
	    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
	    for (int i = 1; i <= t; ++i) {
	    	int s = in.nextInt();
	    	in.nextLine();
	    	Map<String,Integer> map = new HashMap<>();
		    for (int j = 0; j < s; ++j) {
		    	String ss = in.nextLine(); // had to debug to find out we should not use next()
		    	map.put(ss, 0);
		    }
		    int q = in.nextInt();
		    in.nextLine();
		    int res = 0;
		    for (int j = 0; j < q; ++j) {
		    	String qq = in.nextLine();
		    	map.put(qq,map.get(qq)+1);
		    	
		    	boolean greatThanZero = true;
		    	for(Integer e : map.values()){
		    		int toint = e;
		    		if(toint<1){
		    			greatThanZero = false;
		    			break;
		    		}
		    	}
		    	if(greatThanZero){
		    		res++;
			    	for(String sss : map.keySet()){
			    		map.put(sss, 0);
			    	}
			    	map.put(qq,map.get(qq)+1);
		    	}

		    }
	    	System.out.println("Case #" + i + ": "+res);
	   
	    }
		
	}

}

//*******************************************************************
// Performance test between split options
//*******************************************************************
import java.util.regex.Pattern;
// one class needs to have a main() method
public class TestSplitPerf
{
    private static String[] splitArray;
    private static final String line = "a@b.com;prabin@logpoint.com;manish@test.com;xyz@sending.com;abc@logpoint.com";
	private static final int RUNS = 1000000;// 000000;
 
	public static final void testSplit() {
		double start = System.currentTimeMillis();
		for (int i = 0; i < RUNS; i++) {
			splitArray = line.split(";");
		}
		System.out.println("Split: " + (System.currentTimeMillis() - start) + "ms");
        // System.out.println("splitArray; "+Arrays.toString(splitArray));
	}
 
   public static final void testSplitRegex() {
		double start = System.currentTimeMillis();
     Pattern p = Pattern.compile(";");
		for (int i = 0; i < RUNS; i++) {
			splitArray = p.split(line);
		}
		System.out.println("Regex Split: " + (System.currentTimeMillis() - start) + "ms");
        // System.out.println("splitArray; "+Arrays.toString(splitArray));
	}
  
  public static final void testRegexMatcher() {
        double start = System.currentTimeMillis();
	    Pattern p = Pattern.compile(";");
        // System.out.println("splitArray Index; "+index);
        //System.out.println(p.matcher(line).find());
        System.out.println("RegexMatcher: " + (System.currentTimeMillis() - start) + "ms");

  }
  
	public static final void testIndexOf() {
		double start = System.currentTimeMillis();
  		int index =0;
		for (int i = 0; i < RUNS; i++) {
			index = line.indexOf(';'); 
		}
      
        // System.out.println("IndexOf: " + (System.currentTimeMillis() - start) + "ms");
        System.out.println("IndexOf: " + (System.currentTimeMillis() - start) + "ms");
        // System.out.println("splitArray Index; "+index);

	}
  
  
    public static void main(String[] args){
   		testSplit();
   		testSplitRegex();
  		testIndexOf();
        testRegexMatcher();
  	}
}

/*
OUTPUT::
1st run:
Split: 419.0ms
Regex Split: 520.0ms
IndexOf: 9.0ms
RegexMatcher: 0.0ms

2nd run:
Split: 407.0ms
Regex Split: 552.0ms
IndexOf: 10.0ms
RegexMatcher: 0.0ms

3rd run:
Split: 397.0ms
Regex Split: 514.0ms
IndexOf: 10.0ms
RegexMatcher: 0.0ms
*/

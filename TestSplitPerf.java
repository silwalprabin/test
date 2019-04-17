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
        boolean isMatched = false;
		for (int i = 0; i < RUNS; i++) {
			splitArray = line.split(";");
          if(splitArray.length > 1){
            isMatched = true;
          }
		}
        //System.out.println("isMatched; "+isMatched);
		System.out.println("Split: " + (System.currentTimeMillis() - start) + "ms");
	}
 
   public static final void testSplitRegex() {
		double start = System.currentTimeMillis();
        boolean isMatched = false;
        Pattern p = Pattern.compile(";");
		for (int i = 0; i < RUNS; i++) {
			splitArray = p.split(line);
          	if(splitArray.length > 1){
            	isMatched = true;
          	}
		}
        // System.out.println("isMatched; "+isMatched);
		System.out.println("Regex Split: " + (System.currentTimeMillis() - start) + "ms");
	}
  
  public static final void testRegexMatcher() {
        double start = System.currentTimeMillis();
        boolean isMatched = false;
        Pattern p = Pattern.compile(";");
    	for (int i = 0; i < RUNS; i++) {
          isMatched = p.matcher(line).find();
        }
        //System.out.println("isMatched; "+isMatched);
        System.out.println("RegexMatcher: " + (System.currentTimeMillis() - start) + "ms");

  }
  
	public static final void testIndexOf() {
		double start = System.currentTimeMillis();
        boolean isMatched = false;
  	
		for (int i = 0; i < RUNS; i++) {
          if(line.indexOf(';')>=0){
            isMatched = true;
          }
		}
      
        // System.out.println("isMatched; "+isMatched);
        System.out.println("IndexOf: " + (System.currentTimeMillis() - start) + "ms");

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
Split: 406.0ms
Regex Split: 555.0ms
IndexOf: 11.0ms
RegexMatcher: 110.0ms

2nd run:
Split: 401.0ms
Regex Split: 495.0ms
IndexOf: 10.0ms
RegexMatcher: 73.0ms

3rd run:
Split: 460.0ms
Regex Split: 539.0ms
IndexOf: 10.0ms
RegexMatcher: 85.0ms
*/

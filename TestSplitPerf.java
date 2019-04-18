//*******************************************************************
// Performance test between split options
//*******************************************************************
import java.util.regex.Pattern;
import java.util.regex.Matcher;
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
  
  public static final void testRegexMatcherFind() {
        double start = System.currentTimeMillis();
        boolean isMatched = false;
        Pattern p = Pattern.compile("([^;|^,]+)");
    	for (int i = 0; i < RUNS; i++) {
          isMatched = p.matcher(line).find();
        }
        //System.out.println("isMatched; "+isMatched);
        System.out.println("RegexMatcherFind: " + (System.currentTimeMillis() - start) + "ms");

  }
  
  
    public static final void testRegexMatcherMatches() {
        double start = System.currentTimeMillis();
        boolean isMatched = false;
        Pattern p = Pattern.compile("([^;|^,]+)");
    	for (int i = 0; i < RUNS; i++) {
          Matcher matcher = p.matcher(line) ;
          while (matcher.find()) {
             // System.out.println(matcher.group());
            isMatched = true;
          }
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
        testRegexMatcherFind();
        testRegexMatcherMatches();
  	}
}

/*
OUTPUT::
1st run:
Split: 402.0ms
Regex Split: 513.0ms
IndexOf: 9.0ms
RegexMatcherFind: 247.0ms
RegexMatcher: 2309.0ms

2nd run:
Split: 391.0ms
Regex Split: 493.0ms
IndexOf: 10.0ms
RegexMatcherFind: 248.0ms
RegexMatcher: 2273.0ms

3rd run:
Split: 399.0ms
Regex Split: 562.0ms
IndexOf: 11.0ms
RegexMatcherFind: 297.0ms
RegexMatcher: 2284.0ms
*/

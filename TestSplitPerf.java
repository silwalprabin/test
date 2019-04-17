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
		long start = System.currentTimeMillis();
		for (int i = 0; i < RUNS; i++) {
			splitArray = line.split(";");
		}
		System.out.println("Split: " + (System.currentTimeMillis() - start) + "ms");
        // System.out.println("splitArray; "+Arrays.toString(splitArray));
	}
 
   public static final void testSplitRegex() {
		long start = System.currentTimeMillis();
     Pattern p = Pattern.compile(";");
		for (int i = 0; i < RUNS; i++) {
			splitArray = p.split(line);
		}
		System.out.println("Regex Split: " + (System.currentTimeMillis() - start) + "ms");
        // System.out.println("splitArray; "+Arrays.toString(splitArray));
	}
 
  
	public static final void testIndexOf() {
		long start = System.currentTimeMillis();
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
  	}
}

/*
OUTPUT::
1st run:
Split: 394ms
Regex Split: 540ms
IndexOf: 10ms

2nd run:
Split: 418ms
Regex Split: 531ms
IndexOf: 9ms

3rd run:
Split: 444ms
Regex Split: 520ms
IndexOf: 9ms
*/

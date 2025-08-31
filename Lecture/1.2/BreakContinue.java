public class BreakContinue {
  	public static void windowPosSum(int[] a, int n) throws IllegalArgumentException {
  		//	parameter check
  		if (n <= 0)
  			throw new IllegalArgumentException("parameters \"n\" only can be positive.");

  		//	traverse all elements of array, find the element which is positive.
  		for (int i = 0; i < a.length; i += 1) {

  			//	a[i] is positive(e.g: a[i] > 0).
  			if (a[i] > 0) {
  				//	set end index
  				int end_index;
  				if (i + n < a.length - 1)
  					end_index = i + n;
	  			else
	  				end_index = a.length - 1;

	  			//	do sum
	  			for (int j = i + 1; j < end_index + 1; j += 1)
	  				a[i] += a[j];
  			}
  		}
  	}

  	public static void main(String[] args) {
    	int[] a1 = {1, 2, -3, 4, 5, 4};
    	int n1 = 3;
    	windowPosSum(a1, n1);

    	// Should print 4, 8, -3, 13, 9, 4
    	System.out.println(java.util.Arrays.toString(a1));

    	int[] a2 = {1, -1, -1, 10, 5, -1};
    	int n2 = 2;
    	windowPosSum(a2, n2);

    	// Should print -1, -1, -1, 14, 4, -1
    	System.out.println(java.util.Arrays.toString(a2));

    	int[] a3 = {2, 3, 4};
    	int n3 = -1;
    	windowPosSum(a3, n3);
  	}
}
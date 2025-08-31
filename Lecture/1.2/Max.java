public class Max {
	/**  */
	public static int max(int[] array) {
		/**	according to context, all the numbers in array are greater
		 *	than or equal to zero.  
		 */
		int ret_max = 0;

		for (int i = 0; i < array.length; i = i + 1) 
		{
			if (array[i] > ret_max)
				ret_max = array[i];
		}

		return ret_max;
	}

	public static void main(String[] args) {
		int[] t_a1 = new int[] {5, 10, 3, 24};
		System.out.println("the maximum should be 24 = " + Max.max(t_a1)); 
	
		int[] t_a2 = new int[] {55, 2, 3, 45, 7};
		System.out.println("the maximum should be 55 = " + Max.max(t_a2)); 
	}
}
/** Class that prints the Collatz sequence starting from a given number.
 *  @author YOUR NAME HERE
 */
public class Collatz {

    /**  @profile: private method: is_even() function is used to test a natural
     *   number which is even or not.
     *   @param: n is natural number with integrity type.
     *   @return: n is even return true, n is odd return false, otherwise, end program with error code.
     */
    private static boolean is_even(int n)
    {
        //  param check
        assert n > 0 : "n must be natural number";

        //  return state
        boolean state = false;

        //  even number testing
        if (n % 2 == 0)
            state = true;

        return state;
    }

    public static void test_is_even()
    {
        int n1 = 1;
        if (is_even(n1))
            System.out.println("Error!");
        else
            System.out.println("Pass!");

        int n2 = 10;
        if (is_even(n2))
            System.out.println("Pass!");
        else
            System.out.println("Error!");
    }

    /** fixed */
    public static int nextNumber(int n) {

        int next_n  = 0;

        if (is_even(n))
            next_n = n / 2;
        else
            next_n = 3 * n + 1;

        return next_n;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.print(n + " ");
        while (n != 1) {
            n = nextNumber(n);
            System.out.print(n + " ");
        }
        System.out.println();
    }
}


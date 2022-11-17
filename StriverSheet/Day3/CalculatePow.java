package StriverSheet.Day3;

public class CalculatePow {

    // LC 50: https://leetcode.com/problems/powx-n/
    // Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

    // TC when using a normal loop O(n) so n can have maximum value when an integer
    // be upto 2^31-1 i.e. 2147483647

    // what if pow(2, 2147483647) = that mean we have to multiply 2 to the
    // 2147483647 times which is obviously not sufficient at all

    // Optimizations to avoid TLE error:
    // Reduce loops by half when n is even, by squaring x and
    // reducing loop count by half

    // Approach:

    // https://leetcode.com/problems/powx-n/discuss/2694922/Recursive-solution-or-Explained-or-Easy-Understanding-or-T.C.-O(log-n)
    // say n is even: x=2, n=4
    // 2^4 = (2^2) * (2^2) so
    // this means : pow(x,n) = pow(x, n/2) * pow(x, n/2)

    // now, say n is odd: x=2, n=5
    // 2^5 = (2^2) * (2^2) * 2

    // now say n is negative : x=2, n=4
    // 2^(-4) = 1/(2^4)

    // from above we understand in all cases we need pow(x,n/2) always so we
    // calculate it first and than do odd-even processing

    // Improved TC: O(logn)

    public static double myPow(double x, int n) {

        if (n == 0) {
            return 1;
        }
        double result = myPow(x, n / 2);

        if (n % 2 == 0) {
            return result * result;
        } else if (n % 2 == 1) {
            return result * result * x;
        } else {
            return 1 / myPow(x, -n);
        }

    }

    public static void main(String[] args) {
        double x = 2.00;
        int n = 10;

        // double x = 2;
        // int n = -2147483648;
        double result = myPow(x, n);
        System.out.println(result);

    }
}

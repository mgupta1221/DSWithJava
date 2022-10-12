package StriverSheet.Day3;

public class CalculatePow {

    // LC 50: https://leetcode.com/problems/powx-n/
    // Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

    // Approach:

    // Optimizations to avoid TLE error (Both are important):
    // Optimization 1: n can be very long so moved n from "int" to "long"
    // Optimization 2: Reduce loops by half when n is even, by squaring x and
    // reducing loop count by half

    public static double myPow(double x, int n) {
        double result = 1.0;
        boolean isNNegative = false;
        long nn = n;
        if (n < 0) {
            isNNegative = true;
            nn = Math.abs(nn);
        }

        while (nn > 0) {
            if (nn % 2 == 1) {
                result = result * x;
                nn--;
            } else {
                x = x * x;
                nn = nn / 2;
            }

        }
        if (isNNegative) {
            result = 1 / (double) (1.0) / (double) (result);
            ;
        }
        return result;
    }

    public static void main(String[] args) {
        double x = 2.00;
        int n = 10;
        double result = myPow(x, n);
        System.out.println(result);

    }
}

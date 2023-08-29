package GettingStartedBasics.GettingStarted;

/**
 * https://www.youtube.com/watch?v=HXSfAyjWM8A&list=PL-Jc9J83PIiFj7YSPl2ulcpwy-mwj1SSk&index=12
 */

// Check if a number is Prime or Not
public class PrimeNumber {

    // GOOGD APPROACH
    static boolean isPrime_better(int num) {
        boolean result = true;
        if (num == 1)
            return false;

        // IMP: remember to <= with Math.sqrt below
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                result = false;
                break;
            }
        }
        return result;
    }

    // Below approach DOES NOT work for all cases
    static boolean isPrime_OK_approach(int num) {
        boolean flag = true;
        // A number can at most be divided by its square root
        // Notice we are strating the loop from 3
        for (int i = 3; i * i < num; i++) {
            if (num % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {

        boolean result = isPrime_better(11);

        if (result == true) {
            System.out.println("Prime");
        } else {
            System.out.println("NOT Prime");
        }

    }
}

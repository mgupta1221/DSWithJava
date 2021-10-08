package GettingStartedBasics.GettingStarted;

/**
 * https://www.youtube.com/watch?v=HXSfAyjWM8A&list=PL-Jc9J83PIiFj7YSPl2ulcpwy-mwj1SSk&index=12
 */

// Check if a number is Prime or Not
public class PrimeNumber {

    public static void main(String[] args) {

        int n = 21;
        int flag = 0;
        // A number can at most be divided by its square root
        // To do this, in for loop we kept the below condition i*i<n in which we are basically checking SQUARE ROOT
        // Notice we are strating the loop from 3
        for (int i = 3; i * i < n; i++) {
            if (n % i == 0) {
                flag = 1;
                //Notice to optimize further we are breaking the loop as soon as Number is detected as Prime
                break;
            }
        }
        if (flag == 1) {
            System.out.println("Not Prime");
        } else {
            System.out.println("Prime");
        }

    }
}

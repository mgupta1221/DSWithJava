package GettingStarted;

/**
 * https://www.youtube.com/watch?v=5gFC-ayyQMk&list=PL-Jc9J83PIiFj7YSPl2ulcpwy-mwj1SSk&index=30
 */
public class PrimeFactorofNumber {

    public static void main(String[] args) {

        int n = 1440;

        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                n = n / i;
                System.out.println(i);

            }
        }
        if (n != 1) {
            System.out.println(n);
        }

    }
}

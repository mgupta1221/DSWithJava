package AdobeQues.AdobeIntQues;

public class PrintFibonacciUsingRecursion {

    // Condition was :
    // . The code should use recursion , cant use any global variable, cant use
    // memorization parameter or helper function.
    public static long fibonacci(int n, boolean printSequence) {
        // Base cases
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        // Recursive case
        long result = fibonacci(n - 1, false) + fibonacci(n - 2, false);

        // Print the sequence only when called with the original n
        if (printSequence) {
            // Print the sequence in order
            System.out.print("Fibonacci Sequence (0 to " + n + "): ");
            for (int i = 0; i <= n; i++) {
                if (i == 0) {
                    System.out.print("0");
                } else if (i == 1) {
                    System.out.print(", 1");
                } else {
                    // Calculate each value iteratively just for printing
                    long a = 0, b = 1, c = 0;
                    for (int j = 2; j <= i; j++) {
                        c = a + b;
                        a = b;
                        b = c;
                    }
                    System.out.print(", " + c);
                }
            }
            System.out.println();
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 6;

        // With printing the sequence
        System.out.println("\nWith sequence printing:");
        fibonacci(n, true);
        // System.out.println("Fibonacci(" + n + ") = " + result2);
    }
}

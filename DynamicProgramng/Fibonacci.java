package DynamicProgramng;



public class Fibonacci {
    public static void main(String[] args) {

        // 0 1 1 2 3 5 8
        // Without recursion and DP
        // int n = 10;
        // int a = 0;
        // int b = 1;
        // int count = 1;
        // while (count <= 10) {
        // System.out.print(a + "\t");
        // int c = a + b;
        // a = b;
        // b = c;
        // count++;
        // }

        // With recursion
        // int n = 10;
        // int result = FibonaciWithRecursion(n);
        // System.out.println(result);

        // With recursion- memoized - Efficient solution
        int n = 10;
        int[] questionbank = new int[n + 1]; // making array of size n+1  -becuase we have elmenets o to n
        int result = FibonaciMemoized(n, questionbank);
        System.out.println(result);

    }

    public static int FibonaciWithRecursion(int n) {
        if (n == 1 || n == 0) {
            return n;
        }
        System.out.println("Hello: " + n);
        int result = FibonaciWithRecursion(n - 1) + FibonaciWithRecursion(n - 2);
        return result;
    }

    public static int FibonaciMemoized(int n, int[] questionbank) {
        if (n == 1 || n == 0) {
            return n;
        }
        if (questionbank[n] != 0) {// checking in Question bank first
            return questionbank[n];
        }
        
        int result = FibonaciMemoized(n - 1, questionbank) + FibonaciMemoized(n - 2, questionbank);
        questionbank[n] = result;// storing the result in question bank before returning result
        return result;
    }

}

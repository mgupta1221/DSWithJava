package RecursionAndBacktracking.IntroToRecursion;

import java.util.Scanner;

// Problem: https://www.youtube.com/watch?v=uwrc4H3yaJ4
// Solution :https://www.youtube.com/watch?v=QDBrZFROuA0  Must check

public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // No of Disks
        int n = scn.nextInt();

        // Name of first tower
        int t1 = scn.nextInt();
        // Name of Second tower
        int t2 = scn.nextInt();
        // Name of Third tower
        int t3 = scn.nextInt();

        scn.close();

        // We have to move disks from t1 to t2 using t3
        toh(n, t1, t2, t3);
    }

    public static void toh(int n, int t1d, int t2d, int t3d) {
        // Base case
        if (n == 0) {
            return;
        }

        toh(n - 1, t1d, t3d, t2d); // Assuiming that the function will work for n-1, first move (n-1) disks from t1
                                   // to t3

        System.out.println(n + " [" + t1d + "->" + t2d + "]"); // Moving last disk from t1 to t2 directly

        toh(n - 1, t3d, t2d, t1d);// Now move (n-1) disks from t3 to t2

    }

}

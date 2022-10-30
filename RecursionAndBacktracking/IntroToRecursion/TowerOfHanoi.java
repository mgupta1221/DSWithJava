package RecursionAndBacktracking.IntroToRecursion;

import java.util.Scanner;

// Problem: https://www.youtube.com/watch?v=uwrc4H3yaJ4
// Use have to move n disk from toiwer t1 to tower t2 using tower 3

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

        toh(n - 1, t1d, t3d, t2d); // Assuming that the function will work for n-1, first move (n-1)
                                   // disks from t1 to t3 -(Left call as per Euler)
                                   // Agar total 3 disks hain to hum assume kar rhe hain ki upar ki 2 disk(n-1)
                                   // recursion khud move kar dega from tower t1 to tower t3
                                   // utliizing tower 2 (rules follow karte hue)

        System.out.println(n + " [" + t1d + "->" + t2d + "]"); // fir t1 mai 1 disk bachegi wo hum khud move kar denge
                                                               // from t1 se t2 isliye "print"

        toh(n - 1, t3d, t2d, t1d);// Now move (n-1) disks from t3 to t2 - (Right call as per Euler)

    }

}

package RecursionAndBacktracking.IntroToRecursion;

import java.util.Scanner;

// https://www.youtube.com/watch?v=Y5IobAWmfjQ

//Note: Everything before recursive call will execute when you go up in the recursion

// Everything after recursive call(this program) will execute wapas aate hue...Value order will be LIFO in this case as shown below
//PrintIncreasing(1) => PrintIncreasing(2) => PrintIncreasing(3) => PrintIncreasing(4) =>...etc


public class PrintIncreasing {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();


        printIncreasingCall(n);
    }

    // 5
    public static void printIncreasingCall(int n) {
        if (n == 0) {
            return;
        }        
        printIncreasingCall(n - 1);        
        System.out.println(n); //Jab lautte waqt kaam karna hai to println should come after recursive call
    }

}

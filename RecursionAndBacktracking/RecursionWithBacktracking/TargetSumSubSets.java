import java.util.ArrayList;
import java.util.Scanner;

public class TargetSumSubSets {

    // Question :
    // https://www.youtube.com/watch?v=zNxDJJW40_k&list=PL-Jc9J83PIiFxaBahjslhBD1LiJAV7nKs&index=48

    // Solution:
    // https://www.youtube.com/watch?v=HGDmj5NrrjM&list=PL-Jc9J83PIiFxaBahjslhBD1LiJAV7nKs&index=49

    // This solution also uses Print approach(Level and Options).
    // Also, think of solutioning such problems when a value can be part of the
    // solution and cannot be too i.e. similar to PrintSubsequence problem

    // In this question's solution, notice how we are regularly maintianing
    // currentIndex,currentSum and current SetOfElements in recursive call

    //
//For "abc"
//Expected Output  : "abc", "acb","bac" , "bca", "cab", "cba"  

    public static void main(String[] args) {

        // inputs
        int[] arr = { 10, 20, 30, 40, 50 };
        int targetSum = 30;

        int currentIndex = 0;
        String set = "";
        int sumOfSets = 0;

        printTargetSumSubsets(arr, currentIndex, set, sumOfSets, targetSum);
    }

    public static void printTargetSumSubsets(int[] arr, int currentIndex, String set, int sumOfSets, int targetSum) {
        if (currentIndex == arr.length) {
            if (sumOfSets == targetSum) {
                System.out.println(set);
            }
            return;
        }
        // Idea is one number in the set can be part of the answer/ it cnanot be part of
        // the answer so we put 2 conditins as below:

        // First time considering the number, see video for explanation
        printTargetSumSubsets(arr, currentIndex + 1, set + arr[currentIndex] + ",", sumOfSets + arr[currentIndex],
                targetSum);

        // Second time WITHOUT considering the number
        printTargetSumSubsets(arr, currentIndex + 1, set, sumOfSets, targetSum);

    }

}

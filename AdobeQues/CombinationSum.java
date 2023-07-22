package AdobeQues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

// Problem:https://practice.geeksforgeeks.org/problems/combination-sum-1587115620/1

//  Notice how we are removing duplicate elements in ArrayList in the begining itself for optimization, else on
//  GFG code will get Time Limit Exceeded

public class CombinationSum {

    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        // Removing duplicate values first
        HashSet<Integer> hs = new HashSet<Integer>(A);
        A = new ArrayList<Integer>(hs);
        Collections.sort(A);// sorting to match the result with GFG

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> subResult = new ArrayList<>();
        combinationSumHelper(A, B, 0, result, subResult);
        return result;
    }

    static void combinationSumHelper(ArrayList<Integer> A, int B, int idx, ArrayList<ArrayList<Integer>> result,
            ArrayList<Integer> subResult) {
        if (B == 0) {
            if (!result.contains(subResult)) {
                result.add(new ArrayList<>(subResult));
            }
            return;
        }
        if (idx == A.size()) {
            return;
        }
        int currentItem = A.get(idx);
        if (B - currentItem >= 0) {
            subResult.add(currentItem);
            combinationSumHelper(A, B - currentItem, idx, result, subResult);
            subResult.remove(subResult.size() - 1);

        }
        combinationSumHelper(A, B, idx + 1, result, subResult);

    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(7);
        A.add(2);
        A.add(6);
        A.add(5);
        int B = 16;
        ArrayList<ArrayList<Integer>> result = combinationSum(A, B);
        for (int i = 0; i < result.size(); i++) {

            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

}
